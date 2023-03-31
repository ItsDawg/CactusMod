package com.facs.cac;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ClientEventHandler
{
    @SubscribeEvent
    public void onRightClickBlock(final PlayerInteractEvent event) {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            BlockPos pl = null;
            final EntityPlayerSP pla = Minecraft.func_71410_x().field_71439_g;
            final String facename = event.face.name();
            if (facename == "UP") {
                pl = event.pos.func_177981_b(1);
            }
            else if (facename == "DOWN") {
                pl = event.pos.func_177979_c(1);
            }
            else if (facename == "SOUTH") {
                pl = event.pos.func_177970_e(1);
            }
            else if (facename == "NORTH") {
                pl = event.pos.func_177964_d(1);
            }
            else if (facename == "EAST") {
                pl = event.pos.func_177965_g(1);
            }
            else if (facename == "WEST") {
                pl = event.pos.func_177985_f(1);
            }
            final Block under = Minecraft.func_71410_x().field_71441_e.func_180495_p(pl.func_177979_c(1)).func_177230_c();
            String iname = "";
            if (pla.field_71071_by.func_70448_g() != null) {
                iname = pla.field_71071_by.func_70448_g().func_77977_a();
            }
            if (pl != null && pla.field_71071_by.func_70448_g() != null) {
                if (iname.contains("tile.sand")) {
                    if (under == Block.func_149684_b("air") || under == Block.func_149684_b("sand") || under == Block.func_149684_b("cactus")) {
                        event.setCanceled(true);
                    }
                }
                else if (iname.contains("item.string")) {
                    if (under != Block.func_149684_b("air")) {
                        event.setCanceled(true);
                    }
                }
                else if (iname.contains("tile.cactus") && under == Block.func_149684_b("cactus")) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
