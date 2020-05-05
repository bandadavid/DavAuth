package da.david531;



import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DavAuth extends JavaPlugin {
	
	PluginDescriptionFile pdfFile = getDescription();
	public String version = pdfFile.getVersion();
	public String nombre = ChatColor.YELLOW+"["+ChatColor.GREEN+pdfFile.getName()+ChatColor.YELLOW+"]";
	
	private ArrayList<ClaveRegistro> claves = new ArrayList<ClaveRegistro>();
	private FileConfiguration players = new YamlConfiguration();
	private File playersFile;
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----------------------------------------------");
		Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.WHITE+" a sido activado (version: "+ChatColor.RED+version+ChatColor.WHITE+")");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"     Gracias por utilizar mi plugin :D.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----------------------------------------------");
		
		registerEvents();
		registerComands();
		registerPlayers();
		
	}


	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.WHITE+" a sido desactivado (version: "+ChatColor.RED+version+ChatColor.WHITE+")");
		
		if (players != null) {
			this.savePlayers();
		}
	}
	 
	
	private void registerComands() {
		this.getCommand("modificarpin").setExecutor(new Comando(this));
		
	}
	
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new LoginListener(this), this);
		
	}
	
	
	public ClaveRegistro getClaveRegistro(String jugador) {
		for (int i=0;i<claves.size();i++) {
			if (claves.get(i).getJugador().getName().equals(jugador)) {
				return claves.get(i);
			}
		}
		return null;
	}
	
	public void añadirClaveRegistro(Player jugador, int intentosMaximos, boolean modificando){
		claves.add(new ClaveRegistro(jugador, intentosMaximos, modificando));
		
	}
	
	public void eliminarClaveRegistro(String jugador) {
		for (int i=0;i<claves.size();i++) {
			if (claves.get(i).getJugador().getName().equals(jugador)) {
				claves.remove(i);
			}
		}
	}
	
	public void registerPlayers() {
		playersFile = new File(this.getDataFolder(), "players.yml");
        if (!playersFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveResource("players.yml", false);
        }
        try {
            players.load(this.playersFile);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
	
	  public void savePlayers() {
		 try {
			 players.save(playersFile);
		 } catch (IOException e) {
			 e.printStackTrace();
	 	}
	 }
	  
	  public FileConfiguration getPlayers() {
		    if (players == null) {
		        reloadPlayers();
		    }
		    return players;
		}
	  
	  public void reloadPlayers() {
		    if (players == null) {
		    playersFile = new File(getDataFolder(), "players.yml");
		    }
		    players = YamlConfiguration.loadConfiguration(playersFile);

		    Reader defConfigStream;
			try {
				defConfigStream = new InputStreamReader(this.getResource("players.yml"), "UTF8");
				if (defConfigStream != null) {
			        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			        players.setDefaults(defConfig);
			    }
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	    
		}
	
	
	
	
}
