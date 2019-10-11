package it.univpm.ProgettoOOP.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOP.FiltersPkg.Filters;
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
	
}
