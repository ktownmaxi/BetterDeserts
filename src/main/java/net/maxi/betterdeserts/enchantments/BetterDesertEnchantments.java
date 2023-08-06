package net.maxi.betterdeserts.enchantments;

import net.maxi.betterdeserts.MainClass;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BetterDesertEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MainClass.MOD_ID);

    public static RegistryObject<Enchantment> SAND_SPEED =
            ENCHANTMENTS.register("sand_speed",
                    () -> new SandSpeedEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR_FEET, EquipmentSlot.FEET)
            );

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
