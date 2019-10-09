package Filters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;

public class Filters {
ArrayList<FisherAid> AiutiPesca;

public Filters(ArrayList<FisherAid> AiutiPesca) {
	this.AiutiPesca=AiutiPesca;
		
}

public static boolean check (String val, String operator, String CampoRic) {
	
	return true;
	//return false;
}

public ArrayList<FisherAid> selected(ArrayList<FisherAid> selec, String val, String operator, String CampoRic){
	ArrayList<FisherAid> out = new ArrayList<FisherAid>();
	for(FisherAid indice : AiutiPesca) {
		try {
			Method m = indice.getClass().getMethod("get"+CampoRic.substring(0,1).toUpperCase()+CampoRic.substring(1), null);
			try {
				Object tmp = m.invoke(indice);
				if (Filters.check(val, operator, CampoRic))
					out.add(indice);
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
/*public void check(String val1, String operator, String val2) { // per ora è void, poi si vedrà
	switch(val2) {
	case "GEO":
		if(operator=="nin") {
			for(int i=0; i<SavedData.getArrFisherAid().size();i++) {
				if(SavedData.getArrFisherAid().get(i).getGeo()!=val1);  //stampare in JSON
			}
		}
		else if(operator=="in") {
			for(int i=0; i<SavedData.getArrFisherAid().size();i++) {
				if(SavedData.getArrFisherAid().get(i).getGeo()==val1);  //stampare in JSON
			}
		}
		break;
	case "2000":
		Method m = AiutiPesca.getClass().getMethod("get"+AiutiPesca.substring(0, 1).toUpperCase()+fieldName.substring(1),null)
		/*fare un metodo che dica al programma il get da usare in automatico. fare con method (reflect) 
		 * per esempio: SavedData.getArrFisherAid().get(i).method...ecc*/
	/*
		break;
	case "2001":
		
		break;
	case "2002":
		
		break;
	case "2003":
		
		break;
	case "2004":
		
		break;
	case "2005":
		
		break;
	case "2006":
		
		break;
	case "2007":
		
		break;
	case "2008":
		
		break;
	case "2009":
		
		break;
	case "2010":
		
		break;
	case "2011":
		
		break;
	case "2012":
		
		break;
	case "2013":
		
		break;
	case "2014":
		
		break;
	case "2015":
		
		break;
	case "2016":
		
		break;
	case "2017":
		
		break;
	
	}*/


