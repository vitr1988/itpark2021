package lesson10.enumerattion;

public enum Language {
    RUSSIAN(1), ENGLISH(2), GERMAN(3), FRENCH(4);

    private int index;

    Language(int index) {
        this.index = index;
    }

    public static Language as(int index) {
        for (Language language : values()) {
            if (language.index == index) {
                return language;
            }
        }
        return Language.RUSSIAN;
    }

    public String asString() {
        return name().toLowerCase();
    }
}
