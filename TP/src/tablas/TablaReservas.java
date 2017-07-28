package tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controladores.CtrlReserva;
import entidades.Reserva;

public class TablaReservas extends AbstractTableModel {
	
	CtrlReserva ctrlReserva= new CtrlReserva();
	
	ArrayList<Reserva> reservas = ctrlReserva.getReservas(); 
	
	String [] encabezados = {"fecha in", "fecha fin", "detalle", "id de auto"};

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getRowCount() {
		return reservas.size(); //Aca se setea el numero de columnas
	}

	@Override
	public String getColumnName(int x) {
		// TODO Auto-generated method stub
		return encabezados[x];
	}

	
	public Object getValueAt(int x, int y) {
		String retorno = "";
		Reserva reserva = reservas.get(x);
		
		switch(y){
		case 0: retorno= String.valueOf(reserva.getFechaIni());
		break;
		case 1: retorno = String.valueOf(reserva.getFechaFin());
		break;
		case 2: retorno = reserva.getDetalle();
		break;
		case 3: retorno = String.valueOf(reserva.getAutoReservado().getId());
		break;
		
		
		}
		
		return retorno;
	}

}
