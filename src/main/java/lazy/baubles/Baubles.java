package lazy.baubles;

import lazy.baubles.api.BaublesAPI;
import lazy.baubles.api.cap.CapabilityBaubles;
import lazy.baubles.client.gui.PlayerExpandedScreen;
import lazy.baubles.client.renderer.BaublesRenderLayer;
import lazy.baubles.network.PacketHandler;
import lazy.baubles.setup.ModConfigs;
import lazy.baubles.setup.ModItems;
import lazy.baubles.setup.ModMenus;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

import java.util.Map;

@Mod(BaublesAPI.MOD_ID)
public class Baubles {

    public static final KeyMapping KEY_BAUBLES = new KeyMapping("keybind.baublesinventory", GLFW.GLFW_KEY_B, "key.categories.inventory");

    public Baubles() {
        ModConfigs.registerAndLoadConfig();
        ModItems.init();
        ModMenus.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    }

    private void setupCommon(FMLCommonSetupEvent event) {
        CapabilityBaubles.register();
        PacketHandler.registerMessages();
    }

    private void setupClient(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenus.PLAYER_BAUBLES.get(), PlayerExpandedScreen::new);
        ClientRegistry.registerKeyBinding(KEY_BAUBLES);
    }
}
