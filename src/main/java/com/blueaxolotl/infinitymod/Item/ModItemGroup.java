package com.blueaxolotl.infinitymod.Item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup INFINITY_GROUP = new ItemGroup("infinityModTab") {
        @Override
        public ItemStack createIcon()
        {

            return new ItemStack(ModItems.MAGINITE.get());
        }
    };


}
