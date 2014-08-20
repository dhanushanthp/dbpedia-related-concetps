package org.open.util;

public class WordCustomizeUtil {
	/**
	 * This is the method use to Change the word which is acceptable by DBpedia Concept Retrieval.Form of the text is 
	 * Start with Upper Case and space replaced by _.  
	 * @param input text from Users
	 * @return result returns the String value which is supported by DBpedia
	 */
	public static String addUnderscore(String input){
		String result = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
		result = result.replaceAll(" ", "_");
		return result;
	} 
	
	public static String removeUnderscore(String input){
		String result = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
		result = result.replaceAll("_", " ");
		return result;
	} 
	
	public static String[] getRelations(String input){
		String [] listOfRelations =input.split(",");
		return listOfRelations;
	}
}