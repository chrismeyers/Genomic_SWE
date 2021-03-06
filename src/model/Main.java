package model;


import java.io.IOException;
import java.util.*;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import display.*;

public class Main {
	private static GUI gui;
	private static Handler handler = new Handler();
	private static Language language = new Language();
	private static Parser parser = new Parser();
	
	public static void main(String[] args)
	{
		
		parser = new Parser();
		handler = new Handler();
		language = new Language();
		
		try {
			handler.storeData(Parser.readGene());
		} catch (Exception e) {
			GUI.displayException(e);
		}
		try {
			handler.storeDisease(Parser.readDisease());
		} catch (Exception e) {
			GUI.displayException(e);
		}
		try {
			readLanguage("english");
		} catch (Exception e) {
			GUI.displayException(e);
		}
		gui = new GUI();
		gui.refreshData();
		gui.setVisible(true);
		
	}
	
	/**
	 * Tells the parser to write out the disease information.
	 * @param data is the results to write out.
	 * @param path is the path to the file.
	 * @return if the data was successfully written.
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws BiffException 
	 */
	public static boolean writeOut(String path, Patient patient){
		try{
			return parser.writeOut(handler.getResults(), path, patient);
		}catch(Exception e)
		{
			GUI.displayException(e);
			return false;
		}
	}
	
	/**
	 * Tells the parser to read in the info from the file.
	 * Hands the data to the handler.
	 * @param path is the file path of the gene file.
	 * @return a map representing the gene information.
	 */
	public static boolean readGene(String path)
	{
		try {
			boolean res = handler.storeData(Parser.readGene(path));
			gui.refreshData();
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GUI.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Tells the parser to read in the info from the file.
	 * Hands the data to the handler.
	 * @param path is the file path of the gene file.
	 * @return a map representing the gene information.
	 */
	public static boolean readGene()
	{
		try {
			boolean res =  handler.storeData(Parser.readGene());
			gui.refreshData();
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GUI.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Gets the gene data from the handler.
	 * @return the data.
	 */
	public static Map<String, Gene> getData()
	{
		return handler.getData();
	}
	
	/**
	 * Selects a gene from the data list in handler.
	 * @param gene is the gene selected.
	 * @return true if the gene was successfully set.
	 */
	public static boolean selectGene(String gene)
	{
		boolean res = handler.selectGene(gene);
		gui.refreshData();
		return res;
	}
	
	/**
	 * Deselects a gene from the data list in handler.
	 * @param gene is the gene to deselect.
	 * @return true if gene was successfully deselected.
	 */
	public static boolean deselectGene(String gene)
	{
		boolean res = handler.deselectGene(gene);
		gui.refreshData();
		return res;
	}
	
	/**
	 * Deselects all of the genes from the data list in handler.
	 */
	public static void deselectAll()
	{
		handler.deselectAll();
		gui.refreshData();
	}
	
	/**
	 * Sets the gene in the handler.
	 * @param gene is the gene info to set.
	 * @return true if successfully set.
	 */
	public static boolean setGene(Gene gene)
	{
		boolean res = handler.setGene(gene);
		gui.refreshData();
		return res;
	}
	
	/**
	 * Retrieves the list of selected genes in the handler.
	 * @return a map representing the selected genes.
	 */
	public static Map<String, Gene> getSelected()
	{
		return handler.getSelected();
	}
	
	/**
	 * Gets the results from the handler.
	 * @return a map representing the results.
	 */
	public static Map<Disease, ArrayList<ArrayList<Gene>>> results()
	{
		return handler.getResults();
		
	}
	
	/**
	 * Imports the disease list from the parser.
	 * @return a map representing the disease list.
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws BiffException 
	 */
	public static boolean readDisease()
	{
		try{
			return handler.storeDisease(Parser.readDisease());
		}catch(Exception e)
		{
			GUI.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Gets the phrase for the selected language.
	 * @param label is the search number.
	 * @return the phrase assigned to the number.
	 */
	public static String findString(String label)
	{
		return language.findString(label);
	}
	
	/**
	 * imports a language file into the system.
	 * @param lang is the file to select
	 * @return true if properly assigned.
	 */
	public static boolean readLanguage(String lang)
	{
		try{
			return language.setLanguage(Parser.readLanguage(lang));	
		}catch(Exception e){
			GUI.displayException(e);
			//e.printStackTrace();
			return false;
		}
	}
    
    /**
     * removes a gene from the system
     * @param gene is the gene to remove
     * @return true if removed.
     */
    public static boolean removeGene(String gene)
    {
    	boolean res = handler.removeGene(gene);
    	gui.refreshData();
    	return res;
    }
    
    /**
     * retrieves a gene from the system
     * @param gene is the gene name to retrieve
     * @return the gene requested.
     */
    public static Gene getGene(String gene)
    {
    	return handler.getGene(gene);
    }
    
    public static boolean saveGene(String path)
    {
    	try{
    		return parser.saveGenes(handler.getData(), path);
    	}catch(Exception e){
    		GUI.displayException(e);
    		return false;
    	}
    }
}
