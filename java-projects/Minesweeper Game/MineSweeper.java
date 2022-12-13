package Test;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public int row;
    public int column;

    MineSweeper() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the row size you want to play: ");
        this.row = scan.nextInt();
        System.out.print("Enter the column size you want to play: ");
        this.column = scan.nextInt();
    }

    public void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void fillArray(String[][] array, String element) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = element;
            }
        }
    }

    public void addMines(String[][] array) {
        int starNumber = (row * column) / 4;
        while (starNumber > 0) {
            Random rand = new Random();
            int starRow = rand.nextInt(row);
            int starColumn = rand.nextInt(column);
            array[starRow][starColumn] = "* ";
            starNumber--;
        }
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        //Creating a demo game to check if user lose the game or not.
        String[][] demoGame = new String[row][column];

        //Filling the elements of the array with "- "
        fillArray(demoGame, "- ");

        //Then, adding "* " elements to the array.
        addMines(demoGame);

        //Writing the location of the mines.
        /*System.out.println("The location of mines");
        printArray(demoGame);
        System.out.println("=================");*/

        //Creating the original game array, which the user will see and play.
        String[][] game = new String[row][column];
        fillArray(game, "- ");

        int loopSize = (row * column) - (int) ((row * column) / 4);
        while (loopSize > 0) {
            printArray(game);
            int count = 0;
            //Beginning of the game.
            System.out.print("Select row: ");
            int selectedRow = (scan.nextInt()) - 1;
            System.out.print("Select column: ");
            int selectedCol = (scan.nextInt()) - 1;

            if (row >= selectedRow && column >= selectedCol && selectedCol >= 0 && selectedRow >= 0) {
                if (demoGame[selectedRow][selectedCol].equals("* ")) {
                    System.out.println("Game Over! You lost.");
                    break;
                } else {
                    if (selectedRow - 1 >= 0 && selectedCol - 1 >= 0) {
                        if (demoGame[selectedRow - 1][selectedCol - 1].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedRow - 1 >= 0) {
                        if (demoGame[selectedRow - 1][selectedCol].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedRow - 1 >= 0 && selectedCol + 1 < column) {
                        if (demoGame[selectedRow - 1][selectedCol + 1].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedCol - 1 >= 0) {
                        if (demoGame[selectedRow][selectedCol - 1].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedCol + 1 < column) {
                        if (demoGame[selectedRow][selectedCol + 1].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedRow + 1 < row && selectedCol - 1 >= 0) {
                        if (demoGame[selectedRow + 1][selectedCol - 1].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedRow + 1 < row) {
                        if (demoGame[selectedRow + 1][selectedCol].equals("* ")) {
                            count++;
                        }
                    }
                    if (selectedRow + 1 < row && selectedCol + 1 < column) {
                        if (demoGame[selectedRow + 1][selectedCol + 1].equals("* ")) {
                            count++;
                        }
                    }
                    //Type casting of count because my array is in String form.
                    String counter = Integer.toString(count);
                    game[selectedRow][selectedCol] = counter + " ";
                }
            } else {
                System.out.println("You entered a wrong input.");
            }

            loopSize--;

            if (loopSize == 0) {
                System.out.println("Congrats! You won the game!");
                printArray(game);
                System.out.println("====================");
            }
        }
        printArray(demoGame);
        System.out.println("====================");
    }
}
