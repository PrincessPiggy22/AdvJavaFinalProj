public class Trainer {
    String name;
    int teamSize;
    int curMon = 0;
    Mon[] team = new Mon[teamSize];

    Trainer(String name, int teamSize){
        this.name = name;
        this.teamSize = teamSize;
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
        if(outCount == teamSize){
            lose();
        }
    }

    public void changeMon(){
        noMon();
        System.out.println(name + " is changing pokemon!");
        curMon++;

    }

    public void attack(){
        team[curMon].attack();
    }

    public void lose(){
        System.out.println(name + "lost the battle!!");
    }

}
