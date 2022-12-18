package abstracts;

public abstract class CommunicationMedium {
    private String name;
    public CommunicationMedium(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
