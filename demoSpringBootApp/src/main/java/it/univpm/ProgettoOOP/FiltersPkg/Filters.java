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
	private int position;
	
	/**
	 * Primo costruttore che forma un nuovo arraylist di oggetti del tipo da restituire
	 * e fornisce ai filtri l'intera lista di oggetti
	 */
	
	public Filters () {
		out = new ArrayList<FisherAid>();
		AiutiPesca = SavedData.getArrFisherAid();
	}
	
	/**
	 * Secondo costruttore che forma un nuovo arraylist di oggetti del tipo da restituire
	 * e fornisce ai filtri una lista di oggetti già filtrati
	 */
	
	 public Filters(ArrayList<FisherAid> fafa) {
		 out = new ArrayList<FisherAid>();
		 AiutiPesca = fafa;
	 }

	 /**
	 * Metodo che esegue il confronto fra due valori, in base a se sonon stringa o numerici e all'operatore
	 */
	 
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
	
	/**
	 * Metodo che scorre i valori numerici e dunque esegue le opportune operazionni di casting
	 * e chiama volta per volta il check
	 */
	
	public void ScorriAnni (String CampoRic, String operator, String val) {			
		double ValRif = Double.parseDouble(val);
		for (int i=0; i < AiutiPesca.size();i++) {
			if(Filters.check(AiutiPesca.get(i).getAnni()[position], operator, ValRif )) 
				out.add(AiutiPesca.get(i));
		}
	}
	
	/**
	 * Metodo che scorre i valori di tipo stringa e chiama volta per volta il check
	 */	
	
	public void ScorriStr (String CampoRic, String operator, String val) {
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
	
	/**
	 * Il metodo SelectOut riceve i parametri del filtro e seleziona quale metodo
	 * della sua stessa classe andare ad utilizzare in base al tipo di dati ricevuti
	 */
	
	public ArrayList<FisherAid> SelectOut (String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		CellAnno anno = new CellAnno(CampoRic);
		if(anno.CheckAnno()) {							//si verifica se si crca in una colonna anno o in una colonna stringa
			position = anno.getColonna();				//si prende il numero della cella dell'anno che si sta esaminando
			ScorriAnni(CampoRic, operator, val);
		}else ScorriStr(CampoRic, operator, val);
		return out;
	}
}