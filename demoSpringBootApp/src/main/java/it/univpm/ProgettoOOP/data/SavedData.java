package it.univpm.ProgettoOOP.data;

import java.util.ArrayList;
import it.univpm.ProgettoOOP.model.FisherAid;
import it.univpm.ProgettoOOP.model.Metadata;

/**Classe contenente l'arraylist salvata*/
public class SavedData
{
	private static ArrayList<FisherAid> arrFisherAid = new ArrayList<FisherAid>();	//arraylist nel quale saranno contenuti i dati

	public static void setArrFisherAid(ArrayList<FisherAid> arrFisherAid) {
		SavedData.arrFisherAid = arrFisherAid;
	}

	private static ArrayList<Metadata> arrMeta = new ArrayList<Metadata>();
	
	/**nel costruttore vengono formate le caratteristiche delle colonne*/
	public SavedData()
	{
		arrFisherAid = new ArrayList<FisherAid>();
		arrMeta = new ArrayList<Metadata>();
		
		arrMeta.add(new Metadata("Freq", "Frequenza", "string"));
		arrMeta.add(new Metadata("Geo", "Paese", "string"));
		arrMeta.add(new Metadata("Unit", "unita", "string"));
		arrMeta.add(new Metadata("2000", "2000", "double"));
		arrMeta.add(new Metadata("2001", "2001", "double"));
		arrMeta.add(new Metadata("2002", "2002", "double"));
		arrMeta.add(new Metadata("2003", "2003", "double"));
		arrMeta.add(new Metadata("2004", "2004", "double"));
		arrMeta.add(new Metadata("2005", "2005", "double"));
		arrMeta.add(new Metadata("2006", "2006", "double"));
		arrMeta.add(new Metadata("2007", "2007", "double"));
		arrMeta.add(new Metadata("2008", "2008", "double"));
		arrMeta.add(new Metadata("2009", "2009", "double"));
		arrMeta.add(new Metadata("2010", "2010", "double"));
		arrMeta.add(new Metadata("2011", "2011", "double"));
		arrMeta.add(new Metadata("2012", "2012", "double"));
		arrMeta.add(new Metadata("2013", "2013", "double"));
		arrMeta.add(new Metadata("2014", "2014", "double"));
		arrMeta.add(new Metadata("2015", "2015", "double"));
		arrMeta.add(new Metadata("2016", "2016", "double"));
		arrMeta.add(new Metadata("2017", "2017", "double"));
	}
	
	/**metodo che serve per ottenere i dati salvati*/
	public static ArrayList<FisherAid> getArrFisherAid() {	
		return arrFisherAid;
	}
	
	/**metodo che serve per ottenere i metadati*/
	public static ArrayList<Metadata> getArrMeta() {
		return arrMeta;
	}
}
