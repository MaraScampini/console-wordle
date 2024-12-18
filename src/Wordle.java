import java.util.Scanner;

public class Wordle {
    private final Scanner scanner = new Scanner(System.in);
    private final Word userWord = new Word();
    private final WordFetcher correctWords = new WordFetcher();
    private int wordLength = 4;

    public void play(){
        while (wordLength >= 4 && wordLength <= 7) {
            String correctWord = correctWords.getWord(wordLength);
            System.out.println("correctWord = " + correctWord);
            boolean isCorrect = false;
            int tries = 0;
            while (!isCorrect && tries < wordLength + 2) {
                checkWordLength(correctWord);
                isCorrect = userWord.checkUserWord(correctWord);
                System.out.println(userWord.showCorrection());
                tries++;
            }

            if (isCorrect && wordLength != 7 && tries <= wordLength + 2) {
                if (!decideToContinue()) break;
            } else if (isCorrect && wordLength == 7) {
                break;
            } else if (!isCorrect) {
                System.out.println("You ran out of tries!");
                System.out.println("The word was " + correctWord);
                break;
            }
        }

        if (wordLength == 7) System.out.println("Congratulations! Come back tomorrow for more");
    }

    public void checkWordLength(String correctWord) {
        boolean correctLength = false;
        while (!correctLength) {
            System.out.println("Introduce a " + wordLength + " letter word");
            userWord.setUserWord(scanner.nextLine());
            if(checkWordIsOnlyLetters()) correctLength = userWord.checkLength(correctWord);
            else System.out.println("Only letters allowed!");
        }
    }

    public boolean checkWordIsOnlyLetters() {
        return userWord.getUserWord().matches("^[a-zA-Z]+$");
    }

    public boolean decideToContinue() {
        System.out.println("Do you want to continue? YES / NO");
        String wantsToContinue = scanner.nextLine();
        if (wantsToContinue.equalsIgnoreCase("yes")) wordLength++;
        else if (wantsToContinue.equalsIgnoreCase("no")) {
            System.out.println("See you in the next one!");
            return false;
        } else {
            System.out.println("Invalid input, enter YES / NO");
            return true;
        }
        return true;
    }
}
