package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Dyctionary {
	//private List<String> set= new LinkedList<String>();
	private HashSet<String> set =new HashSet<String>();
	private List<RichWord> controllate= new LinkedList<RichWord>();
	
	public HashSet<String> getSet(){
		return this.set;
	}
	
	public void loadDictionary(String language) throws IOException
	{  if(language.toLowerCase().equals("english"))
		{try {
			set.clear();
		FileReader fr = new FileReader("rsc/English.txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		while ((word = br.readLine()) != null) {
			set.add(word);	
		}
		br.close();
		} catch (IOException e){
		System.out.println("Errore nella lettura del file");
		}
		}
	
	if(language.toLowerCase().equals("italian")){
		try {
		//set.clear();
		FileReader fr = new FileReader("rsc/Italian.txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		while ((word = br.readLine()) != null) {
			set.add(word);	
			
		    
		}
		br.close();
		} catch (IOException e){
		System.out.println("Errore nella lettura del file");
		}
		}
	
	if((!language.toLowerCase().equals("english"))&&(!language.toLowerCase().equals("italian"))){
		IOException e = new IOException();
		 System.out.println("Vocabolario selezionato non esistente");
		 throw e;
				}
		
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){		
		for(String c: inputTextList){
			this.controllaParola(c);		
			
		}	
		
		return controllate;
		
	}
	
	public boolean controllaParola(String parola){
		parola.trim();
		parola.replaceAll("[ \\p{Punct}]", "");
		for(String d: set){
			d.trim();
			d.replaceAll("[ \\p{Punct}]", "");
			if(parola.equals(d)){
				RichWord temp= new RichWord(parola,true);
				controllate.add(temp);
				return true;
			}
	   }
		RichWord temp= new RichWord(parola,false);
		controllate.add(temp);
		return false;
     
	}
	
	public String getParoleSbagliate(){
		String elenco="";
		
		for(RichWord c: controllate){
			if(c.isCorretto()==false){
				elenco= elenco+c.getParola()+"\n";
			}
		}
		return elenco;
		
	}

	public int getNumParoleSbagliate() {
		int cont=0;
		for(RichWord c: controllate)
			if(c.isCorretto()==false)
				cont++;
			
		return cont;
	    
	}
	
	public boolean inizializza(){
		this.set.clear();
		this.controllate.clear();
		return true;
		
	}

	public List<String> prendiTesto(String t) {
    	List<String> elenco = new LinkedList<String>();
    	if(!t.contains(" ")){
    		elenco.add(t.trim().replaceAll("[ \\p{Punct}]", ""));
    		return elenco;
    	}  
    	else{
    		return elenco=this.molteParole(t);
    	}
    	
    	
		
	}

	private List<String> molteParole(String t) {
		List<String> elenco = new LinkedList<String>();
		String parola="";
		for(int i=0;i<t.length();i++){
			if(t.charAt(i)==' '){
		       elenco.add(parola.trim().replaceAll("[ \\p{Punct}]", ""));
		       parola="";
			}
			else{
				if((i==t.length()-1)&&(t.charAt(i)!=' ')){
					parola=parola+t.charAt(i);
					 elenco.add(parola.trim().replaceAll("[ \\p{Punct}]", ""));
				       parola="";}
				else
				parola=parola+t.charAt(i);
			}
			
				
			
		}
		return elenco;
	}

	
	
	}
