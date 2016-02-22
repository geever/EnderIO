package crazypants.enderio.item.darksteel;

import crazypants.enderio.ModObject;
import crazypants.enderio.config.Config;
import crazypants.enderio.item.ItemMagnet;
import crazypants.util.ClientUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DarkSteelItems {

  public static ItemGliderWing itemGliderWing;

  public static ItemDarkSteelArmor itemDarkSteelHelmet;
  public static ItemDarkSteelArmor itemDarkSteelChestplate;
  public static ItemDarkSteelArmor itemDarkSteelLeggings;
  public static ItemDarkSteelArmor itemDarkSteelBoots;
  public static ItemDarkSteelSword itemDarkSteelSword;
  public static ItemDarkSteelPickaxe itemDarkSteelPickaxe;
  public static ItemDarkSteelAxe itemDarkSteelAxe;
  public static ItemDarkSteelShears itemDarkSteelShears;

  public static ItemMagnet itemMagnet;

  private DarkSteelItems() {
  }

  public static void createDarkSteelArmorItems() {
    itemGliderWing = ItemGliderWing.create();

    itemDarkSteelHelmet = ItemDarkSteelArmor.create(0);
    itemDarkSteelChestplate = ItemDarkSteelArmor.create(1);
    itemDarkSteelLeggings = ItemDarkSteelArmor.create(2);
    itemDarkSteelBoots = ItemDarkSteelArmor.create(3);

    itemDarkSteelSword = ItemDarkSteelSword.create();
    itemDarkSteelPickaxe = ItemDarkSteelPickaxe.create();
    itemDarkSteelAxe = ItemDarkSteelAxe.create();
    itemDarkSteelShears = ItemDarkSteelShears.create();

    itemMagnet = ItemMagnet.create();
  }

  public static void addLoot() {
    if(Config.lootTheEnder) {
      ItemStack sword = new ItemStack(itemDarkSteelSword, 1, 0);
      ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(sword, 1, 1, 5));
      ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(sword, 1, 1, 5));
      ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(sword, 1, 1, 4));
      ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(sword, 1, 1, 4));
    }

    if(Config.lootDarkSteelBoots) {
      ItemStack boots = new ItemStack(itemDarkSteelBoots, 1, 0);
      ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(boots, 1, 1, 5));
      ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(boots, 1, 1, 5));
    }
  }

  @SideOnly(Side.CLIENT)
  public static void registerItemRenderers() {  
    itemGliderWing.registerRenderers();
    
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelBoots, DarkSteelItems.itemDarkSteelBoots.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelLeggings, DarkSteelItems.itemDarkSteelLeggings.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelChestplate, DarkSteelItems.itemDarkSteelChestplate.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelHelmet, DarkSteelItems.itemDarkSteelHelmet.getItemName());
    
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelAxe, DarkSteelItems.itemDarkSteelAxe.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelSword, DarkSteelItems.itemDarkSteelSword.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelShears, DarkSteelItems.itemDarkSteelShears.getItemName());
    ClientUtil.registerRenderer(DarkSteelItems.itemDarkSteelPickaxe, DarkSteelItems.itemDarkSteelPickaxe.getItemName());
    
    ClientUtil.registerRenderer(itemMagnet, ModObject.itemMagnet.unlocalisedName);
  }
    
}
