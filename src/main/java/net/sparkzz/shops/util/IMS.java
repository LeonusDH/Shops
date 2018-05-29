package net.sparkzz.shops.util;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.PlayerInventory;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;

import java.util.Optional;

/*
Inventory Management System
 */
public class IMS {

    public static Optional<ItemStack> removeItemFromPlayer(Inventory inventory, Optional<ItemStack> itemStack) {
        Inventory items = inventory.query(QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(itemStack.get()));

        if (items.peek(itemStack.get().getQuantity()).filter(stack -> stack.getQuantity() >= itemStack.get().getQuantity()).isPresent()) {
            items.poll(itemStack.get().getQuantity());
            return itemStack;
        }
        return Optional.empty();
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