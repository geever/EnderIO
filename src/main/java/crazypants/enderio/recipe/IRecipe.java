package crazypants.enderio.recipe;

import javax.annotation.Nonnull;

import com.enderio.core.common.util.NNList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public interface IRecipe {

  boolean isValid();

  int getEnergyRequired();

  @Nonnull
  RecipeOutput[] getOutputs();

  @Nonnull
  RecipeInput[] getInputs();

  @Nonnull
  NNList<ItemStack> getInputStacks();

  NNList<FluidStack> getInputFluidStacks();

  @Nonnull
  RecipeBonusType getBonusType();

  boolean isInputForRecipe(MachineRecipeInput... inputs);

  boolean isValidInput(int slotNumber, @Nonnull ItemStack item);

  boolean isValidInput(@Nonnull FluidStack fluid);

  @Nonnull
  NNList<NNList<ItemStack>> getInputStackAlternatives();

  boolean isSynthetic();

}
