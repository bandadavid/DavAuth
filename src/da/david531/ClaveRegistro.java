package da.david531;

import org.bukkit.entity.Player;

public class ClaveRegistro {
	private Player jugador;
	private String clave;
	private int intentosActuales;
	private int intentosMaximos;
	private int modificandoFase;
	
	public ClaveRegistro(Player jugador, int intentosMaximos, boolean modificando) {
		this.jugador = jugador;
		this.clave = "";
		this.intentosMaximos = intentosMaximos;
		this.intentosActuales = this.intentosMaximos;
		if (modificando) {
			this.modificandoFase = 1;
		}
	}
	
	
	public Player getJugador() {
		return this.jugador;
	}
	
	
	public void añadirNumeroClave (int num) {
		clave = clave+num;
	}
	
	
	public void resetearClave () {
		clave = "";
	}
	
	public String getClave () {
		return this.clave;
	}
	
	public int getIntentos() {
		return this.intentosActuales;
	}
	
	public int getIntentosMaximos() {
		return this.intentosMaximos;
	}
	
	public void disminuirIntentos() {
		this.intentosActuales--;
	}
	
	public void aumentarModificandoFase() {
		this.modificandoFase++;
	}
	
	public int getModificandoFase() {
		return this.modificandoFase;
	}
	
	
	
	

}
