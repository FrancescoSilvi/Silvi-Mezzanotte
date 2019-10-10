package it.univpm.ProgettoOOP.Stats;

public class StatObj {
	private float count;
	private float sum;
	private float agv;
	private float max;
	private float min;
	private float devst;
	
public StatObj (float cont, float sum, float agv, float max, float min, float devst) {
	this.count = count;
	this.sum = sum;
	this.agv = agv;
	this.max = max;
	this.min = min;
	this.devst = devst;
}
	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public float getAgv() {
		return agv;
	}

	public void setAgv(float agv) {
		this.agv = agv;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getDevst() {
		return devst;
	}

	public void setDevst(float devst) {
		this.devst = devst;
	}

}
