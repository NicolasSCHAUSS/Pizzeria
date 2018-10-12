package main;

import java.util.Collections;

import dao.Pizza;
import dao.PizzaMemDao;

/**
 * Main Class to use data access object with Pizza
 * @see PizzaMemDao
 * @author nschauss
 */
public class Main {

	public static void main(String[] args) {
		//Use data access object from Class PizzaMemDao 
		PizzaMemDao menuPizza = new PizzaMemDao();
		System.out.println(menuPizza);
		
		//Find pizza : return null, or call toString() if finded
		System.out.println("##### Find pizza : return null, or call toString() if finded #####");
		System.out.println(menuPizza.findPizzaByCode("NAC"));
		System.out.println();
		
		System.out.println("##### findPizzaByCode(\"NAP\") #####");
		System.out.println(menuPizza.findPizzaByCode("NAP"));
		System.out.println();
		
		//Update pizza "NAP" to "MOZ"
		System.out.println("##### Update pizza \"NAP\" to \"MOZ\" #####");
		Pizza mozza = new Pizza("MOZ", "Mozzarella", 20.5F);
		menuPizza.updatePizza("NAP", mozza);
		System.out.println(menuPizza);
		
		//Sort by Pizza price
		System.out.println("##### Sort by Pizza price #####");
		Collections.sort(menuPizza.findAllPizzas(), menuPizza);
		System.out.println(menuPizza);
		
		//Sort by Pizza description
		System.out.println("##### Sort by Pizza description #####");
		Collections.sort(menuPizza.findAllPizzas());
		System.out.println(menuPizza);
		
		

	}

}
