/* Minesweeper.java
 * 
 * Copyright © 2018 Michael E. Cotterell and the University of Georgia. This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License to students and 
 * the public.
 */
package cs1302.Minesweeper ;
import java.io.*;
import java.util.*;

/**
 * This class represents a Minesweeper game.
 *
 * @author Habilou Sanwidi <hss67466@uga.edu>
 */
public class Minesweeper {

    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * information provided in <code>seedFile</code>. Documentation about the
     * format of seed files can be found in the project's <code>README.md</code>
     * file.
     *
     * @param seedFile the seed file used to construct the game
     */

     // Declare Variables
    String[][] grid1;
    String[][] grid2;
    int rows;
    int cols;
    int numMine;
    int score = 0;

    public Minesweeper(File seedFile) {
        try {
            //Read seedFile
            Scanner input = new Scanner(seedFile);
            rows = input.nextInt();
            cols = input.nextInt();
            numMine = input.nextInt();

            //Create a 2D grid
            grid1 = new String[rows][cols];
            grid2 = new String[rows][cols];

            //Fill grid with empty space
            for (int p = 0; p < rows; p++) {
                for (int l = 0; l < cols; l++) {
                    grid1[p][l] = " ";
                    grid2[p][l] = " ";
                }
            }

            //Read mines' location and place them in grid 2
            int x;
            int y;
            while (input.hasNext()) {
                x = input.nextInt();
                y = input.nextInt();
                grid2[x][y] = "M";
            }//while
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        } // catch

    } // Minesweeper

    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * <code>rows</code> and <code>cols</code> values as the game grid's number
     * of rows and columns respectively. Additionally, the number of positions
     * in the grid that will be set as a mine should equal the ceiling of
     * <code>1.0 * rows * cols / 3.0</code>, casted to an <code>int</code>.
     * These mine positions should be assigned randomly.
     *
     * @param rows the number of rows in the game grid
     * @param cols the number of cols in the game grid
     */
    public Minesweeper(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        // Create grid: a 2D int array
        grid1 = new String[rows][cols];
        grid2 = new String[rows][cols];

        // Fill grid 1 with empty Spaces
        for (int p = 0; p < rows; p++) {
            for (int l = 0; l < cols; l++) {
                grid1[p][l] = " ";
                grid2[p][l] = " ";
            }
        } // for

        //Determine the number of mines and place them inside  grid 2
        numMine = (int) (Math.ceil((1.0 * rows * cols) / 3.0));
        int x = 0;
        int y = 0;
        for (int l = 0; l < numMine; l++) {
            x = (int) (Math.random() * rows);
            y = (int) (Math.random() * cols);
            grid2[x][y] = "M";
        } //for

    } // Minesweeper

