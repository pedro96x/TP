package entidades;

import java.util.Date;//Que diferencia hay entre java.util.Date y java.sql.Date? Cual se debe usar?

public class Reserva {
	private int id;
	Auto autoReservado;
	java.sql.Date fechaIni;
	java.sql.Date fechaFin;
	
	public java.sql.Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(java.sql.Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public java.sql.Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}
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
