import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

   

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        // aayush. : we need to switch to frame here. iframe[name='modal_window']
        driver.switchTo().frame("modal_window");
        
        driver.findElement(By.id("signInButton")).click();
       
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }


}
