package abstracts;

import Enums.OpenClose;
import exceptions.MyException;
import subjects.Hero;
import subjects.Point;

import java.util.ArrayList;

public abstract class Transport implements CanChangeLocation {
    private String name;
    private Point point;
    private Location location;
    private ArrayList<Passenger> passengers;
    private Illuminator illuminator;

    public Transport(String name, Point point, Location location, Passenger... passes) {
        this.name = name;
        this.point = point;
        this.location = location;
        illuminator = new Illuminator(OpenClose.CLOSE);
        this.joinToStory();
        System.out.println("Transport - " + name + " is situated in location " + this.location.getLocationName());
        this.passengers = new ArrayList<>(passes.length);
        this.addPassenger(passes);
    }

    public String getName() {
        return name;
    }

    private void joinToStory() {
        System.out.println("Transport " + name + " join to story");
    }

    public void addPassenger(Passenger... passes) {
        for (Passenger passenger : passes) {
            illuminator.open();
            this.passengers.add(passenger);
            System.out.println(passenger.getName() + " is situated in the Transport " + this.name);
            illuminator.close();
        }
    }

    public void subPassenger(Passenger pass) throws MyException.EmptyException {
        if (passengers == null) {
            throw new MyException.EmptyException("Transport " + name + " without passengers");
        }
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(pass.getName())) {
                illuminator.open();
                this.passengers.remove(passenger);
                System.out.println(pass.getName() + " exit transport " + name);
                illuminator.close();
                break;
            }
        }
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    private class Illuminator {
        private OpenClose openClose;

        private Illuminator(OpenClose openClose) {
            this.openClose = openClose;
        }

        private void close() throws MyException.EmptyException {
            if (openClose == OpenClose.CLOSE) {
                throw new MyException.EmptyException("Illuminator already is close");
            }
            openClose = OpenClose.CLOSE;
        }

        private void open() throws MyException.EmptyException {
            if (openClose == OpenClose.OPEN) {
                throw new MyException.EmptyException("Illuminator already is open");
            }
            openClose = OpenClose.OPEN;
        }
    }
}
