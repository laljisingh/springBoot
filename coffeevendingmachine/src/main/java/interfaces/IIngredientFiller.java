package interfaces;

import enums.IngredientType;

public interface IIngredientFiller {

    void fill(IngredientType ingredientType, float quantity);
}
