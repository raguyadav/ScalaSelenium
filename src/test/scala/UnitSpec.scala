import org.scalatest._
import org.scalatest.selenium.WebBrowser

/**
 * Created by ssunger on 15-01-21.
 */


abstract class UnitSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors with WebBrowser with BeforeAndAfter

abstract class HeavySpec extends FlatSpec with GivenWhenThen with Matchers with WebBrowser with BeforeAndAfterAll
