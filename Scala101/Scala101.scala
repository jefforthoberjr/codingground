/** 
 * The primary purpose of this project is to exercise the syntax of scala.
 */

object Scala101 {
   def main(args: Array[String]) {
      println("Welcome to scala 101");
      
      declareWithoutInitialize(false);
      declareWithInitialize(false);
      
   }
   
   def declareWithoutInitialize(printme:Boolean){
       //val foo;
       //var bar;
       //Compile error:
       //"error: '=' expected but ';' found."
       
       //val foo: Int;
       //var bar: Int;
       //Compile error:
       //"error: only classes can have declared but undefined members"
   }
   
   def declareWithInitialize(printme: Boolean){
       //Implicitly typed
       val foo = 5;
       //Explicitly typed
       val foo2: Int = 5;
       
       //Implicitly typed
       val bar = 5;
       //Explicitly typed
       val bar2: Int = 5;
       
       if (printme){
           println(foo);
           println(foo2);
           println(bar);
           println(bar2);
       }
   }
}

