package subjects;

import abstracts.AccelerationOfGravity;
import abstracts.CelestialBody;

public class Moon extends CelestialBody {
    public Moon(String name, AccelerationOfGravity gravity) {
        super(name, gravity);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Moon: " + this.getName();
    }

    @Override
    public int hashCode() {
        int result = this.getName() == null ? 0 : this.getName().hashCode();
        return (result * 41);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((Moon) obj).getName().equals(this.getName());
    }
}
