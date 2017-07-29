package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Auto;
import entidades.Reserva;

public class DataReserva {
	public void setReserva(Reserva res){
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reservas (fechain,fechafin,detalle,auto_reservado,id_persona) values(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1,res.getFechaIni());
			stmt.setDate(2,res.getFechaFin());
			stmt.setString(3,res.getDetalle());
			stmt.setInt(4,res.getAutoReservado().getId());
			stmt.setInt(5,res.getIdPersona());
			
			
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

	public ArrayList<Reserva> getReservas(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tp.reservas");
			if(rs!=null){
				while(rs.next()){
					Reserva res=new Reserva();
					res.setFechaIni(rs.getDate("fechain"));
					res.setFechaFin(rs.getDate("fechafin"));
					res.setDetalle(rs.getString("detalle"));
					Auto au = new Auto();
					au.setId(rs.getInt("auto_reservado"));
					res.setAutoReservado(au);
					res.setIdPersona(rs.getInt("id_persona"));
					reservas.add(res);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reservas;
		
	}

	public ArrayList<Reserva> getReservasAFututoByIdPersona(int id) {
		PreparedStatement stmt = null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().prepareStatement("select * from tp.reservas where id_persona = ? and fechain>curdate()");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Reserva res=new Reserva();
					res.setFechaIni(rs.getDate("fechain"));
					res.setFechaFin(rs.getDate("fechafin"));
					res.setDetalle(rs.getString("detalle"));
					Auto au = new Auto();
					au.setId(rs.getInt("auto_reservado"));
					res.setAutoReservado(au);
//					res.setIdPersona(rs.getInt("id_persona"));
					reservas.add(res);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reservas;
		
	}
	}
//pongo este comentario para poder comitiar

	