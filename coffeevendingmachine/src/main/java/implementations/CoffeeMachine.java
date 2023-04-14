package implementations;

import enums.IngredientType;
import interfaces.IIngredientFiller;

import java.util.Map;

public class CoffeeMachine {

    private IIngredientFiller ingredientFiller;

    private CoffeeContext coffeeContext;

    public CoffeeMachine() {
        ingredientFiller = new CoffeeIngredientFiller();
        coffeeContext = new CoffeeContext();
    }

    void buyCoffee(String type) {
        coffeeContext.setStrategy(type);
        coffeeContext.buy();
    }

    void fillIngredients(Map<IngredientType, Float> ingredients) {
        for(Map.Entry<IngredientType, Float> entrySet : ingredients.entrySet()) {
            ingredientFiller.fill(entrySet.getKey(), entrySet.getValue());
        }
    }
}
