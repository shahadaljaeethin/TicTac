import java.util.*;
public class TicTacProject {
    public static void main(String[] args){
        char[][] board = {
                {'-', '-', '#'}, //board[0] = row #1      [0][1][2] colmn
                {'-', '-', '#'}, //board[1] = row #2
                {'-', '-', '#'}  //board[2] = row #3
        };
        print(""+board[0][0]+"|"+board[0][1]+"|");
        print("------");
/*
        |       |
--------|-------|-------
        |       |
        |       |


 */
    }


    static void print(String message){
        System.out.println(message);
    }
}
