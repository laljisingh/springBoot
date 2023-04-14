package implementations;

import enums.IngredientType;
import interfaces.ICoffeeStrategy;

import java.util.HashMap;
import java.util.Map;

public class CapiccinoStrategy implements ICoffeeStrategy {
    private Map<IngredientType, Float> ingredient_quantity = new HashMap<>();

    private IngredientHolder ingredientHolder;

    public CapiccinoStrategy() {
        ingredient_quantity.put(IngredientType.Water, 200f);
        ingredient_quantity.put(IngredientType.Milk, 100f);
        ingredient_quantity.put(IngredientType.Beans, 12f);
        ingredientHolder = IngredientHolder.getInstance();
    }

    @Override
    public void createCoffee() {
        if(checkIngredient()) {
            consumeIngredients();
            System.out.println("Expresso Dispatched");
        } else {
            throw new RuntimeException("Ingredients for Capiccino is not sufficient");
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
        return 6;
    }

    private void consumeIngredients() {
        for(Map.Entry<IngredientType, Float> mapEntry : ingredient_quantity.entrySet()) {
            ingredientHolder.reduceIngredientQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}
