package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


//'C:\Users\YOUR_USER_NAME\AppData\Local\Google\Chrome\User Data\Default\Extensions'    win
// /Users/YOUR_USER_NAME/Library/Application\ Support/Google/Chrome/Default/Extensions    mac
//gighmmpiobklfepjocnamgkkbiglidom
public class ApplicationManager {

    WebDriver wd;
    HelperAlert alert;
    HelperSelect select;


    public void init() {
        //wd = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=/Users/tayahatum/Tools/4.46.1_0");
        wd = new ChromeDriver(options);

        wd.navigate().to("https://demoqa.com/");

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        alert = new HelperAlert(wd);
        select = new HelperSelect(wd);
        returnAfterInstalledAdBlock();

    }

    public void stop() {
        wd.quit();
    }

    public HelperAlert alert() {
        return alert;
    }

    public HelperSelect select() {
        return select;
    }

    private void returnAfterInstalledAdBlock() {

        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));


    }

}
