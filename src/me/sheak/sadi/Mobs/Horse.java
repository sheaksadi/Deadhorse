package me.sheak.sadi.Mobs;

import net.minecraft.server.v1_16_R3.EntityHorseZombie;
import net.minecraft.server.v1_16_R3.EntityTypes;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

public class Horse extends EntityHorseZombie {

    public Horse(Location loc) {
        super(EntityTypes.ZOMBIE_HORSE,((CraftWorld)loc.getWorld()).getHandle());
        this.setPosition(loc.getX(),loc.getY(),loc.getZ());
        this.setTamed(true);

    }
    public void initpathfinder(){
        super.initPathfinder();
    }
}
