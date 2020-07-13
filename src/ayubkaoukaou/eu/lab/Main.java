package ayubkaoukaou.eu.lab;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.PI;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(20));
    }

    //Define a function that takes an integer argument and returns logical value true
    // or false depending on if the integer is a prime.
    //Per Wikipedia, a prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
    public static boolean isPrime(int num) {
        return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
    }

    //    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//    Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
    public static int solution(int number) {
        int sum = 0;
        int numberThatGivesFizz = 3;
        int numberThatGivesBuzz = 5;

        for (int i = 1; i < number; i++) {
            if (i % numberThatGivesFizz != 0 && i % numberThatGivesBuzz != 0) {
                continue;
            }
            if (i % numberThatGivesFizz == 0 && i % numberThatGivesBuzz == 0) {
                sum += i;
                continue;
            }
            if (i % numberThatGivesFizz == 0) {
                sum += i;
                System.out.println("hey");
            }
            if (i % numberThatGivesBuzz == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') continue;
            list.add(str.substring(0, i) + Character.toUpperCase(ch) + str.substring(i + 1));
        }
        return list.toArray(new String[0]);
    }

    public static int[] foldArray(int[] array, int runs) {
        int[] arr = Arrays.copyOf(array, array.length);
        int bound = arr.length;
        for (int k = 0; k < runs; k++) {
            for (int i = 0; i < bound / 2; i++) {
                arr[i] += arr[bound - 1 - i];
            }
            bound = (bound + 1) / 2;
        }
        return Arrays.copyOf(arr, bound);
    }


    public static void midArray(int[] arr) {
        int firstIndex = arr[0];
        int lastIndex = arr.length - 1;
        int mid = firstIndex + (lastIndex - firstIndex) / 2;

        System.out.println(mid);
    }

    //Fn+1 = Fn + Fn-1
    public static void fibonacci(int numberUpTo) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        System.out.println(n1 + " " + n2);
//n1 is the number two spaces before the current N, and n2 is the one space before the current N

        //Add the old two N spaces before the current N and assign the number to the current N,
        //Then assign the N that is two spaces before to be the N that is one space before,
        //The n2 will take the number that n3 had, as n3 will move on to the next space,
        //And the next space will be created by adding the two spaces before the n3 and assigning the element.
        for (int i = 2; i < numberUpTo; i++) {
            n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
    }

    public static void fizzbuzz(int numberThatGivesFizz, int numberThatGivesBuzz, int totalCount) {
        for (int i = 1; i < totalCount; i++) {

            if (i % numberThatGivesFizz != 0 && i % numberThatGivesBuzz != 0) {
                System.out.println(i);
            }
            if (i % numberThatGivesFizz == 0 && i % numberThatGivesBuzz == 0) {
                System.out.println("FizzBuzz");
            }
            if (i % numberThatGivesFizz == 0) {
                System.out.println("Fizz");
            }
            if (i % numberThatGivesBuzz == 0) {
                System.out.println("Buzz");
            }

        }
    }

    public static int duplicateInArrayFinder(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];

                }

            }
        }
        return 0;
    }

    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static boolean validPhoneNumber(String phoneNumber) {
    /*
    \\( --- Start with an "("
    (\\d{3}) --- Followed by 3 digits
    \\) --- Have an ")"
    (\\s) --- Have an space
    (\\d{3}) --- Followed by 3 digits.
    (\\-) --- Have a "-" after numeric digits
    (\\d{4}) - Ends with four digits
    */
        Pattern p = Pattern.compile("\\((\\d{3})\\)(\\s)(\\d{3})(\\-)(\\d{4})");
        if (p.matcher(phoneNumber).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static String seriesSum(int n) {
        double numberInSeries = 4;
        double nthTerm = 1;
        double sum = 0;
        double numberDivided = nthTerm / numberInSeries;
        for (int i = 2; i < n; i++) {
            double sumOfFractions = numberDivided + nthTerm / (numberInSeries = numberInSeries + 3);
            sum = sumOfFractions;
            numberDivided = sum;
        }
        sum += 1;
        if (n <= 0) sum = 0;
        return String.format("%.2f", sum);
    }

    //    Trolls are attacking your comment section!
//
//    A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
//
//    Your task is to write a function that takes a string and return a new string with all vowels removed.
//
//    For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
//
//    Note: for this kata y isn't considered a vowel.
    // A, E, I, O, and U
    public static String disemvowel(String str) {
        char[] characterArray = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < characterArray.length; i++) {
            if (!(characterArray[i] == 'A' || characterArray[i] == 'a' || characterArray[i] == 'E' || characterArray[i] == 'e' ||
                    characterArray[i] == 'I' || characterArray[i] == 'i' || characterArray[i] == 'O' || characterArray[i] == 'o' ||
                    characterArray[i] == 'U' || characterArray[i] == 'u')) {
                sb.append(characterArray[i]);
            }
        }
        return sb.toString();

    }

    public static int sortDesc(final int num) {
        ArrayList<Integer> list = new ArrayList<>();
        String temp = Integer.toString(num);
        int[] newNum = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newNum[i] = temp.charAt(i) - '0';
        }
        Arrays.sort(newNum);
        for (int i = 0; i < newNum.length; i++) {
            list.add(newNum[i]);
        }
        Collections.reverse(list);
        System.out.println(list);
        String string = "";
        String omgString = "";

        int total = 0;
        for (Integer i : list) { // assuming list is of type List<Integer>
            total = 10 * total + i;
        }

        return total;
    }

    public static void getTemp() {


    }

    public static int duplicateCharCount(String text) {

        ArrayList<Character> listOfChars = new ArrayList<>();
        int counter = 0;

        char[] textArray = text.toLowerCase().toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            for (int j = i + 1; j < textArray.length; j++) {
                if (textArray[i] == textArray[j]) {
                    if (listOfChars.contains(textArray[i])) {

                    } else {
                        listOfChars.add(textArray[i]);
                    }
                }
            }

            counter = listOfChars.size();

        }
        return counter;
    }

    // You are playing the following Nim Game with your friend:
    // There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
    // The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
    // Both of you are very clever and have optimal strategies for the game.
    // Write a function to determine whether you can win the game given the number of stones in the heap.
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }


    //Add two numbers in the array to equal the target
    public static int[] twoSum(int[] numbers, int target) {
        int firstNumber = 0;
        int secondNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    firstNumber = i;
                    secondNumber = j;
                }
            }
        }
        return new int[]{firstNumber, secondNumber};
    }

    //Your message is a string containing space separated words.
//You need to encrypt each word in the message using the following rules:
//The first letter needs to be converted to its ASCII code.
//The second letter needs to be switched with the last letter
//Keepin' it simple: There are no special characters in input.
    public static String encryptThis(String text) {
        if (text.isEmpty()) return text;
        char secondLetter = 0;
        char finalLetter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String[] parts = text.split(" ");
        for (String splittedString : parts) {
            if (splittedString.isEmpty()) continue;
            char asciString = splittedString.charAt(0);
            stringBuilder.append((int) asciString);
            if (splittedString.length() == 2) {
                secondLetter = splittedString.charAt(1);
                stringBuilder.append(secondLetter);
            }
            if (splittedString.length() > 2) {
                secondLetter = splittedString.charAt(1);
                finalLetter = splittedString.charAt(splittedString.length() - 1);
                stringBuilder.append(finalLetter);
                stringBuilder.append(splittedString, 2, splittedString.length() - 1);
                stringBuilder.append(secondLetter);
            }
            stringBuilder.append(" ");
        }
        //Delete the whitespace at the end
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}