	/**
	 *This method prints the welcome message.
	*/
    public void welcome() {
        System.out.println("\n");
        System.out.println("         _");
        System.out.println("   /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
        System.out.println("  /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
        System.out.println(" / /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |");
        System.out.println(" \\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|");
        System.out.println("                              ALPHA EDITION |_| v2018.s\n");
    } // welcome()

	/**
	 *This method prints the game over message.
	*/
    public void gameOver() {
        System.out.println("\nOh no... You revealed a mine\n");
        System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __ ");
        System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|");
        System.out.println("| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |");
        System.out.println(" \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|");
        System.out.println(" |___/\n\n");
        System.exit(0);
    } // gameOver()

	/**
	 *This method prints the win message.
	*/
    public void win() {
        System.out.println("\n\n\n");
        System.out.println("░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\"");
        System.out.println("░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░");
        System.out.println("░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"");
        System.out.println("░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░");
        System.out.println("░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"");
        System.out.println("░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░");
        System.out.println("░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"");
        System.out.println("░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░");
        System.out.println("░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░");
        System.out.println("░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░");
        System.out.println("▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░");
        System.out.println("▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌");
        System.out.println("▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░");
        System.out.println("░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░");
        System.out.println("░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░");
        System.out.println("░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░");
        System.out.println("░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!");
        System.out.println("░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!");
        System.out.printf("░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE: %d\n\n\n", score);
        System.exit(0);
    } // win()

	/**
	 *This method prints the help commands
	*/
    public void help() {
        System.out.println("\nCommands Available...");
        System.out.println(" - Reveal: r/reveal row col");
        System.out.println(" -   Mark: m/mark row col");
        System.out.println(" -  Guess: g/guess row col");
        System.out.println(" -   Help: h/help");
        System.out.println(" -   Quit: q/quit\n");
    } // help()

	/**
	 *This method prints a message in case of a wrong input bu user.
	*/
    public void wrongCommand() {
        System.out.println("\n\nಠ_ಠ says, \"Command not recognized!\"\n");
    } //wrongCommand()

	/**
	 *This method prints the grid
	*/
    public void printGrid() {

        System.out.printf("\n\nRound Completed: %d\n\n", score);

        for (int i = 0; i < rows; i++) {
            System.out.print(" " + i + " |");
            for (int j = 0; j < cols; j++) {
                System.out.printf(" %s |", grid1[i][j]);
            }
            System.out.println();
        }
        System.out.print("     ");
        for (int k = 0; k < cols; k++) {
            System.out.print(k + "   ");
        }
        System.out.println("\n\n");     
    }
     

	/**
	 * This method is called fogOfWar.
	 * When called, it reveals all the mines to the user 
	 * at the expense of one round for the next round only.
	 *  
	 * 
	 */
     public void fogOfWar(){
	System.out.printf("\n\nRound Completed: %d\n\n", score);

        for (int i = 0; i < rows; i++) {
            System.out.print(" " + i + " |");
            for (int j = 0; j < cols; j++) {
			if(grid2[i][j].equals("M")){
			   System.out.printf("<%s>|", grid1[i][j]);
		} else {
                System.out.printf(" %s |", grid1[i][j]);
		}
            }
            System.out.println();
        }
        System.out.print("     ");
        for (int k = 0; k < cols; k++) {
            System.out.print(k + "   ");
        }
        System.out.println("\n\n");     
    
 }
	/**
	 * This method is called to reveal a square.
	 * It takes a square's parameters then first check if there is
	 * a mine. If there is no mine, the method then prints the number
	 * of surrounding mines.
	 *
	 * @param x the row parameter
	 * @param y the column  parameter
	 */
    public void reveal(int x, int y) {
        mineCheck(x, y);
        grid1[x][y] = countSurroundMine(x, y) + "";
        winCheck();
        printGrid();
    } // reveal

	/**
	 * This method is called to mark a square.
	 * It takes a square's parameters prints a "F" 
	 * inside of it.
	 * 
	 *
	 * @param x the row parameter
	 * @param y the column  parameter
	 */
    public void mark(int x, int y) {
        grid1[x][y] = "F";
        printGrid();
    } // mark

	/**
	 * This method is called to guess a square.
	 * It takes the square parameters then prints 
	 * a "?" inside of it.
	 * 
	 *
	 * @param x the row parameter
	 * @param y the column  parameter
	 */
    public void guess(int x, int y) {
        grid1[x][y] = "?";
        printGrid();
    } //guess

	/**
	 * This method is called winCheck.
	 * When called, it checks to see if the
	 * player has revealed all the squares 
	 * not containing a mine.
	 * 
	 */
    public void winCheck() {
        int numOfRemaingMines = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid1[i][j].equals(" ")) {
                    numOfRemaingMines++;
                }
            }
        }
        if (numOfRemaingMines == numMine) {
            win();
        }
    } //winCheck

	/**
	 * This method is called mineCheck.
	 * When called, it checks to see if the 
	 * a particular square contains a mine.
	 * 
	 *
	 * @param x the row parameter
	 * @param y the column  parameter
	 */
    public void mineCheck(int x, int y) {
        if (grid2[x][y].equals("M")) {
            gameOver();
        }
    } //mineCheck()

	/**
	 * This method is called quit.
	 * When called, it prints a goodbye message
	 * and quits the game.
	 * 
	 *
	 */
    public void quit() {
        System.out.print("\n\nლ(ಠ_ಠლ)\n\n");
        System.out.print("Y U NO PLAY MORE?\n\n");
        System.out.print("Bye!\n\n");
        System.exit(0);
    } //quit

	/**
	 * This method is called countSrroundMine.
	 * When called, it counts all surrounding mines.
	 * It takes the parameter of a particular square then checks
	 * each and everyone of its surroundings for mines.
	 *
	 * @param x the row parameter
	 * @param y the column  parameter
	 * @return  number of surrounding mines
	 */
    public int countSurroundMine(int pointX, int pointY) {

        int roundMine = 0;

        if (pointX + 1 < rows) {
            if (grid2[pointX + 1][pointY].equals("M")) {
                roundMine++;
            }
        }

        if (pointX - 1 >= 0) {
            if (grid2[pointX - 1][pointY].equals("M")) {
                roundMine++;
            }
        }

        if (pointY + 1 < cols) {
            if (grid2[pointX][pointY + 1].equals("M")) {
                roundMine++;
            }
        }

        if (pointY - 1 >= 0) {
            if (grid2[pointX][pointY - 1].equals("M")) {
                roundMine++;
            }
        }

        if (pointX + 1 < rows && pointY + 1 < cols) {
            if (grid2[pointX + 1][pointY + 1].equals("M")) {
                roundMine++;
            }
        }

        if (pointX - 1 >= 0 && pointY + 1 < cols) {
            if (grid2[pointX - 1][pointY + 1].equals("M")) {
                roundMine++;
            }
        }

        if (pointX - 1 >= 0 && pointY - 1 >= 0) {
            if (grid2[pointX - 1][pointY - 1].equals("M")) {
                roundMine++;
            }
        }

        if (pointX + 1 < rows && pointY - 1 >= 0) {
            if (grid2[pointX + 1][pointY - 1].equals("M")) {
                roundMine++;
            }
        }
        return roundMine;
    } // countSurroundMine

    /**
     * Starts the game and execute the game loop.
     */
    public void run() {

       
 welcome();
        printGrid();
        String command = "";
        int param1 = 0;
        int param2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("minesweeper-alpha$ ");
        while (true) {
	    score++;
            try{
            command = input.next().toLowerCase();
            if (command.equals("r") || command.equals("reveal")) {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if(param1 >= 0 && param1 < rows && param2 >= 0 && param1 < cols){
                   reveal(param1, param2); 
                }else{
                    System.out.println("\nಠ_ಠ says, \"Out of bound!\"\n");
                } 
            } else if (command.equals("q") || command.equals("quit")) {
                quit();
            } else if (command.equals("m") || command.equals("mark")) {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if(param1 >= 0 && param1 < rows && param2 >= 0 && param1 < cols){
                   mark(param1, param2); 
                }else{
                    System.out.println("\nಠ_ಠ says, \"Out of bound!\"\n");
                } 
            } else if (command.equals("g") || command.equals("guess")) {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if(param1 >= 0 && param1 < rows && param2 >= 0 && param1 < cols){
                   guess(param1, param2);
                }else{
                    System.out.println("\nಠ_ಠ says, \"Out of bound!\"\n");
                }
            } else if (command.equals("h") || command.equals("help")) {
                help();
            } else if(command.equals("n") || command.equals("nofog")){
                fogOfWar();
		score++;
            } else {
                wrongCommand();
            }
            System.out.print("minesweeper-alpha$ ");
            }catch(Exception ex){
                continue;
            }
        }//while

    } // run

    /**
     * The entry point into the program. This main method does implement some
     * logic for handling command line arguments. If two integers are provided
     * as arguments, then a Minesweeper game is created and started with a grid
     * size corresponding to the integers provided and with a number of squares
     * containing mines, placed randomly, as determined by the overloaded
     * constructor. If a single word string is provided as an argument then it
     * is treated as a seed file and a Minesweeper game is created and started
     * using the information contained in the seed file. If none of the above
     * applies, then a usage statement is displayed and the program exits
     * gracefully.
     *
     * @param args the shell arguments provided to the program
     */
    public static void main(String[] args) {

        /*
	  The following switch statement has been designed in such a way that if
	  errors occur within the first two cases, the default case still gets
	  executed. This was accomplished by special placement of the break
	  statements.
         */
        Minesweeper game = null;

        switch (args.length) {

            // random game
            case 2:

                int rows,
                 cols;

                // try to parse the arguments and create a game
                try {
                    rows = Integer.parseInt(args[0]);
                    cols = Integer.parseInt(args[1]);
                    if (rows > 0 && rows <= 10 && cols > 0 && cols <= 10) {
                        game = new Minesweeper(rows, cols);
                    } else {
                        System.out.println("\nಠ_ಠ says, \"Cannot create a mine field with that many rows and/or columns!\"\n");
                        System.exit(0);
                    }

                    break;
                } catch (NumberFormatException nfe) {
                    // line intentionally left blank
                } // try

            // seed file game
            case 1:

                String filename = args[0];
                File file = new File(filename);

                if (file.isFile()) {
                    game = new Minesweeper(file);
                    break;
                } else {
                    System.out.println("\nಠ_ಠ says, \"Invalid seedFile!\"\n");
                    System.exit(0);
                }

            // display usage statement
            default:

                System.out.println("\nUsage: java Minesweeper [FILE]");
                System.out.println("Usage: java Minesweeper [ROWS] [COLS]\n");
                System.exit(0);

        } // switch

        // if all is good, then run the game
        game.run();

    } // main

} // Minesweeper
