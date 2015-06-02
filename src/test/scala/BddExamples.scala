import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver


/**
 * Created by ssunger on 15-01-25.
 */
class BddExamples extends HeavySpec {



  "A HashMap" should "allow an item to be added " in {

    Given ("An empty hashmap of type Int -> String")
    var map = Map[Int, String]()

    When ("an item is added")
    map += (1 -> "Joe")

    Then ("the map should have size 1")
    map should have size (1)

    And ("the map must contain the item added")
    map should (contain key(1) and contain value("Joe"))

    info ("Adding items seems to be working")

  }

}

class WebsiteSpec extends HeavySpec {

  implicit val webDriver: WebDriver = new FirefoxDriver()
 // implicit val webDriver: WebDriver = new HtmlUnitDriver



  override  def afterAll: Unit = {
    close
  }



  "My Website" should "search for a given term" in {
    go to ("http://www.hascode.com/")
    pageTitle should be("hasCode.com")
    click on id("s")
    textField("s").value = "lucene"
    submit()
 //   pageTitle should  include regex ("hascode.com.+Search Results.+lucene")
    pageSource should include ("Lucene Snippets: Index Stats")
    pageSource should include ("Lucene Snippets: Faceting Search")
    pageSource should include ("Hibernate Search Faceting: Discrete and Range Faceting by Example")
  }

  "Google Website Tests" should "lets see do some things" in {

    goTo("http://wcm2ui.preprod01.streamtheworld.net:8810/login")
    pageTitle should be ("WCM2 Login")
    clickOn("j_username")
    textField("j_username").value = "npruser"
    clickOn("j_password")
    pwdField("j_password").value = "npr_user"
    submit()


    goTo("https://www.google.qc/")
    pageTitle should be("Google")
    clickOn("q")
    textField("q").value = "lucene"
    submit()

   // pageTitle should include regex  ("lucene Google Search")

  }


 /* "Log into Wcm2 as NPR" should "allow access" in {

    goTo("http://wcm2ui.preprod01.streamtheworld.net:8810/login")
   // implicitlyWait(Span(10, Seconds))
  //  pageTitle should be ("WCM2 Login")
    clickOn("j_username")
    textField("j_username").value = "npruser"
    clickOn("j_password")
 //   textField("j_password").value = "npr_user"
    textArea("j_password").value = "npr_user"

    submit()


  } */

}
