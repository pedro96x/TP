package controladores;

import java.util.ArrayList;

import data.DataAuto;
import entidades.Auto;

public class CtrlAuto {
	DataAuto dataAuto = new DataAuto();
	public void setAuto(Auto auto) {
		dataAuto.setAuto(auto);
	}
	public void baja(int id) {
		dataAuto.bajaByID(id);
	}
	public void actualizar(Auto auto) {
dataAuto.actualiza(auto);		
	}
	public Auto getByID(int id) {
		return dataAuto.getByID(id);
		
	}
	public ArrayList<Auto> getAutosByID(int id) {
		return dataAuto.getAutosByID(id);
	}

}
