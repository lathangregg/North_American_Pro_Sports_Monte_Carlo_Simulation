import java.util.Objects;

public class class_NBAteam implements Comparable<class_NBAteam>{

    // Team properties; does not change
    public String teamName; // Standard Name of MLB Team
    public int teamID; // ID value between 1-30 to reference MLB teams
    public int division; //
    public int conference; // 0 = Eastern, 1 = Western
    public int interleagueRival; // ID of the team's interleague rival

    // Assigned values; changes by season
    public double teamStrength; // randomly assigned value that determines likelihood that a team wins an individual game
    public int strengthRank; // The teams relative strength rank (strongest = 1, weakest = 32)

    // Determined By Simulation
    public int regSeasonW;
    public int regSeasonL;
    public boolean playInResult;
    public boolean r1Result;
    public boolean r2Result;
    public boolean r3Result;
    public boolean ChampResult;

    // Calculated based on season results
    public boolean divisionBestRecord;
    public boolean divisionChamp;
    public boolean playoff; // Does the team make the playoff? - assigned after the regular season is simulated
    public int playoffSeed; // Teams playoff seed
    public int finalStandings; // Where the team finishes in the league
    public int regSeasonRank; // Rank of regular season record

    public class_NBAteam(String teamName, int teamID, int division, int conference) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.division = division;
        this.conference = conference;
    }

    public class_NBAteam() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getConference() {
        return conference;
    }

    public void setConference(int conference) {
        this.conference = conference;
    }

    public int getInterleagueRival() {
        return interleagueRival;
    }

    public void setInterleagueRival(int interleagueRival) {
        this.interleagueRival = interleagueRival;
    }

    public double getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(double teamStrength) {
        this.teamStrength = teamStrength;
    }

    public int getStrengthRank() {
        return strengthRank;
    }

    public void setStrengthRank(int strengthRank) {
        this.strengthRank = strengthRank;
    }

    public int getRegSeasonW() {
        return regSeasonW;
    }

    public void setRegSeasonW(int regSeasonW) {
        this.regSeasonW = regSeasonW;
    }

    public int getRegSeasonL() {
        return regSeasonL;
    }

    public void setRegSeasonL(int regSeasonL) {
        this.regSeasonL = regSeasonL;
    }

    public boolean isPlayInResult() {
        return playInResult;
    }

    public void setPlayInResult(boolean playInResult) {
        this.playInResult = playInResult;
    }

    public boolean isR1Result() {
        return r1Result;
    }

    public void setR1Result(boolean r1Result) {
        this.r1Result = r1Result;
    }

    public boolean isR2Result() {
        return r2Result;
    }

    public void setR2Result(boolean r2Result) {
        this.r2Result = r2Result;
    }

    public boolean isR3Result() {
        return r3Result;
    }

    public void setR3Result(boolean r3Result) {
        this.r3Result = r3Result;
    }

    public boolean isChampResult() {
        return ChampResult;
    }

    public void setChampResult(boolean champResult) {
        ChampResult = champResult;
    }

    public boolean isDivisionBestRecord() {
        return divisionBestRecord;
    }

    public void setDivisionBestRecord(boolean divisionBestRecord) {
        this.divisionBestRecord = divisionBestRecord;
    }

    public boolean isDivisionChamp() {
        return divisionChamp;
    }

    public void setDivisionChamp(boolean divisionChamp) {
        this.divisionChamp = divisionChamp;
    }

    public boolean isPlayoff() {
        return playoff;
    }

    public void setPlayoff(boolean playoff) {
        this.playoff = playoff;
    }

    public int getPlayoffSeed() {
        return playoffSeed;
    }

    public void setPlayoffSeed(int playoffSeed) {
        this.playoffSeed = playoffSeed;
    }

    public int getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(int finalStandings) {
        this.finalStandings = finalStandings;
    }

    public int getRegSeasonRank() {
        return regSeasonRank;
    }

    public void setRegSeasonRank(int regSeasonRank) {
        this.regSeasonRank = regSeasonRank;
    }

    @Override
    public int compareTo(class_NBAteam comparestu) {
        int compareWins = ((class_NBAteam) comparestu).getRegSeasonW();

        //  For Ascending order
        //return this.regSeasonW - compareWins;

        // For Descending order
        return compareWins-this.regSeasonW;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        class_NBAteam that = (class_NBAteam) o;
        return division == that.division && playoffSeed == that.playoffSeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conference, playoffSeed);
    }

    @Override
    public String toString() {
        return "class_NBAteam{" +
                "teamName='" + teamName + '\'' +
                ", teamID=" + teamID +
                ", division=" + division +
                ", conference=" + conference +
                ", interleagueRival=" + interleagueRival +
                ", teamStrength=" + teamStrength +
                ", strengthRank=" + strengthRank +
                ", regSeasonW=" + regSeasonW +
                ", regSeasonL=" + regSeasonL +
                ", playInResult=" + playInResult +
                ", r1Result=" + r1Result +
                ", r2Result=" + r2Result +
                ", r3Result=" + r3Result +
                ", ChampResult=" + ChampResult +
                ", divisionBestRecord=" + divisionBestRecord +
                ", divisionChamp=" + divisionChamp +
                ", playoff=" + playoff +
                ", playoffSeed=" + playoffSeed +
                ", finalStandings=" + finalStandings +
                ", regSeasonRank=" + regSeasonRank +
                '}';
    }
}
