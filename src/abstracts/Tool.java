package abstracts;

import subjects.Point;

public abstract class Tool implements Item {
    private String name;
    private Location location;
    private Point point;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }
}
