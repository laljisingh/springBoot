package implementations;

import enums.IngredientType;

import java.util.HashMap;
import java.util.Map;

public class IngredientHolder {

    private static IngredientHolder instance;

    private Map<IngredientType, Float> ingredient_quantity = new HashMap<>();

    private IngredientHolder() {
        ingredient_quantity.put(IngredientType.Water, 0.0f);
        ingredient_quantity.put(IngredientType.Beans, 0.0f);
        ingredient_quantity.put(IngredientType.Milk, 0.0f);
    }

    public static IngredientHolder getInstance() {
        if(instance == null) {
            instance = new IngredientHolder();
        }
        return instance;
    }

    public void setIngredientQuantity(IngredientType ingredientType, float quantity) {
        ingredient_quantity.put(ingredientType, ingredient_quantity.get(ingredientType) + quantity);
    }

    public void reduceIngredientQuantity(IngredientType ingredientType, float quantity) {
        ingredient_quantity.put(ingredientType, ingredient_quantity.get(ingredientType) - quantity);
    }

    public float getIngredientQuantity(IngredientType ingredientType) {
        return ingredient_quantity.get(ingredientType);
    }
}
