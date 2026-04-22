import java.util.Scanner;

public class Main {
    public static Mon yourMon;
    static Mon zingbah = new Mon("Zing Zing Zingbah", 1000,1000);
    static Mon Jingbah = new Mon("Jingbah", 200,200);
    static Mon Zumbah = new Mon("Zumbah", 500,500);
    static Mon Humbah = new Mon("Humbah", 400,400);
    static Mon sixSeven = new Mon("Brainrotbah", 670000,670000);
    static Mon Jumbah = new Mon("Jumbah", 350,350);

    static Mon Collins = new Mon("Phil Zing Zing Collins", 2000,2000);
    static Mon Yoda = new Mon("Yoda", 1500,1500);

    static Mon EZingbah = zingbah;
    static Mon EJingbah = Jingbah;
    static Mon EZumbah = Zumbah;
    static Mon EHumbah = Humbah;
    static Mon E67 = sixSeven;
    static Mon EJumbah = Jumbah;
    static Mon ECollins = Collins;
    static Mon EYoda = Yoda;

    //public static int round = 1;


    // Battle choices
    public static void choices(Mon yourMon, Mon enemMon){
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat will you do?");
        System.out.println("1: Attack");
        System.out.println("2: View enemy");

        int choice = input.nextInt();

        if(choice == 1){
            attack(yourMon, enemMon);
        } else if (choice == 2) {
            viewEnemy(yourMon, enemMon);
        }else{
            System.out.println("Invalid input");
            choices(yourMon, enemMon);
        }

    }



    public static void attack(Mon yourMon, Mon enemMon){
        System.out.println("\nChoose your attack");
        System.out.print("1:");
        yourMon.printMove(yourMon.moveOne);
        System.out.print("\n2:");
        yourMon.printMove(yourMon.moveTwo);
        System.out.println("\n3:");
        yourMon.printMove(yourMon.moveThree);

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        int attaxk = yourMon.attack(choice);
        if (attaxk == 0) {
            System.out.println("That attack can't be used");
            attack(yourMon, enemMon);
        }
        enemMon.hp -= attaxk;
        System.out.println(enemMon.name + " took " + attaxk + " damage!!");

    }

    public static void viewEnemy(Mon yourMon, Mon enemMon){
        enemMon.printStats();
        enemMon.printMove(enemMon.moveOne);
        enemMon.printMove(enemMon.moveTwo);
        enemMon.printMove(enemMon.moveThree);
        choices(yourMon, enemMon);
    }


    public static void lose(){
        System.out.println("\nBattle lost :(\n Restart the game to try again");
    }

