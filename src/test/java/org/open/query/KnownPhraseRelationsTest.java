package org.open.query;

import java.io.IOException;
import java.util.Collection;

public class KnownPhraseRelationsTest {

	public static void main(String[] args) throws IOException {
		KnownPhraseRelations kpr = new KnownPhraseRelations();
		long start = System.currentTimeMillis();
		Collection<String> person = kpr.getRelations("obama");
		Collection<String> country = kpr.getRelations("london");
		Collection<String> job = kpr.getRelations("engineer");
		Collection<String> city = kpr.getRelations("bangalore");
		long end = System.currentTimeMillis();
		
		System.out.println("\nCheck Person : \n"+ "Total result : "+ person.size() +"\n"+ "Relation : "+ person);
		System.out.println("\nCheck Country : \n"+ "Total result : "+ country.size() +"\n"+ "Relation : "+ country);
		System.out.println("\nCheck Job : \n"+ "Total result : "+ job.size() +"\n"+ "Relation : "+ job);
		System.out.println("\nCheck City : \n"+ "Total result : "+ city.size() +"\n"+ "Relation : "+ city);
		
		System.out.println("\nDuration : " + (end- start));
	}

}
