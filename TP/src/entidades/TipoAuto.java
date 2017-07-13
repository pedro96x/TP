package entidades;

public class TipoAuto { //Esta clase va a representar el modelo de auto. Ejemplo nombre = "Renault Scénic" 
	private int id;
	String nombre;
	int cantMaxReservas; //Cantidad maxima de autos de igual tipo que puede reservar un usuario al mismo tiempo 
	                     //Ejmplo: Si este tipo de auto se llama "limusina" y esta variable esta seteada en "2" el
						 //usuario solo podra reservar 2 autos del tipo limusina al mismo tiepo.
	
	int limMaxDeTiempoDeReserva; //Cantidad maxima de horas que un usuario puede reservar un auto, Ejemplo: 140 (horas)
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantMaxReservas() {
		return cantMaxReservas;
	}

	public void setCantMaxReservas(int cantMaxReservas) {
		this.cantMaxReservas = cantMaxReservas;
	}

	public int getLimMaxDeTiempoDeReserva() {
		return limMaxDeTiempoDeReserva;
	}

	public void setLimMaxDeTiempoDeReserva(int limMaxDeTiempoDeReserva) {
		this.limMaxDeTiempoDeReserva = limMaxDeTiempoDeReserva;
	}

	public int getMinDiasDeAnti() {
		return minDiasDeAnti;
	}

	public void setMinDiasDeAnti(int minDiasDeAnti) {
		this.minDiasDeAnti = minDiasDeAnti;
	}

	int minDiasDeAnti; //Cantidad minima de dias necesarios para hacer la reserva, Ejemplo: 2 (dias)
}
