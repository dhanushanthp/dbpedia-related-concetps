package org.open.query;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Properties;

import org.open.util.WordCustomizeUtil;

public class KnownPhraseRelationsTest {

	public static void main(String[] args) throws IOException {
		KnownPhraseRelations kpr = new KnownPhraseRelations();
		long start = System.currentTimeMillis();
		System.out.println(kpr.getRelations("Obama").size());
		System.out.println(kpr.getRelations("London").size());
		System.out.println(kpr.getRelations("Engineer"));
		long end = System.currentTimeMillis();
		System.out.println("Duration : " + (end- start));
		Properties p = new Properties();
		InputStream file = new FileInputStream("relation.properties");
		p.load(file);
		System.out.println(Arrays.toString(WordCustomizeUtil.getRelations(p.getProperty("dbpedia-owl"))));
	}

}
