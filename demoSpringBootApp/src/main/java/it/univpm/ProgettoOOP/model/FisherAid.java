package it.univpm.ProgettoOOP.model;

/** Classe "scheleto" degli oggetti che rappresentano le righe della tabella*/
public class FisherAid {
	
	private String Freq;
	private String Geo;
	private String Unit;
	private double[] Anni;
	
	public FisherAid(String Freq, String Geo, String Unit, double[] Anni)
	{
		this.Freq = Freq;
		this.Geo = Geo;
		this.Unit = Unit;
		this.Anni = Anni;
	}

	public String getFreq() {
		return Freq;
	}

	public String getGeo() {
		return Geo;
	}


	public String getUnit() {
		return Unit;
	}


	public double[] getAnni() {
		return Anni;
	}
	


}
