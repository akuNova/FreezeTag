package me.nova.freezetag.Controllers;

import me.nova.freezetag.Models.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Random;

import static me.nova.freezetag.FreezeTag.*;

public class GameController {
    enum State {PREGAME, START, PROGRESS, END}

    private State stage;
    private Arena arena;
    private Team it;
    private Team runner;

    public GameController() {
        stage = State.PREGAME;

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        it = board.registerNewTeam("it");
        runner = board.registerNewTeam("runner");
        it.setColor(ChatColor.RED);
        it.setPrefix(String.valueOf(ChatColor.RED));
        runner.setColor(ChatColor.AQUA);
        runner.setPrefix(String.valueOf(ChatColor.AQUA));
    }

    public void startGame() {

        stage = State.START;

        //if no one is "it", put a random player on team "it"
        ArrayList<Player> allPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Random random = new Random();
        if (it.getSize() == 0) it.addPlayer(allPlayers.get(random.nextInt(allPlayers.size())));
        //add all remaining players to runner team
        for (Player p : allPlayers) {
            if (it.hasPlayer(p)) continue;
            runner.addPlayer(p);
        }

        //start the round
        startRound(new Arena(INITIAL_SIZE, new Location(allPlayers.get(0).getWorld(),
                random.nextInt(X_MIN, X_MAX),
                0,
                random.nextInt(Z_MIN, Z_MAX))));
    }

    public void startRound(Arena arena) {
        //loads Arena into the world
        arena.loadArena();

        //TODO DISPLAY TITLE

        //TODO give "IT" team materials and compass

        //TODO teleport all players to each side
    }
}
