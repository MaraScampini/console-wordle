public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my version of WORDLE!");
        System.out.println();
        System.out.println("You will get a four-letter word to start.");
        System.out.println("If you get that one right, you will get a five-letter one next,");
        System.out.println("and so on until you hit a seven-letter word!");
        System.out.println();
        System.out.println("The amount of tries available will be the same");
        System.out.println("as in the letters in each word.");
        System.out.println();
        System.out.println("Good luck!");
        Wordle wordle = new Wordle();
        wordle.play();
    }
}