/**
 * author: Jeffry Orthober Jr.
 * 
 * overview:
 *  Designed as a handy utility program to help calculate kill odds 
 *  for the video game XCOM: Enemy Unknown. To be used to help decision
 *  making on the battlefield. (To automate what would otherwise be a
 *  series of basic pen and paper probabilistic calculations).
 * 
 *  (The probability calculation involved are fairly generic,
 *  thus this program could easily be repurposed for other 
 *  games involving probability).
 * 
 *  There are a number of complex combat details and unexposed
 *  nuiances to the game XCOM. How exactly XCOM calculates certain
 *  events is not fully known, thus this tool is only intended to
 *  provide quick rough estimates.
 * 
 *  The code base is a work in progress. I plan to add features as 
 *  the need arises.
 * 
 *  There is currently no user interface for this program. At the
 *  moment all input is hardcoded.
 * 
 *  Note that there is an extensive activy mod community for XCOM.
 *  (I'm guessing there already exist mods that do the same work
 *  as this program). Nonetheless this program can be used for those
 *  who do have a version of XCOM that does not support mods.
 * 
 * more details:
 *  XCOM involves a battlefield of soldiers, with weapons, damage, 
 *  hit points, etc. Each player takes turns moving and shooting with
 *  their whole regiment of soldiers. The game XCOM displays to the
 *  player the probability of any given soldier's shot being successful.
 *  Armed with this information, you can calculate the probability of 
 *  multiple shots from multiple soldiers being successful. 
 *  
 *  A common scenario in XCOM: you have 1 enemy soldier surrounded by 4
 *  of your soldiers, but all 4 soliders have a weak shot. Should you 
 *  attack or reposition your soldiers?
 */

object XCOMKillCalculator {
    
    /**
     * Scenario: It's your turn. You have multiple soliders with
     * a possible shot on 1 enemy soldier; what are the odds that
     * you can kill the enemy solider this turn.
     */
    def main(args: Array[String]) {
        println("XCOMKilCalculator")
        println("Calculations will  be performed to answer the following question:")
        println("What are the odds that my soldiers can kill the enemy this turn?")
      
        val mySoldiers:List[Soldier] = List(
            new Soldier("A", 10, new Weapon(0.17, 5, 0, 7), null),
            new Soldier("B", 10, new Weapon(0.3, 4, 0.1, 6), null),
            new Soldier("C", 10, new Weapon(0.17, 5, 0, 7), null),
            new Soldier("D", 10, new Weapon(0.29, 2, .1, 3), null),
            new Soldier("E", 10, new Weapon(0.32, 4, .1, 6), null)
            );
        //Note: At the moment only primary weapons are used in the
        //calculations. Also, hitPoints are currently set to an
        //arbitrary value because the calculations do not involve our 
        //soldiers taking damage from enemy fire.
        
        val muton = Soldier("Enemy", 10, null, null);
        //Note: At the moment enemy's weapons are null because currently
        //the calculations do not consider the enemy's return fire.
        
        val enemy = muton
        
        println("INPUT for calculation:")
        println("My soldiers: " + mySoldiers)
        println("The enemy: " + enemy)
        
        calculateChanceToKillEnemy(enemy, mySoldiers)
        
   }
   
   /**
    * Assumes each soldiers takes a shot.
    */
   def calculateChanceToKillEnemy(enemy:Soldier, soldiers:List[Soldier]){
       generateOutcomes(soldiers, new Outcome(1,0,""))
       
       //TODO sum all outcomes that have > HP in damage
       
       //temp debug
       println(outcomes);
   }
   
   //List of all possible event combinations
   var outcomes: List[Outcome] = List();
   
 
   /**
    * Recursive operation.
    * 
    * Each outcome is calculated as the combination of 1 shot event from 
    * all soldiers.
    */
    def generateOutcomes(soldiers:List[Soldier], currentOutcome:Outcome){
       
        //base case
        if(soldiers.size == 0){
            outcomes = outcomes :+ currentOutcome
        }
        //recursive case
        else{
            //grab next soldier
            val currentSoldier:Soldier = soldiers.head;
            val remainingSoldiers:List[Soldier] = soldiers.drop(1);
           
            //recurse for each player's possible events
            val eventPrimaryHits = new Outcome(
                currentSoldier.primaryWeapon.chanceToHit,
                currentSoldier.primaryWeapon.hitDamage,
                "Player " + currentSoldier.name + " hits. ")
            generateOutcomes(remainingSoldiers, 
            currentOutcome.appendEvent(eventPrimaryHits));
            
            //TODO add crit event
            
            //TODO add miss event
    
       }
   }
}

