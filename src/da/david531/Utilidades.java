package da.david531;

import org.bukkit.inventory.ItemStack;

public class Utilidades {
	public static ItemStack getCabeza(ItemStack item, String id, String textura) {
        net.minecraft.server.v1_8_R3.ItemStack cabeza = org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(item);
        net.minecraft.server.v1_8_R3.NBTTagCompound tag = cabeza.hasTag() ? cabeza.getTag() : new net.minecraft.server.v1_8_R3.NBTTagCompound();
        net.minecraft.server.v1_8_R3.NBTTagCompound skullOwnerCompound = new net.minecraft.server.v1_8_R3.NBTTagCompound();
        net.minecraft.server.v1_8_R3.NBTTagCompound propiedades = new net.minecraft.server.v1_8_R3.NBTTagCompound();
       
       
        net.minecraft.server.v1_8_R3.NBTTagList texturas = new net.minecraft.server.v1_8_R3.NBTTagList();
        net.minecraft.server.v1_8_R3.NBTTagCompound texturasObjeto = new net.minecraft.server.v1_8_R3.NBTTagCompound();
        texturasObjeto.setString("Value", textura);
        texturas.add(texturasObjeto);
        propiedades.set("textures", texturas);
        skullOwnerCompound.set("Properties", propiedades);
        skullOwnerCompound.setString("Id", id);
        tag.set("SkullOwner", skullOwnerCompound);
        cabeza.setTag(tag);
       
       
        return org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asBukkitCopy(cabeza);
    }
	
	
	public static int getNumeroSlot(int slot) {
		switch(slot) {
		case 12:
			return 1;
		case 13:
			return 2;
		case 14:
			return 3;
		case 21:
			return 4;
		case 22:
			return 5;
		case 23:
			return 6;
		case 30:
			return 7;	
		case 31:
			return 8;	
		case 32:
			return 9;	
		}
		return 0;
	}
}
