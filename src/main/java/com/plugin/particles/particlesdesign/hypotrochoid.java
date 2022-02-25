package com.plugin.particles.particlesdesign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class hypotrochoid extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void CreateShape(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            Location loc = e.getPlayer().getLocation();


            double M = 24;
            double N = 13;
            double F = 2;

            for (double theta = 0; theta < 2 * N * Math.PI; theta += Math.PI / 40) {
                for (double t = theta / N; t < 2 * Math.PI; t += Math.PI / 40) {
                    double x = (1 - N / M) * Math.cos(N * t) + F * N / M * Math.cos((M - N) * t);
                    double y = 1;
                    double z = (1 - N / M) * Math.sin(N * t) - F * N / M * Math.sin((M - N) * t);


                    loc.add(x, y, z);
                    e.getPlayer().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                    loc.subtract(x, y, z);
                }


            }


        }

    }
}

