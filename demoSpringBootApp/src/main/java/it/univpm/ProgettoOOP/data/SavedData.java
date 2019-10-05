package it.univpm.ProgettoOOP.data;

import java.util.ArrayList;
import it.univpm.ProgettoOOP.model.FisherAid;
import it.univpm.ProgettoOOP.model.Metadata;
/**
 * Classe contenente gli oggetti che servono a memorizzare dati e metadati
 */
public class SavedData
{
	private static ArrayList<FisherAid> arrFisherAid = new ArrayList<FisherAid>();

	public static void setArrFisherAid(ArrayList<FisherAid> arrFisherAid) {
		SavedData.arrFisherAid = arrFisherAid;
	}

	private static ArrayList<Metadata> arrMeta = new ArrayList<Metadata>();
	
	public SavedData()
	{
		arrFisherAid = new ArrayList<FisherAid>();
		arrMeta = new ArrayList<Metadata>();
		
		arrMeta.add(new Metadata("Freq", "Frequenza", "string"));
		arrMeta.add(new Metadata("Geo", "Paese", "string"));
		arrMeta.add(new Metadata("Unit", "Unità", "string"));
		arrMeta.add(new Metadata("2000", "2000", "float"));
		arrMeta.add(new Metadata("2001", "2001", "float"));
		arrMeta.add(new Metadata("2002", "2002", "float"));
		arrMeta.add(new Metadata("2003", "2003", "float"));
		arrMeta.add(new Metadata("2004", "2004", "float"));
		arrMeta.add(new Metadata("2005", "2005", "float"));
		arrMeta.add(new Metadata("2006", "2006", "float"));
		arrMeta.add(new Metadata("2007", "2007", "float"));
		arrMeta.add(new Metadata("2008", "2008", "float"));
		arrMeta.add(new Metadata("2009", "2009", "float"));
		arrMeta.add(new Metadata("2010", "2010", "float"));
		arrMeta.add(new Metadata("2011", "2011", "float"));
		arrMeta.add(new Metadata("2012", "2012", "float"));
		arrMeta.add(new Metadata("2013", "2013", "float"));
		arrMeta.add(new Metadata("2014", "2014", "float"));
		arrMeta.add(new Metadata("2015", "2015", "float"));
		arrMeta.add(new Metadata("2016", "2016", "float"));
		arrMeta.add(new Metadata("2017", "2017", "float"));
	}
	
	public static ArrayList<FisherAid> getArrFisherAid() {
		return arrFisherAid;
	}
	
	public static ArrayList<Metadata> getArrMeta() {
		return arrMeta;
	}
}
