package net.sparkzz.shops.util;

import net.sparkzz.shops.Shops;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

/*
Point of Sale system
 */
public class POS {

    public static Optional<UniqueAccount> requestAccount(Player player) {
        if (!Shops.getEconomy().isPresent()) {
            player.sendMessage(Text.of(TextColors.RED, "Could not retrieve economy! Please contact an administrator."));
            return Optional.empty();
        }

        Optional<UniqueAccount> account = Shops.getEconomy().get().getOrCreateAccount(player.getUniqueId());

        if (!account.isPresent()) {
            player.sendMessage(Text.of(TextColors.RED, "There was an error accessing your account!"));
            return Optional.empty();
        }

        return account;
    }
}