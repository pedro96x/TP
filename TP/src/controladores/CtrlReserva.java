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
//		Auto auto;
		ArrayList <Auto> autos = controladorAuto.getAutosByID(tipoauto.getId());
		ArrayList <Reserva> reservas = dataRes.getReservas();
		
//		for (int i = 0; i < autos.size(); i++) {
//			
//		}
//		ArrayList <Auto> autos2 =autos;
//		for (Auto auto : autos){
//			if(auto.getTipo().getId() != tipoauto.getId()){
//				Auto auto2 = auto;
//				autos2.remove(auto2);
//			}
//		}
		
		
		
		
//		for (Reserva reserva: reservas){
//			if(//esto esta comentado porque primero quiero que me funcione el tema de que me muestre solo 
//					//los autos del tipo de auto que le pedí en el primer combobox
//					//(reserva.getAutoReservado().getTipo().getId() == tipoauto.getId()
//					//&&
//				//NuevoDate.seSolapan(reserva.getFechaIni(),reserva.getFechaFin(),fechaInicioRes,fechaFinRes))
//					//||
//					!reserva.getAutoReservado().getTipo().equals(tipoauto)
//					) {
//				
//				
//				auto = controladorAuto.getByID(reserva.getAutoReservado().getId());
//				for (Auto auto : autos){
//					if (	!reserva.getAutoReservado().getTipo().equals(tipoauto)){
//					autos.remove();
//					}
//				}
//			}
//		}
	
	
	return autos;
	}
}
