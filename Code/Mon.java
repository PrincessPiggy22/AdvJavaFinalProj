public class Mon {

     static String name;
      int hp;
     static int maxHp;

    Mon() {
        this.name = "base";
        this.hp = 50;
        this.maxHp = 50;
    }

    static Move moveOne = new Move("Slap",10,10);
    static Move moveTwo = new Move("Kick",20,5);
    static Move moveThree = new Move("Punch",30,5);

    public static void printMove(Move move){

        System.out.print(move.name + " | dmg: " + move.dmg + " | uses: " + move.uses);

    }

    public void printStats(){
        System.out.println(this.name + "\nHP: " + this.hp +"/"+this.maxHp);
    }

    public int attack(int move){

        if(move == 1){
            if(moveOne.uses > 0){
                moveOne.uses--;
                return moveOne.dmg;
            } else{
                attack(move);
            }

        } else if (move == 2) {
            if(moveTwo.uses > 0){
                moveTwo.uses--;
                return moveTwo.dmg;
            } else{
                attack(move);
            }
        } else if (move == 3) {
            if(moveThree.uses > 0){
                moveThree.uses--;
                return moveThree.dmg;
            } else{
                attack(move);
            }
        }
        return 0;
    }

}
