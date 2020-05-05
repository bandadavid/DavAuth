package da.david531;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.xephi.authme.events.LoginEvent;
import net.md_5.bungee.api.ChatColor;

public class LoginListener implements Listener{
	
	public DavAuth plugin;
	public LoginListener(DavAuth plugin) {
		this.plugin = plugin;
		
	}

	
	@EventHandler
	public void alLoguearse(LoginEvent event) {
		Player jugador = event.getPlayer();
		FileConfiguration players = plugin.getPlayers();
		if(players.contains("Players."+jugador.getUniqueId()+".clave")) {
			crearInventarioLogeo(jugador,plugin);
		}else {
			crearInventarioRegistro(jugador,plugin);
		}
	}
	
	public static void crearInventarioLogeo(Player jugador, DavAuth plugin) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Logeo"));
		InventarioLogin.rellenarInventario(inv);
		plugin.añadirClaveRegistro(jugador, 3, false);
		jugador.openInventory(inv);
	}
	
	public static void crearInventarioRegistro(Player jugador, DavAuth plugin) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Registro"));
		InventarioLogin.rellenarInventario(inv);
		plugin.añadirClaveRegistro(jugador, 3, false);
		jugador.openInventory(inv);
	}
	
	public static void crearInventarioModificar(Player jugador, DavAuth plugin) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Modificar"));
		InventarioLogin.rellenarInventario(inv);
		plugin.añadirClaveRegistro(jugador, 1, true);
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aEscribe tu PIN actual."));
		item.setItemMeta(meta);
		inv.setItem(4, item);
		jugador.openInventory(inv);
	}
	
	@EventHandler
	public void clickearInvetario(InventoryClickEvent event) {
		String pathinventory1 = ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Registro");
		String pathinventory2 = ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Logeo");
		String pathinventory3 = ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Modificar");
		String pathinventory1M = ChatColor.stripColor(pathinventory1);
		String pathinventory2M = ChatColor.stripColor(pathinventory2);
		String pathinventory3M = ChatColor.stripColor(pathinventory3);
		boolean esRegistro = false;
		boolean esLogeo = false;
		boolean esModificar = false;
		
		if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory1M)) {
			esRegistro = true;
		}else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory2M)) {
			esLogeo = true;
		}else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory3M)) {
			esModificar = true;
		}else {
			return;
		}
		
		event.setCancelled(true);
		if (event.getCurrentItem() == null) {
			return;
		}
		if (event.getSlotType() == null) {
			return;
		}else {
			Player jugador = (Player) event.getWhoClicked();
			if (event.getClickedInventory().equals(jugador.getOpenInventory().getTopInventory())) {
				int slot = event.getSlot();
				ClaveRegistro clave = plugin.getClaveRegistro(jugador.getName());
				if ((slot >= 12 && slot <= 14) || (slot >= 21 && slot <= 23) || (slot >= 30 && slot <= 32)) {
					int num = Utilidades.getNumeroSlot(slot);
					if (clave != null) {
						clave.añadirNumeroClave(num);
						InventarioLogin.setDecoracionClave(event.getClickedInventory(), clave.getClave().length());
						if (clave.getClave().length() >= 5) {
							FileConfiguration players = plugin.getPlayers();
							String claveString = clave.getClave();
							if(esRegistro) {
								jugador.playSound(jugador.getLocation(), Sound.LEVEL_UP, 10, 2);
								players.set("Players."+jugador.getUniqueId()+".clave", claveString);
								jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN REGISTRADO! &7Tu clave es: &a"+claveString));
								plugin.eliminarClaveRegistro(jugador.getName());
								jugador.closeInventory();
								return;
							}else if(esLogeo) {
								String claveVerdadera = players.getString("Players."+jugador.getUniqueId()+".clave");
								if (claveString.equals(claveVerdadera)) {
									jugador.playSound(jugador.getLocation(), Sound.LEVEL_UP, 10, 2);
									jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN CORRECTO! &7Diviertete en &aMentor Network"));
									plugin.eliminarClaveRegistro(jugador.getName());
									jugador.closeInventory();
									return;
								}else {
									int intentos = clave.getIntentos();
									if (intentos <= 1) {
										plugin.eliminarClaveRegistro(jugador.getName());
										jugador.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN INCORRECTO! &7No puedes entrar a &aMentor Network."));
										return;
									}else {
										jugador.playSound(jugador.getLocation(), Sound.FIZZ, 10, 1);
										int intentosMaximos = clave.getIntentosMaximos();
										clave.disminuirIntentos();
										InventarioLogin.resetearDecoracionClave(event.getClickedInventory());
										clave.resetearClave();
										jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN INCORRECTO! &8(&6"+(intentosMaximos-intentos+1)+"&7/&6"+intentosMaximos+"&8)"));
										return;
									}
								}
							}else if (esModificar) {
								int fase = clave.getModificandoFase();
								if (fase == 1) {
									String claveVerdadera = players.getString("Players."+jugador.getUniqueId()+".clave");
									if (claveString.equals(claveVerdadera)) {
										jugador.playSound(jugador.getLocation(), Sound.DOOR_OPEN, 10, 2);
										clave.aumentarModificandoFase(); //FASE 2
										InventarioLogin.resetearDecoracionClave(event.getClickedInventory());
										clave.resetearClave();
										ItemStack item = new ItemStack(Material.BOOK);
										ItemMeta meta = item.getItemMeta();
										jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lInstrucciones en el &6&lLIBRO"));
										meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aEscribe tu nuevo PIN."));
										item.setItemMeta(meta);
										event.getClickedInventory().setItem(4, item);
										
									}else {
										plugin.eliminarClaveRegistro(jugador.getName());
										jugador.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN INCORRECTO! &7No puedes modificar tu PIN de &aMentor Network."));
										return;	
									}
								}else {
									jugador.playSound(jugador.getLocation(), Sound.LEVEL_UP, 10, 2);
									players.set("Players."+jugador.getUniqueId()+".clave", claveString);
									jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l¡PIN MODIFICADO! &7Tu nueva clave es: &a"+claveString));
									jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lSigue disfrutando de &aMentor Network."));
									plugin.eliminarClaveRegistro(jugador.getName());
									jugador.closeInventory();
									return;
								}
								
								
							}
						}
						jugador.playSound(jugador.getLocation(), Sound.NOTE_PLING, 10, 2);
					}
				}else if (slot == 49) {
					if (clave != null) {
						clave.resetearClave();
						InventarioLogin.resetearDecoracionClave(event.getClickedInventory());
					}
				}
			}
		}
	}
	
	@EventHandler
	public  void cerrarInventario(InventoryCloseEvent event) {
		final Player jugador = (Player) event.getPlayer();
		final Inventory inv = event.getInventory();
		if (plugin.getClaveRegistro(jugador.getName()) != null) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				public void run() {
					jugador.openInventory(inv);
				}
			}, 2L);
		}
	}
	
	@EventHandler
	public void alSalir(PlayerQuitEvent event) {
		Player jugador = event.getPlayer();
		plugin.eliminarClaveRegistro(jugador.getName());
	}
}
