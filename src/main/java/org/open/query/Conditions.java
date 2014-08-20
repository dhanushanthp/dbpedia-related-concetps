package org.open.query;

import org.open.util.WordCustomizeUtil;

public class Conditions {
	public static RelationGenerator rg = new RelationGenerator();
	public static final String PREFIX = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> "+
			"PREFIX dbpedia: <http://dbpedia.org/resource/> "+
			"PREFIX cata: <http://dbpedia.org/resource/Category:> "+
			"PREFIX dbpprop: <http://dbpedia.org/property/> "+
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/> "+
			"PREFIX dcterms: <http://purl.org/dc/terms/> "+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#> ";
	
	public static final String getStemming(String phrase){
		phrase = WordCustomizeUtil.addUnderscore(phrase);
		String STEMMING = " {{dbpedia:"+ phrase +" dbpedia-owl:wikiPageRedirects ?getSubject . }"+
				" UNION "+
				" { "+
				" {?redirects dbpedia-owl:wikiPageRedirects dbpedia:"+ phrase +" . }"+
				" {?redirects dbpedia-owl:wikiPageRedirects ?getSubject . }"+
				" }}";
		return STEMMING;
	}
	
	public static final String QUERY = " {"+
			rg.getOwl()+
			" UNION "+
			rg.getProp()+
			" UNION "+
			rg.getFoaf()+
			" UNION "+
			rg.getPropOf() +
			" UNION "+
			rg.getOwlOf() +
			" }";


	public static final String FILTER = " BIND(REPLACE(str(?result), \"http://dbpedia.org/resource/\", \"\") AS ?output1) .\n"+
			" BIND(REPLACE(str(?output1), \"Category:\", \"\") AS ?output) .\n"+
			" FILTER(!REGEX(?output, \"[\\\\d]\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"-\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"\\\\(\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"\\\\)\",\"i\" )) .\n";
}
