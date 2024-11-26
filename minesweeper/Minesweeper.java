import java.util.Random;               // TODO: win functionality, fix scanner issue,
import java.util.Scanner;

public class Minesweeper {
    static Scanner scan = new Scanner(System.in);
    static int activeMines;
    public static void main(String[] args) {
        while (true) { 
            System.out.print("Enter rows (5-90): ");
            int rows = scan.nextInt();
            System.out.print("Enter columns (5-26): ");
            int columns = scan.nextInt();
    
            //scan.close();

            Position[][] pos = new Position[rows][columns];
            if ((rows >= 5 && rows <= 90) && (columns >= 5 && columns <= 26)) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        pos[i][j] = new Position(0, false, false, false);
                    }
                }
                placeMines(pos, rows, columns);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        pos[i][j].adjacentMines = minesTouching(pos, i, j);
                    }
                }

                while (true) {
                    printBoard(pos, rows, columns);
                    input(pos);
                    checkWin(pos);
                }
            }
            else {
                System.out.println("Error: Invalid size");
            }
        }
    }

    public static void placeMines(Position[][] pos, int rows, int columns) {
        Random rand = new Random();

        final double mineDensity = 0.20; // Configurable
        int totalMines = (int) Math.round(mineDensity * rows * columns);
        activeMines = totalMines;
        System.out.println("Total mines: " + totalMines);

        int placedMines = 0;
        while (placedMines < totalMines) {
            int row = rand.nextInt(rows);
            int column = rand.nextInt(columns);

             if (!pos[row][column].isBomb) {
                pos[row][column].isBomb = true;
                placedMines++;
             }
        }
    }

    public static int minesTouching(Position[][] pos, int i, int j) {
        int mineCount = 0;
        for (int I = i - 1; I <= i + 1; I++) {
            for (int J = j - 1; J <= j + 1; J++) {
                if (I >= 0 && I < pos.length && J >= 0 && J < pos[0].length) {
                    if (pos[I][J].isBomb) {
                        mineCount++;
                    }  
                }
            }
        }
        return mineCount;
    }

    public static void printBoard(Position[][] pos, int rows, int columns) {
        System.out.print("\033[H\033[2J");
        System.out.print("    ");
        for (int i = 0; i < columns; i++) {
            char ch = (char) (i + 65);
            System.out.print(" " + ch);
        }
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < columns; i++) {
            System.out.print("--");
        }
        System.out.println("-");
        for (int i = 0; i < rows; i++) {      
            if (i < 9) {
                System.out.print(" ");
            }
            
            System.out.print((i + 1) + " |");

            for (int j = 0; j < columns; j++) {
                System.out.print(" ");
                if (pos[i][j].isRevealed) {
                    if (pos[i][j].isFlagged) {
                        System.out.print("F");
                    }
                    else if (pos[i][j].isBomb) {
                        System.out.print("*");
                    }
                    else if (pos[i][j].adjacentMines == 0) {
                        System.out.print(" ");
                        //zeroClear(pos, i, j);
                    }
                    else {
                        System.out.print(pos[i][j].adjacentMines);
                    }
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println(" |");
        }
        System.out.print("    ");
        for (int i = 0; i < columns; i++) {
            System.out.print("--");
        }
        System.out.println("-");
    }

    public static void zeroClear(Position[][] pos, int i, int j) {
        for (int I = i - 1; I <= i + 1; I++) {
            for (int J = j - 1; J <= j + 1; J++) {
                if (I >= 0 && I < pos.length && J >= 0 && J < pos[0].length) {
                    if (!pos[I][J].isRevealed) {
                        pos[I][J].isRevealed = true;
                        if (pos[I][J].adjacentMines == 0) {
                            zeroClear(pos, I, J);
                        }
                    }
                }
            }
        }
    }

    public static void input(Position[][] pos) {
        while (true) {
            try {
                System.out.println("Flags left: " + activeMines);
                System.out.print("Enter coordinates and action (ex: A 1, B 22 flag, C 5 unflag): ");
                String input = scan.nextLine();
        
                String[] split = input.split(" ");
                int row = Integer.parseInt(split[1]) - 1;
                int column = (split[0].toLowerCase()).charAt(0) - 'a';
        
                if (split.length >= 3) {
                    if (split[2].equalsIgnoreCase("flag") && pos[row][column].adjacentMines != 0) {
                        pos[row][column].isRevealed = true;
                        pos[row][column].isFlagged = true;
                        activeMines--;
                    }
                    else if (split[2].equalsIgnoreCase("unflag") && pos[row][column].adjacentMines != 0) {
                        pos[row][column].isRevealed = false;
                        pos[row][column].isFlagged = false;
                        activeMines++;
                    }
                }
                else {
                    if (pos[row][column].isBomb && !pos[row][column].isFlagged) {
                        lose(pos);
                    }
                    if (pos[row][column].isRevealed) {
                        circleClear(pos, row, column);
                    }
                    else if (pos[row][column].adjacentMines == 0) {
                        pos[row][column].isRevealed = true;
                        zeroClear(pos, row, column);
                    }
                    else {
                        pos[row][column].isRevealed = true;
                    }
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Error: Invalid input");
                scan.nextLine();
            }

        }
    }

    public static void circleClear(Position[][] pos, int row, int column) {
        if (pos[row][column].isRevealed) {
            for (int I = row - 1; I <= row + 1; I++) {
                for (int J = column - 1; J <= column + 1; J++) {
                    if (I >= 0 && I < pos.length && J >= 0 && J < pos[0].length) {
                        pos[I][J].isRevealed = true;
                        if (pos[I][J].adjacentMines == 0) {
                            zeroClear(pos, I, J);
                        }
                        if (pos[I][J].isBomb && !pos[I][J].isFlagged) {
                            lose(pos);
                        }
                    }
                }
            }
        }
    }

    public static void lose(Position[][] pos) {
        System.out.println("\nwomp womp, you hit a mine :(");

        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                pos[i][j].isRevealed = true;
            }
        }
    
        printBoard(pos, pos.length, pos[0].length);
    
        System.exit(0);
    }

    public static void checkWin(Position[][] pos) { // if all non bomb tiles are revealed
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (!pos[i][j].isRevealed && !pos[i][j].isBomb) {
                    return;
                }
            }
        }
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                pos[i][j].isRevealed = true;
            }
        }
        printBoard(pos, pos.length, pos[0].length);
        System.out.println("You win!");
        System.exit(0);
    }
}