package pom;

import org.openqa.selenium.By;

public class CreateDbPOM {
	public void clickToCreateDatabase() {
		LoginPOM.element = LoginPOM.driver.findElement(By.partialLinkText("New"));
		LoginPOM.element.click();
	}

	public void enterDbName(String databaseName) {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='text_create_db']"));
		LoginPOM.element.sendKeys(databaseName);
	}

	public void clickCreateButton() {
		LoginPOM.element = LoginPOM.driver.findElement(By.xpath("//input[@id='buttonGo']"));
		LoginPOM.element.click();
	}
}
