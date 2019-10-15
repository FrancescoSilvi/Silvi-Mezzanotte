package it.univpm.ProgettoOOP.Stats;

import java.util.ArrayList;

import it.univpm.ProgettoOOP.model.CellAnno;
import it.univpm.ProgettoOOP.model.FisherAid;

public class StatsCalc {
	private ArrayList<StatObj> arrStats;
	private ArrayList<FisherAid> afa;
	private int j;
	
	/**Nel costruttore si riceve l'array list su quale lavorare
	 * e la colonna sulla quale calcolare le statistiche */
	public StatsCalc (ArrayList<FisherAid> afa, String Colonna) {
		try{
			this.afa = afa;
			CellAnno anno = new CellAnno(Colonna);
			j = anno.getColonna();
			}catch(NumberFormatException e) {
				e.printStackTrace(); }			
	}
	
	//conta le righe presenti
	public int Count() {
		int num = 0;
		for(int i = 0; i < afa.size(); i++)
			if(afa.get(i).getAnni()[j] >= 0) num++;
		return num;
	}
	
	//calcola la somma
	public double Sum () {
		double sum = 0;
		for(int i = 0; i < afa.size(); i++) 
			sum += afa.get(i).getAnni()[j];	
		return sum;
	}

	//calcola la media
	public double Avg() {
		return Sum()/Count();
	}	

	//trova il massimo
	public double Max() {
		double max = 0;
		for(int i = 0; i < afa.size(); i++)
			if (max < afa.get(i).getAnni()[j])
				max = afa.get(i).getAnni()[j];
		return max;
	}
	
	//trova il minimo
	public double Min() {
		double min = 0;
		for(int i = 0; i < afa.size(); i++)
			if (min > afa.get(i).getAnni()[j])
				min = afa.get(i).getAnni()[j];
		return min;
	}

	//calcola la deviazione standard
	public double DevSt() {
	double devst2 = 0;
	double media = Avg();
	double num = Count();
	for(int i = 0; i < Count(); i++)
		devst2 += Math.pow((afa.get(i).getAnni()[j]-media),2)/num;
	return Math.sqrt(devst2);		
	}
	
	//forma un arraylist di oggetti StatObj e lo popola con i risultati, poi restituisce l'arraylist
	public  ArrayList<StatObj> stats (){
		arrStats = new ArrayList<StatObj>();
		arrStats.add(new StatObj(Count(), Sum(), Avg(), Max(), Min(), DevSt()));
		return arrStats;
	}
}
