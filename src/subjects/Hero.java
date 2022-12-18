package subjects;

import Enums.Thought;
import abstracts.*;
import exceptions.MyException;

import java.util.ArrayList;
import java.util.Arrays;

public class Hero implements CanChangeLocation, CanBeSeen, Passenger {
    private ToolSet toolSet;
    private String name;
    private Location location;
    private Point point;
    private Psyche psycheStatus;
    private Orders orders;
    private int weight;
    private int massage;
    private Hand hand;
    private Back back;
    private Belt belt;
    private CommunicationMedium communicationMedium;
    private Thought thought;
    private Suit suit;

    {
        hand = new Hand();
        back = new Back();
        belt = new Belt();
    }

    public Hero(String name, Location location, Point point, int massage, Thought thought, CommunicationMedium communicationMedium) {
        this.name = name;
        this.location = location;
        this.point = point;
        this.massage = massage;
        this.setWeight();
        this.joinToStory();
        this.setPsycheStatus();
        this.thought = thought;
        this.communicationMedium = communicationMedium;
    }

    public Hand getHand() {
        return hand;
    }

    public void dress(Suit suit) throws MyException.EmptyException {
        if (suit == null) {
            throw new MyException.EmptyException(name + " can't dress, suit is empty");
        }
        System.out.println(name + " wears " + suit.getName());
        this.suit = suit;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPsycheStatus() {
        if (name.equals("Клепка") && weight < massage * AccelerationOfGravity.EARTHGRAVITY.getValueOfGravity()) {
            System.out.println(name + " is situated in " + location.getCelestialBody().getName() + "\n" + "Weight of " + name + " is pretty low");
            psycheStatus = Psyche.NOTNORMAL;
            System.out.println(name + " went mad");
        } else
            psycheStatus = Psyche.NORMAL;
    }

    public Psyche getPsycheStatus() {
        return this.psycheStatus;
    }

    public void setWeight() {
        weight = massage * (location.getCelestialBody().getGravity().getValueOfGravity());
    }

    private void joinToStory() {
        System.out.println("Hero " + name + " joins to story");
    }

    @Override
    public void setLocation(Location location) throws MyException.EmptyException {
        if (location == null) {
            throw new MyException.EmptyException(name + " can't change location, it's empty");
        }
        this.location = location;
        System.out.println("Hero " + name + " moved to location " + location.getLocationName());
    }

    public void go(int x) {
        point.sumX(x);
        System.out.println("Hero " + name + " go location " + location.getLocationName() + " его координаты " + point.getX());
    }

    public void jump() {
        System.out.println(name + " is jumping " + location.getLocationName());
    }

    public void goWithJumps() {
        point.sumX(20);
        System.out.println("Hero " + name + " go with jumps location " + location.getLocationName() + " его координаты " + point.getX());
    }

    public void see(CanBeSeen object) throws MyException.EmptyException {
        if (object == null) {
            throw new MyException.EmptyException(name + "can't see null!");
        }
        if (object.getPoint().getX() >= point.getX() && this.getLocation().equals(object.getLocation())) {
            if (object instanceof Hero) {
                System.out.println(name + " sees " + object.getName() + "\n" + object.getName() + " is situated in location " + object.getLocation().getLocationName());
                System.out.println("His point is " + object.getPoint().getX());
                Hero obj = (Hero) object;
                if (obj.getHand().getItem() != null) {
                    System.out.println("In " + obj.getName() + "'s " + "hands is smth");
                }
            } else if (object.getPoint().getX() - point.getX() >= 6) {
                System.out.println(name + ": I see smth, but I can't name it, it's so far");
            } else {
                System.out.println(name + " sees " + object.getName() + "\n" + object.getName() + " is situated in location " + object.getLocation().getLocationName());
                System.out.println("His point is " + object.getPoint().getX());
            }
        } else {
            System.out.println(name + " sees nothing");
        }
    }

    public void catchUpSomeone(Hero hero) throws MyException.EmptyException {
        try {
        System.out.println(name + " catches " + hero.name);
        this.point.setX(hero.point.getX());
        } catch (NullPointerException exp) {
            throw new MyException.EmptyException(name + " can't see null!");
        }
    }

    public void thinkAbout(Hero hero) throws MyException.EmptyException {
        if (hero == null) {
            throw new MyException.EmptyException(name + " can't think about null!");
        }
        if (hero.getPsycheStatus().equals(Psyche.NOTNORMAL)) {
            System.out.println(hero.getName() + " feels bad, his psyche is " + hero.getPsycheStatus() + " " + this.getName() + " needs to send him to transport");
            this.orders = Orders.GOTOTHEROCKET;
        } else {
            System.out.println("He is alright");
        }
    }

    public void think() {
        System.out.println(thought.getName());
    }

    public void toOrder(Hero... heroes) throws MyException.EmptyException{
        for (Hero hero: heroes) {
            if (hero == null) {
                throw new MyException.EmptyException(name + " can't order to null");
            }
        }
        if (this.communicationMedium != null) {
            for (Hero hero : heroes) {
                System.out.println(name + " orders по " + communicationMedium.getName() + ": " + hero.getName() + " " + this.orders.getName());
            }
        }
    }

    public void setOrders(Orders order) throws MyException.EmptyException{
        if (order == null) {
            throw new MyException.EmptyException(name + " can't have order 'null'");
        }
        this.orders = order;
    }

    public void abey(Hero hero) throws MyException.EmptyException{
        if (hero == null) {
            throw new MyException.EmptyException(name + " can't abey to null");
        }
        if (this.psycheStatus == Psyche.NOTNORMAL) {
            System.out.println(this.name + ": I won't abey you, man");
            this.tumble();
        } else if (hero.orders == Orders.GOTOTHEROCKET) {
            System.out.println("Ok, I do it");
        }
    }

    public void take(Item item) {
        System.out.println(name + " take " + item.getName());
        hand.take(item);
    }

    public void putToBelt(Item... items) {
        for(Item item: items) {
            System.out.println(name + " put to belt item " + item.getName());
        }
        belt.put(items);
    }

    public void putToBack(Item item) {
        System.out.println(name + " put to back item " + item.getName());
        back.put(item);
    }

    public void tumble() {
        class PointChanger {
            public void changePoint(Hero hero) {
                if (hero.getPsycheStatus() == Psyche.NOTNORMAL) {
                    for (int i = 0; i < 10; i++) {
                        if (i % 2 == 0) {
                            hero.getPoint().sumX((int) (Math.random()*2));
                            System.out.println(hero.getPoint().getX() + " is tumble");
                        } else {
                            hero.getPoint().sumX((int) (-Math.random()*2));
                            System.out.println(hero.getPoint().getX() + " is tumble");
                        }
                    }
                }
            }
        }
        PointChanger zxc = new PointChanger();
        zxc.changePoint(this);
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Hero: " + name;
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
        return ((Hero) obj).name.equals(name);
    }

    public void addToolSet(ToolSet toolSet) {
        this.toolSet = toolSet;
    }

    private class Hand {
        private Item item;

        private void take(Item item) {
            this.item = item;
        }

        private Item getItem() {
            return item;
        }
    }

    private class Back {
        private Item item;

        private void put(Item item) {
            this.item = item;
        }
    }

    private class Belt {
        private ArrayList<Item> items;

        {
            items = new ArrayList();
        }

        private void put(Item... items) {
            this.items.addAll(Arrays.asList(items));
        }
    }
}
