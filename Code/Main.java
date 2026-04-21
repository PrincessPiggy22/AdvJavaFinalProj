import java.util.Scanner;

public class Main {



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
        yourMon.printMove(yourMon.moveOne);
        yourMon.printMove(yourMon.moveTwo);
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
        System.out.println("You lost!!!");
    }

    public static void win(){
        System.out.println("You win!!");
    }

    public static void enemyAttacks(Mon yourMon, Mon enemMon){
        int enemyAttack = enemMon.attack((int) ((Math.random() * (3 - 1)) + 1));
        if (enemyAttack == 0){
            enemyAttacks(yourMon, enemMon);
        }
        yourMon.hp -= enemyAttack;
        System.out.println(yourMon.name + " took " + enemyAttack + " damage");
    }

    public static void battleLoop(Mon yourMon, Mon enemMon){
        yourMon.printStats();
        choices(yourMon, enemMon);
        enemyAttacks(yourMon, enemMon);

        if(yourMon.hp <= 0){
            lose();
        } else if (enemMon.hp<=0) {
            win();
        } else{
            battleLoop(yourMon, enemMon);
        }

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n\nWelcome to the world of Boohbahmon!!\n" +
                "Here you journey with ONE Boohbahmon to become the best trainer!");
        System.out.println("but before you choose your partner here are some things to keep in mind" +
                "\n1: You only get one partner, once you choose you can't get anymore" +
                "\n2: Your partner's status will remain the same. Hp lost will stay lost, uses will stay used" +
                "\nmake sure you manage your resources wisely" +
                "\nEnough of the boring stuff, here are your options:" +
                "\n1: Zumbah" +
                "\n2: Jingbah" +
                "\n3: Humbah");
        int choice = scanner.nextInt();
        

    }

    public static void main(String[] args) {
        Mon yourMon;
        Mon zingbah = new Mon("Zing Zing Zingbah", 1000,1000); //AI debug
        zingbah.makeMove(1, "godBlast", 10000, 1);
        zingbah.makeMove(2, "boohbahBounce", 20, 15);
        zingbah.makeMove(3, "orange", 30, 10);

        Mon Jingbah = new Mon("Jingbah", 100,100);
        Jingbah.makeMove(1, "Sparkle Beam", 20, 10);
        Jingbah.makeMove(2, "boohbahBounce", 25, 15);
        Jingbah.makeMove(3, "pink", 100, 2);

        Mon Zumbah = new Mon("Zumbah", 200,200);
        Zumbah.makeMove(1, "Zoombah", 100, 5);
        Zumbah.makeMove(2, "boohbahBounce", 25, 20);
        Zumbah.makeMove(3, "urple guy", 90, 3);

        //battleLoop(zingbah,Ezingbah);
        opening();

    }
}


