package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Vuelo {
	private Ruta ruta;
	private String fecha;
	private Avion avion;
	private Map<String, Tiquete> tiquetes = new HashMap<String, Tiquete>();
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public Collection<Tiquete> getTiquetes() {
		Collection<Tiquete> tickets = new ArrayList<Tiquete>();
		for (String cod: tiquetes.keySet()) {
			tickets.add(tiquetes.get(cod));
		}
		return tickets;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		try {
			int total = 0;
			for (int i = 0; i < cantidad; i++) {
				total += calculadora.calcularTrarifa(this, cliente) * cantidad;
				tiquetes.remove(((ArrayList<Tiquete>) getTiquetes()).get(0));
			}
			return total;
		} catch (Exception e) {
			throw(e);
		}
	}
	
	public boolean equals(Object obj) {
		if ((obj.getClass() == this.getClass()) && (((Vuelo) obj).getRuta() == ruta) && (((Vuelo) obj).getFecha() == fecha) && (((Vuelo) obj).getAvion() == avion)) {
			return true;
		}
		return false;
	}
}
