package me.nova.freezetag.Models;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class Arena {
    private int size;
    private Location center;

    public Arena(int size, Location center) {
        this.size = size;
        this.center = center;
    }

    public void loadArena() {
        World w = center.getWorld();
        WorldBorder border = w.getWorldBorder();
        border.setCenter(center);
        border.setSize(size);
        border.setWarningDistance(0);

        System.out.printf("Setting world border to %f, %f; size = %d\n", center.getX(), center.getZ(), size);
    }
}
