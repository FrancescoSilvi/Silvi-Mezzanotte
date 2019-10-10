package it.univpm.ProgettoOOP.Stats;

import java.util.ArrayList;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;

public class StatsCalc {
	private ArrayList<StatObj> arrStats;
	private ArrayList<FisherAid> afa;
	private int j;
	
	public StatsCalc (ArrayList<FisherAid> afa, String Colonna) {
		try{
			this.afa = afa;
			if(Integer.parseInt(Colonna)<=2017 && Integer.parseInt(Colonna)>=2000)
				j = Integer.parseInt(Colonna)-2000;
			}catch(NumberFormatException e) {
				e.printStackTrace(); }			
	}
	
	public int Count() {
		int num = 0;
		for(int i = 0; i < SavedData.getArrFisherAid().size(); i++)
			if(SavedData.getArrFisherAid().get(i).getAnno(j, i) >= 0) num++;
		return num;
	}
	
	public float Sum () {
		float sum = 0;
		for(int i = 0; i < SavedData.getArrFisherAid().size(); i++)
			sum += SavedData.getArrFisherAid().get(i).getAnno(j, i);
		return sum;
	}

	public float Avg() {
	
	}	

	public float Max() {
	
	}
	
	public float Min() {
	
	}

	public float DevSt() {
	
	}
	
	public  ArrayList<StatObj> stats (ArrayList<FisherAid> fas){
		arrStats = new ArrayList<StatObj>();
		arrStats.add(new StatObj(Count(), Sum(), Avg(), Max(), Min(), DevSt()));
		return arrStats;
	}
}
