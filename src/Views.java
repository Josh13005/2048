/**
 * Author: Joshua Sam Varughese
 * MacID: varugj1
 * Date: 2021/04/02
 */

package src;

/**
 * @brief A views class that prints the board.
 * @details the board is print into a 4x4 grid.
 */
public class Views {

    public Views(){}

    /**
     * @brief prints the board as a matrix using ASCII characters.
     * @param board the board of the game which is a nested arrayList of values.
     */
    public void printBoard(BoardT board){
        System.out.println("+---+---+---+---+");
        for (int x = 0; x < 4; x++){
            System.out.print("|");
            for (int y = 0; y < 4; y++){
                if(board.getBoard().get(x).get(y) == 0) {
                    System.out.print("  ");
                    System.out.print(" |");
                }
                else {
                    System.out.printf("%2d", board.getBoard().get(x).get(y));
                    System.out.print(" |");
                }
            }
            System.out.println();
            System.out.println("+---+---+---+---+");
        }
    }

}
