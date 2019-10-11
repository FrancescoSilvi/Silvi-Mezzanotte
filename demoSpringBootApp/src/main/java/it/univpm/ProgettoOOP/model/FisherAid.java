package it.univpm.ProgettoOOP.model;

import it.univpm.ProgettoOOP.data.SavedData;

public class FisherAid {
	
	private String Freq;
	private String Geo;
	private String Unit;
	private float[] Anni;
	
	public FisherAid(String Freq, String Geo, String Unit, float[] Anni)
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


	public float[] getAnni() {
		return Anni;
	}
	
 
	public float getAnno(int j, int i) {
		float[] Anni = SavedData.getArrFisherAid().get(i).getAnni();
		return Anni[j];
	}
	


}
