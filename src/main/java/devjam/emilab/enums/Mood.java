package devjam.emilab.enums;

public enum Mood {
    GREAT("Great"),
    GOOD("Good"),
    OKAY("Okay"),
    DOWN("Down"),
    BAD("Bad");

    private String value;

    public String getValue() {
        return value;
    }

    private Mood(String value) {
        this. value = value;
    }

}
