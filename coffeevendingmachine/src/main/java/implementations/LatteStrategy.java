package implementations;

import enums.IngredientType;
import interfaces.ICoffeeStrategy;

import java.util.HashMap;
import java.util.Map;

public class LatteStrategy implements ICoffeeStrategy {

    private Map<IngredientType, Float> ingredient_quantity = new HashMap<>();

    private IngredientHolder ingredientHolder;

    public LatteStrategy() {
        ingredient_quantity.put(IngredientType.Water, 350f);
        ingredient_quantity.put(IngredientType.Milk, 75f);
        ingredient_quantity.put(IngredientType.Beans, 20f);
        ingredientHolder = IngredientHolder.getInstance();
    }

    @Override
    public void createCoffee() {
        if(checkIngredient()) {
            consumeIngredients();
            System.out.println("Expresso Dispatched");
        } else {
            throw new RuntimeException("Ingredients for Latte is not sufficient");
        }
    }

    @Override
    public boolean checkIngredient() {
        for(Map.Entry<IngredientType, Float> mapEntry : ingredient_quantity.entrySet()) {
            if(ingredientHolder.getIngredientQuantity(mapEntry.getKey()) < mapEntry.getValue())
                return false;
        }
        return true;
    }

    @Override
    public float getPrice() {
        return 7;
    }

    private void consumeIngredients() {
        for(Map.Entry<IngredientType, Float> mapEntry : ingredient_quantity.entrySet()) {
            ingredientHolder.reduceIngredientQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}
