package it.univpm.ProgettoOOP.Stats;

/**Classe costruita per effettuare controlli booleani,
 * o determinate assegnazioni in caso di successi*/

public class Check {

 	/**Metodo che esegue il confronto fra due valori,
 	 * in base a se sono stringhe o numeri e all'operatore*/
	public boolean FilterCK (Object val, String operator, Object ValRif) {	
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
	
	 /**Metodo che restituisce il valore della cella relativa
	  * all'anno, se non si tratta di un annoo viene passato -1*/
	 public int getColonna (String CampoRic) {	
		 switch (CampoRic) {
		 case "2000": return 0;
		 case "2001": return 1;
		 case "2002": return 2;
		 case "2003": return 3;
		 case "2004": return 4;
		 case "2005": return 5;
		 case "2006": return 6;
		 case "2007": return 7;
		 case "2008": return 8;
		 case "2009": return 9;
		 case "2010": return 10;
		 case "2011": return 11;
		 case "2012": return 12;
		 case "2013": return 13;
		 case "2014": return 14;
		 case "2015": return 15;
		 case "2016": return 16;
		 case "2017": return 17;
		 default: return -1;
		 }
	 }
}
