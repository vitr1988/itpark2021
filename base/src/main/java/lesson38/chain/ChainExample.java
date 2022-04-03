package lesson38.chain;

public class ChainExample {

    private Long id;
    private String name;
    private boolean enabled;

    public ChainExample setId(Long id) {
        this.id = id;
        return this;
    }

    public ChainExample setName(String name) {
        this.name = name;
        return this;
    }

    public ChainExample setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
