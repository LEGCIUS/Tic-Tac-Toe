class Board {
    private final char[][] board;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        // Inicializar el tablero con espacios en blanco
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row >= 0 && row < boardSize && col >= 0 && col < boardSize &&
                board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
//Permite mostrar el tablero en la consola
    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < boardSize - 1) {
                System.out.println("---------");
            }
        }
    }

    public void reset() {
        // Pone el tablero en blanco
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = ' ';
            }
        }
    }
}
