public class Mon {

      String name;
      int hp;
      int maxHp;
    Move moveOne = new Move("Slap",10,10);
    Move moveTwo = new Move("Kick",20,5);
    Move moveThree = new Move("Punch",30,5);

    Mon(String name, int hp, int maxHp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
    }

     public void makeMove(int moveNum, String name, int dmg, int uses){
        if(moveNum == 1){
            moveOne = new Move(name,dmg,uses);
        } else if (moveNum == 2) {
            moveTwo = new Move(name,dmg,uses);
        } else if (moveNum == 3) {
            moveThree = new Move(name,dmg,uses);
        } else {
            System.out.println("Invalid move number");
        }
     }

    public void printMove(Move move){

        System.out.print(move.name + " | dmg: " + move.dmg + " | uses: " + move.uses +"\n");

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
