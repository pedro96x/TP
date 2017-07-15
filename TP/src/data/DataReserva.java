package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Reserva;

public class DataReserva {
	public void setReserva(Reserva res){
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"INSERT INTO tp.reservas (auto_reservado,fecha,detalle,cant_horas_reserv) VALUES(?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,res.getAutoReservado().getId());
			stmt.setDate(2,res.getFecha());
			stmt.setString(3,res.getDetalle());
			stmt.setInt(4,res.getCantHorasReserv());
			
			
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

}}