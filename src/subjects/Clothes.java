package subjects;

import abstracts.Item;
import abstracts.Location;

public abstract class Clothes implements Item {
    private String name;
    private Location location;
    private Point point;
    public Clothes(String name, Location location, Point point) {
        this.name = name;
        this.location = location;
        this.point = point;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getPoint() {
        return point;
    }
}
