package subjects;

import abstracts.CelestialBody;
import abstracts.Location;

public class InToTheTransport extends Location {
    public InToTheTransport(String name, CelestialBody celestialBody) {
        super(name, celestialBody);
    }

    @Override
    public String getLocationName() {
        return super.getLocationName();
    }

    @Override
    public int hashCode() {
        int result = this.getLocationName() == null ? 0 : this.getLocationName().hashCode();
        return (result) * 41;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((InToTheTransport) obj).getLocationName().equals(this.getLocationName());
    }

    @Override
    public String toString() {
        return "InToTheTransport: " + this.getLocationName();
    }
}
