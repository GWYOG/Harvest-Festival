package joshie.harvest.shops.purchasable;

import joshie.harvest.calendar.CalendarHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PurchasableYearWeekend extends PurchasableWeekend {
    private final int year;

    public PurchasableYearWeekend(long cost, ItemStack stack, int year) {
        super(cost, stack);
        this.year = year;
    }

    @Override
    public boolean canBuy(World world, EntityPlayer player) {
        return super.canBuy(world, player) && CalendarHelper.haveYearsPassed(world, player, year);
    }
}
