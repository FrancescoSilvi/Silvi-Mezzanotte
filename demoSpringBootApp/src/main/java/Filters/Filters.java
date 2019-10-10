package Filters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;

public class Filters {
ArrayList<FisherAid> AiutiPesca = SavedData.getArrFisherAid();

//public Filters (ArrayList<FisherAid> AiutiPesca) {
//	this.AiutiPesca = AiutiPesca;
//}

public static boolean check (Object ValRif, String operator, Object val) {
	if(val instanceof String && ValRif instanceof String) {	//per le stringhe
		switch (operator) {
		case "in":
			if ((String)val==(String)ValRif) return true;
			return false;
		case "nin":
			if ((String)val!=(String)ValRif) return true;
			return false;
		}
	}else if(val instanceof Number && ValRif instanceof Number) {	//per i numeri
		switch (operator) {
		case "gt":	//>
			if ((float)val>(float)ValRif) return true;
			return false;
		case "gte":	//>=
			if ((float)val>=(float)ValRif) return true;
			return false;
		case "lt":	//<
			if ((float)val<(float)ValRif) return true;
			return false;
		case "lte":	//<=
			if ((float)val<=(float)ValRif) return true;
			return false;
		case "in":	//==
			if((float)val==(float)ValRif) return true;
			return false;
		case "nin":	//!=
			if((float)val!=(float)ValRif) return true;
			return false;
	//	case "bt":	//=<value>=
	//		break;
		}
	}
	return false;
}

public ArrayList<FisherAid> selected(String CampoRic, String operator, String val){
	ArrayList<FisherAid> out = new ArrayList<FisherAid>();
	for(FisherAid indice : AiutiPesca) {		//scorre gli ogetti (le righe)
		try {
			Method m = indice.getClass().getMethod("get"+CampoRic.substring(0,1).toUpperCase()+CampoRic.substring(1), null);
			//la riga precedente crea un metodo in base al campo di ricerca
			try {
				Object tmp = m.invoke(indice);	//richiama il metodo creato da Method
				if (Filters.check(tmp, operator, val))
					out.add(indice);	//add aggiunge una riga ad out
			}catch (IllegalAccessException e) {
				e.printStackTrace();
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			}catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		}
		}
		return out;
		}

			
}