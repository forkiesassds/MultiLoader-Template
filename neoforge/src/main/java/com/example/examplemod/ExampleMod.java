package com.example.examplemod;

import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(Constants.MOD_ID)
public class ExampleMod {

    public ExampleMod(IEventBus bus) {
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        if (FMLLoader.getDist().isClient()) {
            CommonClientClass.init();
        }
        bus.addListener(ExampleMod::onGatherData);
    }

    private static void onGatherData(GatherDataEvent event) {
        FabricDataGenHelper.runDatagenForMod(Constants.MOD_ID, Constants.MOD_ID, new ExampleModDatagen(), event);
    }
}