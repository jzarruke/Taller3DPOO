package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}

	public abstract String getTipoCliente();

	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int valor = 0;
		for (Tiquete ticket: tiquetesSinUsar) {
			valor += ticket.getTarifa();
		}
		return valor;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for (Tiquete ticket: tiquetesSinUsar) {
			if (vuelo.equals(ticket.getVuelo())) {
				tiquetesUsados.add(ticket);
				tiquetesSinUsar.remove(ticket);
			}
		}
	}
}