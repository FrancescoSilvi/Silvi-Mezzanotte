package it.univpm.ProgettoOOP.model;

public class CellAnno {
private int NumCella;
private String CampoRic;

public CellAnno(String CampoRic) {
	this.CampoRic = CampoRic;
}
 public boolean CheckAnno() {
	 switch (CampoRic) {
	 case "2000": return true;
	 case "2001": return true;
	 case "2002": return true;
	 case "2003": return true;
	 case "2004": return true;
	 case "2005": return true;
	 case "2006": return true;
	 case "2007": return true;
	 case "2008": return true;
	 case "2009": return true;
	 case "2010": return true;
	 case "2011": return true;
	 case "2012": return true;
	 case "2013": return true;
	 case "2014": return true;
	 case "2015": return true;
	 case "2016": return true;
	 case "2017": return true;
	 default: return false;
	 }
 }
 
 public int getColonna () {
	 switch (CampoRic) {
	 case "2000": return 0;
	 case "2001": return 1;
	 case "2002": return 2;
	 case "2003": return 3;
	 case "2004": return 4;
	 case "2005": return 5;
	 case "2006": return 6;
	 case "2007": return 7;
	 case "2008": return 8;
	 case "2009": return 9;
	 case "2010": return 10;
	 case "2011": return 11;
	 case "2012": return 12;
	 case "2013": return 13;
	 case "2014": return 14;
	 case "2015": return 15;
	 case "2016": return 16;
	 case "2017": return 17;
	 default: return -1;
	 }
 }
 }
