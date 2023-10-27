import java.util.Random;
//La "logica(es aleatoria)" que lleva la computadora para poner su simbolo
class ComputerPlayer {
    private char symbol;
    private String computerName;

    public ComputerPlayer(char symbol, String computerName) {
        this.symbol = symbol;
        this.computerName = computerName;
    }

    public static void makeMove(Board board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(board.getBoardSize());
            col = random.nextInt(board.getBoardSize());
        } while (!board.placeSymbol(row, col, 'O'));
        System.out.println("Pepe the computer ha jugado en la fila " +
                (row + 1) + " y columna " + (col + 1));
    }
}
