package implementations;

import interfaces.ICoffeeStrategy;

import java.util.Objects;

public class CoffeeContext {

    private ICoffeeStrategy coffeeStrategy;

    void setStrategy(String coffeeType) {
        if(Objects.equals(coffeeType, "Latte")) {
            coffeeStrategy = new LatteStrategy();
        } else if (Objects.equals(coffeeType, "Cappicino")) {
            coffeeStrategy = new CapiccinoStrategy();
        } else {
            coffeeStrategy = new ExpressoStrategy();
        }
    }

    void buy() {
        coffeeStrategy.createCoffee();
    }
}
