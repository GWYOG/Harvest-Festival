package joshie.harvest.npc.schedule;

import joshie.harvest.api.buildings.BuildingLocation;
import joshie.harvest.api.calendar.Season;
import joshie.harvest.api.calendar.Weekday;
import joshie.harvest.api.npc.INPC;
import joshie.harvest.api.npc.ISchedule;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

import static joshie.harvest.api.npc.INPC.Location.HOME;
import static joshie.harvest.api.npc.INPC.Location.WORK;
import static joshie.harvest.npc.schedule.ScheduleLocations.GENERALFRONT;
import static joshie.harvest.npc.schedule.ScheduleLocations.MINEENTRANCE;
import static joshie.harvest.npc.schedule.ScheduleLocations.MINEHUTENTRANCE;

public class ScheduleBrandon implements ISchedule {
    @Override
    public BuildingLocation getTarget(World world, EntityLiving entity, INPC npc, Season season, Weekday day, long time) {
        if (npc.getShop() != null && npc.getShop().isOpen(world, null)) return npc.getLocation(WORK);
        else {
            if (time >= 5000L && time <= 10000L) return MINEENTRANCE;
            else if (time >= 13000L && time <= 14000L) return MINEHUTENTRANCE;
            else if (time >= 10000L && time <= 17000L) return GENERALFRONT;
            else return npc.getLocation(HOME);
        }
    }
}