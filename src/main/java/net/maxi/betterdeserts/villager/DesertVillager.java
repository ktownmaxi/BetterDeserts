package net.maxi.betterdeserts.villager;

import com.google.common.collect.ImmutableSet;
import net.maxi.betterdeserts.MainClass;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class DesertVillager {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MainClass.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MainClass.MOD_ID);

    public static final RegistryObject<PoiType> DESERT_VILLAGER_POI = POI_TYPES.register("desert_villager_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.CHISELED_RED_SANDSTONE.getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> DESERT_MASTER = VILLAGER_PROFESSIONS.register("desert_master",
            () -> new VillagerProfession("desert_master", x -> x.get() == DESERT_VILLAGER_POI.get(),
                    x -> x.get() == DESERT_VILLAGER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CARTOGRAPHER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiTypes.class,
                    "registerBlockStates", PoiType.class).invoke(null, DESERT_VILLAGER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }


}
