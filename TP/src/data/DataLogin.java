package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Persona;
import ui.Login;

public class DataLogin {
	public Persona compara(Persona per){
		
		Persona p = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, habilitado, user, pass FROM personasTP where user=? and pass = ?");
		stmt.setString(1, per.getUser());
		stmt.setString(2, per.getPass());
		rs = stmt.executeQuery();
			if (rs != null && rs.next()){
				p = new Persona();
				p.setId(rs.getInt("id"));
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setDni(rs.getInt("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setUser(rs.getString("user"));
				p.setPass(rs.getString("pass"));
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
		
		return p;
	}

}
