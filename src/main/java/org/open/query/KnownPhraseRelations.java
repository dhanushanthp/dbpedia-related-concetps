package org.open.query;

import java.util.Collection;
import org.open.util.QueryUtil;

public class KnownPhraseRelations {
public Collection<String> getRelations(String input){
	String query = Conditions.PREFIX +
			" SELECT DISTINCT ?output "+
			"WHERE { "+
			Conditions.getStemming(input) +
			Conditions.PERSONS +
			" UNION "+
			Conditions.COUNTRY +
			" UNION "+
			Conditions.CITY +
			" UNION "+
			Conditions.PLACES +
			" UNION "+
			Conditions.ORGANIZATION +
			" UNION "+
			Conditions.JOBS +
			" UNION "+
			Conditions.TECH +
			Conditions.FILTER +
			" }";
	Collection<String> output = QueryUtil.jenaQuery(query, "output", "http://dbpedia.org");
	return output;
}
}
