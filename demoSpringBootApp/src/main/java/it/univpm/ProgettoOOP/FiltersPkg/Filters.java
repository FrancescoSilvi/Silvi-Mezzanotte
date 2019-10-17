package it.univpm.ProgettoOOP.FiltersPkg;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.Stats.Check;
import it.univpm.ProgettoOOP.model.FisherAid;

/**Classe chiamata per applicare i filtri richiesti*/
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
	 * Metodo che scorre i valori numerici e dunque esegue le opportune operazionni di casting
	 * e chiama volta per volta il check
	 */
	
	public void ScorriAnni (String CampoRic, String operator, String val) {			
		double ValRif = Double.parseDouble(val);
		for (int i=0; i < AiutiPesca.size();i++) {
			if(new Check().FilterCK(AiutiPesca.get(i).getAnni()[position], operator, ValRif )) 	
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
					if(new Check().FilterCK(tmp, operator, val))	
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
	Check anno = new Check();
		if(anno.getColonna(CampoRic)==-1) {							//si verifica se si crca in una colonna anno o in una colonna stringa
			ScorriStr(CampoRic, operator, val);	
		}else { position = anno.getColonna(CampoRic);				//si prende il numero della cella dell'anno che si sta esaminando
				ScorriAnni(CampoRic, operator, val);
		}
		return out;
	}
}