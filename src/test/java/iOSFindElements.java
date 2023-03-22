import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class iOSFindElements {

    public static void main(String[] args) throws Exception {
        String email= "jose.virgen+02@grandpad.net";
        String pass= "Test12345!";

        AppiumDriver driver= CreateDriverSession.initializeDriver("iOS");
        WebElement emailInput= driver.findElement(AppiumBy.iOSNsPredicateString("value == \"Email\""));
        emailInput.sendKeys(email);

        WebElement loginContinue= driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Continue\" AND name == \"Continue\" AND value == \"Continue\""));
        loginContinue.click();

        WebElement typeMyPass= driver.findElement(AppiumBy.iOSNsPredicateString("label == \"I'd rather type my password\" AND name == \"I'd rather type my password\" AND value == \"I'd rather type my password\""));
        typeMyPass.click();

        WebElement passInput= driver.findElement(AppiumBy.iOSNsPredicateString("value == \"Password\""));
        passInput.sendKeys(pass);

        WebElement loginSubmit= driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Continue\" AND name == \"Continue\" AND value == \"Continue\""));
        loginSubmit.click();

    }


}

