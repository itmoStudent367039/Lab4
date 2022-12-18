package abstracts;

public class LocationChanger {
    public void changeLocation(CanChangeLocation thing, Location location) {
        thing.setLocation(location);
    }
}
