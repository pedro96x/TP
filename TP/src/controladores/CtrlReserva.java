package controladores;

import java.sql.Date;
import java.util.ArrayList;

import data.DataAuto;
import data.DataReserva;
import entidades.Auto;
import entidades.Reserva;
import entidades.TipoAuto;
import manejoTiempo.NuevoDate;

public class CtrlReserva {
		DataReserva dataRes = new DataReserva();
		DataAuto dataAuto = new DataAuto();
		
	
		public void setReserva(Reserva res) {
		dataRes.setReserva(res);
	}

	

	public ArrayList<Auto> getAutosDisponibles(String fechaI, String fechaF, ArrayList<Auto> arrayMismoTipoAutos) {
		ArrayList <Reserva> reservas = dataRes.getReservas();
		ArrayList <Auto> autosDisponibles = new ArrayList <Auto>();
		
		for (int i = 0; i < reservas.size(); i++) {
			for (int j = 0; j < arrayMismoTipoAutos.size(); j++) {
				if(arrayMismoTipoAutos.get(j).equals(reservas.get(i).getAutoReservado())){
					if(NuevoDate.seSolapan(reservas.get(i).getFechaIni(),reservas.get(i).getFechaFin(),fechaI,fechaF)){
						boolean q=NuevoDate.seSolapan(reservas.get(i).getFechaIni(),reservas.get(i).getFechaFin(),fechaI,fechaF);
						System.out.println("Se solapan");
					}
					else{
						autosDisponibles.add(arrayMismoTipoAutos.get(j));
						System.out.println("No se solapan");
					}
					
				}
				else{
					autosDisponibles.add(arrayMismoTipoAutos.get(j));
				}
			}
			
		}
		return autosDisponibles;
	}
	
}
