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
            System.out.println("¡Empate! El juego ha terminado en empate.");
        } else {
            System.out.println("¡Felicidades! Has ganado.");
        }
    }
}