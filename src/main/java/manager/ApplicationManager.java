package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//https://www.reddit.com/r/learnpython/comments/4zzn69/how_do_i_get_adblockplus_to_work_with_selenium/
//'C:\Users\YOUR_USER_NAME\AppData\Local\Google\Chrome\User Data\Default\Extensions'
public class ApplicationManager {

    WebDriver wd;
    HelperAlert alert;
    HelperSelect select;


    public void init() {
        //wd = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("load-extension=/Users/tayahatum/Library/Application\\ Support/Google/Chrome/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom");
        options.addArguments("load-extension=/Users/tayahatum/Tools/4.46.1_0");
        wd = new ChromeDriver(options);

        wd.navigate().to("https://demoqa.com/");

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
