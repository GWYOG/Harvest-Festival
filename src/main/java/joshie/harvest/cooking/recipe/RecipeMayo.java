package joshie.harvest.cooking.recipe;

import joshie.harvest.animals.HFAnimals;
import joshie.harvest.api.cooking.Ingredient;
import joshie.harvest.api.cooking.RecipeHandler;
import joshie.harvest.api.cooking.Utensil;
import joshie.harvest.api.core.ISizeable.Size;
import joshie.harvest.core.HFCore;
import joshie.harvest.tools.ToolHelper;
import net.minecraft.item.ItemStack;

import java.util.List;

public class RecipeMayo implements RecipeHandler {
    @Override
    public ItemStack getResult(Utensil utensil, List<ItemStack> stacks, List<Ingredient> ingredients) {
        if (utensil != Utensil.COUNTER) return null;
        if (stacks.size() != 2) return null;
        ItemStack egg = ToolHelper.isOil(stacks.get(0)) ? stacks.get(1) : stacks.get(0);
        Size size = HFAnimals.EGG.matches(egg) ? HFCore.SIZEABLE.getSize(egg) : Size.SMALL;
        if (ingredients.contains(HFIngredients.OIL) && ingredients.contains(HFIngredients.OIL)) {
            if (ingredients.contains(HFIngredients.EGG)) {
                return HFAnimals.MAYONNAISE.getStack(size);
            }
        }

        return null;
    }
}