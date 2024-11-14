import java.util.ArrayList;
import java.util.Random;

public class CorrectWords {

    private final ArrayList<String> fourLetter = new ArrayList<>();
    private final ArrayList<String> fiveLetter = new ArrayList<>();
    private final ArrayList<String> sixLetter = new ArrayList<>();
    private final ArrayList<String> sevenLetter = new ArrayList<>();
    private final Random random = new Random();

    private void initializeFourLetter() {
        fourLetter.add("able");
        fourLetter.add("bark");
        fourLetter.add("cake");
        fourLetter.add("dare");
        fourLetter.add("echo");
        fourLetter.add("fame");
        fourLetter.add("gaze");
        fourLetter.add("hike");
        fourLetter.add("idea");
        fourLetter.add("joke");
        fourLetter.add("kite");
        fourLetter.add("lamp");
        fourLetter.add("maze");
        fourLetter.add("note");
        fourLetter.add("open");
        fourLetter.add("park");
        fourLetter.add("quiz");
        fourLetter.add("rose");
        fourLetter.add("star");
        fourLetter.add("wave");
    }

    private void initializeFiveLetter(){
        fiveLetter.add("apple");
        fiveLetter.add("brave");
        fiveLetter.add("cloud");
        fiveLetter.add("dance");
        fiveLetter.add("eagle");
        fiveLetter.add("flame");
        fiveLetter.add("grape");
        fiveLetter.add("heart");
        fiveLetter.add("ivory");
        fiveLetter.add("juice");
        fiveLetter.add("knife");
        fiveLetter.add("lemon");
        fiveLetter.add("music");
        fiveLetter.add("noble");
        fiveLetter.add("ocean");
        fiveLetter.add("piano");
        fiveLetter.add("quiet");
        fiveLetter.add("river");
        fiveLetter.add("smile");
        fiveLetter.add("table");
    }

    private void initializeSixLetter(){
        sixLetter.add("action");
        sixLetter.add("beauty");
        sixLetter.add("camera");
        sixLetter.add("dinner");
        sixLetter.add("energy");
        sixLetter.add("family");
        sixLetter.add("garden");
        sixLetter.add("health");
        sixLetter.add("island");
        sixLetter.add("joyful");
        sixLetter.add("kindly");
        sixLetter.add("lively");
        sixLetter.add("memory");
        sixLetter.add("nature");
        sixLetter.add("orange");
        sixLetter.add("people");
        sixLetter.add("quaint");
        sixLetter.add("rhythm");
        sixLetter.add("silver");
        sixLetter.add("travel");
    }

    private void initializeSevenLetter() {
        sevenLetter.add("amazing");
        sevenLetter.add("believe");
        sevenLetter.add("courage");
        sevenLetter.add("diamond");
        sevenLetter.add("elegant");
        sevenLetter.add("freedom");
        sevenLetter.add("genuine");
        sevenLetter.add("harmony");
        sevenLetter.add("inspire");
        sevenLetter.add("journey");
        sevenLetter.add("kindred");
        sevenLetter.add("liberty");
        sevenLetter.add("mystery");
        sevenLetter.add("natural");
        sevenLetter.add("optimum");
        sevenLetter.add("passion");
        sevenLetter.add("quality");
        sevenLetter.add("respect");
        sevenLetter.add("sincere");
        sevenLetter.add("thought");
    }

    public String getCorrectWord(int length) {
        return switch (length) {
            case 4 -> getFourLetterWord();
            case 5 -> getFiveLetterWord();
            case 6 -> getSixLetterWord();
            case 7 -> getSevenLetterWord();
            default -> "Invalid length";
        };

    }

    private String getFourLetterWord(){
        initializeFourLetter();
        return this.fourLetter.get(this.random.nextInt(20));
    }

    private String getFiveLetterWord(){
        initializeFiveLetter();
        return this.fiveLetter.get(this.random.nextInt(20));
    }

    private String getSixLetterWord(){
        initializeSixLetter();
        return this.sixLetter.get(this.random.nextInt(20));
    }

    private String getSevenLetterWord(){
        initializeSevenLetter();
        return this.sevenLetter.get(this.random.nextInt(20));
    }
}
