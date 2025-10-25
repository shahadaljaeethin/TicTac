import java.util.InputMismatchException;
import java.util.Random;
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
*/
 while(true){
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
char someoneWon ='N';
    //1.create new board.
    char[][] board = {
            {'1', '2', '3'}, //board[0] = row #1      [0][1][2] colmn
            {'4', '5', '6'}, //board[1] = row #2
            {'7', '8', '9'}  //board[2] = row #3
    };
    boolean haveWinner=false; //means whether X/O has won.
    while (someoneWon=='N') {
        //2.show the board
        printBoard(board);
        //3.take the input
       board = updateBoard(board);
        //4.check the winner
        someoneWon= haveWinner(board);   }
        //5.return a score!
        print(someoneWon+" has won!\n");
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

public static void  isEmpty(int index,char[][] old)throws Exception{
int[] pairs = getPair(index);
int row = pairs[0], colmn = pairs[1];

if(old[row][colmn]=='X'||old[row][colmn]=='O')
throw new Exception("index "+index+" is already taken,");
}

public static char[][] updateBoard(char[][] old){
//this method to add the player&Computer 's movement. (adds two movement)
char[][] newBoard = old;
Scanner r = new Scanner(System.in);
int index,row,colmn;
int[] pairs;
Random random = new Random();
        print("***(Your turn)***");
        print("\n===================");

    //1.ask the player
        while(true) {
        index=0; //in case of catch
        try {
            print("\nEnter the index:\n");
            index = r.nextInt();
            pairs =  getPair(index);      //may throw exception if index is out of board
            isEmpty(index,old);          //may throw exception if the index is taken.
            //update the board
            row = pairs[0];
            colmn = pairs[1];
            newBoard[row][colmn]='X';
            break;
        }
        catch (InputMismatchException e){print("\nindex must be numbers from the board.\n"); r.nextLine();}
        catch (IndexOutOfBoundsException e){print("\nError in array reading.\n");}
        catch (Exception e){print("\nINDEX ERROR: "+e.getMessage()); r.nextLine(); }
        }
        //2.play the computer
        while(true){
        try{
        index =  random.nextInt(9) +1;
        isEmpty(index,newBoard);//may throw exception if the index is taken
        pairs =  getPair(index);//won't throw since limit always 1-9.
        row = pairs[0];
        colmn = pairs[1];
        newBoard[row][colmn]='O';
        break;
        }catch (Exception e){}//don't show a message just re-choice again.
        }
        return newBoard;

}

public static char haveWinner(char[][] board){
char win = 'N';//N = nobody , X = x won , O = o won.
for(int r=0;r<3;r++){   //winnig in Rows
    if(board[r][0]=='X'&&board[r][1]=='X'&&board[r][2]=='X')  win = 'X';
    else if(board[r][0]=='O'&&board[r][1]=='O'&&board[r][2]=='O')  win = 'O';
}
for(int c=0;c<3;c++){   //winning in Colmns
    if(board[0][c]=='X'&&board[1][c]=='X'&&board[2][c]=='X')  win = 'X';
    else if(board[0][c]=='O'&&board[1][c]=='O'&&board[2][c]=='O')  win = 'O';
}

    if(board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X')  win = 'X'; //1&5&9
    else   if(board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O')  win = 'O';

    if(board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X')  win = 'X'; //3&5&7
    else   if(board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O')  win = 'O';

if(win!='N') {
print("\n!!!******!!!\n");
printBoard(board);}
    return win;
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
            throw new Exception("the entered index out of bound!");
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
