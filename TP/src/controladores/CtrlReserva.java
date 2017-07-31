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
		
		public ArrayList<Reserva> getReservas(){	
			return dataRes.getReservas();
			}
	
		public void setReserva(Reserva res) {
			dataRes.setReserva(res);
	}

	
//		NuevoDate.seSolapan(reservas.get(i).getFechaIni(),reservas.get(i).getFechaFin(),fechaI,fechaF))
	public ArrayList<Auto> getAutosDisponibles(String fechaI, String fechaF, ArrayList<Auto> arrayMismoTipoAutos) {
		ArrayList <Reserva> reservas = dataRes.getReservas();
		ArrayList <Auto> autosDisponibles = new ArrayList <Auto>();
		
		for (int i = 0; i < reservas.size(); i++) {
			for (int j = 0; j < arrayMismoTipoAutos.size(); j++) {
				if((reservas.get(i).getAutoReservado().getId()==arrayMismoTipoAutos.get(j).getId())&&(NuevoDate.seSolapan(reservas.get(i).getFechaIni(),reservas.get(i).getFechaFin(),fechaI,fechaF))){
					arrayMismoTipoAutos.remove(arrayMismoTipoAutos.get(j));
					
				}
			}
			
		}
		return arrayMismoTipoAutos;
	}
		
//		if(reservas.size()>0){
//			
//		for (int i = 0; i < reservas.size(); i++) {
//			for (int j = 0; j < arrayMismoTipoAutos.size(); j++) {
//				if(arrayMismoTipoAutos.get(j).getId()==reservas.get(i).getAutoReservado().getId()){
//					if(NuevoDate.seSolapan(reservas.get(i).getFechaIni(),reservas.get(i).getFechaFin(),fechaI,fechaF)){
//						System.out.println("se solapan");
//						
//						
//					}
//					else{
//						autosDisponibles.add(arrayMismoTipoAutos.get(j));
//						
//					}
//					
//				}
//				else{
//					autosDisponibles.add(arrayMismoTipoAutos.get(j));
//					
//				}
//			}
//			
//		}
//		}
//		else{
//			for (int i = 0; i < arrayMismoTipoAutos.size(); i++) {
//				autosDisponibles.add(arrayMismoTipoAutos.get(i));
//				
//			}
//		}
//		
//		
//		int cont=0;
//		for (int i = 0; i < autosDisponibles.size(); i++) {
//			for (int j = 0; j < autosDisponibles.size(); j++) {
//				if(autosDisponibles.get(j).equals(autosDisponibles.get(i))){
//					cont++;
//				}
//				if(cont!=reservas.size()){
//					autosDisponibles.remove(autosDisponibles.get(j));
//				}
//		}}
//		return autosDisponibles;
//	}

	public ArrayList<Reserva> getReservasAFututoByIdPersona(int id) {
		return dataRes.getReservasAFututoByIdPersona(id);
	}

	public void deleteById(int id) {
		dataRes.deleteById(id);
		
	}
	
}
