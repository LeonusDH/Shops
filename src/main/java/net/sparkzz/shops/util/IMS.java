package net.sparkzz.shops.util;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.PlayerInventory;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

/*
Inventory Management System
 */
public class IMS {

    public static boolean transferFrom(Player player, ItemStack itemStack) {
        Inventory inventory = player.getInventory();

        if (!inventory.contains(itemStack)) {
            player.sendMessage(Text.of(TextColors.RED, String.format("Could not find % in your inventory!", itemStack.getTranslation().get())));
            return false;
        }

        Inventory items = inventory.query(QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(itemStack));

        if (items.peek(itemStack.getQuantity()).filter(stack -> stack.getQuantity() >= itemStack.getQuantity()).isPresent())
            items.poll(itemStack.getQuantity());
        return true;
    }

    public static boolean transferTo(Player player, ItemStack itemStack) {
        Inventory inventory = player.getInventory();

        if (getAvailableSpace((PlayerInventory) inventory, itemStack.getType()) - itemStack.getQuantity() <= 0) {
            player.sendMessage(Text.of(TextColors.RED, "There is no room to make this purchase!"));
            return false;
        }

        inventory.offer(itemStack);
        return true;
    }

    public static int getAvailableSpace(PlayerInventory inventory, ItemType item) {
        int total = 0;

        for (Inventory slot : (inventory.getMainGrid().slots())) {
            Optional<ItemStack> contents = slot.peek();

            if (contents.isPresent()) {
                if (contents.get().getType() == item)
                    total += contents.get().getMaxStackQuantity() - contents.get().getQuantity();
            } else total += item.getMaxStackQuantity();
        }

        for (Inventory slot : inventory.getHotbar().slots()) {
            Optional<ItemStack> contents = slot.peek();

            if (contents.isPresent()) {
                if (contents.get().getType() == item)
                    total += contents.get().getMaxStackQuantity() - contents.get().getQuantity();
            } else total += item.getMaxStackQuantity();
        }
        return total += 1;
    }
}