object ExerciseTuples{

    def declareTuples(printme: Boolean){
        var foo = (3,1,4,1,5,9)
        var foo2: (Int, Int, Int, Int, Int, Int) = foo
        if(printme){println(foo)}
        if(printme){println(foo2)}
        
        val foo3 = ("Bob", 42)
        val foo4: (String, Int) = foo3
        if(printme){println(foo3)}
        if(printme){println(foo4)}
        
        //Nested Tuples
        val n = ("Bob",(1,2,3), "Joe",("A","B","C"))
        val n2: (String, (Int, Int, Int), String, (String, String, String)) = n
        if(printme){println(n)}
        if(printme){println(n2)}
        
    }
    
    def declareMultipleVarsViaTuple(printme: Boolean){
        //Named Tuple elements
        val (name: String, age: Int) = ("Bob", 42)
        if(printme){println(name)}
        if(printme){println(age)}
    }
    
    def maxTupleSize(printme: Boolean){
        val foo22 = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)
        if(printme){println(foo22)}
        
        //Compile error
        //"error: ... is not a member of package scala"
        //val foo23 = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)
        //if(printme){println(foo23)}
    }
    
    //TODO debug why I have this wrong
    // def exerciseCaseClassUnapply(printme: Boolean){
    //     var foo = new Cat("Patches", "Calico")
    //     //Auto-generated unapply method is in the companion object
    //     var bar: (String, String) = Cat.unapply(foo)
    //     if(printme){println(bar)}
    // }
    
    //TODO debug why I have this wrong
    // def exerciseCaseClassApply(printme: Boolean){
    //     val foo = Cat.apply(("Patches", "Calico"))
    //     if(printme){println(foo)}
    // }

}