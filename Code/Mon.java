public class Mon {

    String name;
    String type;
    int hp;
    int lvl = 1;

    Move moveOne = new Move("Punch","Normal",10,5);
    Move moveTwo = new Move("Kick","Normal",7,10);
    Move moveThree = new Move("Slap","Normal",10,15);

    Mon(String name, String  type, int hp) {
        this.name = name;
        this.type = type;
        this.hp = hp;
    }

    public void lvlUp(int levels){
        lvl += levels;
        hp += levels*5;
    }

    public int attack(){
        int move = (int) ((Math.random() * (3 - 1)) + 1);
        if(move == 1){
            if(moveOne.uses > 0){
                moveOne.uses--;
                return moveOne.dmg;
            } else{
                attack();
            }

        } else if (move == 2) {
            if(moveTwo.uses > 0){
                moveTwo.uses--;
                return moveTwo.dmg;
            } else{
                attack();
            }
        } else if (move == 3) {
            if(moveThree.uses > 0){
                moveThree.uses--;
                return moveThree.dmg;
            } else{
                attack();
            }
        }
        return 0;
    }

}
