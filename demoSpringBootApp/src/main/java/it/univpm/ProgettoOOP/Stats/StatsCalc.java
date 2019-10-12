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
	
	public double Sum () {
		double sum = 0;
		for(int i = 0; i < afa.size(); i++) 
			sum += afa.get(i).getAnni()[j];	
		return sum;
	}

	public double Avg() {
		return Sum()/Count();
	}	

	public double Max() {
		double max = 0;
		for(int i = 0; i < afa.size(); i++)
			if (max < afa.get(i).getAnni()[j])
				max = afa.get(i).getAnni()[j];
		return max;
	}
	
	public double Min() {
		double min = 0;
		for(int i = 0; i < afa.size(); i++)
			if (min > afa.get(i).getAnni()[j])
				min = afa.get(i).getAnni()[j];
		return min;
	}

	public double DevSt() {
	double devst2 = 0;
	double media = Avg();
	double num = Count();
	for(int i = 0; i < Count(); i++)
		devst2 += Math.pow((afa.get(i).getAnni()[j]-media),2)/num;
	return Math.sqrt(devst2);		
	}
	
	public  ArrayList<StatObj> stats (){
		arrStats = new ArrayList<StatObj>();
		arrStats.add(new StatObj(Count(), Sum(), Avg(), Max(), Min(), DevSt()));
		return arrStats;
	}
}
