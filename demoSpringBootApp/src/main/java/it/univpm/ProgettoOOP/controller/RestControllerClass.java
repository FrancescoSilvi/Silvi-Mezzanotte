package it.univpm.ProgettoOOP.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOP.data.SavedData;
//import it.univpm.ProgettoOOP.filter.FeaturFilter;
import it.univpm.ProgettoOOP.model.FisherAid;
import it.univpm.ProgettoOOP.model.Metadata;
//import it.univpm.ProgettoOOP.statistics.NumberStat;
//import it.univpm.ProgettoOOP.statistics.ResultNum;
//import it.univpm.ProgettoOOP.statistics.ResultStr;
//import it.univpm.ProgettoOOP.statistics.StringStat;

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
	

}
