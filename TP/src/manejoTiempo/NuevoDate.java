package manejoTiempo;

import java.sql.Date;
abstract
public class NuevoDate {
		//Esta clase ABSTRACTA posee un metodo seSolapan el cual recibe dos rangos de tiempo y devuelve True si se solapan y False si no se solapan
	public static boolean seSolapan(Date fechain1, Date fechafin1, Date fechain2, Date fechafin2) {
		
		long in1=fechain1.getTime();
		long fin1=fechafin1.getTime();
		long in2=fechain2.getTime();
		long fin2=fechafin2.getTime();
		
		if (fin2 < in1 && fin1> in2){
			return false;
		}
		else {return true;}
	}

}
