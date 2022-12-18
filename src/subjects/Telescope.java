package subjects;

import abstracts.Location;
import abstracts.Optics;

public class Telescope extends Optics {
    public Telescope(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
    }

    @Override
    public void setLocation(Location location) {
        super.setLocation(location);
    }
}
