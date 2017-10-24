package TP4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import TP2.Point;

public class ExoUnC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(17,19);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez donner le nom de l'attribut a remettre a zéro :");
		System.out.println("Attributs : ");
		Field[] fields = p.getClass().getDeclaredFields();
		System.out.println("ATTRIBUTS---------");
		for (Field field : fields) {
			System.out.println("\t- "+field.toString());
		}
		String att = sc.nextLine();
		String method = "set"+att.toUpperCase();
		
		
		try {
			p.getClass().getMethod(method, int.class).invoke(p,0);
			System.out.println(p.toString());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
