package tictactoe;
import java.util.Scanner;
public class SimpleTicTacToe {
    static Scanner sc = new Scanner(System.in);
    static int place = 0;
    public static void main(String[] args) {
        // write your code here
        boolean ends = false;
        boolean xturn = true;
        //System.out.println("Enter cells: ");
        String enter = "_________";
        System.out.println("---------");
        System.out.println("| "+ enter.charAt(0) + " "+ enter.charAt(1) + " "+enter.charAt(2) +" |");
        System.out.println("| "+ enter.charAt(3) + " "+ enter.charAt(4) + " "+enter.charAt(5) +" |");
        System.out.println("| "+ enter.charAt(6) + " "+ enter.charAt(7) + " "+enter.charAt(8) +" |");
        System.out.println("---------");
        boolean hasEmpty = false;
        boolean has3x = false;
        boolean has3o = false;
        int numx = 0;
        int numo = 0;
        while(!ends){
            enter(enter);
            enter = enter.substring(0, place) + (xturn ? 'X' : 'O')+ enter.substring(place + 1);
            xturn = xturn ? false : true;
            System.out.println("---------");
            System.out.println("| "+ enter.charAt(0) + " "+ enter.charAt(1) + " "+enter.charAt(2) +" |");
            System.out.println("| "+ enter.charAt(3) + " "+ enter.charAt(4) + " "+enter.charAt(5) +" |");
            System.out.println("| "+ enter.charAt(6) + " "+ enter.charAt(7) + " "+enter.charAt(8) +" |");
            System.out.println("---------");
            numx = 0;
            numo = 0;
            hasEmpty = false;
            for (int i = 0; i < 9; i++) {
                if (enter.charAt(i) == 'X') numx++;
                else if (enter.charAt(i) == 'O') numo++;
                else hasEmpty = true;
            }
            int[][] in = {
                {0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}
            };
            for (int i = 0; i < 8; i++){
                if (enter.charAt(in[i][0]) == 'X' && enter.charAt(in[i][1]) == 'X' && enter.charAt(in[i][2]) == 'X'){
                    has3x = true;
                }
                else if (enter.charAt(in[i][0]) == 'O' && enter.charAt(in[i][1]) == 'O' && enter.charAt(in[i][2]) == 'O'){
                    has3o = true;
                }
            }
            if (Math.abs(numx -numo) >= 2) {
                System.out.println("Impossible");
            } else if (has3x) {
                System.out.println(has3o ? "Impossible" : "X wins");
                ends = true;
            } else if (has3o) {
                System.out.println("O wins");
                ends = true;
            } else if (hasEmpty) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
                ends = true;
            }
        }
    }
    static void enter(String enter){
            System.out.println("Enter the coordinates: ");
            String input1 = sc.next();
            String input2 = sc.hasNext() ? sc.next() : null;
            while (!input1.matches("[0-9]+") || !input2.matches("[0-9]+") ){ 
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates: ");
                input1 = sc.next();
                input2 = sc.next();
            }
            if (input2.equals("1") || input2.equals("2") || input2.equals("3")){
                if (input1.equals("1")){
                    place = Integer.parseInt(input2) - 1;
                } else if (input1.equals("2")){
                    place = Integer.parseInt(input2) + 2;
                } else if (input1.equals("3")){
                    place = Integer.parseInt(input2) + 5;
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    enter(enter);
                }
            }
            else{
                System.out.println("Coordinates should be from 1 to 3!");
                enter(enter);
            }
            if (enter.charAt(place) != '_' ) {
            System.out.println("This cell is occupied! Choose another one!");
            enter(enter);
        }
        }
}
