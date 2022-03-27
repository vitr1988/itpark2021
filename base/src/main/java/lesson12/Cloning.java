package lesson12;

public class Cloning implements Cloneable {
    private String name;
    private Long id;
    private Double size;

    public Cloning(Cloning copy) {
        this.id = copy.id;
        this.name = copy.name;
        this.size = copy.size;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
