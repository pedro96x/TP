package controladores;

import data.*;
import entidades.*;

public class CtrlPersona {
	
	private DataPersona dataPer;
	
	public CtrlPersona(){
		dataPer = new DataPersona();
	}
	
	public void alta(Persona p) {
		dataPer.setPersona(p);
	}
	
	public void baja(int dni) {
		dataPer.deleteByDni(dni);	
	}
	
	public void modific(Persona p){
		dataPer.actualiza(p);
	}
	
	public Persona getByDni(int document) {
		return dataPer.getByDni(document);
	}
}
