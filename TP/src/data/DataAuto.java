package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controladores.CtrlTipoAuto;
import entidades.Auto;
import entidades.Persona;
import entidades.Reserva;
import entidades.TipoAuto;

public class DataAuto {

		public Auto getByID(int ID){
			CtrlTipoAuto controladorTipoAuto = new CtrlTipoAuto();
			TipoAuto tipoAuto;
			Auto auto = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;
			
			try{
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"select nombre , id_tipoauto,id_auto FROM autos where id_auto=?");
			stmt.setInt(1, ID);
			rs = stmt.executeQuery();
				if (rs != null && rs.next()){
					auto = new Auto();
					tipoAuto = controladorTipoAuto.getByID(rs.getInt("id_tipoauto"));
					auto.setId(rs.getInt("id_auto"));
					auto.setTipo(tipoAuto);
					auto.setNombre(rs.getString("nombre"));
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
			
			return auto;
		}
		
		
		public void setAuto(Auto auto){
			
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		
			try{
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into autos(nombre, id_tipoauto ) VALUES (?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, auto.getNombre() );
				stmt.setInt(2, auto.getTipo().getId() );
				 stmt.executeUpdate();
				 keyResultSet=stmt.getGeneratedKeys();
				 if(keyResultSet!=null && keyResultSet.next()){
					 auto.setId(keyResultSet.getInt(1));
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


	public void bajaByID(int id){
		
	PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from autos where id_auto=?");
			stmt.setInt(1, id );
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
	    }
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void actualiza(Auto auto){
		
	PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update autos set  nombre = ?, id_tipoauto=? WHERE id_auto = ?");
			stmt.setString(1, auto.getNombre() );
			stmt.setInt(2, auto.getTipo().getId() );
			stmt.setInt(3, auto.getId());
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
	    }
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public ArrayList<Auto> getAutosByID(int id) {
		
		ArrayList<Auto> autos = new ArrayList<Auto>();
//		autos =null;
		Auto auto=null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre,id_auto,id_tipoauto FROM autos WHERE id_tipoauto = ?");
			stmt.setInt(1, id);
		rs = stmt.executeQuery();
			while (rs != null && rs.next()){
				auto = new Auto();
				auto.setNombre(rs.getString("nombre"));
				auto.setId(rs.getInt("id_auto"));
				TipoAuto tipo = new TipoAuto();
				tipo.setId(rs.getInt("id_tipoauto"));
				auto.setTipo(tipo);

				
				
				autos.add(auto);
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
		
		return autos;
		
		
	}}

	
