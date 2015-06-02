def calc(in: String*): Int = {
  var ret = 0
  in.filter(_ != "").foreach(ret += _.toInt)
  ret
}

calc("5","5")



val myList = List("hello", "how" , "are", "you")

myList.mkString(" ")

myList.filter(_ != "how" ).map(_ + "s")


// Regex determing if string contains a regular expression pattern.
"hello".r

"[0-9]+".r()

