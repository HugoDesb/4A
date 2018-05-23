package TP7;

public class Main {

	/*****************************************************************/
	/**                 EXERCICE 2 - ADAPTER                        **/
	/*****************************************************************/
	
	public static void main(String[] args) {
		/*****************************************************************/
		/**                 EXERCICE 2 - ADAPTER                        **/
		/*****************************************************************/
		System.out.println("//////////////////////////////////////////////");
		System.out.println("         Exercice 2                           ");
		System.out.println("//////////////////////////////////////////////");
		
		StackArray<String> mine = new StackArray<>();
		mine.push("this");
		mine.push("is");
		mine.push("mine");
		
		System.out.println(mine.peek());
		System.out.println(mine.pop());
		System.out.println(mine.pop());
		System.out.println(mine.pop());
		
		
		

		/*****************************************************************/
		/**                 EXERCICE 3 - SINGLETON                      **/
		/*****************************************************************/
		System.out.println();
		System.out.println("//////////////////////////////////////////////");
		System.out.println("         Exercice 3                           ");
		System.out.println("//////////////////////////////////////////////");
		
		Singleton a = Singleton.getInstance(); 
		System.out.println(a.toString());
		a.add(50);
		Singleton.getInstance().add(20);
		System.out.println(a.toString());
		
		
		/*****************************************************************/
		/**                 EXERCICE 4 - OBSERVATOR                     **/
		/*****************************************************************/
		System.out.println();
		System.out.println("//////////////////////////////////////////////");
		System.out.println("         Exercice 4                           ");
		System.out.println("//////////////////////////////////////////////");
		
		PointCritique loul = new PointCritique();
		loul.setX(0);
		loul.setY(4);
		
		
	}
}
