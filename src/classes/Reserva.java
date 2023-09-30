package classes;

import java.time.LocalDateTime;

public class Reserva {
	
	private Modelo modelo;
	private LocalDateTime dataReserva;
	
	public Reserva() {
		
	}

	public Reserva(Modelo modelo, LocalDateTime dataReserva) {
		this.modelo = modelo;
		this.dataReserva = dataReserva;
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	public LocalDateTime getDataReserva() {
		return dataReserva;
	}
}
