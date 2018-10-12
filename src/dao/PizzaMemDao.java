package dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PizzaMemDao Class
 * @author formation
 * @see main.Main
 */
public class PizzaMemDao implements Comparator<Pizza>, IPizzaDao  {

	//Attributes
	private List<Pizza> listPizza ;
	
	/**
	 * PizzaMemDao Constructor
	 * @param listPizza
	 */
	public PizzaMemDao() {		
		Pizza p1 = new Pizza("MAR", "Marguarita", 5.5F);
		Pizza p2 = new Pizza("NAP", "Napolitaine", 10.5F);
		Pizza p3 = new Pizza("QUA", "Quatre fromages", 15.5F);
		
		this.listPizza = new ArrayList<Pizza>();
		this.listPizza.add(p3);
		this.listPizza.add(p1);
		this.listPizza.add(p2);
	}

	/* PizzaMemDao Getter
	 * @see dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		return listPizza;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		for(int i=0; i<listPizza.size();i++)
		{
			if(listPizza.get(i).getCode().equalsIgnoreCase(codePizza))
			{
				listPizza.set(i,pizza);
			}
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
		Pizza toMatch = null;
		
		for(int i=0; i<listPizza.size();i++)
		{
			if(listPizza.get(i).getCode().equalsIgnoreCase(codePizza))
			{
				toMatch = listPizza.get(i);
			}
		}
		
		return toMatch;
	}

	@Override
	public boolean isPizzaExists(String codePizza) {
		
		//Use ternary expression
		return findPizzaByCode(codePizza)==null?true:false;
	}
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		if(isPizzaExists(pizza.getCode()))
		{
			updatePizza(pizza.getCode(),pizza);
		}
		else
		{
			listPizza.add(pizza);
		}
			
	}

	@Override
	public void deletePizza(String codePizza) {
		if(isPizzaExists(codePizza))
		{
			Pizza toRemove = findPizzaByCode(codePizza);
			listPizza.remove(toRemove);
		}
	}

	@Override
	public int compare(Pizza p1, Pizza p2) {
		
		int ret = 0;
		
		if (p1.getPrix()<p2.getPrix())
		{
			ret = -1;
		}
		else
		{
			ret = 1;
		}
		
		return ret;
		
	}
	
	@Override
	public String toString() {
		//Used with old array, no need by ArrayList
		/**
		String pizzaString = "";
		
		for(int i=0; i<tabPizza.size();i++)
		{
			pizzaString += (tabPizza.get(i).toString()+"\n") ;
		}
		
		return pizzaString;
		**/
		return listPizza.toString();
	}
}
