package it.univpm.ProgettoOOP;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.datasetManipulation.DatasetHandler;
import it.univpm.ProgettoOOP.datasetManipulation.Parser;

@SpringBootApplication
public class EsameOOP {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		DatasetHandler dh = new DatasetHandler("http://data.europa.eu/euodp/data/api/3/action/package_show?id=JaHjwrKS416PSCHTJWbQA");
		if (dh.downloadCSV())
		{
			SavedData sd = new SavedData();
			Parser p = new Parser("dataset.csv");
			p.parse();
		}
		else System.out.println("Impossibile avviare l'applicazione, dataset non trovato.");
		SpringApplication.run(EsameOOP.class, args);
	}

}
