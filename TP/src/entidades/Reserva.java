package entidades;

import java.util.Date;//Que diferencia hay entre java.util.Date y java.sql.Date? Cual se debe usar?

public class Reserva {
	private int id;
	Auto autoReservado;
	java.sql.Date fecha; 
	String detalle;
	int cantHorasReserv;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Auto getAutoReservado() {
		return autoReservado;
	}
	public void setAutoReservado(Auto autoReservado) {
		this.autoReservado = autoReservado;
	}
	public java.sql.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantHorasReserv() {
		return cantHorasReserv;
	}
	public void setCantHorasReserv(int cantHorasReserv) {
		this.cantHorasReserv = cantHorasReserv;
	}
}
