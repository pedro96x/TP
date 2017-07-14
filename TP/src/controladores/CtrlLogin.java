package controladores;
import data.DataLogin;
import data.DataPersona;
import entidades.Persona;


public class CtrlLogin {
	
	private DataLogin dataLogin;
	
	public CtrlLogin(){
		dataLogin = new DataLogin();
	}
	
	public Persona compara(Persona p){
		Persona per=dataLogin.compara(p);
		return per;
	}

}
