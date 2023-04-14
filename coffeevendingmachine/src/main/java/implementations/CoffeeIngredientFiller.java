package implementations;

import enums.IngredientType;
import interfaces.IIngredientFiller;

public class CoffeeIngredientFiller implements IIngredientFiller {
    private IngredientHolder ingredientHolder;

    public CoffeeIngredientFiller() {
        ingredientHolder = IngredientHolder.getInstance();
    }
    @Override
    public void fill(IngredientType ingredientType, float quantity) {
        ingredientHolder.setIngredientQuantity(ingredientType, quantity);
    }
}
