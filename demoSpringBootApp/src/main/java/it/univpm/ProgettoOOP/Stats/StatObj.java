package it.univpm.ProgettoOOP.Stats;

/**Classe scheletro che contiene i risultati delle statistiche*/
public class StatObj {
	private double count;
	private double sum;
	private double agv;
	private double max;
	private double min;
	private double devst;
	
public StatObj (double count, double sum, double agv, double max, double min, double devst) {
	this.count = count;
	this.sum = sum;
	this.agv = agv;
	this.max = max;
	this.min = min;
	this.devst = devst;
}
	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAgv() {
		return agv;
	}

	public void setAgv(double agv) {
		this.agv = agv;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getDevst() {
		return devst;
	}

	public void setDevst(double devst) {
		this.devst = devst;
	}

}
