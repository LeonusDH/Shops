package net.sparkzz.shops.command;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class ShopsCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource source, CommandContext args) {
        source.sendMessage(Text.builder().color(TextColors.DARK_AQUA).append(Text.of("===[ Shops ]===")).build());
        source.sendMessage(Text.builder().color(TextColors.GREEN).append(Text.of("Created By: MrSparkzz")).build());
        source.sendMessage(Text.builder().color(TextColors.GREEN).append(Text.of("Version: 0.1.0-alpha")).build());
        source.sendMessage(Text.builder().color(TextColors.DARK_AQUA).append(Text.of("===[ Shops ]===")).build());

        return CommandResult.success();
    }
}
