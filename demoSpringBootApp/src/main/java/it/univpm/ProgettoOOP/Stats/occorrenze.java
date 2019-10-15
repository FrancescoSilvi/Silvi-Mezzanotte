package it.univpm.ProgettoOOP.Stats;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import it.univpm.ProgettoOOP.model.FisherAid;

/**
 * classe che restituisce un hashmap che informa su quante volte
 * ogni stringa che è presente in una colonna si ripete
*/
public class occorrenze {
	HashMap<String, Integer> StringRip;
	ArrayList<FisherAid> afa;
	
	//viene passata un'array list che potrebbe anche essere stata filtrata
	public occorrenze(ArrayList<FisherAid> arrFA) {
		this.afa = arrFA;
		StringRip = new HashMap<String, Integer>();
	}
	
	/**
	 * Se la stringa selezinoata non è già stata incontrata la si inserisce nell'hashmap accompagnata dall'intero 1,
	 * altrimenti si incrementa solamente l'intero senza aggiungerla nuovamente
	 */
	public HashMap<String, Integer> NumRip(String CampoRic) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		for(FisherAid FA : afa) {
			Method m = FA.getClass().getMethod("get" + CampoRic.substring(0, 1).toUpperCase()+CampoRic.substring(1), null);
			if (StringRip.containsKey( m.invoke(FA) )) { 
				StringRip.put((String) m.invoke(FA), StringRip.get((String) m.invoke(FA)) + 1);
			}else StringRip.put((String) m.invoke(FA),1); 
		}
		return StringRip;
	}
	
}
