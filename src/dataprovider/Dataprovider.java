package dataprovider;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name = "DataValues")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] { { "1", "Amit", "Gzb", "23445 " }, { "2", "Ajay", "US", "7777" },
				{ "3", "Aman", "Delhi", "54123" }, { "4", "Rahul", "Noida", "2541" } };
	}
}
