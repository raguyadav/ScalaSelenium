import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created by ssunger on 15-06-02.
 */
class LightSpeed extends HeavySpec {

  implicit val webDriver: WebDriver = new FirefoxDriver()

  "User" should "land on light speed main page" in {

    goTo("http://www.lightspeedpos.com/")
  }

}
