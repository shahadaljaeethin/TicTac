import java.util.Scanner;
import java.util.HashMap;

public class main {
    public static void main(String[] args){
    Scanner r = new Scanner(System.in);
    print("Welcome to  Tic Tac Toe game!\nyou will play againts the computer.\n");
    String choice = "Y";
/* Game loop:
========================================================================================
========================================================================================
*/    while(true){
    try {
        print("Type (Y/y) to start a new game: ");
        choice = r.next();
        if (!choice.equalsIgnoreCase("y")) break;
        //show scores.

        //start new round
        startGame();

        }catch (Exception e){}
    }


    print("\nHope you enjoyed the game.");
    }//main




/* objective methods:
========================================================================================
========================================================================================
*/
public static void startGame(){
    //1.create new board.
    char[][] board = {
            {'1', '2', '3'}, //board[0] = row #1      [0][1][2] colmn
            {'4', '5', '6'}, //board[1] = row #2
            {'7', '8', '9'}  //board[2] = row #3
    };
    boolean haveWinner=false; //means whether X/O has won.

    //2.show the board
    printBoard(board);
    //3.take the input

    //4.check the winner

    //5.return a score!

}

public static void printBoard(char[][] board){
    //this method to print the given board.
        int colmn = 0;
        for(int i=0;i<board.length;i++) //rows
         {
             for(int c=colmn;c<(colmn+3);c++)  //colmn
              print("[" + board[i][c] + "]");

              print("\n-----------\n");
         }}

public static void  isEmpty(int index,char[] old)throws Exception{
int[] pairs = getPair(index);
int row = pairs[0], colmn = pairs[1];

//if(old[row][colmn]!='X');
}

public static char[] updateBoard(char[] old){
//this method to add the player&Computer 's movement. (adds two movement)
char[] newBoard = old;
Scanner r = new Scanner(System.in);
int index,row,colmn;
int[] pairs;
        //1.ask the player
        while(true) {
        try {
            print("\n***X player's turn***\nEnter the index:");
            index = r.nextInt();
            pairs =  getPair(index); //may throw exception if index is out of board
            isEmpty(index,old);          //may throw exception if index is taken.
            //update the board

            break;
        }catch (Exception e){}
        }
        //2.play the computer


        return newBoard;

}

public static int[] getPair(int blockIndex)throws Exception{
    //this method to return pairs of given index for better UX.
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
    return pairs;
}


    /* easier code methods:
    ========================================================================================
    ========================================================================================
    */
    //method for printing shortcut
    static void print(String message){
    System.out.print(message);
    }
}
