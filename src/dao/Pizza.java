package dao;

/**
 * Pizza Class
 * @see IPizzaDao, PizzaMemDao
 * @author nschauss
 */
public class Pizza implements Comparable<Pizza>{

	//Pizza Attributes
	private String code;
	private String designation;
	private float prix;
	
	/**
	 * Pizza Constructor
	 * @param code
	 * @param designation
	 * @param prix
	 */
	public Pizza(String code, String designation, float prix) {
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}
	
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}


	/**
	 * @return the price
	 */
	public float getPrix() {
		return prix;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}


	/**
	 * @param prix the price to set
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public int compareTo(Pizza p) {
		int ret = 0;
		
		if (this.getDesignation().compareToIgnoreCase(p.getDesignation()) < 0)
		{
			ret = -1;
		}
		else
		{
			ret = 1;
		}
		
		return ret;
	}

	/**
	 * @return the Pizza description
	 */
	@Override
	public String toString()
	{
		return "##### Pizza.toString() #####\n"+
				"\tcode : "+code+"\n"+
				"\tdesignation : "+designation+"\n"+
				"\tprix : "+prix+"€";
	}
}
