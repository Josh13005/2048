/**
 * Author: Joshua Sam Varughese
 * MacID: varugj1
 * Date: 2021/04/02
 */

package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @brief An ADT that represents a Board and its functions.
 * @details a 4x4 board for the game 2048.
 */
public class BoardT {

    private ArrayList<ArrayList<Integer>>board;
    public int score;
    public final static int size = 4;

    /**
     * @brief A BoardT constructor, initializes a nested arrayList of 0's
     * to reresent an empty board.
     */
    public BoardT(){
        this.board = new ArrayList<ArrayList<Integer>>();
        this.score = 0;
        for(int i = 0; i < size; i++)
            this.board.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
    }

    /**
     * @brief gets the board for the game.
     * @return returns a nested arrayList which represents a board.
     */
    public ArrayList<ArrayList<Integer>> getBoard() {
        return board;
    }

    /**
     * @brief gets the score after each move
     * @return returns an integer which represents the current score of the game.
     */
    public int getScore() {
        return score;
    }

    /**
     * @brief Inserts two numbers in a random position of the board.
     * the numbers inserted can be any of 2 or 4.
     */
    public void Insert_Random_Beginning(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(board.size());
            int y = random.nextInt(board.get(0).size());
            int u = random.nextInt(board.size());
            int v = random.nextInt(board.get(0).size());

            if(this.board.get(x).get(y) == 0 && this.board.get(u).get(v) == 0) {
                if (x != u || y != v) {
                    board.get(x).set(y, Math.random() > 0.1 ? 2 : 4);
                    board.get(u).set(v, Math.random() > 0.1 ? 2 : 4);
                    break;
                }
            }
        }
    }

    /**
     * @brief Inserts a number in a random position of the board.
     * the number inserted can be either a 2 or a 4.
     */
    public void Insert_Random(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(board.size());
            int y = random.nextInt(board.get(0).size());
            if(this.board.get(x).get(y) == 0) {
                board.get(x).set(y, Math.random() > 0.1 ? 2 : 4);
                break;
            }
        }
    }

    /**
     * @brief Checks for the number "2048" in the board.
     * @return returns True if "2048" exists in the board.
     */
    public boolean end_condition_2048(){
        for(int i = 0; i < this.board.size(); i++)
            for(int j = 0; j < this.board.get(0).size(); j++)
                if (this.board.get(i).get(j) == 2048)
                    return true;
                return false;

    }

    /**
     * @brief Checks if the board is completely filled.
     * @return returns True if the the board is completely filled.
     */
    public boolean end_condition_filled_board(){
        if(!this.is_moveUp() && !this.is_moveDown() &&
                !this.is_moveLeft() && !this.is_moveRight())
            return true;
        return false;

    }

    /**
     * @brief moves the board up. Each row gets shifted up if the
     * rows before it contains zero's or gets added if the the same element
     * is present in the row before.
     */
    public void moveUp(){
        for(int i = 0; i < 4; i++){
            int counter = 0;
            for(int j = 0; j < 4; j++) {
                if(this.board.get(j).get(i)!=0) {
                    this.board.get(counter).set(i, this.board.get(j).get(i));
                    if(counter != j) {
                        this.board.get(j).set(i, 0);
                    }
                    counter++;
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if (this.board.get(j).get(i) == this.board.get(j + 1).get(i)) {
                    this.board.get(j).set(i, this.board.get(j).get(i) + this.board.get(j + 1).get(i));
                    this.board.get(j + 1).set(i, 0);
                    int total = this.board.get(j).get(i);
                    this.score+=total;
                    break;
                }
            }
        }

        for(int i = 0; i < 4; i++){
            int counter = 0;
            for(int j = 0; j < 4; j++) {
                if(this.board.get(j).get(i)!=0) {
                    this.board.get(counter).set(i, this.board.get(j).get(i));
                    if(counter != j) {
                        this.board.get(j).set(i, 0);
                    }
                    counter++;
                }
            }
        }
    }

    /**
     * @brief moves the board down. Each row gets shifted down if the
     * rows after it contains zero's or gets added if the the same element
     * is present in the row after.
     */
    public void moveDown() {
        for (int i = 0; i < 4; i++) {
            int counter = 0;
            for (int j = 3; j >= 0; j--) {
                if (this.board.get(j).get(i) != 0) {
                    this.board.get(3 - counter).set(i, this.board.get(j).get(i));
                    if (3 - counter != j) {
                        this.board.get(j).set(i, 0);
                    }
                    counter++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (this.board.get(j).get(i) == this.board.get(j - 1).get(i)) {
                    this.board.get(j).set(i, this.board.get(j).get(i) + this.board.get(j - 1).get(i));
                    this.board.get(j - 1).set(i, 0);
                    int total = this.board.get(j).get(i);
                    this.score += total;
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int counter = 0;
            for (int j = 3; j >= 0; j--) {
                if (this.board.get(j).get(i) != 0) {
                    this.board.get(3 - counter).set(i, this.board.get(j).get(i));
                    if (3 - counter != j) {
                        this.board.get(j).set(i, 0);
                    }
                    counter++;
                }
            }
        }
    }

    /**
     * @brief moves the board to the left. Each column gets shifted to the left if the
     * column's to the right contains zero's or gets added if the the same element
     * is present in the column to the right.
     */
    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            int counter = 0;
            for (int j = 0; j < 4; j++) {
                if (this.board.get(i).get(j) != 0) {
                    this.board.get(i).set(counter, this.board.get(i).get(j));
                    if (counter != j) {
                        this.board.get(i).set(j, 0);
                    }
                    counter++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board.get(i).get(j) == this.board.get(i).get(j + 1)) {
                    this.board.get(i).set(j, this.board.get(i).get(j) + this.board.get(i).get(j + 1));
                    this.board.get(i).set(j + 1, 0);
                    int total = this.board.get(i).get(j);
                    this.score += total;
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int counter = 0;
            for (int j = 0; j < 4; j++) {
                if (this.board.get(i).get(j) != 0) {
                    this.board.get(i).set(counter, this.board.get(i).get(j));
                    if (counter != j) {
                        this.board.get(i).set(j, 0);
                    }
                    counter++;
                }
            }
        }
    }

    /**
     * @brief moves the board to the right. Each column gets shifted to the right if the
     * column's to the left contains zero's or gets added if the the same element
     * is present in the column to the left.
     */
    public void moveRight(){
        for(int i = 0; i < 4; i++){
            int counter = 0;
            for(int j = 3; j >= 0; j--) {
                if(this.board.get(i).get(j) != 0) {
                    this.board.get(i).set(3 - counter, this.board.get(i).get(j));
                    if(3 - counter != j) {
                        this.board.get(i).set(j, 0);
                    }
                    counter++;
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 3; j > 0; j--) {
                if(this.board.get(i).get(j) == this.board.get(i).get(j - 1)) {
                    this.board.get(i).set(j, this.board.get(i).get(j) + this.board.get(i).get(j - 1));
                    this.board.get(i).set(j - 1, 0);
                    int total = this.board.get(i).get(j);
                    this.score += total;
                    break;
                }
            }
        }

        for(int i = 0; i < 4; i++){
            int counter = 0;
            for(int j = 3; j >= 0; j--) {
                if(this.board.get(i).get(j) != 0) {
                    this.board.get(i).set(3 - counter, this.board.get(i).get(j));
                    if(3 - counter != j) {
                        this.board.get(i).set(j, 0);
                    }
                    counter++;
                }
            }
        }
    }

    /**
     * @brief Checks if the board can move up.
     * @return returns True if the board can move up.
     */
    public boolean is_moveUp(){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.board.get(j).get(i) == 0 && this.board.get(j + 1).get(i) != 0)
                    return true;
                if(this.board.get(j).get(i) != 0 && this.board.get(j).get(i) == this.board.get(j + 1).get(i))
                    return true;
            }
        }
        return false;
    }

    /**
     * @brief Checks if the board can move down.
     * @return returns True if the board can move down.
     */
    public boolean is_moveDown(){
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j > 0; j--) {
                if(this.board.get(j).get(i) == 0 && this.board.get(j - 1).get(i) != 0)
                    return true;
                if(this.board.get(j).get(i) != 0 && this.board.get(j).get(i) == this.board.get(j - 1).get(i))
                    return true;
            }
        }
        return false;
    }

    /**
     * @brief Checks if the board can move to the left.
     * @return returns True if the board can move to the left.
     */
    public boolean is_moveLeft(){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.board.get(i).get(j) == 0 && this.board.get(i).get(j + 1) != 0)
                    return true;
                if(this.board.get(i).get(j) != 0 && this.board.get(i).get(j) == this.board.get(i).get(j + 1))
                    return true;
            }
        }
        return false;
    }

    /**
     * @brief Checks if the board can move to the right.
     * @return returns True if the board can move to the right.
     */
    public boolean is_moveRight(){
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j > 0; j--) {
                if(this.board.get(i).get(j) == 0 && this.board.get(i).get(j - 1) != 0)
                    return true;
                if(this.board.get(i).get(j) != 0 && this.board.get(j).get(i) == this.board.get(i).get(j - 1))
                    return true;
            }
        }
        return false;
    }
}
