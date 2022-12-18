package Enums;

public enum Thought {
    SEARCH("I need change location to Road (Searching)"),
    WITHOUT("null");
    private String name;
    Thought(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
