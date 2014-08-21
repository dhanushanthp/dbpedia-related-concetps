package org.open.query.knownphrases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.open.query.ChiefCoordinator;
import org.open.util.WordCustomizeUtil;

public class UniqueQueryGenerator {
	Properties data = new Properties();
	final String SUBJECT = "subject";
	final String OBJECT = "result";
	
	public UniqueQueryGenerator(){
		try {
			InputStream file = new FileInputStream("relation.properties");
			data.load(file);
		} catch (IOException e) {
			System.out.println("Your relation.properties file is missing.");
			e.printStackTrace();
		}
	}
	public StringBuffer getOwl() throws ArrayIndexOutOfBoundsException {
		String [] relations = WordCustomizeUtil.getRelations(data.getProperty("dbpedia-owl"));
		StringBuffer output = buildQuery(SUBJECT,ChiefCoordinator.DBPEDIA_OWL,relations,OBJECT);
		return output;
	}
	
	public StringBuffer getProp() throws ArrayIndexOutOfBoundsException {
		String [] relations = WordCustomizeUtil.getRelations(data.getProperty("dbpprop"));
		StringBuffer output = buildQuery(SUBJECT,ChiefCoordinator.DBBPROP,relations,OBJECT);
		return output;
	}
	
	public StringBuffer getOwlOf() throws ArrayIndexOutOfBoundsException {
		String [] relations = WordCustomizeUtil.getRelations(data.getProperty("dbpeida-owl-of"));
		StringBuffer output = buildQuery(OBJECT,ChiefCoordinator.DBPEDIA_OWL,relations,SUBJECT);
		return output;
	}
	
	public StringBuffer getPropOf() throws ArrayIndexOutOfBoundsException {
		String [] relations = WordCustomizeUtil.getRelations(data.getProperty("dbpprop-of"));
		StringBuffer output = buildQuery(OBJECT,ChiefCoordinator.DBBPROP,relations,SUBJECT);
		return output;
	}
																																																																			
	public StringBuffer getFoaf() throws ArrayIndexOutOfBoundsException {
		String [] relations = WordCustomizeUtil.getRelations(data.getProperty("foaf"));
		StringBuffer output = buildQuery(SUBJECT,ChiefCoordinator.FOAF,relations,OBJECT);
		return output;
	}
	
	/**
	 * Get the subject from predicate where we are search using object. So the sample 
	 * Query will be like.
	 * {?subject predicate: relation ?object}
	 * @param subject
	 * @param predicate
	 * @param relations
	 * @param object
	 * @return
	 */
	//TODO Here the arrayout of bound exception need to be fixed
	private StringBuffer buildQuery(String subject , String predicate,String[] relations,String object) {
		StringBuffer output = new StringBuffer();
		if (relations.length > 1) {
			for (int i = 0; i < relations.length - 1; i++) {
				output.append(" { ?" + subject+ " " + predicate +":" + relations[i]	+ " ?" + object +" } UNION");
			}
		}
		output.append(" { ?" + subject+ " " + predicate +":" + relations[relations.length - 1] + " ?" + object +" }");
		return output;
	}
}
