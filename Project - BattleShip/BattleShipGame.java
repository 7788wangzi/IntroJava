import java.util.Random;
import java.util.Scanner;

public class BattleShipGame {

    public static void main(String[] arg){
        int[][] myArrayMap = new int[10][10];

        Scanner input = new Scanner(System.in);

        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right now, the sea is empty.");

        boolean gameOver = false;
        gameOver = PrintMapAndCheckIsGameOver(myArrayMap);
        // Player 5 ships
        int count = 0;

        while(count<5)
        {
            System.out.print("Enter X coordinate for your ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int y= input.nextInt();

            if(x>=0&x<10)
            {

            }else{
                System.out.print("Enter X coordinate for your ship (0 ~9): ");
                x=input.nextInt();
            }

            if(y>=0&y<10)
            {

            }else{
                System.out.print("Enter Y coordinate for your ship (0 ~9): ");
                y=input.nextInt();
            }

            if(myArrayMap[x][y]==0) {
                myArrayMap[x][y] = 1;
                count++;
            }
            else{
                System.out.print("Place is occupied: ");
            }
        }
        gameOver = PrintMapAndCheckIsGameOver(myArrayMap);

        // Computer Ship
        int csCount =0;
        while(csCount<5) {
            Random rand = new Random();
            int csX = rand.nextInt(10);
            int csY = rand.nextInt(10);

            if(myArrayMap[csX][csY]==1|myArrayMap[csX][csY]==2)
            {

            }
            else
            {
                System.out.println((csCount+1)+". ship DEPLOYED");
                myArrayMap[csX][csY]=2;
                csCount++;
            }
        }



        //System.out.println("**** Welcome to Battle Ships game ****");
        //System.out.println("Right now, the sea is empty.");

       // boolean gameOver = false;
        gameOver = PrintMapAndCheckIsGameOver(myArrayMap);

        boolean userTurn = true;

        while(!gameOver){
            if(userTurn)
            {
                System.out.println("YOUR TURN");
                System.out.print("Enter X coordinate: ");

                int urX = input.nextInt();
                System.out.print("Enter Y coordinate: ");
                int urY = input.nextInt();

                if((urX>=0&urX<10)&(urY>=0&urY<10))
                {
                    if(myArrayMap[urX][urY]==2)
                    {
                        System.out.println("Boom! You sunk the ship!");
                        myArrayMap[urX][urY]=5; // output as "!"
                    }
                    else if(myArrayMap[urX][urY]==1)
                    {
                        System.out.println("Oh no, you sunk your own ship :(");
                        myArrayMap[urX][urY]=-1; // output as "x"
                    }
                    else{
                        System.out.println("Sorry, you missed");
                        myArrayMap[urX][urY]=10; // output as "-"
                    }
                }
                else{
                    System.out.println("Sorry, you missed");
                }

                userTurn=false;

                gameOver= PrintMapAndCheckIsGameOver(myArrayMap);
            }

            if(userTurn==false)
            {
                System.out.println("COMPUTER'S TURN");
                Random rnd = new Random();
                int csX = rnd.nextInt(10);
                int csY=rnd.nextInt(10);

                while(myArrayMap[csX][csY]==-5) {
                    csX = rnd.nextInt(10);
                    csY=rnd.nextInt(10);
                }

                if(myArrayMap[csX][csY]==1)
                {
                    System.out.println("The Computer sunk one of your ships!");
                    myArrayMap[csX][csY]=6; // output as "x"
                }
                else if (myArrayMap[csX][csY]==2)
                {
                    System.out.println("The Computer sunk one of its own ships");
                    myArrayMap[csX][csY]=-2; // output as "!"
                }
                else{
                    System.out.println("Computer missed");
                    if(myArrayMap[csX][csY]==0)
                    {
                        myArrayMap[csX][csY]=-5; // computer no guss -5 any more
                    }
                }

                userTurn=true;
                gameOver= PrintMapAndCheckIsGameOver(myArrayMap);
            }
        }
    }

    public static boolean PrintMapAndCheckIsGameOver(int[][] argArr)
    {
        int yourShip=0;
        int computerShip =0;

        System.out.println("   0123456789  ");
        //System.out.println("0 |          | 0");
        for(int i=0; i<argArr.length; i++)
        {
            System.out.print(i+" |");
            for(int j=0; j<argArr[i].length; j++)
            {
                if(argArr[i][j]==1 | argArr[i][j]==2)
                {
                    System.out.print("@");
                }
                else if(argArr[i][j]==5 | argArr[i][j]==-2)
                {
                    System.out.print("!");
                }
                else if(argArr[i][j]==-1| argArr[i][j]==6)
                {
                    System.out.print("x");
                }
                else if(argArr[i][j]==10)
                {
                    System.out.print("-");
                }
                else {
                    System.out.print(" ");
                }
                //System.out.print(argArr[i][j]);

                if(argArr[i][j]==1)
                {
                    yourShip++;
                }
                else if(argArr[i][j]==2)
                {
                    computerShip++;
                }
            }
            System.out.println("| "+i);
        }

        System.out.println("   0123456789   ");

        System.out.println("Your ships: "+yourShip+" | Computer ships: "+computerShip);
        if(yourShip==0)
        {
            System.out.println("Computer win the battle :(");
            return true;

        }
        if(computerShip==0)
        {
            System.out.println("Hooray! You win the battle :)");
            return true;

        }

        return  false;
    }
}


