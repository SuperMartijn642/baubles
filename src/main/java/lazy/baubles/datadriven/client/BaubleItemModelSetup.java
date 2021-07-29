package lazy.baubles.datadriven.client;

import lazy.baubles.api.BaublesAPI;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BaubleItemModelSetup {

    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event) {
        BakedModel existingModel = event.getModelRegistry().get(BaublesItemModel.INVENTORY_MODEL);
        BaublesItemModel customModel = new BaublesItemModel(existingModel);
        event.getModelRegistry().put(BaublesItemModel.INVENTORY_MODEL, customModel);
    }

    @SubscribeEvent
    public static void onTextureStitching(TextureStitchEvent.Pre e) {
        if (!e.getMap().location().equals(TextureAtlas.LOCATION_BLOCKS)) return;
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/ring"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/amulet"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/charm"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/belt"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/body"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/head"));
        e.addSprite(new ResourceLocation(BaublesAPI.MOD_ID, "item/trinket"));
    }
}
