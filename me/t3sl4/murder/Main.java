package me.t3sl4.murder;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin implements Listener {
    public static Main instance;
    public MySQL sql;
    public ArrayList<PlayerData> datalist;
    public HashMap<String, PlayerData> pdata;
    public HashMap<String, ScoreboardManager> scoreboards;
    public HashMap<String, ScoreboardType> scorestate;
    public HashMap<String, Integer> cooldownTime;
    public HashMap<String, BukkitRunnable> cooldownTask;
    public MurderAPI api;
    public SignManager sm;
    public String user;
    public arenas arenas;
    public rewards rewards;
    public data data;
    public potions potions;
    public messages messages;
    public settings settings;
    public boolean works;
    public String nmsver;
    public boolean useOldMethods;
    public ArrayList<String> bungeepl;
    public ArrayList<Material> passable;
    public ArrayList<Block> blocks;
    private HashMap<String, Float> Pitch;
    private HashMap<String, Float> Yaw;
    private HashMap<String, ItemStack[]> armourContents;
    private HashMap<String, ItemStack[]> inventoryContents;
    private HashMap<String, GameMode> gamemode;
    private HashMap<String, Integer> level;
    private HashMap<String, Float> xp;
    boolean startmap;
    public Arena bungee;
    public HashMap<String, String> votes;
    public HashMap<String, Integer> point;
    boolean disabled;
    public ArrayList<String> opened;
    public HashMap<String, SmartInventory> sd;


    public static Main getInstance() {
        return Main.instance;
    }
}
