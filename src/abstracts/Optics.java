package abstracts;

import subjects.Point;

public abstract class Optics implements Item{
    private String name;
    private Location location;
    private Point point;

    public Optics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Point getPoint() {
        return point;
    }
}
