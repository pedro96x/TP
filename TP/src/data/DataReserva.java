package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Auto;
import entidades.Reserva;

public class DataReserva {
	public void setReserva(Reserva res){
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"INSERT INTO tp.reservas (auto_reservado,fechain, fechafin,detalle,cant_horas_reserv) VALUES(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,res.getAutoReservado().getId());
			stmt.setDate(2,res.getFechaIni());
			stmt.setDate(3,res.getFechaIni());
			stmt.setString(4,res.getDetalle());
			stmt.setInt(5,res.getCantHorasReserv());
			
			
			 stmt.executeUpdate();
			 keyResultSet=stmt.getGeneratedKeys();
			 if(keyResultSet!=null && keyResultSet.next()){
				 res.setId(keyResultSet.getInt(1));
			 			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
        }
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

}

	public ArrayList<Reserva> getReservas() {
		// Este metodo teiene de devolver un arraylist de todas las reservas de este tipo 
		
		Reserva reserva = null;
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		Auto auto = new Auto();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select auto_reservado,fechain, fechafin,detalle FROM tp.reservas");
		rs = stmt.executeQuery();
			if (rs != null && rs.next()){
				reserva = new Reserva();
				reserva.setFechaIni(rs.getDate("fechafin"));
				reserva.setFechaFin(rs.getDate("fechain"));
				reserva.setDetalle(rs.getString("detalle"));
				auto.setId(rs.getInt("auto_reservado"));
				reserva.setAutoReservado(auto);
				
				reservas.add(reserva);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return reservas;
		
		
	}}

	