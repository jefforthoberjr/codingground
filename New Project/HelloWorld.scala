object HelloWorld {
   def main(args: Array[String]) {
      println("Hello, world!")
      
     var players:List[Player] = List(
           new Player("A", new Weapon(0.17, 5, 0, 7), null),
           new Player("B", new Weapon(0.3, 4, 0.1, 6), null),
           new Player("C", new Weapon(0.17, 5, 0, 7), null),
           new Player("D", new Weapon(0.29, 2, .1, 3), null),
           new Player("E", new Weapon(0.32, 4, .1, 6), null)
           );
   }
   
   def calculateChanceToKillEnemy(enemy:Player, players:List[Player]){
       generateOutcomes(players, new Outcome(1,0,""))
       
       //temp debug
       println(outcomes);
   }
   
   //List of all possible event combinations
   var outcomes: List[Outcome] = List();
   
 
   //recursion
   //An outcome is the compound probability of a series of events.
   //Each player has a set of possible events that they can perform.
   //Thus, an outcome is the combination of 1 event from all players.
   def generateOutcomes(players:List[Player], currentOutcome:Outcome){
       
        //base case
        if(players.size == 0){
            outcomes = outcomes :+ currentOutcome
        }
        //recursive case
       else{
           //grab next player
           val currentPlayer:Player = players.head;
           val remainingPlayers:List[Player] = players.drop(1);
           
            //recurse for each player's possible events
            val eventPrimaryHits = new Outcome(
                currentPlayer.getPrimaryWeapon.chanceToHit,
                currentPlayer.getPrimaryWeapon.hitDamage,
                "Player " + currentPlayer.name + " hits. ")
            generateOutcomes(remainingPlayers, 
            currentOutcome.appendEvent(eventPrimaryHits));
    
       }
   }
}