    public static void win(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("you did it!!");
        System.out.println("You and " + yourMon + "deafeated everyone and became god or whatever");
        System.out.println("That's the end!!");
        System.out.println("Or is it??");
        System.out.println("1: yes it is" +
                "\n??: No it isnt");
        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.println("Okie doki bye bye");
        } else if (choice == 67 || choice == 69 || choice == 21) {
            System.out.println(E67.name + " Challenges you!!");
            battleLoop(yourMon, E67, 8);
        }
    }

    public static void enemyAttacks(Mon yourMon, Mon enemMon){
        int enemyAttack = (int) ((Math.random() * (3 - 1)) + 1);
        int enAtk = enemMon.attack(enemyAttack);
        if (enAtk == 0){
            enemyAttacks(yourMon, enemMon);
        }
        yourMon.hp -= enAtk;
        if(enemyAttack == 1){
            System.out.println(enemMon.name + " used " + enemMon.moveOne.name);
        } else if(enemyAttack == 2){
            System.out.println(enemMon.name + " used " + enemMon.moveTwo.name);
        } if(enemyAttack == 3){
            System.out.println(enemMon.name + " used " + enemMon.moveThree.name);
        }
        System.out.println(yourMon.name + " took " + enAtk + " damage");
    }

    //Jingbah, Jumbah, Humbah, Zumbah, zingbah, yoda, collins, secret boss
    public static void rounds(int round){
        System.out.println("\n\n\n");
        System.out.println("Round " + round);
        if(round == 1){
            System.out.println(EJingbah.name + " Challenges you!!");
            battleLoop(yourMon, EJingbah, round);

        } else if (round == 2) {
            System.out.println(EJumbah.name + " Challenges you!!");
            battleLoop(yourMon, EJumbah, round);
        } else if (round == 3) {
            System.out.println(EHumbah.name + " Challenges you!!");
            battleLoop(yourMon, EHumbah, round);
        }else if (round == 4) {
            System.out.println(EZumbah.name + " Challenges you!!");
            battleLoop(yourMon, EZumbah, round);
        }else if (round == 5) {
            System.out.println(EZingbah.name + " Challenges you!!");
            battleLoop(yourMon, EZingbah, round);
        }else if (round == 6) {
            System.out.println(EYoda.name + " Challenges you!!");
            battleLoop(yourMon, EYoda, round);
        }else if (round == 7) {
            System.out.println(ECollins.name + " Challenges you!!");
            battleLoop(yourMon, ECollins, round);
        }else if (round == 8) {
            win();

        } else if (round == 9) {
            System.out.println("you defeated the final boss!!!");

        }else {
            System.out.println(round + " is not a valid round");
        }

    }

    public static void battleLoop(Mon yourMon, Mon enemMon, int round){
        if(yourMon.hp<= 0){
            lose();
        }
        System.out.println("\n");
        System.out.println("Enemy\n-------");
        enemMon.printStats();
        System.out.println("You\n-------");
        yourMon.printStats();
        System.out.println("");
        choices(yourMon, enemMon);
        System.out.println("");

        if(enemMon.hp > 0){
            enemyAttacks(yourMon, enemMon);
        } else {
            rounds(round + 1);
        }

        battleLoop(yourMon, enemMon, round);

    }


    public static void opening(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Boohbahmon Adventure\n\n\nStart your adventure?\n1:Yes\n2:No");
        int choice = scanner.nextInt();
        if(choice == 1){
            start();
        } else if (choice == 2) {
            System.out.println("Damn okay :(");
        } else {
            System.out.println("Invalid input");
            opening();
        }
    }

    public static void start(){
        System.out.println("\n\n\n\n\nWelcome to the world of Boohbahmon!!\n" +
                "Here you journey with ONE Boohbahmon to become the best trainer!");
        System.out.println("but before you choose your partner here are some things to keep in mind" +
                "\n1: You only get one partner, once you choose you can't get anymore" +
                "\n2: Your partner's status will remain the same. Hp lost will stay lost, uses will stay used" +
                "\nmake sure you manage your resources wisely" +
                "\nEnough of the boring stuff, here are your options:" +
                "\n1: Zumbah - High Health/Low Damage" +
                "\n2: Jingbah - Low Health/High Damage" +
                "\n3: Humbah - Balanced" +
                "\n Or you could try getting a secret Boohbahmon!");

        chooseMon();

    }
    public static void chooseMon(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            yourMon = Zumbah;
        }else if(choice == 2){
            yourMon = Jingbah;
        } else if (choice == 3) {
            yourMon = Humbah;
        } else if (choice == 67 || choice == 6 || choice == 7 || choice == 21 || choice == 69) {
            yourMon = sixSeven;
        } else if(choice == 333){
            yourMon = zingbah;
        }else if(choice == 4){
            yourMon = Jumbah;
        }else if(choice == 1981 || choice == 1951){
            yourMon = Collins;
        }else if(choice == 1977){
            yourMon = Yoda;
        } else{
            System.out.println(choice + "is not valid please try again");
            chooseMon();
        }

        System.out.println("You chose " + yourMon.name);
        System.out.println("Now time to start the gauntlet!!!");
        System.out.println("------------------------------------");

        rounds(1);
    }

    public static void main(String[] args) {
         //AI debug
        zingbah.makeMove(1, "God Blast", 10000, 1);
        zingbah.makeMove(2, "Boohbah Supreme Bounce", 150, 50);
        zingbah.makeMove(3, "orange", 200, 13);

        Jingbah.makeMove(1, "Sparkle Beam", 100, 15);
        Jingbah.makeMove(2, "Boohbah Bounce", 70, 13);
        Jingbah.makeMove(3, "pink fluffy unicorns dancing on rainbows", 150, 3);

        Zumbah.makeMove(1, "Zoombah", 50, 20);
        Zumbah.makeMove(2, "Boohbah Bounce", 55, 50);
        Zumbah.makeMove(3, "urple guy", 70, 3);

        Humbah.makeMove(1, "Pipe Bomb", 10000, 1);
        Humbah.makeMove(2, "Boohbah Bounce", 70, 50);
        Humbah.makeMove(3, "King in Yellow", 80, 35);

        sixSeven.makeMove(1, "67", 676767, 67);
        sixSeven.makeMove(2, "Brainrot Blast", 676921, 69);
        sixSeven.makeMove(3, "Skibidi Sigma Ohio Fortnite Battlepass TungTungTung 67 21 Alpha Chad Rizzler Rizz", 99999999, 1000);

        Jumbah.makeMove(1, "Hydrate or Die-drate", 60, 20);
        Jumbah.makeMove(2, "Boohbah Bounce", 65, 50);
        Jumbah.makeMove(3, "Cookie Monster", 80, 15);

        Collins.makeMove(1, "I Don't Care Anymore", 1, 10000);
        Collins.makeMove(2, "Sussudio", 85, 12);
        Collins.makeMove(3, "Take Me Home", 85, 15);

        Yoda.makeMove(1, "Do or Do not there is no try", 100, 5);
        Yoda.makeMove(2, "Seagulls, stop it now", 95, 10);
        Yoda.makeMove(3, "That log had a baby :0", 85, 10);





        //battleLoop(zingbah,Ezingbah);
        opening();
        rounds(1);



    }
}


