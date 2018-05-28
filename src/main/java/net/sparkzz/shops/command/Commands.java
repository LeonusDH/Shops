package net.sparkzz.shops.command;

import net.sparkzz.shops.Shops;
import org.spongepowered.api.CatalogTypes;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class Commands {

    private static CommandSpec info = CommandSpec.builder()
            .description(Text.of("Get shop info"))
            .executor(new ShopsCommand()).build();
    private static CommandSpec sell = CommandSpec.builder()
            .description(Text.of("Sell an item to a shop"))
            .arguments(
                    GenericArguments.catalogedElement(Text.of("item"), CatalogTypes.ITEM_TYPE),
                    GenericArguments.integer(Text.of("quantity"))
            )
            .executor(new SellCommand()).build();


    public static void register(Shops plugin) {
        Sponge.getCommandManager().register(plugin, info, "shops");
        Sponge.getCommandManager().register(plugin, sell, "sell");
    }
}