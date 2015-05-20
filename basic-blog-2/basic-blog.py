import os

import jinja2
import webapp2

from google.appengine.ext import db

template_dir = os.path.join(os.path.dirname(__file__), 'templates')
jinja_env = jinja2.Environment(loader = jinja2.FileSystemLoader(template_dir),
							   autoescape = True)


class Post(db.Model):
	title = db.StringProperty(required = True)
	content = db.TextProperty(required = True)
	created = db.DateTimeProperty(auto_now_add = True)

class Handler(webapp2.RequestHandler):
	def write(self, *a, **kw):
		self.response.out.write(*a, **kw)
		
	def render_str(self, template, **params):
		t = jinja_env.get_template(template)
		return t.render(params)

	def render(self, template, **kw):
		self.write(self.render_str(template, **kw))
		

class NewPost(Handler): 
	def render_front(self, title="", content="", error=""):
		self.render("basic-blog.html", title=title, content=content, error=error)
	
	def get(self):
		self.render_front()
		
	def post(self):
		title = self.request.get("title")
		content = self.request.get("body")
		
		if title and content:
			a = Post(title=title, content=content)
			a.put()
			str = "/{}".format(a.key().id())
			self.redirect(str)
		else:
			error = "please enter both title and content!"
			self.render_front(title, content, error)

class PostPage(Handler):
	def get(self, post_id):
		key = db.Key.from_path('Post', int(post_id), parent=None)
		post = db.get(key)

		if not post:
			self.error(404)
			return

		self.render("permalink.html", post = post)
	
class MainPage(Handler):
		def get(self):
			posts = db.GqlQuery("SELECT * FROM Post ORDER BY created DESC")
			self.render("blog-posts.html", posts = posts)
	
application = webapp2.WSGIApplication([
	('/?', MainPage),
	('/([0-9]+)', PostPage),
	('/newpost', NewPost)
], debug=True)
