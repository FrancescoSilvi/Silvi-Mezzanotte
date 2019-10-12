package it.univpm.ProgettoOOP.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	 * Restituisce la lista dei metadati
	 */
	@GetMapping("/metadata")
	public ArrayList<Metadata> stampaMeta()
	{
		return SavedData.getArrMeta();
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"CampoRic", "operator", "val"})
	public ArrayList<FisherAid> getData(@RequestParam String CampoRic, String operator, String val) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		return new Filters().SelectOut(CampoRic, operator, val);
	}
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ArrayList<StatObj> getStats(@RequestParam String anno) {
			
		StatsCalc sc = new StatsCalc(SavedData.getArrFisherAid(), anno);
		return sc.stats();
		}
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET, params = {"anno", "CampoRic", "operator", "val"})
	public ArrayList<StatObj> getStats(@RequestParam String anno, String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			
		StatsCalc sc = new StatsCalc(new Filters().SelectOut(CampoRic, operator, val), anno);
		return sc.stats();
		}
	
	@RequestMapping(value = "/occ", method = RequestMethod.GET)
	public HashMap<String, Integer> getOcc(@RequestParam String CampoRic) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
		{	
			return new occorrenze(SavedData.getArrFisherAid()).NumRip(CampoRic);
		}
	
	@RequestMapping(value = "/occ", method = RequestMethod.GET, params = {"Colonna", "CampoRic", "operator", "val"})
	public HashMap<String, Integer> getOcc(@RequestParam String Colonna, String CampoRic, String operator, String val) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
			return new occorrenze(new Filters().SelectOut(CampoRic, operator, val)).NumRip(Colonna);
		}
	
}
