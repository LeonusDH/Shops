package net.sparkzz.shops.command;

import net.sparkzz.shops.util.IMS;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.PlayerInventory;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class BuyCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource source, CommandContext args) {
        if (!(source instanceof Player)) {
            source.sendMessage(Text.of(TextColors.RED, "Only players can use this command!"));
            return CommandResult.success();
        }

        if (args.<Integer>getOne("quantity").get() <= 0) {
            source.sendMessage(Text.of(TextColors.RED, "Quantity must be greater than 0!"));
            return CommandResult.success();
        }

        ItemStack itemStack = ItemStack.builder().itemType(args.<ItemType>getOne("item").get()).quantity(args.<Integer>getOne("quantity").get()).build();
        PlayerInventory inventory = (PlayerInventory) ((Player) source).getInventory();

        if (IMS.getAvailableSpace(inventory, itemStack.getType()) - itemStack.getQuantity() <= 0) {
            source.sendMessage(Text.of(TextColors.RED, "There is no room to make this purchase!"));
            return CommandResult.success();
        }

        inventory.offer(itemStack);
        source.sendMessage(Text.of(TextColors.GREEN, "Transaction success!"));

        return CommandResult.success();
    }
}
