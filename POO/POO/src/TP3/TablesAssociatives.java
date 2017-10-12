package TP3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class TablesAssociatives {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialisation
		TreeMap<String, Integer> map = new TreeMap<>();
		
		
		//Lecture du fichier
		File f = new File("/amuhome/d16023863/Documents/4A/POO/sampletp3.txt");
		try{
			Scanner sc = new Scanner(f);
			while(sc.hasNext()){
				scanLine(map, sc.next());
			}
			sc.close();
		}catch(IOException e){
			System.out.println("Erreur");
		}
		System.out.println(map.toString());

	}
	
	public static void scanLine(TreeMap<String, Integer> map, String line){
		line.replaceAll("\\p{P}", ""); //removes punctuation
		String [] words = line.split(" ");
		for(String ss : words){
			if(map.containsKey(ss)){
				map.put(ss, map.get(ss));
			}else{
				map.put(ss, 1);
			}
		}
	}

}
