package implementations;

import enums.IngredientType;
import interfaces.ICoffeeStrategy;

import java.util.HashMap;
import java.util.Map;

public class ExpressoStrategy implements ICoffeeStrategy {

    private Map<IngredientType, Float> ingredient_quantity = new HashMap<>();

    private IngredientHolder ingredientHolder;

    public ExpressoStrategy() {
        ingredient_quantity.put(IngredientType.Water, 250f);
        ingredient_quantity.put(IngredientType.Milk, 0f);
        ingredient_quantity.put(IngredientType.Beans, 16f);
        ingredientHolder = IngredientHolder.getInstance();
    }

    @Override
    public void createCoffee() {
        if(checkIngredient()) {
            consumeIngredients();
            System.out.println("Expresso Dispatched");
        } else {
            throw new RuntimeException("Ingredients for Expresso is not sufficient");
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
        return 4;
    }

    private void consumeIngredients() {
        for(Map.Entry<IngredientType, Float> mapEntry : ingredient_quantity.entrySet()) {
            ingredientHolder.reduceIngredientQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }

}
