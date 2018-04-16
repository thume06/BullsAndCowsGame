//Just a little game I made before, wanted to see how fast I could do it now.
package game;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);
        String word = "planet";
        int tryNum = 1;
        int maxTries = 10;

        System.out.println("Guess the 6 letter isogram.");
        System.out.println();

        while(tryNum <= maxTries) {
            System.out.print("Try " + tryNum + " of " + maxTries + ". Enter your guess: ");
            String input = scanner.nextLine().toLowerCase();
            if(!checkValid(input, word)){
                tryNum = tryNum - 1;
            }


            //IF THE GUESS IS VALID
            else{
                if(bullsCows(input, word) == word.length()){
                    System.out.print("Congratulations, you won! Would you like to play again? (y/n): ");
                    String input2 = scanner.nextLine().toLowerCase();
                    if (String.valueOf(input2.charAt(0)).toLowerCase().equals("y")){
                        tryNum = 0;
                    }
                    else{
                        System.exit(0);
                    }
                }
                else if(tryNum == maxTries){
                    System.out.print("Better luck next time! Would you like to play again? (y/n): ");
                    String input2 = scanner.nextLine().toLowerCase();
                    if (String.valueOf(input2.charAt(0)).toLowerCase().equals("y")){
                        tryNum = 0;
                    }
                    else{
                        System.exit(0);
                    }
                }

            }
        tryNum++;
        }


    }

    public static boolean checkValid(String g, String w){
        if (g.length() != w.length()){
            System.out.println("Guess must be " + w.length() + " characters");
            return false;
        }
        int count = 0;
        ArrayList<String> charArray = new ArrayList<String>();
        while(count < w.length()){
            charArray.add(String.valueOf(g.charAt(count)));
            count++;
        }
        count = 0;
        while(count < charArray.size()){
            int charCount = 0;
            String character = charArray.get(count);
            int count2 = 0;
            while(count2 < charArray.size()){
                if(charArray.get(count).equals(charArray.get(count2))){
                    charCount++;
                }
                count2++;
            }
            if(charCount >= 2){
                System.out.println("Please do not enter repeating letters.");
                return false;
            }
            count++;
        }

        return true;
    }

    public static int bullsCows(String g, String w){
        int count = 0;
        int bulls = 0;
        int cows = 0;
        while(count < g.length()){
            int count2 = 0;
            while(count2 < w.length()){
                String guessChar = String.valueOf(g.charAt(count));
                String wordChar = String.valueOf(w.charAt(count2));
                if(guessChar.equals(wordChar)){
                    if(count == count2){
                        bulls++;
                    }
                    else{
                        cows++;
                    }
                }
                count2++;
            }
            count++;
        }
        System.out.println("Bulls: " + bulls + ". Cows: " + cows + ".\n");
        return bulls;
    }
}
