  import org.scalatest.{FeatureSpec, GivenWhenThen}

  /**
   * Created by ssunger on 15-01-20.
   */


    class MatchersStuff extends UnitSpec {

    "Equality Matchers" should  "comparings strings,ints lists" in {
      4 should equal(4)
      "foo" should equal("foo")
      List(1, 2, 3) should equal(List(1, 2, 3))
    }

    it should "be able to compare sizes and lengths etc" in {
      List(1, 2, 3) should have length 3
      Array(4, 5, 6) should have length 3

      List(1,2,3) should have size 3
      Array(9,5,6) should have size 3

    }
    it should "be able to handle Should Be scenarios" in {
      7 should be < (8)
      var foo = List(1, 2, 3)
      var boo = foo
      foo should be theSameInstanceAs (boo)
    }

    it should "contain used for Collections" in {

      List(1,2,3,4) should contain (3)
      Array("hello","how","harry","Sally") should contain ("harry")
      val users = Map(1 -> "harry",2 -> "sally",3 -> "John")
      users should contain value("sally")
      users should contain key(2)
      users should (contain value("sally") and contain key(2))
    }

    it should "checking a class with matchers" in {
      case class Recipe(name: String, ingredients: List[String], bakingminutes: Int)

      val cakeRecipe = Recipe("Cake", List("eggs","flour","sugar"), 12)

      cakeRecipe should  have (
        'name("Cake"),
        'ingredients(List("eggs","flour","sugar")),
        'bakingminutes(12)
      )
    }

    it should "Negation : how to use the must not be" in {
      7 should not be >(8)
      List(1,2,3) should not be ('empty)
    }
  }



    class StringCalculatorSpec extends UnitSpec {

    "A calculator" should "return a 0 when one/two/three.. empty strings is provided" in {

    calc("") should be (0)
    calc("","") should be (0)
    calc("","","") should be (0)
  }

    it should "return a sum of 1 + 10 + 100 as 111" in {
      calc("1","10","100") should be (111)
    }

    def calc(in: String*): Int = {
      var ret = 0
      in.filter(_ != "").foreach(ret += _.toInt)
      ret
    }

  }
    class ExampleSpec extends UnitSpec {

    "An array" should "give the right value" in {
      //   val stack = new Stack[Int]
      //   stack.push(1)
      //   stack.push(2)

      val array = Array(1, 2, 3, 4)

      array(0) should be(1)
      array(1) should be(2)

     // assertResult(array(2) == 4, "Wrong value of array" )
      assertResult(3) {
        array(2) // place code that will go in here
      }

    }

    it should "throw ArrayIndexOutOfBoundsException if an empty Array is used" in {
      val array = Array()

      a[ArrayIndexOutOfBoundsException] should be thrownBy {
        array(0)
      }
    }

    it should "lets see how a it catches an exception that we want to happen " in {
      val array = Array(1, 2, 3, 4)

      try {
        array(-1) // if this throws proper exception then
        fail()
      }

      catch {
        case _: ArrayIndexOutOfBoundsException => //expected , so continue.
      }
    }

      it should " lets see how intercept works to catch exception" in {
        val array = Array(1,2,3,4)

        intercept[ArrayIndexOutOfBoundsException] {
          array(-1)
        }

      }

  }

    class TVSet {
      private var on = false

      def isOn = on

      def pressPowerButton(): Unit = {
        on = !on
      }

    }

    class TVSetSpec extends FeatureSpec with GivenWhenThen {

        info("As a TV set owner")
        info("I want to be able to turn TV on and off")
        info("So i can watch tv when I want")
        info("And save energy when I am not watching TV")

        feature("TV Power Button") {
          scenario("User presses power button when Tv is off") {

            Given("a TV set that is switched off")
            val tv = new TVSet
            assert(!tv.isOn)

            When("the power button is pressed")
            tv.pressPowerButton()

            Then("the TV should switch on")
            assert(tv.isOn)
          }

          scenario("User presses power button when Tv is on") {

            Given("A TV set that is already turned on")
            val tv = new TVSet
            tv.pressPowerButton()
            assert(tv.isOn)

            When("the power button is pressed")
            tv.pressPowerButton()

            Then("the TV should switch off")
            assert(!tv.isOn)

          }

        }

      }



