package org.open.query;

import org.pearson.util.WordCustomizeUtil;

public class Conditions {
	public static final String PREFIX = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\n"+
			"PREFIX dbpedia: <http://dbpedia.org/resource/>\n"+
			"PREFIX cata: <http://dbpedia.org/resource/Category:>\n"+
			"PREFIX dbpprop: <http://dbpedia.org/property/>\n"+
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"+
			"PREFIX dcterms: <http://purl.org/dc/terms/>\n"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"+
			"";
	
	public static final String getStemming(String phrase){
		phrase = WordCustomizeUtil.addUnderscore(phrase);
		String STEMMING = "#Remove Ambiguity\n"+
				" {{dbpedia:"+ phrase +" dbpedia-owl:wikiPageRedirects ?getSubject . }\n"+
				" UNION\n"+
				" {\n"+
				" {?redirects dbpedia-owl:wikiPageRedirects dbpedia:"+ phrase +" . }\n"+
				" {?redirects dbpedia-owl:wikiPageRedirects ?getSubject . }\n"+
				" }}\n"+
				"";
		return STEMMING;
	}
	
	
	public static final String PERSONS = "{ \n"+
			" {?getSubject dbpedia-owl:office ?result} # Office \n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:profession ?result} # Profession\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:successor ?result} # Relation\n"+
			" UNION \n"+
			" {?getSubject dbpprop:birthPlace ?result} # BirthPlace\n"+
			" UNION \n"+
			" {?getSubject dbpprop:data ?result} # Awards\n"+
			" UNION \n"+
			" {?getSubject foaf:name ?result} # Other name\n"+
			" UNION \n"+
			" {?getSubject dbpprop:residence ?result} # Living place\n"+
			" UNION \n"+
			" {?getSubject dbpedia-owl:battle ?result} # Living place\n"+
			" UNION \n"+
			" {?getSubject dbpedia-owl:deathPlace ?result} # Death Place\n"+
			" UNION \n"+
			" {?getSubject dbpedia-owl:orderInOffice ?result} # Worked Office\n"+
			" #UNION \n"+
			" # { ?result dbpedia-owl:knownFor ?getSubject} # This has been removed to ignore the non-related output for Concepts\n"+
			" UNION \n"+
			" { ?result dbpprop:author ?getSubject} # Author of \n"+
			" }";
	
	public static final String COUNTRY = " {\n"+
			" {?getSubject dbpedia-owl:largestCity ?result} # Largest City\n"+
			" UNION\n"+
			" {?result dbpedia-owl:largestCity ?getSubject} # Largest City of\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:leaderName ?result} # Name of president\n"+
			" UNION\n"+
			" {?result dbpprop:locationCountries ?getSubject} # Name of president\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:capital ?result} # Capital Of country\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:currency ?result} # Currency\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:demonym ?result} # People Called as\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:country ?result} # Country\n"+
			" }\n";
	
	public static final String CITY = " {\n"+
			" {?getSubject dbpedia-owl:timeZone ?result} # Time Zone \n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:type ?result} # Time Zone \n"+
			" }\n";
	
	public static final String PLACES = " {\n"+
		" {?getSubject dbpedia-owl:location ?result} # Location\n"+
		" UNION\n"+
		" {?getSubject dbpprop:nativeLanguage ?result} # Native Language\n"+
		" UNION\n"+
		" {?getSubject dbpprop:locmapin ?result} # Located\n"+
		" UNION\n"+
		" {?getSubject dbpprop:region ?result} # Region\n"+
		" \n"+
		" }\n";

	public static final String ORGANIZATION = " {\n"+
			" {?getSubject dbpedia-owl:foundationPlace ?result} # Org placed in\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:foundedBy ?result} # Founded by\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:industry ?result} # Induxstry\n"+
			" UNION\n"+
			" {?getSubject dbpprop:locationCountry ?result} # Located Country\n"+
			" UNION\n"+
			" {?result dbpedia-owl:author ?getSubject} # Has products\n"+
			" UNION\n"+
			" {?result dbpedia-owl:board ?getSubject} # Board\n"+
			" }\n";
	
	public static final String JOBS = " {\n"+
		" {?result dbpprop:relatedOccupation ?getSubject} # Related work of \n"+
		" UNION\n"+
		" {?getSubject dbpprop:relatedOccupation ?result} # Related work\n"+
		" UNION\n"+
		" {?getSubject dbpprop:activitySector ?result} # Activity Sector\n"+
		" UNION\n"+
		" {?result dbpprop:activitySector ?getSubject} # Activity Sector of\n"+
		" UNION\n"+
		" {?getSubject dbpprop:fieldOfStudy ?result} # Field Of Study\n"+
		" }\n";

	public static final String TECH = " {\n"+
			" {?getSubject dbpprop:genre ?result} # Related To\n"+
			" UNION\n"+
			" {?getSubject dbpprop:developer ?result} # Dev\n"+
			" UNION\n"+
			" {?getSubject dbpprop:operatingSystem ?result} # Os Base\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:influenced ?result} # Influnced\n"+
			" UNION\n"+
			" {?getSubject dbpedia-owl:influencedBy ?result} # Influnced by\n"+
			" UNION\n"+
			" {?getSubject dbpprop:extendedTo ?result} # Newer version\n"+
			" UNION\n"+
			" {?getSubject dbpprop:mime ?result} # Newer version\n"+
			" }\n";

	public static final String FILTER = " BIND(REPLACE(str(?result), \"http://dbpedia.org/resource/\", \"\") AS ?output1) .\n"+
			" BIND(REPLACE(str(?output1), \"Category:\", \"\") AS ?output) .\n"+
			" FILTER(!REGEX(?output, \"[\\\\d]\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"-\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"\\\\(\",\"i\" )) .\n"+
			" FILTER(!REGEX(?output, \"\\\\)\",\"i\" )) .\n";
}
