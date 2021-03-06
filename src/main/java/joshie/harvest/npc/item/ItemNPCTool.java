package joshie.harvest.npc.item;

import joshie.harvest.core.HFTab;
import joshie.harvest.core.base.item.ItemHFEnum;
import joshie.harvest.npc.item.ItemNPCTool.NPCTool;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

import static joshie.harvest.npc.item.ItemNPCTool.NPCTool.NPC_KILLER;
import static net.minecraft.util.text.TextFormatting.AQUA;

public class ItemNPCTool extends ItemHFEnum<ItemNPCTool, NPCTool> {
    public enum NPCTool implements IStringSerializable {
        BLUE_FEATHER(true, false), NPC_KILLER(true, false), GIFT(false, true), CALENDAR(false, true), CLOCK(false, true), WEATHER(false, true);

        public boolean colored;
        public boolean hidden;

        NPCTool(boolean colored, boolean hidden) {
            this.colored = colored;
            this.hidden = hidden;
        }

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ENGLISH);
        }
    }

    public ItemNPCTool() {
        super(HFTab.TOWN, NPCTool.class);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (getEnumFromStack(stack) == NPC_KILLER) {
            entity.setDead();
            return true;
        }

        return false;
    }

    @Override
    public int getSortValue(ItemStack stack) {
        return 1;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (getEnumFromStack(stack).colored) return AQUA + super.getItemStackDisplayName(stack);
        else return super.getItemStackDisplayName(stack);
    }
}