package controladores;

import java.util.ArrayList;

import data.DataReserva;
import entidades.Auto;
import entidades.Reserva;
import entidades.TipoAuto;
import manejoTiempo.NuevoDate;

public class CtrlReserva {
		DataReserva dataRes = new DataReserva();
		
	public void setReserva(Reserva res) {
		dataRes.setReserva(res);
	}
	

	public ArrayList<Auto> getAutosDisponibles(java.sql.Date fechaInicioRes, java.sql.Date fechaFinRes, TipoAuto tipoauto){
		CtrlAuto controladorAuto = new CtrlAuto();
		
		ArrayList <Auto> autos = controladorAuto.getAutos();
		ArrayList <Reserva> reservas = dataRes.getReservas();
		
		
		for (Reserva reserva: reservas){
			if(reserva.getAutoReservado().getTipo().getId() == tipoauto.getId()
					&&
				NuevoDate.seSolapan(reserva.getFechaIni(),reserva.getFechaFin(),fechaInicioRes,fechaFinRes)){
				
					autos.remove(reserva.getAutoReservado());
					
			}
		}
	
	
	return autos;
	}
}
