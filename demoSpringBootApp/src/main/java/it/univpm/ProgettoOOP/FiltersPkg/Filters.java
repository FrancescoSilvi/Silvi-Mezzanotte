package it.univpm.ProgettoOOP.FiltersPkg;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.CellAnno;
import it.univpm.ProgettoOOP.model.FisherAid;


public class Filters {
private static ArrayList<FisherAid> AiutiPesca;
private static ArrayList<FisherAid> out;
private int cella;
//aggiungere filtro unita di misura!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public Filters () {
		out = new ArrayList<FisherAid>();
		AiutiPesca = SavedData.getArrFisherAid();
	}
	
	public static boolean check (Object val, String operator, Object ValRif) {	
		if(val instanceof String && ValRif instanceof String) {	//per le stringhe
			switch (operator) {
			case "in":
				if (ValRif.equals(val)) return true;
				return false;
			case "nin":
				if (!(ValRif.equals(val))) return true;
				return false;
			}
		}else if(val instanceof Number && ValRif instanceof Number) {	//per i numeri
			double val1 = ((Number) val).doubleValue();
			double val2 = ((Number) ValRif).doubleValue();
			switch (operator) {
			case "gt":	//>
				if (val1 > val2) return true;
				return false;
			case "gte":	//>=
				if (val1 >= val2) return true;
				return false;
			case "lt":	//<
				if (val1 < val2) return true;
				return false;
			case "lte":	//<=
				if (val1 <= val2) return true;
				return false;
			case "in":	//==
				if(val1 == val2) return true;
				return false;
			case "nin":	//!=
				if(val1 != val2) return true;
				return false;
			}
		}
		return false;
	}
	
	
	public void ScorriAnni (String CampoRic, String operator, String val) {			
		double ValRif = Double.parseDouble(val);
		for (int i=0; i < SavedData.getArrFisherAid().size();i++) {
			if(Filters.check(SavedData.getArrFisherAid().get(i).getAnni()[cella], operator, ValRif )) 
				out.add(SavedData.getArrFisherAid().get(i));
		}
	}
	
	public void ScorriStr (String CampoRic, String operator, String val) {
	//	if(!(out.isEmpty())) out.clear();
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
			
	
	}
	
	
	public ArrayList<FisherAid> SelectOut (String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		CellAnno anno = new CellAnno(CampoRic);
		cella = anno.getColonna();	
		if(anno.CheckAnno())
			ScorriAnni(CampoRic, operator, val);
		else ScorriStr(CampoRic, operator, val);
		return out;
	}
}