package mayssemhannachi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

    static ArrayList<Integer> playerPositions= new ArrayList<>();
    static ArrayList<Integer> cpuPositions= new ArrayList<>();

    // making the board 
    public static void main(String[] args){
        char [][] gameBoard = {{' ','|',' ','|',' '}, 
        {'-','+','-','+','-'}, 
        {' ','|',' ','|',' '} , 
        {'-','+','-','+','-'}, 
        {' ','|',' ','|',' '}}; //made five for the lines between each 2 spaces 
        //print out the gameboard using the method we created
        printGameBoard(gameBoard);//we have to pass the parameter so that it can print it out
        
        while(true){
            Scanner scan = new Scanner(System.in);   //a scanner is used to get input from the user (a declaration not a method)
            System.out.println("Enter your placement (1-9): ");
            int pos =scan.nextInt();//we are asking the user to enter a number(cell number from one to nine)
            while(playerPositions.contains(pos)||cpuPositions.contains(pos)){
                System.out.println("Position taken");
                pos =scan.nextInt();
            }


            placePiece(gameBoard, pos,"player");
        
            Random rand = new Random(); // Declare Random object once

            // Generate a random integer between 1 and 9
            int cpuPos ;

            do {
                cpuPos = rand.nextInt(9) + 1;
            } while (isPositionTaken(cpuPos, pos)); // Generate a new CPU position if it's the same as the user's

            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);
            String result = checkWinner();
            if (result != null) {
                 System.out.println(result);
                break; // Add this line to exit the game loop when it's over
}

        }
        
        
    }
    public static boolean isPositionTaken(int pos, int userPos) {
        return (pos == userPos) || playerPositions.contains(pos) || cpuPositions.contains(pos);
    }
    
    public static void placePiece(char [][] gameBoard, int pos, String user){
        char symbol=' ';
        if(user.equals("player")){
            symbol='X';
            playerPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol='O';
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){

        

        List topRow=Arrays.asList(1,2,3);
        List middleRow=Arrays.asList(4,5,6);
        List bottomeRow=Arrays.asList(7,8,9);
        List leftdcol=Arrays.asList(1,4,7);
        List midcol=Arrays.asList(2,5,8);
        List rightcol=Arrays.asList(3,6,9);
        List cros1=Arrays.asList(1,5,9);
        List cros2=Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomeRow);
        winning.add(leftdcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cros1);
        winning.add(cros2);
        for(List l: winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations you WOOOOOON!!!!!!!!!";
            }else if (cpuPositions.containsAll(l)){
                return "CPU WIIIINNNS!!!!! SORRRYYYYY :(";
            }else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "DRAW!!!!!!";
            }
            
        }
        return null;


    }
    public static void printGameBoard(char [][] gameBoard){//to put the board in method for more organisation
        for(char[] row: gameBoard){//for each row inside the gameboard
            for(char c : row){//for each char in row
                System.out.print(c);
            }
            System.out.println();//to print a new line after the gameBoard
        }
    }
}