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
		for(int i = 0; i < afa.size(); i++)
			if(afa.get(i).getAnno(j, i) >= 0) num++;
		return num;
	}
	
	public float Sum () {
		float sum = 0;
		for(int i = 0; i < afa.size(); i++)
			sum += afa.get(i).getAnno(j, i);
		return sum;
	}

	public float Avg() {
		return Sum()/Count();
	}	

	public float Max() {
		float max = 0;
		for(int i = 0; i < afa.size(); i++)
			if (max < afa.get(i).getAnno(j, i))
				max = afa.get(i).getAnno(j, i);
		return max;
	}
	
	public float Min() {
		float min = 0;
		for(int i = 0; i < afa.size(); i++)
			if (min > afa.get(i).getAnno(j, i))
				min = afa.get(i).getAnno(j, i);
		return min;
	}

	public float DevSt() {
	float devst2 = 0;
	float media = Avg();
	float num = Count();
	for(int i = 0; i < Count(); i++)
		devst2 += (afa.get(i).getAnno(j, i)-media)/num;
	return (float)Math.sqrt(devst2);		
	}
	
	public  ArrayList<StatObj> stats (ArrayList<FisherAid> fas){
		arrStats = new ArrayList<StatObj>();
		arrStats.add(new StatObj(Count(), Sum(), Avg(), Max(), Min(), DevSt()));
		return arrStats;
	}
}
