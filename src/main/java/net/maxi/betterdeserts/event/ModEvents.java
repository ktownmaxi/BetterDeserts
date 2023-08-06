package net.maxi.betterdeserts.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.maxi.betterdeserts.villager.DesertVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber
    public static class ForgeEvents{
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if(event.getType() == DesertVillager.DESERT_MASTER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack wbucket_stack = new ItemStack(Items.WATER_BUCKET);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        wbucket_stack, 2, 15, 0.02F));

            }

                if (event.getType() == DesertVillager.DESERT_MASTER.get()) {
                    Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                    ItemStack wbottle_stack = new ItemStack(Items.GLASS_BOTTLE);
                    int villagerLevel = 1;

                    trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.EMERALD, 1),
                            wbottle_stack, 5, 3, 0.02F));
                }
        }
    }
}
