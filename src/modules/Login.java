package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import config.DatabaseConfig;
import dataprovider.Dataprovider;
import pom.CreateDbPOM;
import pom.CreateTablePOM;
import pom.LoginPOM;

public class Login {
	LoginPOM loginPOM;
	CreateDbPOM createDbPOM;
	CreateTablePOM createTablePOM;

	DatabaseConfig config;
	Connection conn;

	int i = 1;

	@BeforeClass
	public void startUp() {
		loginPOM = new LoginPOM();
		LoginPOM.extentTest = LoginPOM.extent.startTest("Testing Phpmyadmin!",
				"Creating database & Table using selenium");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Application Launched");
	}

	@AfterClass
	public void tearDown() {
		// loginPOM.closeApp();
		// LoginPOM.extentTest.log(LogStatus.INFO, "----->Application Closed");
	}

	@Test(priority = 0)
	public void loginApp() {
		LoginPOM.extentTest = LoginPOM.extent.startTest("Login to the application!", "Entering username & password");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered username");
		loginPOM.setUsername("root");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered password");
		loginPOM.setPassword("");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Click login button");
		loginPOM.clickGoButton();
		LoginPOM.extent.endTest(LoginPOM.extentTest);
		LoginPOM.extent.flush();
	}

	@Test(priority = 1)
	public void createDatabase() {
		createDbPOM = new CreateDbPOM();
		LoginPOM.extentTest = LoginPOM.extent.startTest("Creating Database!", "");
		createDbPOM.clickToCreateDatabase();
		LoginPOM.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered Database Name");
		createDbPOM.enterDbName("SeleniumTesting");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Clicked create button");
		createDbPOM.clickCreateButton();
		LoginPOM.extent.endTest(LoginPOM.extentTest);
		LoginPOM.extent.flush();
	}

	@Test(priority = 2)
	public void createTable() {
		createTablePOM = new CreateTablePOM();
		LoginPOM.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPOM.extentTest = LoginPOM.extent.startTest("Creating Table!", "");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered TableName");
		createTablePOM.enterTableName("TestingTable");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Seleting all text of the column number textbox");
		createTablePOM.selectAll();
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered column number");
		createTablePOM.entetColumnNumber(4);
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Clicked create button");
		createTablePOM.clickCreateButton();

		// 1st row
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered first column name");
		createTablePOM.enterFirstColumnName("id");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered first column type");
		createTablePOM.enterFirstColumnType("INT");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered first column length as 2");
		createTablePOM.enterFirstColumnLength(2);

		// 2nd row
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered second column name");
		createTablePOM.enterSecondColumnName("Name");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered second column type");
		createTablePOM.enterSecondColumnType("VARCHAR");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered second column length as 25");
		createTablePOM.enterSecondColumnLength(25);

		// 3rd row
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered third column name");
		createTablePOM.enterThirdColumnName("Address");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered third column type");
		createTablePOM.enterThirdColumnType("VARCHAR");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered third column length as 50");
		createTablePOM.enterThirdColumnLength(50);

		// 4th row
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered fourth column name");
		createTablePOM.enterFourthColumnName("PhoneNumber");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered fourth column type");
		createTablePOM.enterFourthColumnType("INT");
		LoginPOM.extentTest.log(LogStatus.INFO, "----->Entered fourth column length as 10");
		createTablePOM.enterFourthColumnLength(10);

		LoginPOM.extentTest.log(LogStatus.INFO, "----->Clicked on save button");
		createTablePOM.clickSaveDataButton();

		LoginPOM.extent.endTest(LoginPOM.extentTest);
		LoginPOM.extent.flush();
	}

	@Test(priority = 3, dataProvider = "DataValues", dataProviderClass = Dataprovider.class)
	public void insertData(String id, String name, String address, String phoneNumber) {
		getConnection();
		try {
			String sql = "INSERT INTO testingtable (id, Name, Address, PhoneNumber)" + "VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		while (i == 1) {
			config = new DatabaseConfig();
			conn = config.getConection("seleniumtesting");
			i = i + 1;
		}
	}
}
