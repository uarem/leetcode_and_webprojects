import os

import jinja2
import webapp2
import hmac

from google.appengine.ext import db

template_dir = os.path.join(os.path.dirname(__file__), 'templates')
jinja_env = jinja2.Environment(loader = jinja2.FileSystemLoader(template_dir),
							   autoescape = True)

							   
SECRET = 'somestring'

def make_hash(s):
	return hmac.new(SECRET, s).hexdigest()
	

class User(db.Model):
	username = db.StringProperty(required = True)
	password = db.StringProperty(required = True)
	email = db.EmailProperty

class Handler(webapp2.RequestHandler):
	def write(self, *a, **kw):
		self.response.out.write(*a, **kw)
		
	def render_str(self, template, **params):
		t = jinja_env.get_template(template)
		return t.render(params)

	def render(self, template, **kw):
		self.write(self.render_str(template, **kw))
		
class MainPage(Handler): 
	def render_front(self, username="", email="", error=""):
		self.render("forms.html", username=username, email=email, error=error)
	
	def get(self):
		self.render_front()
		
	def post(self):
		username = self.request.get("username")
		password = self.request.get("password")
		password_dup = self.request.get("password_dup")
		email = self.request.get("email")
		
		lists = db.GqlQuery("SELECT * FROM User WHERE username=':1'", username)
		
		if not lists and username and password and password_dup and password==password_dup:
			a = User(username=username, password=password, email=email)
			a.put()
			hashed_username = make_hash(username)
			self.response.headers.add_header('Set-Cookie', 'username=%s|%s' %(str(username),str(hashed_username)))
			self.redirect("/welcome")
		elif lists:
			error = "User Id already exists"
			self.render_front(username, email, error)
		else:
			# [TODO] make it throw exceptions on individual level
			error = "Give us proper information!"
			self.render_front(username, email, error)
	
	
class WelcomeHandler(Handler):
	def get(self):
		username_hash_set = self.request.cookies.get('username')
		arr = username_hash_set.split('|')
		
		if arr[1] == make_hash(arr[0]):
			self.response.write("Welcome %s... " %arr[0])
		else:
			self.redirect('/')

class LoginHandler(Handler):
	def render_front(self, username="", error=""):
		self.render("login.html", username=username, error=error)
	
	def get(self):
		self.render_front()
		
	def post(self):
		username = self.request.get('username')
		password = self.request.get('password')
		
		if username and password:
			u = db.GqlQuery("SELECT * FROM User WHERE username='%s'" %username)
			
			if u and password == u.get().password:
				self.response.headers.add_header('Set-Cookie', 'username=%s|%s' %(str(username),str(make_hash(username))))
				self.redirect('/welcome')
			else:
				error="Given username and password does not match our record"
				self.render_front(username, error)
		else:
			error="Please input the username/password"
			self.render_front(username, error)
				
class LogoutHandler(Handler):
	def get(self):
		self.response.headers.add_header('Set-Cookie','username=')
		self.redirect('/')
				
application = webapp2.WSGIApplication([
    ('/', MainPage),
	('/welcome', WelcomeHandler),
	('/login', LoginHandler),
	('logout', LogoutHandler)
], debug=True)
