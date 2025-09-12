package driver;

public class Salesman {
	//property: variable belongs to the class
	public String Name;
	
	//float on financial number is a wrong idea?
	public int Revenue;
	
	//method: function belongs to the class
	//what is this function with the same name as the class name
	//constructor: create an new instance of a class: allocate the memory address of a pointer
	public Salesman() {
		//what is this.Name?->Null
		//what is this.Revenue?->Null?
	}
	
	public Salesman(String Name, int Revenue) {
		this.Name = Name;
		this.Revenue =  Revenue;
	}

}
