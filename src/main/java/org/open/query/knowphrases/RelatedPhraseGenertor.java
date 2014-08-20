package org.open.query.knowphrases;

import java.util.Collection;

import org.open.util.QueryUtil;
import org.open.util.WordCustomizeUtil;

public class RelatedPhraseGenertor {
public Collection<String> getRelations(String input){
	input = WordCustomizeUtil.addUnderscore(input);
	String query = UniqueQueryCoordinator.PREFIX +
			" SELECT DISTINCT ?output "+
			"WHERE { "+
			UniqueQueryCoordinator.getStemming(input) +
			UniqueQueryCoordinator.QUERY +
			UniqueQueryCoordinator.FILTER +
			" }";
	Collection<String> output = QueryUtil.jenaQuery(query, "output", "http://dbpedia.org");
	return output;
}
}
