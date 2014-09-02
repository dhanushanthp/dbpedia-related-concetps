package org.open.util;

import java.util.Collection;
import java.util.HashSet;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class QueryUtil {
	
	public static Collection<String> jenaQuery(String query,String resultString,String URL) {
		Collection<String> result = new HashSet<String>();
		String service = URL + "/sparql";
		QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);
				
		try {
			ResultSet results = qe.execSelect();
			for (; results.hasNext();) {
				QuerySolution sol = results.next();
				result.add(sol.get("?"+ resultString).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			qe.close();
		}
		return result;
	}
}
