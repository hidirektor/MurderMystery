package me.t3sl4.murder;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SmartInventory {
    Player p;
    HashMap<Inventory, Inventory> hash;
    HashMap<Inventory, Inventory> hash2;
    Inventory main;
    boolean op;

    public SmartInventory(final Player p) {
        this.hash = new HashMap<Inventory, Inventory>();
        this.hash2 = new HashMap<Inventory, Inventory>();
        this.main = null;
        this.op = false;
        this.p = p;
        this.Update();
    }

    public void CallOnEmpty(final ItemStack itemStack, final Inventory inventory) {

    }

    public boolean checkifenough() {
        return this.hash.size() * 28 >= Arenas.getArenas().size();
    }

    public void clearinv(final Inventory inventory) {

    }

    public boolean isInventoryFull(final Inventory inventory) {

    }

    public void LoadFrame() {

    }

    public void openInventory() {

    }
    public void Update() {

    }
}
