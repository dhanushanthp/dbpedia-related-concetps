package org.open.query;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.lang.time.StopWatch;
import org.open.query.knownphrases.RelatedQueryGenertor;

public class KnownPhraseRelationsTest {
	
	public static void main(String[] args) throws IOException {
		RelatedQueryGenertor kpr = new RelatedQueryGenertor();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		String per = "osama";
		String con = "india";
		String jo  = "engineer";
		String cit = "bangalore";
		
		Collection<String> person = kpr.getRelations(per);
		Collection<String> country = kpr.getRelations(con);
		Collection<String> job = kpr.getRelations(jo);
		Collection<String> city = kpr.getRelations(cit);
		stopWatch.stop();
		
		System.out.println("\nCheck Person : "+ per +"\n"+ "Total result : "+ person.size() +"\n"+ "Relation : "+ person);
		System.out.println("\nCheck Country : "+ con +"\n"+ "Total result : "+ country.size() +"\n"+ "Relation : "+ country);
		System.out.println("\nCheck Job : "+jo+"\n"+ "Total result : "+ job.size() +"\n"+ "Relation : "+ job);
		System.out.println("\nCheck City : "+cit+"\n"+ "Total result : "+ city.size() +"\n"+ "Relation : "+ city);
		
		System.out.println("\nDuration : " + stopWatch.getTime());
	}

}
