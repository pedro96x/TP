package manejoTiempo;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
abstract
public class NuevoDate {
		//Esta clase ABSTRACTA posee un metodo seSolapan el cual recibe dos rangos de tiempo y devuelve True si se solapan y False si no se solapan
	public static boolean seSolapan(Date fechain1, Date fechafin1, String fechain2, String fechafin2) {
		
		String sfechain1 = fechain1.toString(); 
		String sfechafin1 = fechafin1.toString(); 
		String sfechain2 = fechain2.toString(); 
		String sfechafin2 = fechafin2.toString(); 
		
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		DateTime fechaInicio1 = formatter.parseDateTime(sfechain1);
		DateTime fechaFin1 = formatter.parseDateTime(sfechafin1);

		DateTime fechaInicio2 = formatter.parseDateTime(sfechain2);
		DateTime fechaFin2 = formatter.parseDateTime(sfechafin2);

		
		Interval intervalo1 = new Interval( fechaInicio1, fechaFin1 );
		Interval intervalo2 = new Interval( fechaInicio2, fechaFin2 );
		
	return intervalo1.overlaps( intervalo2 );
}}
