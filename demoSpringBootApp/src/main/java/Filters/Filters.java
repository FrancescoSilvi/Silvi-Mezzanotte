package Filters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;


public class Filters {
private static ArrayList<FisherAid> AiutiPesca;
private static ArrayList<FisherAid> out;
private int cella;

	public Filters () {
		out = new ArrayList<FisherAid>();
		AiutiPesca = SavedData.getArrFisherAid();
	}
	
	public static boolean check (Object ValRif, String operator, Object val) {		System.out.print("sto facendo il check -> ");
		if(val instanceof String && ValRif instanceof String) {	//per le stringhe
																System.out.println("per stringa stringa");
			switch (operator) {
			case "in":
				if (ValRif.equals(val)) return true;
				return false;
			case "nin":
				if (!(ValRif.equals(val))) return true;
				return false;
			}
		}else if(val instanceof Number && ValRif instanceof Number) {	//per i numeri
																System.out.println("per numero numero");
			double val1 = ((Number) ValRif).doubleValue();
			double val2 = ((Number) val).doubleValue();
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
				if (val1 >= val2) return true;
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
	
	
	public void ScorriAnni (String CampoRic, String operator, String val) {			System.out.println("sono nel scorri anni");
		//double AnnoRic = Double.parseDouble(CampoRic);
		for (int i=0; i < SavedData.getArrFisherAid().size();i++) {
			if(Filters.check(cella+2000, operator, SavedData.getArrFisherAid().get(i).getAnno(cella, i))) {
				out.add(SavedData.getArrFisherAid().get(i));						System.out.println("riempo out da scorri anni");}
		}
	}
	
	public void ScorriStr (String CampoRic, String operator, String val) {			System.out.println("sono nel scorri stringa");
	//	if(!(out.isEmpty())) out.clear();
		for(FisherAid indice : AiutiPesca) {		//scorre gli ogetti (le righe)
			try {
				Method m = indice.getClass().getMethod("get"+CampoRic.substring(0,1).toUpperCase()+CampoRic.substring(1), null);
				//la riga precedente crea un metodo in base al campo di ricerca
				try {
					Object tmp = m.invoke(indice);	//richiama il metodo creato da Method
					if (Filters.check(tmp, operator, val)) {
						out.add(indice);	//add aggiunge una riga ad out
																					System.out.println("riempo out da scorri stringa");}
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
	{													System.out.println("sono nel slect out");
		CellAnno anno = new CellAnno(CampoRic);
		if(anno.CheckAnno())
			ScorriAnni(CampoRic, operator, val);
		else ScorriStr(CampoRic, operator, val);
		cella = anno.getColonna();						System.out.println("ritorno out");
		return out;
	}
}
/* *************************************************************************
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

			
}*/