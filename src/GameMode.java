class GameMode {
    private String playerVsPlayer;
    private String playerVsComputer;

    public GameMode(String playerVsPlayer, String playerVsComputer) {
        this.playerVsPlayer = playerVsPlayer;
        this.playerVsComputer = playerVsComputer;
    }

    public void displayModes() {
        System.out.println("1. " + playerVsPlayer);
        System.out.println("2. " + playerVsComputer);
    }
}
