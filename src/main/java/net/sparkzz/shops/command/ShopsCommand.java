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
        source.sendMessage(Text.of(TextColors.DARK_AQUA, "===[ Shops ]==="));
        source.sendMessage(Text.of(TextColors.GREEN, "Created By: MrSparkzz"));
        source.sendMessage(Text.of(TextColors.GREEN, "Version: Alpha"));
        source.sendMessage(Text.of(TextColors.DARK_AQUA, "===[ Shops ]==="));

        return CommandResult.success();
    }
}
