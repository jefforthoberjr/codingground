
case class Outcome(chance:Double, damage:Double, description:String){
    def appendEvent(event:Outcome):Outcome={
        new Outcome(
            this.chance * event.chance,
            this.damage + event.damage,
            this.description + event.description)
    }
}