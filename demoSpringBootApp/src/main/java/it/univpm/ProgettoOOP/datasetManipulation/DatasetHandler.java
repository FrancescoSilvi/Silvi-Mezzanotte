package it.univpm.ProgettoOOP.datasetManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


public class DatasetHandler
{
	private String strJSON, line;
	private URL link;
	private BufferedReader in;
	/**
	 * Nel costruttore il contenuto dell'URL è copiato e memorizzato in una variabile
	 */
	public DatasetHandler(String url) throws MalformedURLException, IOException
	{
		this.strJSON = "";
		this.line = "";
		this.link = new URL(url);
	    this.in = new BufferedReader(new InputStreamReader(link.openStream()));
	    
	    while ((line = in.readLine()) != null)
	    {
	    	strJSON += line;
	    }
	    in.close();
	}
	
	/**
	 * Converte la stringa precedentemente salvata in un oggetto di tipo JSON per poi andare a localizzare la posizione dell'URL del dataset.
	 * Dopodiché legge il contenuto dell'URL e ne effettua una copia salvata su un file in locale
	 */
	public boolean downloadCSV() throws MalformedURLException, IOException, JSONException
	{
		JSONObject json = new JSONObject(strJSON);
		link = new URL(json.getJSONObject("result").getJSONArray("resources").getJSONObject(1).getString("url"));
		in = new BufferedReader(new InputStreamReader(link.openStream()));
	    PrintWriter out = new PrintWriter("dataset.csv");
	    
	    while ((line = in.readLine()) != null)
	    {
	    	if (!line.trim().isEmpty()) //considera anche gli spazi perché con gli spazi non funziona
	    	{
	    		out.println(line);
	    	}
	    }
	    in.close();
	    out.close();
	    
	    return true;
	}
}
