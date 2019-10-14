package it.univpm.ProgettoOOP.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOP.FiltersPkg.Filters;
import it.univpm.ProgettoOOP.Stats.StatObj;
import it.univpm.ProgettoOOP.Stats.StatsCalc;
import it.univpm.ProgettoOOP.Stats.occorrenze;
import it.univpm.ProgettoOOP.data.SavedData;
import it.univpm.ProgettoOOP.model.FisherAid;
import it.univpm.ProgettoOOP.model.Metadata;

@RestController
public class RestControllerClass
{
	/**
	 * Restituisce la lista dei dati
	 */
	@GetMapping("/data")
	public ArrayList<FisherAid> stampaDati()
	{
		return SavedData.getArrFisherAid();
	}
	/**
	 * Restituisce la lista delle colonne
	 */
	@GetMapping("/metadata")
	public ArrayList<Metadata> stampaMeta()
	{
		return SavedData.getArrMeta();
	}
	/**
	 * Restituisce la lista dei dati filtrati in base ai valori acquisiti
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"CampoRic", "operator", "val"})
	public ArrayList<FisherAid> getData(@RequestParam String CampoRic, String operator, String val) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		return new Filters().SelectOut(CampoRic, operator, val);
	}
	/**
	 * Restituisce la lista dei dati in % o di quelli in € filtrati in base ai valori acquisiti
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"unità", "CampoRic", "operator", "val"})
	public ArrayList<FisherAid> getData(@RequestParam String unità, String CampoRic, String operator, String val) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		if(unità.equals("%")) unità = "PC_GDP";
		else if (unità.equals("€")) unità = "MEUR_KP_PRE";
		ArrayList<FisherAid> FirstFilter = new Filters().SelectOut("unit", "in", unità);
		return new Filters(FirstFilter).SelectOut(CampoRic, operator, val);
	}
	/**
	 * Restituisce le statistiche dei dati in % o di quelli in € calcolate sull'anno richiesto
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET, params = {"unità", "anno"})
	public ArrayList<StatObj> getStats(@RequestParam String unità, String anno) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
		{
		if(unità.equals("%")) unità = "PC_GDP";
		else if (unità.equals("€")) unità = "MEUR_KP_PRE";
		StatsCalc sc = new StatsCalc(new Filters().SelectOut("unit", "in", unità), anno);
		return sc.stats();
		}
	/**
	 * Restituisce le statistiche dei dati in % o di quelli in € calcolate sull'anno richiesto e filtrate secondo i valori acquisiti
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET, params = {"unità", "anno", "CampoRic", "operator", "val"})
	public ArrayList<StatObj> getStats(@RequestParam String unità, String anno, String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
		{
		if(unità.equals("%")) unità = "PC_GDP";
		else if (unità.equals("€")) unità = "MEUR_KP_PRE";
		ArrayList<FisherAid> FirstFilter = new Filters().SelectOut("unit", "in", unità);
		StatsCalc sc = new StatsCalc(new Filters(FirstFilter).SelectOut(CampoRic, operator, val), anno);
		return sc.stats();
		}
	/**
	 * Restituisce il numero di rietizioni delle stringhe nella colonna selezionata
	 */
	@RequestMapping(value = "/occ", method = RequestMethod.GET)
	public HashMap<String, Integer> getOcc(@RequestParam String Colonna) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
		{	
			return new occorrenze(SavedData.getArrFisherAid()).NumRip(Colonna);
		}
	/**
	 * Restituisce il numero di rietizioni delle stringhe nella colonna selezionata sulle righr rimaste dopo il filtraggio
	 */
	@RequestMapping(value = "/occ", method = RequestMethod.GET, params = {"Colonna", "CampoRic", "operator", "val"})
	public HashMap<String, Integer> getOcc(@RequestParam String Colonna, String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
			return new occorrenze(new Filters().SelectOut(CampoRic, operator, val)).NumRip(Colonna);
		}
	
}
