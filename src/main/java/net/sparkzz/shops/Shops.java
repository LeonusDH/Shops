package net.sparkzz.shops;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.service.ChangeServiceProviderEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.economy.EconomyService;

import javax.inject.Inject;
import java.util.Optional;

import static net.sparkzz.shops.command.Commands.register;

@Plugin(id = "shops", name = "Shops", version = "0.4.0-alpha", description = "Command Based Shops", authors = {"MrSparkzz"})
public class Shops {

    private static Optional<EconomyService> economy;

    @Inject
    private Logger logger;

    @Listener
    public void onServerInit(GameInitializationEvent event) {
        register(this);
        logger.debug("Commands Initialized");
    }

    public static Optional<EconomyService> getEconomy() {
        return economy;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Shops v0.4.0-alpha");
    }

    @Listener
    public void onChangeServiceProvider(ChangeServiceProviderEvent event) {
        if (event.getService().equals(EconomyService.class))
            economy = Optional.of((EconomyService) event.getNewProviderRegistration());
    }
}