package Filters;

import java.util.ArrayList;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;

public class Filters {
ArrayList<FisherAid> AiutiPesca;
public Filters(ArrayList<FisherAid> AiutiPesca) {
	this.AiutiPesca=AiutiPesca;
}
public void check(String val1, String operator, String val2) { // per ora è void, poi si vedrà
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
	
	}
}
}
