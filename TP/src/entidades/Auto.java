package entidades;

public class Auto { //Esta clase va a representar a cada auto en si, donde nombre 
	                //podria tener la patente y el color.
	private int id;
	String nombre;
	TipoAuto tipo;
	
	
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
	public TipoAuto getTipo() {
		return tipo;
	}
	public void setTipo(TipoAuto tipo) {
		this.tipo = tipo;
	}
}
