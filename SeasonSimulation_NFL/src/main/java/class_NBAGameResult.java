public class class_NBAGameResult {
    public int gameID;
    public String team1;
    public String team2;
    public String winningTeam;
    public int winningTeamID;

    public class_NBAGameResult(int gameID, String team1, String team2, String winningTeam, int winningTeamID) {
        this.gameID = gameID;
        this.team1 = team1;
        this.team2 = team2;
        this.winningTeam = winningTeam;
        this.winningTeamID = winningTeamID;
    }

    public class_NBAGameResult(String team1, String team2, String winningTeam, int winningTeamID) {
        this.team1 = team1;
        this.team2 = team2;
        this.winningTeam = winningTeam;
        this.winningTeamID = winningTeamID;
    }

    public class_NBAGameResult() {
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getWinningTeam() {
        return winningTeam;
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

    @Override
    public String toString() {
        return "class_NBAGameResult{" +
                "gameID=" + gameID +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", winningTeamID=" + winningTeamID +
                '}';
    }
}
