import java.util.Scanner;

class Player {
    private char symbol;
    private String playerName;

    public Player(char symbol) {
        this.symbol = symbol;
        this.playerName = getPlayerNameFromUser();
    }

    public String getPlayerNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public char getSymbol() {
        return symbol;
    }

    public String getPlayerName() {
        return playerName;
    }
}