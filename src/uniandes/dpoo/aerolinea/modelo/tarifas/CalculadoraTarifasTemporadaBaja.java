package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES = 0.2;
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int Km = calcularDistanciaVuelo(vuelo.getRuta());
		if (cliente.getTipoCliente().equals("NATURAL")) {
			return Km * COSTO_POR_KM_NATURAL;
		}
		return Km * COSTO_POR_KM_CORPORATIVO;
	}
	
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		if (cliente.getTipoCliente().equals("CORPORATIVO")) {
			if (((ClienteCorporativo) cliente).getTamanoEmpresa() == 3) {
				return DESCUENTO_PEQ;
			} else if (((ClienteCorporativo) cliente).getTamanoEmpresa() == 2) {
				return DESCUENTO_MEDIANAS;
			} else if (((ClienteCorporativo) cliente).getTamanoEmpresa() == 1) {
				return DESCUENTO_GRANDES;
			}
		}
		return 0;
	}
}