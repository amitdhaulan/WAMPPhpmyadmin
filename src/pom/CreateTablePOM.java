package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class CreateTablePOM {
	public void enterTableName(String tableName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@name='table']"));
		LoginPOM.element.sendKeys(tableName);
	}

	public void clickCreateButton() {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@value='Go']"));
		LoginPOM.element.click();
	}

	public void selectAll() {
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		LoginPOM.driver.findElement(By.xpath("//input[@name='num_fields']")).sendKeys(selectAll);
	}

	public void entetColumnNumber(int number) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@name='num_fields']"));
		LoginPOM.element.sendKeys(number + "");
	}

	/*
	 * -------------------------------table columns-----------------------------
	 */
	/*----------------------------------1st-----------------------------*/
	public void enterFirstColumnName(String columnName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_0_1']"));
		LoginPOM.element.sendKeys(columnName);
	}

	public void enterFirstColumnType(String columnType) {
		Select type = new Select(LoginPOM.driver.findElement(By.id("field_0_2")));
		type.selectByVisibleText(columnType);
	}

	public void enterFirstColumnLength(int length) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_0_3']"));
		LoginPOM.element.sendKeys(length + "");
	}

	/*----------------------------------2nd-----------------------------*/
	public void enterSecondColumnName(String columnName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_1_1']"));
		LoginPOM.element.sendKeys(columnName);
	}

	public void enterSecondColumnType(String columnType) {
		Select type = new Select(LoginPOM.driver.findElement(By.id("field_1_2")));
		type.selectByVisibleText(columnType);
	}

	public void enterSecondColumnLength(int length) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_1_3']"));
		LoginPOM.element.sendKeys(length + "");
	}

	/*----------------------------------3rd-----------------------------*/
	public void enterThirdColumnName(String columnName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_2_1']"));
		LoginPOM.element.sendKeys(columnName);
	}

	public void enterThirdColumnType(String columnType) {
		Select type = new Select(LoginPOM.driver.findElement(By.id("field_2_2")));
		type.selectByVisibleText(columnType);
	}

	public void enterThirdColumnLength(int length) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_2_3']"));
		LoginPOM.element.sendKeys(length + "");
	}

	/*----------------------------------4th-----------------------------*/
	public void enterFourthColumnName(String columnName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_3_1']"));
		LoginPOM.element.sendKeys(columnName);
	}

	public void enterFourthColumnType(String columnType) {
		Select type = new Select(LoginPOM.driver.findElement(By.id("field_3_2")));
		type.selectByVisibleText(columnType);
	}

	public void enterFourthColumnLength(int length) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='field_3_3']"));
		LoginPOM.element.sendKeys(length + "");
	}

	// ------------------------------------------------------------------------
	public void clickSaveDataButton() {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@name='do_save_data']"));
		LoginPOM.element.click();
	}

}
