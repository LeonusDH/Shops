package net.sparkzz.shops.util;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;

import java.util.Optional;

/*
Inventory Management System
 */
public class IMS {

    public static Optional<ItemStack> removeItemFromPlayer(Inventory inventory, Optional<ItemStack> itemStack) {
        Inventory items = inventory.query(QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(itemStack.get()));
        ItemStack tempStack = itemStack.get();

        if (items.peek(tempStack.getQuantity()).filter(stack -> stack.getQuantity() >= tempStack.getQuantity()).isPresent()) {
            items.poll(tempStack.getQuantity());
            return itemStack;
        }
        return Optional.empty();
    }
}