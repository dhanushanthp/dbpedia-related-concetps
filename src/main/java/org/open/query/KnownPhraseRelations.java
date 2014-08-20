package org.open.query;

import java.util.Collection;

import org.open.util.QueryUtil;
import org.open.util.WordCustomizeUtil;

public class KnownPhraseRelations {
public Collection<String> getRelations(String input){
	input = WordCustomizeUtil.addUnderscore(input);
	String query = Conditions.PREFIX +
			" SELECT DISTINCT ?output "+
			"WHERE { "+
			Conditions.getStemming(input) +
			Conditions.QUERY +
			Conditions.FILTER +
			" }";
	Collection<String> output = QueryUtil.jenaQuery(query, "output", "http://dbpedia.org");
	return output;
}
}
