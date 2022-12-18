package main;

import Enums.Thought;
import abstracts.*;
import exceptions.MyException;
import subjects.*;

public class Story {

    public static void main(String[] args) throws MyException.ScenarioException {
        try {
            CelestialBody body = new Moon("Луна", AccelerationOfGravity.MOONGRAVITY);
            Location inTransport = new InToTheTransport("Около транспорта", body);
            Location landingPlace = new LandingSite("Место приземления", body);
            Hero znaika = new Hero("Знайка", inTransport, new Point(0, 0), 40, Thought.SEARCH, new Radio("Рация"));
            Hero kubik = new Hero("Кубик", inTransport, new Point(0, 0), 45, Thought.WITHOUT, new Radio("Рация"));
            Hero tubik = new Hero("Тюбик", inTransport, new Point(0, 0), 42, Thought.WITHOUT, new Radio("Рация"));
            Hero zvezdochkin = new Hero("Звездочкин", inTransport, new Point(0, 0), 47, Thought.WITHOUT, new Radio("Рация"));
            Hero steklyashkin = new Hero("Стекляшкин", inTransport, new Point(0, 0), 39, Thought.WITHOUT, new Radio("Рация"));
            Hero klepka = new Hero("Клепка", inTransport, new Point(0, 0), 35, Thought.WITHOUT, new Radio("Рация"));
            Transport transport = new Rocket("Ракета", new Point(0, 0), landingPlace, znaika, kubik, tubik, zvezdochkin, steklyashkin, klepka);
            Location closeToTransport = new NextToTransport("Около ракеты", body);
            znaika.dress(new SpaceSuit("Скафандр"));
            transport.subPassenger(znaika);
            znaika.setLocation(closeToTransport);
            znaika.think();
            Location onRoad = new Road("Дорога", body, 100);
            znaika.setLocation(onRoad);
            znaika.setOrders(Orders.TAKEISTRUMENTSFORCLIMBING);
            znaika.toOrder(kubik, tubik, zvezdochkin, steklyashkin, klepka);
            kubik.dress(new SpaceSuit("Скафандр"));
            tubik.dress(new SpaceSuit("Скафандр"));
            steklyashkin.dress(new SpaceSuit("Скафандр"));
            zvezdochkin.dress(new SpaceSuit("Скафандр"));
            klepka.dress(new SpaceSuit("Скафандр"));
            kubik.take(new Alpenstock("Алпенсток"));
            kubik.putToBelt(new IcePick("Ледоруб"), new Wire("Веревка"));
            zvezdochkin.take(new Alpenstock("Алпенсток"));
            zvezdochkin.putToBelt(new IcePick("Ледоруб"), new Wire("Веревка"));
            klepka.take(new Alpenstock("Алпенсток"));
            klepka.putToBelt(new IcePick("Ледоруб"), new Wire("Веревка"));
            tubik.take(new Alpenstock("Алпенсток"));
            tubik.putToBelt(new IcePick("Ледоруб"), new Wire("Веревка"));
            steklyashkin.take(new Alpenstock("Алпенсток"));
            steklyashkin.putToBelt(new IcePick("Ледоруб"), new Wire("Веревка"));
            Optics telescope = new Telescope("Телескоп");
            steklyashkin.putToBack(telescope);
            znaika.setOrders(Orders.FOLLOWME);
            znaika.toOrder(kubik, tubik, steklyashkin, zvezdochkin, klepka);
            znaika.go(15);
            transport.subPassenger(kubik);
            transport.subPassenger(tubik);
            transport.subPassenger(zvezdochkin);
            transport.subPassenger(steklyashkin);
            kubik.setLocation(closeToTransport);
            tubik.setLocation(closeToTransport);
            zvezdochkin.setLocation(closeToTransport);
            steklyashkin.setLocation(closeToTransport);
            kubik.setLocation(onRoad);
            tubik.setLocation(onRoad);
            zvezdochkin.setLocation(onRoad);
            steklyashkin.setLocation(onRoad);
            kubik.go(10);
            tubik.go(10);
            zvezdochkin.go(10);
            steklyashkin.go(10);
            transport.subPassenger(klepka);
            klepka.setLocation(closeToTransport);
            klepka.jump();
            klepka.setLocation(onRoad);
            klepka.goWithJumps();
            znaika.see(klepka);
            znaika.thinkAbout(klepka);
            znaika.toOrder(klepka);
            klepka.abey(znaika);
            Item boot = new Clothes("Ponchik's boot", onRoad, new Point(26, 0)) {
                @Override
                public Location getLocation() {
                    return super.getLocation();
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public Point getPoint() {
                    return super.getPoint();
                }
            };
            znaika.see(boot);
            znaika.go(10);
            znaika.see(boot);
            znaika.take(boot);
            kubik.see(znaika);
            kubik.catchUpSomeone(znaika);
        } catch (Exception exp) {
            exp.printStackTrace();
            System.out.println("Smth is wrong");
            throw new MyException.ScenarioException();
        }
    }
}
