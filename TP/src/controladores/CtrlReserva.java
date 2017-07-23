package controladores;

import java.util.ArrayList;
import java.util.HashSet;

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
		ArrayList <Auto> autos2 = new ArrayList <Auto>();
		
		
		for (Reserva reserva : reservas) {
			for (Auto auto : autos) {
				if (!NuevoDate.seSolapan(reserva.getFechaIni(), reserva.getFechaFin(), fechaInicioRes, fechaFinRes)){
					autos2.add(auto);
				}
			}
		}//Esto revisa reserva por reserva a ver si el auto se solapa, si no es asi lo agrega a autos2
		//El problema es que un auto puede ser usado por dos reservas sin que se solape las fechas 
		//Ejemplo: reserva 1 fechaInicio = "2017-10-10" fechaFin = "2017-10-15" 
		//         reserva 2 fechaInicio = "2017-10-16" fechaFin = "2017-10-20" 
		//Si pido un auto para fechaInicio = "2017-10-23" y fechaFin "2017-10-27" el auto va a ser agregado dos veces a autos2
		// porque el for anterior verifica que no se solape con la reserva 1 y agrega el auto a auto2, despues hace lo mismo con reserva 2  y agrega el amismo auto
		
		//Ahora vamos a intentar eliminar los repetidos
		//Como no nos funca el remove() voy a hacer otro arreglo mas.
		
		
		//foma 1: (la cree yo, pero no funciona, devuelve un arrayList vacio)
		ArrayList <Auto> autos3 = new ArrayList <Auto>();
		
		for (Auto auto2 : autos2) {
			boolean encontrado= false;
			
			for (Auto auto3 : autos3) {
				if(autos3.isEmpty()){
					autos3.add(auto2);
				}
				if (auto2.getId()==auto3.getId()){
					encontrado = true;
					break;
				}
				if (auto2.getId()!=auto3.getId()){
					encontrado = false;
				}
				
			}
			if (encontrado = false){
				autos3.add(auto2);
			}
		}
		
		//forma 2: (sacada de internet)
//		autos2 = new ArrayList <Auto>(new HashSet<Auto>(autos2));
		
		
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
	
	
	return autos3;
	}
}
