package com.facs.cac;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "cac", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class Main
{
    public static final String MODID = "cac";
    public static final String VERSION = "1.0";
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register((Object)new ClientEventHandler());
    }
}
