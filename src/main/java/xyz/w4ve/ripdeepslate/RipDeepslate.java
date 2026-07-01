package xyz.w4ve.ripdeepslate;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RipDeepslate implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("RipDeepslate");

    @Override
    public void onInitialize() {
        LOGGER.info("RipDeepslate loaded: deepslate now mines like stone with a netherite pickaxe.");
    }
}
