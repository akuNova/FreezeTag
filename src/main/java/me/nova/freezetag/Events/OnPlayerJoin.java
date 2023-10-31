package me.nova.freezetag.Events;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getName().equals("akuNova")) {
            PlayerProfile profile = p.getPlayerProfile();
            profile.setName("Nova");
            p.setPlayerProfile(profile);
            p.setDisplayName("Nova");
            p.setPlayerListName("Nova");
        }
    }
}
