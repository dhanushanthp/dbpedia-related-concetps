package org.open.query;

public interface ChiefCoordinator {
	String FILTER_KNOWN = " FILTER(!REGEX(?output, \"[\\\\d]\",\"i\" )) ."+
			" FILTER(!REGEX(?output, \"-\",\"i\" )) ."+
			" FILTER(!REGEX(?output, \"\\\\(\",\"i\" )) ."+
			" FILTER(!REGEX(?output, \"\\\\)\",\"i\" )) ." +
			" FILTER(!REGEX(?output, \"List\",\"i\" )) .";
	
	String PREFIX = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> "+
			"PREFIX dbpedia: <http://dbpedia.org/resource/> "+
			"PREFIX cata: <http://dbpedia.org/resource/Category:> "+
			"PREFIX dbpprop: <http://dbpedia.org/property/> "+
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/> "+
			"PREFIX dcterms: <http://purl.org/dc/terms/> "+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#> ";
	
	public String getStemming(String phrase);
	
	
}
