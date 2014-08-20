package org.open.query;

import java.util.Collection;
import org.open.util.QueryUtil;

public class KnownPhraseRelations {
public Collection<String> getRelations(String input){
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
