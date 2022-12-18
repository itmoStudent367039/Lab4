package abstracts;

public abstract class CelestialBody {
    private String name;
    private AccelerationOfGravity gravity;
    public CelestialBody(String name, AccelerationOfGravity gravity) {
        this.name = name;
        this.gravity = gravity;
    }
    public CelestialBody() {}
    public String getName() {
        return name;
    }
    public AccelerationOfGravity getGravity() {
        return gravity;
    }
}
