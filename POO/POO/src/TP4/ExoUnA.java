package TP4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

import TP2.Point;

public class ExoUnA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez donner le nom d'une classe du TP2");
		String s = sc.nextLine();
		s="TP2."+s;
		sc.close();
		
		try {
			Class<?> classe = Class.forName(s);
			Field[] f = classe.getDeclaredFields();
			System.out.println("ATTRIBUTS---------");
			for (Field field : f) {
				System.out.println("\t"+field.getName()+" : "+field.getType().getName());
			}
			
			System.out.println("METHODES----------");
			Method[] m = classe.getDeclaredMethods();
			for (Method method : m) {
				String pr = "\t"+method.getName() +"(";
				if(method.getParameterCount() > 0){
					Parameter[] para = method.getParameters();
					for(int i = 0;i<method.getParameterCount()-1;i++){
						pr+= para[i].getType().getName()+" "+para[i].getName()+", ";
					}
					pr+= para[para.length-1].getType().getName()+" "+para[para.length-1].getName();
				}
				pr+=") : "+method.getReturnType().getName();
				System.out.println(pr);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
