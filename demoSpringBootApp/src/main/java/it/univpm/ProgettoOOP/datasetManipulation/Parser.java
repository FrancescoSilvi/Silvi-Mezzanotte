package it.univpm.ProgettoOOP.datasetManipulation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;

public class Parser
{
	private FileReader reader;
	private String dataset, str;
	private String[] line;
	private BufferedReader csvReader;
	private ArrayList<FisherAid> afa;
	
	public Parser(String dataset)
	{
		this.dataset = dataset;
		this.afa = SavedData.getArrFisherAid();
	}
	/**
	 * Memorizza le informazioni del dataset in un Arraylist di oggetti
	 */
	public void parse() throws FileNotFoundException, IOException, NullPointerException, NumberFormatException
	{
		
		csvReader = new BufferedReader(new FileReader(dataset));
		csvReader.readLine();       
		
		while ((str = csvReader.readLine()) != null)
        {
			line = str.split("[;,]");
        	afa.add(new FisherAid(line[0], line[1], line[2], 
        			new float[] {Float.parseFloat(line[3]),
        						 Float.parseFloat(line[4]),
        						 Float.parseFloat(line[5]),
        						 Float.parseFloat(line[6]),
        						 Float.parseFloat(line[7]),
        						 Float.parseFloat(line[8]),
        						 Float.parseFloat(line[9]),
        						 Float.parseFloat(line[10]),
        						 Float.parseFloat(line[11]),
        						 Float.parseFloat(line[12]),
        		        		 Float.parseFloat(line[13]),
        		        		 Float.parseFloat(line[14]),
        		        		 Float.parseFloat(line[15]),
        						 Float.parseFloat(line[16]),
								 Float.parseFloat(line[17]),
        						 Float.parseFloat(line[18]),
								 Float.parseFloat(line[19]),
        						 Float.parseFloat(line[20])}));
        }

        csvReader.close();
	}
}