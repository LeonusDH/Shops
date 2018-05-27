package net.sparkzz.shops;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import javax.inject.Inject;

import static net.sparkzz.shops.command.Commands.register;

@Plugin(id = "shops", name = "Shops", version = "0.1.0-alpha", description = "Command Based Shops", authors = {"MrSparkzz"})
public class Shops {

    @Inject
    private Logger logger;

    @Listener
    public void onServerInit(GameInitializationEvent event) {
        register(this);
        logger.debug("Commands Initialized");
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Shops v0.0.0-alpha");
    }
}