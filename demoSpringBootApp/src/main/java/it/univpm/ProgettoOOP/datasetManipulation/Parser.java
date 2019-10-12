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
		this.afa = SavedData.getArrFisherAid();		//l'array è stato popolato
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
        			new double[] {Double.parseDouble(line[3]),
        						 Double.parseDouble(line[4]),
        						 Double.parseDouble(line[5]),
        						 Double.parseDouble(line[6]),
        						 Double.parseDouble(line[7]),
        						 Double.parseDouble(line[8]),
        						 Double.parseDouble(line[9]),
        						 Double.parseDouble(line[10]),
        						 Double.parseDouble(line[11]),
        						 Double.parseDouble(line[12]),
        		        		 Double.parseDouble(line[13]),
        		        		 Double.parseDouble(line[14]),
        		        		 Double.parseDouble(line[15]),
        						 Double.parseDouble(line[16]),
								 Double.parseDouble(line[17]),
        						 Double.parseDouble(line[18]),
								 Double.parseDouble(line[19]),
        						 Double.parseDouble(line[20])}));
        }

        csvReader.close();
	}
}