package me.t3sl4.murder;

import java.sql.ResultSet;
import org.bukkit.scheduler.BukkitRunnable;
import java.sql.DriverManager;
import org.bukkit.plugin.Plugin;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import java.sql.Connection;
public class MySQL {
    private String host;
    private String databse;
    private String user;
    private String password;
    private String port;
    private Connection con;

    public MySQL(final String host, final String port, final String database, final String user, final String password) {
        this.host = host;
        this.databse = database;
        this.user = user;
        this.password = password;
        this.port = port;
        this.connect();
    }

    public void close() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.getInstance(), () -> {
            try {
                if(this.con != null) {
                    this.con.close();
                }
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void closeInstantly() {
        if(this.con != null) {
            try {
                this.con.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void connect() {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.getInstance(), () -> {
            if(this.con != null) {
                this.close();
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                this.con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.databse + "?autoReconnect=true", this.user, this.password);
            } catch(SQLException e) {
                e.printStackTrace();
            }
            new BukkitRunnable() {
                public void run() {
                    if(MySQL.this.isConnected()) {
                        System.out.println("[Murder] Connected to MySQL database :)");
                        MySQL.this.createTable();
                    }
                    if(!MySQL.this.isConnected()) {
                        System.out.println("[Murder] Could not connect to MySQL database :(");
                    }
                }
            }.runTaskLater((Plugin) Main.getInstance(), 60L);
        });
    }

    public void createTable() {
        try {
            this.getConnection().createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS MurderData (playername VARCHAR(16), wins INT(10), loses INT(10), deaths INT(10), kills INT(10), coins INT(10), score INT(10))");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.con;
    }

    public boolean isConnected() {
        try {
            return !this.getConnection().isClosed();
        } catch(Exception e) {
            return false;
        }
    }

    public ResultSet Query(final String s) {
        ResultSet executeQuery = null;
        try {
            executeQuery = this.con.createStatement().executeQuery(s);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return executeQuery;
    }

    public void update(final String s) {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.getInstance(), () -> {
            try {
                this.con.createStatement().executeUpdate(s);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
