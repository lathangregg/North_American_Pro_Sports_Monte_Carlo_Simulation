public class class_GameResult {
    // This class is used to store the results of each game

    // Variables
        public int gameID;
        public String homeTeam;
        public String awayTeam;
        public int week;
        public String winningTeam;
        public int winningTeamID;
        public String losingTeam;
        public int losingTeamID;

    // Constructors and Getters/Setters
    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public String getLosingTeam() {
        return losingTeam;
    }

    public void setLosingTeam(String losingTeam) {
        this.losingTeam = losingTeam;
    }

    public int getLosingTeamID() {
        return losingTeamID;
    }

    public void setLosingTeamID(int losingTeamID) {
        this.losingTeamID = losingTeamID;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getWinningTeamID() {
        return winningTeamID;
    }

    public void setWinningTeamID(int winningTeamID) {
        this.winningTeamID = winningTeamID;
    }

    public class_GameResult(String homeTeam, String awayTeam, int week, String winningTeam, int winningTeamID, String losingTeam, int losingTeamID) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.week = week;
        this.winningTeam = winningTeam;
        this.winningTeamID = winningTeamID;
        this.losingTeam = losingTeam;
        this.losingTeamID = losingTeamID;
    }

    public class_GameResult() {
    }

    @Override
    public String toString() {
        return "class_GameResult{" +
                "gameID=" + gameID +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", week=" + week +
                ", winningTeam='" + winningTeam + '\'' +
                ", winningTeamID=" + winningTeamID +
                ", losingTeam='" + losingTeam + '\'' +
                ", losingTeamID=" + losingTeamID +
                '}';
    }
}
