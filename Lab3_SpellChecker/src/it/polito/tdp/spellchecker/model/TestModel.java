package it.polito.tdp.spellchecker.model;

import java.io.IOException;
import java.util.*;

public class TestModel {

	public static void main(String[] args) throws IOException {
	
		
		Dyctionary d= new Dyctionary();
		
		d.loadDictionary("italian");
		
		System.out.println(""+d.getSet());
		
		System.out.println("+++++++++CONTROLLO PAROLE +++++");
		
		List<String> parole= new LinkedList<String>();
		parole.add("abaco");
		parole.add("abgfjf");		
		
		System.out.println(d.spellCheckText(parole));

	}

}
