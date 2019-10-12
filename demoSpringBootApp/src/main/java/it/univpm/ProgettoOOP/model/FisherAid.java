package it.univpm.ProgettoOOP.model;


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
	


}
