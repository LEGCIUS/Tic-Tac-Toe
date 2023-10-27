//Esta clase da los mensajes de empate o victoria
class GameResult {
    private boolean draw;
    private boolean winner;
    private boolean winnerSymbol;

    public GameResult(boolean draw, boolean winner, boolean winnerSymbol) {
        this.draw = draw;
        this.winner = winner;
        this.winnerSymbol = winnerSymbol;
    }

    public void displayResult() {
        if (draw) {
            System.out.println("¡Empate!");
        } else {
            System.out.println("¡Has ganado!.");
        }
    }
}