package OOPS.TicTacToeGame;

public class Board {
    private char [][] board;
    private int boardSize = 3;
    char p1symbol , p2sysmbol;
    int count;
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;

    public Board(char p1symbol , char p2symbol){
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j]=' ';
            }
        }
        this.p1symbol = p1symbol;
        this.p2sysmbol = p2symbol;
    }

    public int move(char symbol, int x, int y) {
        if(x<0 || x>boardSize || y <0 || y > boardSize || board[x][y] != ' ' ){
            return INVALID;
        }
        board[x][y] = symbol;
        count++;
        //Row
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS ;
        }
        //coloum
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS ;
        }
        //First Diogonal
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS ;
        }
        //Second Diogonal
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS ;
        }

        if(count == boardSize*boardSize){
            return DRAW;
        }

        return INCOMPLETE;

    }

    public void print() {
        System.out.println("-------------------------");
        for(int i = 0 ; i < boardSize ; i++ ){
            for (int j = 0; j < boardSize; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------");
   }
}
