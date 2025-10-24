import java.util.Scanner;
import java.util.HashMap;

public class main {
    public static void main(String[] args){
    Scanner r = new Scanner(System.in);
    print("Welcome to  Tic Tac Toe game!\nyou will play againts the computer.\n");
    String choice = "Y";
//---------------------------------------------------------
    while(true){
    try {
        print("Type (Y/y) to start a game: ");
        choice = r.next();
        if (!choice.equalsIgnoreCase("y")) break;
        startGame();
    }catch (Exception e){}
    }
    print("\nHope you enjoyed the game.");
    }//main




/*
========================================================================================
========================================================================================
*/
    public static void printBoard(char[][] board){
    int colmn = 0;
        for(int i=0;i<board.length;i++) //rows
         {
             for(int c=colmn;c<(colmn+3);c++)  //colmn
                 print("[" + board[i][c] + "]");

         print("\n-----------\n");

         }

    }

public static int[] getPair(int blockIndex)throws Exception{
int[] pairs = new int[2]; // (x,y) = (row,colmn)
HashMap<Integer,int[]> board = new HashMap<>();
//here is the index with its location in the board array.
    board.put(1,new int[]{0,0});
    board.put(2,new int[]{0,1});
    board.put(3,new int[]{0,2});
    board.put(4,new int[]{1,0});
    board.put(5,new int[]{1,1});
    board.put(6,new int[]{1,2});
    board.put(7,new int[]{2,0});
    board.put(8,new int[]{2,1});
    board.put(9,new int[]{2,2});
            if(blockIndex<=0||blockIndex>=10)
            throw new Exception("the entered index is wrong!");
    pairs = board.get(blockIndex);
    print("="+pairs[0]+","+pairs[1]);
    return pairs;
}
public static void startGame(){
    //create new board.
    char[][] board = {
            {'1', '2', '3'}, //board[0] = row #1      [0][1][2] colmn
            {'4', '5', '6'}, //board[1] = row #2
            {'7', '8', '9'}  //board[2] = row #3
    };


    printBoard(board);

}


    //method for printing shortcut
    static void print(String message){
    System.out.print(message);
    }
}
