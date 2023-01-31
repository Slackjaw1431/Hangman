package hangman;

import static hangman.hangedMan.showLives;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class Hangman {

    public static void main(String[] args) throws IOException {

        File dictionary = new File("C:\\Users\\TM\\Desktop\\Projects\\Hangman\\src\\hangman\\dictionary.txt");
        ArrayList<String> words = new ArrayList<>();

        Scanner c = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman");
        System.out.println("1. Play game\n2. Add a word to the dictionary");

        Scanner scan = new Scanner(dictionary);
        while (scan.hasNextLine()) {
            words.add(scan.nextLine());//adds words from txt file to word array list
        }

        int choice = c.nextInt();
        int lives;

        if (choice == 1) {

            String chosenWord = words.get((int) (Math.random() * words.size()));//chosenWord = chosenWord.replaceAll("\\s+", ""); //removes spaces between words
            char[] hiddenWord = chosenWord.toCharArray();//converts chosenword string to char array
            char[] answer = new char[chosenWord.length()];//makes an answer char array to later match with hiddenWord

            for (int i = 0; i < hiddenWord.length; i++) {
                if (hiddenWord[i] == '-') {
                    answer[i] = '-';
                } else {
                    answer[i] = '_';//assigns all the non empty or - spaces in the array a blank space
                }
            }
            if (hiddenWord.length > 2) {
                lives = hiddenWord.length - 1;//making it so that the amount of lives depends on the letters in the word  a word should have at least 4 letters and length starts at 0
            } else if (hiddenWord.length >= 4 && hiddenWord.length <= 6) {
                lives = hiddenWord.length - 3;
            } else {
                lives = hiddenWord.length - 5;
            }

            boolean finished = false;

            while (finished == false) {

                System.out.println();
                for (int i = 0; i < answer.length; i++) {
                    if (answer[i] == '_') {
                        System.out.print(answer[i] + " ");
                    } else {
                        System.out.print(answer[i] + " ");
                    }
                }
                System.out.println();
                livesCall(lives);
                System.out.println("************************");
                System.out.println("Enter a letter: ");
                String guess = input.next();

                while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                    System.out.println("Please only enter single letters");
                    guess = input.next();
                }

                boolean match = false;
                for (int i = 0; i < hiddenWord.length; i++) {
                    if (guess.charAt(0) == hiddenWord[i] || Character.toUpperCase(guess.charAt(0)) == hiddenWord[i]) {
                        if (answer[i] == hiddenWord[i]) {
                            System.out.println("The letter has already been added. Try again");
                            match = true;
                        } else {
                            answer[i] = hiddenWord[i];
                            match = true;
                        }
                    }
                }
                if (!match) {
                    lives--;
                    showLives(lives);
                    System.out.println("Try again");
                }

                if (Arrays.equals(hiddenWord, answer)) {
                    finished = true;
                    System.out.println("\nYou solved the word and it was " + chosenWord);
                } else if (lives <= 0) {
                    finished = true;
                    System.out.println("\nGame Over!\nThe hidden word was " + chosenWord);
                }
            }
        } else if (choice == 2) {//adding a new word

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\TM\\Desktop\\Projects\\Hangman\\src\\hangman\\dictionary.txt", true));
            System.out.println("Enter new word to add to the dictionary: ");

            Scanner input2 = new Scanner(System.in);
            String newWord = input2.nextLine();

            boolean hasDigit = false;
            for (int i = 0; i < newWord.length(); i++) {
                if (Character.isDigit(newWord.charAt(i))) {
                    hasDigit = true;
                    System.out.println("Please only enter words with letters: ");
                    newWord = input2.nextLine();
                } else if (newWord.length() < 3) {
                    System.out.println("Please enter a word with at least 3 letters: ");
                    newWord = input2.nextLine();
                }
            }
            words.replaceAll(String::toLowerCase);//convert all strings in words arraylist to lowercase also can do e -> e.toLowerCase()
            String newWordL = newWord.toLowerCase();

            if (words.contains(newWordL) == true) {
                System.out.println("Word already exists in the dictionary.");
            } else {
                writer.newLine();
                writer.write(newWord);
                writer.close();

                System.out.println("Word has been added to the dictionary.");
            }
        }
    }

    public static void livesCall(int lives) {
        if (lives == 1) {
            System.out.println("\nYou have " + lives + " try remaining");
        } else if (lives >= 2) {
            System.out.println("\nYou have " + lives + " tries remaining");
        }
    }

}
