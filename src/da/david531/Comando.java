package da.david531;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {
	
	public DavAuth plugin;
	public Comando(DavAuth plugin) {
		this.plugin = plugin;
		
	}
	
	public boolean onCommand(CommandSender sender, Command commad, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player jugador = (Player)sender;
		LoginListener.crearInventarioModificar(jugador, plugin);
		return false;
	}

}
