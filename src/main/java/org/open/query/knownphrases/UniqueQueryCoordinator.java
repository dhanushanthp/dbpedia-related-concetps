package org.open.query.knownphrases;

import org.open.query.ChiefCoordinator;
import org.open.util.WordCustomizeUtil;

public class UniqueQueryCoordinator implements ChiefCoordinator{
	public static UniqueQueryGenerator rg = new UniqueQueryGenerator();
	
	@Override
	public String getStemming(String phrase){
		phrase = WordCustomizeUtil.addUnderscore(phrase);
		String STEMMING = " {{dbpedia:"+ phrase +" dbpedia-owl:wikiPageRedirects ?subject . }"+
				" UNION "+
				" { "+
				" {?redirects dbpedia-owl:wikiPageRedirects dbpedia:"+ phrase +" . }"+
				" {?redirects dbpedia-owl:wikiPageRedirects ?subject . }"+
				" }}";
		return STEMMING;
	}
	
	public final String QUERY = " {"+
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


	public final String FILTER = " BIND(REPLACE(str(?result), \"http://dbpedia.org/resource/\", \"\") AS ?tmp) ."+
			" BIND(REPLACE(str(?tmp), \"Category:\", \"\") AS ?output) ."+
			ChiefCoordinator.FILTER_KNOWN;
}
