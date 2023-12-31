//La clase es para revisar si hay un 3 en raya
class GameLogic {
    public static boolean checkWinner(Board board, char symbol) {
        char[][] gameBoard = board.getBoard();
        int boardSize = board.getBoardSize();

        //Revisa las filas y columnas
        for (int i = 0; i < boardSize; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && 
                    gameBoard[i][2] == symbol) ||
                (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && 
                    gameBoard[2][i] == symbol)) {
                return true;
            }
        }
        //Revisa las diagonales
        return (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && 
                gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol &&
                gameBoard[2][0] == symbol);
    }
}