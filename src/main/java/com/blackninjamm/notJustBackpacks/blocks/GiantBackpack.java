package com.blackninjamm.notJustBackpacks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;

public class GiantBackpack extends Block
{
    public GiantBackpack(Properties properties)
    {
        super(properties);
    }
/*
    @SubscribeEvent
    private void clickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        if (event.getUseBlock() == Event.Result.ALLOW)
        {

        }
    }
*/
}
