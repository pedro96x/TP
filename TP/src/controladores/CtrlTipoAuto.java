
package controladores;

import java.util.ArrayList;

import data.*;
import entidades.*;

public class CtrlTipoAuto {
	
	private DataTipoAuto dataTipoAuto;
	
	public CtrlTipoAuto(){
		dataTipoAuto = new DataTipoAuto();
	}
	
	public void alta(TipoAuto tipoauto) {
		dataTipoAuto.setTipoAuto(tipoauto);
	}
	
	public void baja(int id) {
		dataTipoAuto.deleteByID(id);	
	}
	
	public void modific(TipoAuto tipoauto){
		dataTipoAuto.actualiza(tipoauto);
	}
	
	public TipoAuto getByID(int id) {
		return dataTipoAuto.getByID(id);
	}

	public ArrayList<TipoAuto> getArrayList() {
		return dataTipoAuto.getArrayList();
	}
}