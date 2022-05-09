package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperAlert extends HelperBase{

    public HelperAlert(WebDriver wd) {
        super(wd);
    }

    public void selectItemAlert() {

        scroll(0, 300);
        //click(By.id("close-fixedban"));
        click(By.xpath("//h5[.='Alerts, Frame & Windows']"));
    }

    public void selectAlerts() {
        click(By.xpath("//span[text()='Alerts']"));

    }
}
