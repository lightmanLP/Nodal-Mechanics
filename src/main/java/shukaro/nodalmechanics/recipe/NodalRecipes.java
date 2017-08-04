package shukaro.nodalmechanics.recipe;

import fox.spiteful.forbidden.DarkAspects;
import fox.spiteful.forbidden.items.ForbiddenItems;
import WayofTime.alchemicalWizardry.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import shukaro.nodalmechanics.items.NodalItems;
import taintedmagic.common.registry.ItemRegistry;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;

import java.util.ArrayList;

public class NodalRecipes
{
    public static InfusionRecipe matrixRecipe;
    public static ShapedArcaneRecipe variedAttuneRecipe;
    public static ShapedArcaneRecipe sameAttuneRecipe;
    public static InfusionRecipe variedNodeRecipe;
    public static InfusionRecipe sameNodeRecipe;
    public NodalRecipes()
    {
        matrixRecipe = new InfusionRecipe("NODECATALYZATION", new ItemStack(NodalItems.itemMatrix), 10, new AspectList()
            .add(Aspect.GREED, 80)
            .add(DarkAspects.LUST, 16)
            .add(Aspect.MINE, 16), ItemApi.getBlock("blockJar", 0),
                                          new ItemStack[] {new ItemStack(ModItems.demonBloodShard, 1, 0),
                                                           new ItemStack(ForbiddenItems.deadlyShards, 1, 5),
                                                           new ItemStack(ForbiddenItems.deadlyShards, 1, 3),
                                                           new ItemStack(ItemRegistry.ItemMaterial, 1, 5)});
        AspectList attuneAspectList = new AspectList().add(Aspect.AIR, 2)
                                                      .add(Aspect.WATER, 2)
                                                      .add(Aspect.FIRE, 2)
                                                      .add(Aspect.ORDER, 2)
                                                      .add(Aspect.ENTROPY, 2)
                                                      .add(Aspect.EARTH, 2);
        ItemStack variedAttune = new ItemStack(NodalItems.itemMatrix);
        ItemStack[] phials = new ItemStack[6];
        ArrayList<Aspect> primalAspects = Aspect.getPrimalAspects();
        AspectList variedAspectList = new AspectList();
        for (int i = 0; i < primalAspects.size(); i++)
        {
            variedAspectList.add(primalAspects.get(i), 2);
            phials[i] = ItemApi.getItem("itemEssence", 1);
            NBTTagCompound tagCompound = new NBTTagCompound();
            AspectList phialAspectList = new AspectList().add(primalAspects.get(i), 8);
            phialAspectList.writeToNBT(tagCompound);
            phials[i].setTagCompound(tagCompound);
        }
        NBTTagCompound variedTagCompound = new NBTTagCompound();
        variedAspectList.writeToNBT(variedTagCompound);
        variedAttune.setTagCompound(variedTagCompound);
        variedAttuneRecipe =
            new ShapedArcaneRecipe("NODECATALYZATION", variedAttune, attuneAspectList, "ABC", " X ", "DEF", 'A',
                                   phials[0], 'B', phials[1], 'C', phials[2], 'D', phials[3], 'E', phials[4], 'F',
                                   phials[5], 'X', NodalItems.itemMatrix);
        ItemStack sameAttune = new ItemStack(NodalItems.itemMatrix);
        AspectList sameAspectList = new AspectList().add(Aspect.FIRE, 16);
        NBTTagCompound sameTagCompound = new NBTTagCompound();
        sameAspectList.writeToNBT(sameTagCompound);
        sameAttune.setTagCompound(sameTagCompound);
        ItemStack phial = ItemApi.getItem("itemEssence", 1);
        AspectList phialAspectList = new AspectList().add(Aspect.FIRE, 8);
        NBTTagCompound phialTagCompound = new NBTTagCompound();
        phialAspectList.writeToNBT(phialTagCompound);
        phial.setTagCompound(phialTagCompound);
        sameAttuneRecipe =
            new ShapedArcaneRecipe("NODECATALYZATION", sameAttune, attuneAspectList, "AAA", "ABA", "AAA", 'A',
                                   phial.copy(), 'B', NodalItems.itemMatrix);
        NBTTagCompound variedNodeTagCompound = new NBTTagCompound();
        AspectList variedNodeAspectList = new AspectList().add(Aspect.AIR, 2)
                                                          .add(Aspect.EARTH, 2)
                                                          .add(Aspect.FIRE, 2)
                                                          .add(Aspect.WATER, 2)
                                                          .add(Aspect.ORDER, 2)
                                                          .add(Aspect.ENTROPY, 2);
        variedNodeAspectList.writeToNBT(variedNodeTagCompound);
        variedNodeTagCompound.setInteger("nodetype", 0);
        ItemStack variedNode = ItemApi.getItem("itemJarNode", 0);
        variedNode.setTagCompound(variedNodeTagCompound);
        variedNodeRecipe = new InfusionRecipe("NODECATALYZATION", variedNode, 10, new AspectList().add(Aspect.AIR, 4)
                                                                                                  .add(Aspect.EARTH, 4)
                                                                                                  .add(Aspect.FIRE, 4)
                                                                                                  .add(Aspect.WATER, 4)
                                                                                                  .add(Aspect.ORDER, 4)
                                                                                                  .add(Aspect.ENTROPY,
                                                                                                       4), variedAttune,
                                              new ItemStack[] {ItemApi.getItem("itemResource", 14),
                                                               ItemApi.getItem("itemResource", 14),
                                                               ItemApi.getItem("itemResource", 14),
                                                               ItemApi.getItem("itemResource", 14)});
        NBTTagCompound sameNodeTagCompound = new NBTTagCompound();
        AspectList sameNodeAspectList = new AspectList().add(Aspect.FIRE, 16);
        sameNodeAspectList.writeToNBT(sameNodeTagCompound);
        sameNodeTagCompound.setInteger("nodetype", 0);
        ItemStack sameNode = ItemApi.getItem("itemJarNode", 0);
        sameNode.setTagCompound(sameNodeTagCompound);
        sameNodeRecipe =
            new InfusionRecipe("NODECATALYZATION", sameNode, 10, new AspectList().add(Aspect.FIRE, 32), sameAttune,
                               new ItemStack[] {ItemApi.getItem("itemResource", 14),
                                                ItemApi.getItem("itemResource", 14),
                                                ItemApi.getItem("itemResource", 14),
                                                ItemApi.getItem("itemResource", 14)});
    }
    @SuppressWarnings("unchecked")
    public void initRecipes()
    {
        ThaumcraftApi.addInfusionCraftingRecipe("NODECATALYZATION", new ItemStack(NodalItems.itemMatrix), 10,
                                                new AspectList().add(Aspect.GREED, 80)
                                                                .add(DarkAspects.LUST, 16)
                                                                .add(Aspect.MINE, 16), ItemApi.getBlock("blockJar", 0),
                                                new ItemStack[] {new ItemStack(ModItems.demonBloodShard, 1, 0),
                                                                 new ItemStack(ForbiddenItems.deadlyShards, 1, 5),
                                                                 new ItemStack(ForbiddenItems.deadlyShards, 1, 3),
                                                                 new ItemStack(ItemRegistry.ItemMaterial, 1, 5)});
        RecipeAttune recipeAttune = new RecipeAttune();
        ThaumcraftApi.getCraftingRecipes().add(recipeAttune);
        RecipeNode recipeNode = new RecipeNode();
        ThaumcraftApi.getCraftingRecipes().add(recipeNode);
    }
}
