package net.sparkzz.shops.command;

import net.sparkzz.shops.Shops;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class Commands {

    private static CommandSpec info = CommandSpec.builder()
            .description(Text.of("Get shop info"))
            .executor(new ShopsCommand()).build();

    public static void register(Shops plugin) {
        Sponge.getCommandManager().register(plugin, info, "shops");
    }
}