package it.univpm.ProgettoOOP.Stats;

import java.util.ArrayList;

import it.univpm.ProgettoOOP.model.CellAnno;
import it.univpm.ProgettoOOP.model.FisherAid;

public class StatsCalc {
	private ArrayList<StatObj> arrStats;
	private ArrayList<FisherAid> afa;
	private int j;
	
	public StatsCalc (ArrayList<FisherAid> afa, String Colonna) {
		try{
			this.afa = afa;
			CellAnno anno = new CellAnno(Colonna);
			j = anno.getColonna();
			}catch(NumberFormatException e) {
				e.printStackTrace(); }			
	}
	
	public int Count() {
		int num = 0;
		for(int i = 0; i < afa.size(); i++)
			if(afa.get(i).getAnni()[j] >= 0) num++;
		return num;
	}
	
	public float Sum () {
		float sum = 0;
		for(int i = 0; i < afa.size(); i++) 
			sum += afa.get(i).getAnni()[j];	
		return sum;
	}

	public float Avg() {
		return Sum()/Count();
	}	

	public float Max() {
		float max = 0;
		for(int i = 0; i < afa.size(); i++)
			if (max < afa.get(i).getAnni()[j])
				max = afa.get(i).getAnni()[j];
		return max;
	}
	
	public float Min() {
		float min = 0;
		for(int i = 0; i < afa.size(); i++)
			if (min > afa.get(i).getAnni()[j])
				min = afa.get(i).getAnni()[j];
		return min;
	}

	public float DevSt() {
	float devst2 = 0;
	float media = Avg();
	float num = Count();
	for(int i = 0; i < Count(); i++)
		devst2 += Math.pow((afa.get(i).getAnni()[j]-media),2)/num;
	return (float)Math.sqrt(devst2);		
	}
	
	public  ArrayList<StatObj> stats (){
		arrStats = new ArrayList<StatObj>();
		arrStats.add(new StatObj(Count(), Sum(), Avg(), Max(), Min(), DevSt()));
		return arrStats;
	}
}
