package com.blackninjamm.notJustBackpacks;

import com.blackninjamm.notJustBackpacks.lists.BlockList;
import com.blackninjamm.notJustBackpacks.lists.ItemList;
import com.google.common.eventbus.Subscribe;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("notjustbackpacks")
public class NotJustBackpacks
{
    public static NotJustBackpacks instance;
    public static final String modid = "notjustbackpacks";
    private static final Logger logger = LogManager.getLogger(modid);


    public NotJustBackpacks()
    {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("Setup method registered.");
    }

    private void clientRegistries(final FMLClientSetupEvent event)
    {
        logger.info("clientRegistries method registered.");
    }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll
            (
                ItemList.hardened_steel = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("hardened_steel")),

                ItemList.hardened_steel_block = new ItemBlock(BlockList.hardened_steel_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.hardened_steel_block.getRegistryName())
            );
            logger.info("Items registered");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll
            (
                BlockList.hardened_steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1f).sound(SoundType.METAL)).setRegistryName(location("hardened_steel_block"))


            );
            logger.info("Blocks registered");
        }

        @SubscribeEvent
        public void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event)
        {
            TileEntityType.register(packagedBlock.getRegistryName().toString(), TileEntityType.Builder.create());
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(modid, name);
        }

}

