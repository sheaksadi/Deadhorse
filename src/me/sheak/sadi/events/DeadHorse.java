package me.sheak.sadi.events;


import me.sheak.sadi.Mobs.Horse;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import java.util.List;
import java.util.Random;


public class DeadHorse implements Listener {


    @EventHandler
    public void onspwan(EntitySpawnEvent e){
        Random rand  = new Random();

        List<Entity> list = (List<Entity>) e.getLocation().getWorld().getNearbyEntities(e.getLocation(), 500, 500, 500);

        Entity entity = e.getEntity();
        Location entityLocation = entity.getLocation();

        for (Entity entt : list){
            if (entt instanceof ZombieHorse){
                return;
            }
        }


        if (rand.nextInt(1000) != 2) {
            return;
        }
        if (entityLocation.getY()<60){
            return;
        }

        Biome biome = entityLocation.getBlock().getBiome();
        if (biome != Biome.SWAMP) {
            return;
        }
        if(!(e.getEntity() instanceof Monster)){
            return;
        }
        if(e.getLocation().getBlock().isLiquid()){
            return;
        }




        WorldServer world =((CraftWorld)entityLocation.getWorld()).getHandle();

        world.addEntity(new Horse(entityLocation));
        //World world= e.getEntity().getWorld();
        //world.spawnEntity(entityLocation,EntityType.SHEEP);
        e.setCancelled(true);

    }
}
