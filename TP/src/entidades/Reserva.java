package entidades;

import java.util.Date;//Que diferencia hay entre java.util.Date y java.sql.Date? Cual se debe usar?

public class Reserva {
	private int id;
	Auto autoReservado;
	Date fecha; 
	String detalle;
}
