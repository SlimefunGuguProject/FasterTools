package me.smourad.fastertools.item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import me.smourad.fastertools.event.PlayerMiningBlockEvent;

import javax.annotation.Nonnull;

public interface FasterToolUseHandler extends ItemHandler {

    void onToolUse(PlayerMiningBlockEvent event);

    @Override
    @Nonnull
    default Class<? extends ItemHandler> getIdentifier() {
        return FasterToolUseHandler.class;
    }

}
