
// ex. 1

val list = List("poniedzialek", "wtorek", "sroda", "czwartek", "piatek", "sobota", "niedziela", "nieznany-dzien")

println("-- A")
for (day <- list) println(day)

println("-- B")
for (day <- list if day.startsWith("p")) println(day)

println("-- C")
list.foreach( println );

println("-- D")
var i = 0;
while (i < list.length) {
  println(list(i))
  i += 1
}

println("-- E")
def printList[T](list: List[T]) {
  def inner(list: List[T], i: Int) {
    list match {
      case head :: tail =>
        println(i + ": " + head)
        inner(tail, i + 1)
      case Nil =>
    }
  }
  inner(list, 0)
}
printList(list)

println("-- F")
def reversePrint[A](src: List[A], dest: List[A] = Nil) {
  if (src == Nil) {
    ;
  }
  else {
    reversePrint(src.tail, src.head :: dest)
    println(src.head)
  }
}
reversePrint(list);

println("-- G")
list.fold(0) { (z, i) =>
  println(i)
}

list.foldRight() { (z, i) =>
  println(z)
}

list.foldLeft() { (z, i) =>
  println(i);
}

println("-- H")
list.foldLeft() { (z, i) =>
    if(i.startsWith("p"))
      println(i)
}

// ex. 2
val products = Map("olowek" -> 2.4, "gumka" -> 1.5, "wrona" -> 1.0);
val discountedProducts = products.map( s => s._2 * 0.90);

discountedProducts.fold() { (z, i) =>
  print(i)
  println("")
}

// ex. 3
val (id, username, login) = (0, "randomusername", 0.55)
println("Id is: " + id) //Prints "Id is: 0".
println("Username is: " + username) //Prints "Username is: randomusername".
println("double is: " + login) //Prints "Username is: randomusername".

// ex.4
println("jest: " + products.get("olowek"));
println("niejest: " + products.get("nie"));

// ex.5
def isWorking(day: String) = day match {
  case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek"=> "praca"
  case "sobota" | "niedziela" => "wolne"
  case default => "Nie ma takiego dnia"
}

println(isWorking("poniedzialek"))
println(isWorking("wtorek"))
println(isWorking("niedziela"))
println(isWorking("lambda lamdba"))

// ex.6
class KontoBankowe() {

  def this (stanKonta: Int) {
    this();
    this._stanKonta = stanKonta;
  }

  private var _stanKonta = 0;

  def wplata(amount: Int): Unit = {
    _stanKonta += amount;
  }

  def wyplata(amount: Int): Unit = {
    _stanKonta -= amount;
  }
}

var stanKonta = new KontoBankowe()
var stanKonta2 = new KontoBankowe(200);

// ex. 7
case class Person(name: String, firstname: String) {

}

def hello(person: Person): String = {
  person match {
    case Person(name, _) if name.contains("przemek") =>
      "Siemasz przemooo"
    case Person(name, _) if name.contains("jedkier") =>
      "czesc jedkier"
    case Person(name, _) if name.contains("szymek") =>
      "ello szymek"
    case default =>
      "siema"
  }
}

println(hello(new Person("przemek", "niebieski")));
println(hello(new Person("jedkier", "niebieski")));
println(hello(new Person("szymek", "niebieski")));
println(hello(new Person("karpetka", "niebieski")));

// ex.8
var numbers = List(1, 2, 7, 4, 0, 6, 1, 2, 0, 1);

def removeZero(list: List[Int]): List[Int] = {
  list.filter( x => x != 0);
}

var numbersWithout = removeZero(numbers);
numbersWithout.foreach( println );

// ex.9
def increase(list: List[Int]): List[Int] = {
  list.map(x => x + 1);
}

var increased = increase(numbers);
increased.foreach( println );

// ex.10
def between(list: List[Double]): List[Double] = {
  list.filter(x =>  -5 <= x && x <= 12);
}

var floats = List(-7.4, -5.0, -23, 1, 2.2, 3.4, 22, 455);
var filtered = between(floats);

filtered.foreach(println);