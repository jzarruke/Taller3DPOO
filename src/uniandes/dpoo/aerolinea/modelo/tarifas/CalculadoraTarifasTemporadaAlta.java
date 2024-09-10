package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	protected int COSTO_POR_KM = 1000;
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return (calcularDistanciaVuelo(vuelo.getRuta())) * COSTO_POR_KM;
	}
	
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		cliente.getTipoCliente();
		return 0;
	}
}