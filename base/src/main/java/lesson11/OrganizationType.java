package lesson11;

public enum OrganizationType {
    OOO(100), ZAO(200, "ЗАО"), OAO(300, "ОАО");

    private final int number;
    private String name;

    OrganizationType(int number) {
        this.number = number;
    }

    OrganizationType(int number, String russianName) {
        this.number = number;
        this.name = russianName;
    }

    public int getNumber() {
        return number;
    }
}
