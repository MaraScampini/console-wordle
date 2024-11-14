import java.util.ArrayList;

public class Word {
    private String userWord;
    private ArrayList<Integer> correctIndexes = new ArrayList<>();
    private ArrayList<Integer> halfCorrectIndexes = new ArrayList<>();
    private final String RESET = "\u001B[0m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";

    public boolean checkLength(String correctWord){
        return userWord.length() == correctWord.length();
    }

    public String getUserWord(){
        return this.userWord;
    }

    public void setUserWord(String userWord){
        this.userWord = userWord;
    }

    public boolean checkUserWord(String correctWord) {
        char[] userWordChars = this.userWord.toCharArray();
        char[] correctWordChars = correctWord.toCharArray();
        boolean[] usedCorrectChars = new boolean[correctWord.length()];
        this.correctIndexes.clear();
        this.halfCorrectIndexes.clear();

        // GET CORRECT INDEXES
        for(int i = 0; i < this.userWord.length(); i++) {
            if(userWordChars[i] == correctWordChars[i]) {
                correctIndexes.add(i);
                usedCorrectChars[i] = true;
            }
        }

        // SECOND PASS TO GET HALF-CORRECT INDEXES
        // i = userWord || j = correctWord
        for(int i = 0; i < this.userWord.length(); i++) {
            if(!correctIndexes.contains(i)) {
                for(int j = 0; j < correctWord.length(); j++) {
                    if(!usedCorrectChars[j] && (userWordChars[i] == correctWordChars[j])) {
                        halfCorrectIndexes.add(i);
                        usedCorrectChars[j] = true;
                        break;
                    }
                }
            }
        }

        return this.correctIndexes.size() == this.userWord.length();
    }

    public String showCorrection() {
        StringBuilder correctedWord = new StringBuilder();
        for(int i = 0; i < this.userWord.length(); i++) {
            if(this.correctIndexes.contains(i)) correctedWord.append(GREEN).append(this.userWord.charAt(i)).append(RESET);
            else if(this.halfCorrectIndexes.contains(i)) correctedWord.append(YELLOW).append(this.userWord.charAt(i)).append(RESET);
            else correctedWord.append(this.userWord.charAt(i));
        }

        return correctedWord.toString();
    }
}
