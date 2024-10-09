package Main;

import Entity.CoffeeCup;
import Entity.VirtualPerson;
import Exception.TooColdException;
import Exception.TooHotException;

public class Main {
    public static void main(String[] args) {
        VirtualPerson person = new VirtualPerson();
        CoffeeCup coldCup = new CoffeeCup(60);
        CoffeeCup hotCup = new CoffeeCup(90);
        CoffeeCup perfectCup = new CoffeeCup(75);


        try {
            person.drinkCoffee(coldCup);
        } catch (TooColdException | TooHotException e) {
            System.out.println(e.getMessage());
        }


        try {
            person.drinkCoffee(hotCup);
        } catch (TooColdException | TooHotException e) {
            System.out.println(e.getMessage());
        }

        try {
            person.drinkCoffee(perfectCup);
        } catch (TooColdException | TooHotException e) {
            System.out.println(e.getMessage());
        }
    }
}
