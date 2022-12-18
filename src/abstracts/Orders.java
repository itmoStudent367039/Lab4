package abstracts;

public enum Orders {
    GOTOTHEROCKET("have to go to the transport"),
    FOLLOWME("have to follow me"),
    TAKEISTRUMENTSFORCLIMBING("have to take ClimbingSet");
    private String name;
    Orders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
