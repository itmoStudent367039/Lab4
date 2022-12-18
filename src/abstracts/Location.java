package abstracts;

public abstract class Location {
    private String name;
    private CelestialBody celestialBody;
    public Location(String name, CelestialBody celestialBody) {
        this.name = name;
        this.celestialBody = celestialBody;
    }
    public CelestialBody getCelestialBody() {
        return celestialBody;
    }
    public String getLocationName() {
        return name;
    }
    public Location() {}
}
