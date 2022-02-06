/**
 * Author: Joshua Sam Varughese
 * MacID: varugj1
 * Date: 2021/04/02
 */

package src;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class testing {

    private BoardT board;
    private Views v;

    @Before
    public void setUp(){
        v = new Views();
        board = new BoardT();
        for(int i = 0; i < 4; i += 2)
            for(int j = 0; j < 4; j += 2)
                board.getBoard().get(i).set(j, 2);

    }

    @After
    public void tearDown(){
        this.board = null;
    }

    @Test
    public void test_Insert_random_beginning(){
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                board.getBoard().get(i).set(j, 0);
        board.Insert_Random_Beginning();
        boolean bool = false;
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.getBoard().get(i).get(j) == 2 ||
                    board.getBoard().get(i).get(j) == 4){
                    bool = true;
                    counter += 1;
                }
            }
        }
        assertTrue(counter == 2 && bool);
    }

    @Test
    public void test_insert_random(){
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                board.getBoard().get(i).set(j, 0);
        board.Insert_Random();
        boolean bool = false;
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.getBoard().get(i).get(j) == 2 ||
                        board.getBoard().get(i).get(j) == 4){
                    bool = true;
                    counter += 1;
                }
            }
        }
        assertTrue(counter == 1 && bool);
    }

    @Test
    public void test_endCondition_2048(){
        Random rand = new Random();
        board.getBoard().get(rand.nextInt(4)).set(rand.nextInt(4), 2048);
        assertTrue(board.end_condition_2048());
    }

    @Test
    public void test_moveUp(){
        board.moveUp();
        assertTrue(board.getBoard().get(0).get(0) == 4 &&
                    board.getBoard().get(0).get(2) == 4);
    }

    @Test
    public void test_moveDown(){
        board.moveDown();
        assertTrue(board.getBoard().get(3).get(0) == 4 &&
                board.getBoard().get(3).get(2) == 4);
    }

    @Test
    public void test_moveLeft(){
        board.moveLeft();
        assertTrue(board.getBoard().get(0).get(0) == 4 &&
                board.getBoard().get(2).get(0) == 4);
    }

    @Test
    public void test_moveRight(){
        board.moveRight();
        assertTrue(board.getBoard().get(0).get(3) == 4 &&
                board.getBoard().get(2).get(3) == 4);
    }

    @Test
    public void test_score(){
        board.moveUp();
        assertTrue(board.getScore() == 8);
    }

    @Test
    public void test_isMoveUp(){
        assertTrue(board.is_moveUp());
    }

    @Test
    public void test_isMoveDown(){
        assertTrue(board.is_moveDown());
    }

    @Test
    public void test_isMoveLeft(){
        assertTrue(board.is_moveLeft());
    }

    @Test
    public void test_isMoveRight(){
        assertTrue(board.is_moveRight());
    }

    @Test
    public void test_endCondition_filledBoard(){

        board.getBoard().get(0).set(0,4);
        board.getBoard().get(0).set(1,32);
        board.getBoard().get(0).set(2,8);
        board.getBoard().get(0).set(3,2);

        board.getBoard().get(1).set(0,8);
        board.getBoard().get(1).set(1,4);
        board.getBoard().get(1).set(2,128);
        board.getBoard().get(1).set(3,4);

        board.getBoard().get(2).set(0,2);
        board.getBoard().get(2).set(1,8);
        board.getBoard().get(2).set(2,64);
        board.getBoard().get(2).set(3,16);

        board.getBoard().get(3).set(0,32);
        board.getBoard().get(3).set(1,2);
        board.getBoard().get(3).set(2,16);
        board.getBoard().get(3).set(3,4);

        assertTrue(board.end_condition_filled_board());
    }
}
