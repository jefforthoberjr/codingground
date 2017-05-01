object ExerciseCaseClass{

    def gettersAndSettersParamsNoDecl(printme: Boolean){
        //Cat is a case class, whose params were declared without 'val' or 'var'
        //Only the getter is auto generated 
        val foo = new Cat("Mittens", "Calico")
        if(printme){println(foo.name + " " +  foo.color)}
        
        // foo.name = "Blackie"
        // foo.color = "Black"
        //Compile error:
        //"error: reassignment to val"
        // if(printme){println(foo.name + " " +  foo.color)}
        
    }
    
    def gettersAndSettersParamsWithVar(printme: Boolean){
        //Dog is a case class, whose params were declared with 'var'
        //Only the getter is auto generated 
        //(i.e. escentially the 'var' decl specs are ignored)
        val foo = new Dog("Spot", "Lab")
        if(printme){println(foo.name + " " +  foo.breed)}
        
        //foo.name = "Barkie"
        //foo.breed = "Beagle"
        //Compile error:
        //"error: reassignment to val"
        //if(printme){println(foo.name + " " +  foo.breed)}
    }
    
    def gettersAndSettersParamsWithVal(printme: Boolean){
        //Badger is a case class, whose params were declared with 'val'
        //Only the ??? is auto generated 
        val foo = new Badger("Honey", "Wisconsin")
        if(printme){println(foo.name + " " +  foo.location)}
        
        foo.name = "Stripey"
        foo.location = "Minnesota"
        //Compile error:
        //"error: reassignment to val"
        if(printme){println(foo.name + " " +  foo.location)}
    }
}