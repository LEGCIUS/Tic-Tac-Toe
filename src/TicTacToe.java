import java.util.Scanner;

public class TicTacToe {
    private final String writeName;
    private final Scanner scanner;
    private final Board board;

    public TicTacToe(String selectSymbol, String writeName) {
        this.writeName = writeName;
        this.scanner = new Scanner(System.in);
        this.board = new Board(3); // Tamaño del tablero 3x3 por defecto
    }

    public void chooseGameMode() {
        System.out.println("Selecciona el modo de juego:");
        System.out.println("1. Jugador vs Jugador");
        System.out.println("2. Jugador vs Pepe the computer");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:              
                playAgainstHuman();
                break;

            case 2:
                playAgainstComputer();
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona 1 o 2.");
                chooseGameMode();
                break;
        }
    }

    public void playAgainstHuman() {
        
        System.out.println("Comienza el juego. " + writeName + 
                " (X) vs Jugador 2 (O)");
        boolean playerTurn = true;

        while (!board.isBoardFull() && !GameLogic.checkWinner(board, 'X') 
                && !GameLogic.checkWinner(board, 'O')) {
            board.printBoard();
            System.out.print((playerTurn ? writeName : "Jugador 2") + 
                    ", es tu turno. Ingresa la fila y columna (ej. 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (board.placeSymbol(row, col, (playerTurn ? 'X' : 'O'))) {
                playerTurn = !playerTurn;
            } else {
                System.out.println("Posición ocupada. Intenta de nuevo.");
            }
        }

        board.printBoard();
        if (GameLogic.checkWinner(board, 'X')) {
            System.out.println(writeName + " ¡Felicidades, has ganado!");
        } else if (GameLogic.checkWinner(board, 'O')) {
            System.out.println("Jugador 2 ¡Felicidades, has ganado!");
        } else {
            System.out.println("¡Empate! El juego ha terminado en empate.");
        }
    }

    public void playAgainstComputer() {
        System.out.println("Comienza el juego. " + writeName + 
                " (X) vs Pepe the computer (O)");
        boolean playerTurn = true;

        while (!board.isBoardFull() && !GameLogic.checkWinner(board, 'X') 
                && !GameLogic.checkWinner(board, 'O')) {
            board.printBoard();
            if (playerTurn) {
                System.out.print(writeName + 
                        ", es tu turno. Ingresa la fila y columna (ejemplo. 1 2): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (board.placeSymbol(row, col, 'X')) {
                    playerTurn = false;
                } else {
                    System.out.println("Posición ocupada. Intenta de nuevo.");
                }
            } else {
                ComputerPlayer.makeMove(board);
                playerTurn = true;
            }
        }

        board.printBoard();
        if (GameLogic.checkWinner(board, 'X')) {
            System.out.println(writeName + " ¡Felicidades, has ganado!");
        } else if (GameLogic.checkWinner(board, 'O')) {
            System.out.println("Pepe the computer ¡Felicidades, has ganado!");
        } else {
            System.out.println("¡Empate! El juego ha terminado en empate.");
        }
    }

   public void playGame() {
    try (scanner) {
        boolean playAgain = true;
        
        while (playAgain) {
            chooseGameMode(); // Permite al jugador elegir el modo de juego
            
            board.reset(); // Reinicia el tablero para una nueva partida

            System.out.println("¿Quieres jugar de nuevo? (S/N): ");
            String response = scanner.next().toUpperCase();
            playAgain = response.equals("S");
        }
        
        System.out.println("¡Gracias por jugar! Hasta luego.");
    }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Selecciona el símbolo (X/O): ");
        String symbol = scanner.nextLine();

        System.out.print("Ingresa tu nombre: ");
        String playerName = scanner.nextLine();

        TicTacToe ticTacToe = new TicTacToe(symbol, playerName);
        ticTacToe.playGame();
    }
}