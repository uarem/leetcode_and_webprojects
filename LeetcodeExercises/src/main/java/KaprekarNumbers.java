/**
 * Created by uarem on 4/29/2015.
 *
 * http://en.wikipedia.org/wiki/Kaprekar_number
 *
 * Write a function that identifies Kaprekar numbers and to determine the Kaprekar numbers less than a thousand.
 * e.g. 9 is a Kaprekar number since 9^2 = 81 and 8 + 1 = 9
 *
 */
public class KaprekarNumbers {

    public boolean kaprekarNumbers(int input) {
        int doubleInput = (int) Math.pow(input, 2);

        String doubleInputInString = String.valueOf(doubleInput);
        String firstHalf = (doubleInputInString.length() == 1) ? "0" : doubleInputInString.substring(0, doubleInputInString.length()/2);
        String secondHalf = doubleInputInString.substring((int) Math.ceil(doubleInputInString.length()/2));

        return input == (Integer.parseInt(firstHalf) + Integer.parseInt(secondHalf));
    }
}
