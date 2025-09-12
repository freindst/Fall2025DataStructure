package driver;

public class Main {

	public static void main(String[] args) {
		Salesman a = new Salesman("Alice", 100);
		Salesman b = new Salesman("Bob", 200);
		Salesman c = new Salesman("Cath", 150);
		Salesman d = new Salesman("David", 175);
		Salesman e = new Salesman("Evan", 300);
		Salesman f = new Salesman("Frank", 225);
		Salesman g = new Salesman("George", 120);
		
		Salesman[] allSales = new Salesman[] {
				a, b, c, d, e, f, g
		};
		
		Salesman[] five = TopFiveSales(allSales);
		for(int i = 0; i < 5; i++) {
			System.out.print("Salesman Name: " + five[i].Name + ", ");
			System.out.println(five[i].Revenue);
		}

	}
	
	//procedure programming
	public static Salesman[] TopFiveSales(Salesman[] sales) {
		Salesman[] topFive = new Salesman[5];
		//loop through the sales
		//keep the top five in topFive in descending order
		for(int i = 0; i < sales.length; i++) {
			Salesman cur = sales[i];
			//compare the items in topFive with cur
			Salesman temp;
			for(int j = 0; j < topFive.length; j++) {
				if (topFive[j] == null) {
					topFive[j] = cur;
					break;
				} else if (cur.Revenue > topFive[j].Revenue) {
					temp = topFive[j];
					topFive[j] = cur;
					cur = temp;
				}
			}
		}
		return topFive;
	}

}
