import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CorrectWords correctWords = new CorrectWords();
        Word userWord = new Word();

        String correctFourLetterWord = correctWords.getFourLetterWord();
        System.out.println("correctFourLetterWord = " + correctFourLetterWord);

        boolean isCorrect = false;
        int tries = 0;
        while (!isCorrect && tries < 4) {
            boolean correctLength = false;
            while (!correctLength) {
                System.out.println("Introduce a 4 letter word");
                userWord.setUserWord(scanner.nextLine());
                correctLength = userWord.checkLength(correctFourLetterWord);
            }

            isCorrect = userWord.checkUserWord(correctFourLetterWord);
            System.out.println(userWord.showCorrection());
            tries++;
        }
    }
}