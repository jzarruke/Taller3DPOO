package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private Vuelo vuelo;
	private Cliente cliente;
	private int tarifa;
	private boolean usado;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		super();
		this.codigo = codigo;
		this.vuelo = vuelo;
		cliente = clienteComprador;
		this.tarifa = tarifa;
		usado = false;
	}

	public String getCodigo() {
		return codigo;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getTarifa() {
		return tarifa;
	}
	
	public void marcarComoUsado(){
		usado = true;
	}

	public boolean esUsado() {
		return usado;
	}
}
