package org.open.query.knownphrases;

import java.util.Collection;

import org.open.util.QueryUtil;
import org.open.util.WordCustomizeUtil;
import org.open.query.ChiefCoordinator;;

public class RelatedQueryGenertor {
public Collection<String> getRelations(String input){
	UniqueQueryCoordinator uqc = new UniqueQueryCoordinator();
	input = WordCustomizeUtil.addUnderscore(input);
	String query = ChiefCoordinator.PREFIX +
			" SELECT DISTINCT ?output "+
			"WHERE { "+
			uqc.getStemming(input) +
			uqc.QUERY +
			uqc.FILTER +
			" }";
	Collection<String> output = QueryUtil.jenaQuery(query, "output", "http://dbpedia.org");
	return output;
}
}
