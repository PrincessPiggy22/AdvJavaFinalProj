public class Trainer {
    String name;
    int curMon = 0;
    Mon[] team = new Mon[6];

    Trainer(){
        this.name = "jeff";
    }

    public void checkMon(int mon){
        if (team[mon].hp <= 0){
            changeMon();
        }
    }

    public void noMon(){
        int outCount = 0;
        for(Mon mon : team){
            outCount++;
        }
        if(outCount == team.length){
            lose();
        }
    }


    public void changeMon(){
        noMon();
        System.out.println(name + " is changing pokemon!");
        curMon++;

    }

    public void attack(){
        team[curMon].attack((int) ((Math.random() * (3 - 1)) + 1));
    }int move = (int) ((Math.random() * (3 - 1)) + 1);

    public void lose(){
        System.out.println(name + "lost the battle!!");
    }

}
