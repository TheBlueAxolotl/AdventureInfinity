package com.blueaxolotl.infinitymod.Item;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.Item.custom.ModSpawnEggs;
import com.blueaxolotl.infinitymod.entities.ModEntityTypes;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfinityMod.MOD_ID);


        public static final RegistryObject<Item> MAGINITE = ITEMS.register("maginite",
                () -> new Item(new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

        public static final RegistryObject<Item> TANZANITE = ITEMS.register("tanzanite",
            () -> new Item(new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

    public static final RegistryObject<Item> MAGINITE_SWORD = ITEMS.register("maginite_sword",
            () -> new SwordItem(ModItemTier.MAGINITE, 3, 3f,
        new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

    public static final RegistryObject<Item> INFUSED_SWORD = ITEMS.register("infused_sword",
            () -> new SwordItem(ModItemTier.TANZANITE, 3, 3f,
                    new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

    public static final RegistryObject<ModSpawnEggs> PROTECTOR_SPAWN_EGG = ITEMS.register("protector_spawn_egg",
            () -> new ModSpawnEggs(ModEntityTypes.PROTECTOR, 0xff00ff, 0xcc00cc,
                    new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

    public static final RegistryObject<ModSpawnEggs> PIXIE_SPAWN_EGG = ITEMS.register("pixie_spawn_egg",
            () -> new ModSpawnEggs(ModEntityTypes.PIXIE, 0xe888ff, 0xe67cff,
                    new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));

    public static final RegistryObject<ModSpawnEggs> SNAKE_SPAWN_EGG = ITEMS.register("snake_spawn_egg",
            () -> new ModSpawnEggs(ModEntityTypes.SNAKE, 0x27F320, 0x27F320,
                    new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
