package da.david531;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class InventarioLogin {
	
	@SuppressWarnings("deprecation")
	public static void rellenarInventario(Inventory inv) {
		ItemStack item = new ItemStack(160, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		for (int i=0; i<=8; i++) {
			inv.setItem(i, item);
		}
		
		for (int i=45; i<=53; i++) {
			inv.setItem(i, item);
		}
		
		 
		inv.setItem(9, item);inv.setItem(18, item);inv.setItem(27, item);inv.setItem(36, item);
		inv.setItem(17, item);inv.setItem(26, item);inv.setItem(35, item);inv.setItem(44, item);
		item = new ItemStack(159, 1, (short) 9);
		meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for (int i=38; i<=42; i++) {
			inv.setItem(i, item);
		}
		
		
		item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "6c55d1bf-0b7b-4573-9a49-90260c8edcf0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU1ZmMyYzFiYWU4ZTA4ZDNlNDI2YzE3YzQ1NWQyZmY5MzQyMjg2ZGZmYTNjN2MyM2Y0YmQzNjVlMGMzZmUifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l1"));
        item.setItemMeta(meta);
        inv.setItem(12, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "0b1f1e2b-45da-46dd-a274-cac35939b2e1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM2MWIwNGUxMmE4Nzk3NjdiM2I3MmQ2OTYyN2YyOWE4M2JkZWI2MjIwZjVkYzdiZWEyZWIyNTI5ZDViMDk3In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l2"));
        item.setItemMeta(meta);
        inv.setItem(13, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "e1334711-200a-4b15-84ed-ec0046086903", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjgyM2Y3NzU1OGNhNjA2MGI2ZGM2YTRkNGIxZDg2YzFhNWJlZTcwODE2NzdiYmMzMzZjY2I5MmZiZDNlZSJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l3"));
        item.setItemMeta(meta);
        inv.setItem(14, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "10c41097-5752-4b25-8cd3-d0e73c41ee36", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTFiOWM0ZDZmNzIwOGIxNDI0Zjg1OTViZmMxYjg1Y2NhYWVlMmM1YjliNDFlMGY1NjRkNGUwYWNhOTU5In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l4"));
        item.setItemMeta(meta);
        inv.setItem(21, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "14e8c0e4-e8a6-4017-a9e9-578a7e103863", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMxNDE1OTczYjQyZjgyODZmOTQ4ZTIxNDA5OTJiOWEyOWQ4MDk2NTU5M2IxNDU1M2Q2NDRmNGZlYWZiNyJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l5"));
        item.setItemMeta(meta);
        inv.setItem(22, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "6443ab88-b03d-49ee-95b9-23478f270ef7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZmNWZiZmJjODk0NGE1MDc3NzExMzc5OGU5ZmUzYWVhYzJlMzk2NDg5NDdiNzBjYzEwM2RlYjZjOWU4NjYxIn19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l6"));
        item.setItemMeta(meta);
        inv.setItem(23, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "3769477b-8dac-400c-868e-9ecedde6bf4f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGYzYWNkNmRmZDViY2JmYTlmYzg0ZGYzZDcwNGJiZDlkMTQ4N2VhODdjZjU2NDQyN2JiOGVjOTVjNjUyMjcifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l7"));
        item.setItemMeta(meta);
        inv.setItem(30, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "11bb577d-3b24-4a0b-ae7e-f06414ad7b56", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViMTE1ZmE0N2E5ZDJkNmQ0MWU1YWE3YmU0ZTEzNjdmZjkyYzRlOTQ2NTg5N2Q1ZDYyYTc2NWVmOTI0ZjQifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l8"));
        item.setItemMeta(meta);
        inv.setItem(31, item);
       
        item = new ItemStack(397,1,(short)3);
        item = Utilidades.getCabeza(item, "9dbc242b-884b-482b-be56-4b054536fdc8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWFiOGEyN2FlZTQ3NzlmMDQzYTY2OGM5ZTkyN2EzNTNlNjNhYzc5MWVkM2Y1NmEyNGY2MWQ5NDM5Y2NmZDUxNSJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l9"));
        item.setItemMeta(meta);
        inv.setItem(32, item);
        
        
        item = new ItemStack(Material.REDSTONE_BLOCK);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cResetear"));
		item.setItemMeta(meta);
		inv.setItem(49, item);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void setDecoracionClave (Inventory inv, int numActual) {
		int pos = 37+numActual;
		ItemStack item = new ItemStack(159, 1, (short) 5);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		inv.setItem(pos, item);
	}
	
	@SuppressWarnings("deprecation")
	public static void resetearDecoracionClave (Inventory inv) {
		ItemStack item = new ItemStack(159, 1, (short) 9);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		for (int i=38; i<=42; i++) {
			inv.setItem(i, item);
		}
		
	}

}
