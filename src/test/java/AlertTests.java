import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @Test
    public void alertTest(){
       app.alert().selectItemAlert();
       app.alert().selectAlerts();
    }
}
