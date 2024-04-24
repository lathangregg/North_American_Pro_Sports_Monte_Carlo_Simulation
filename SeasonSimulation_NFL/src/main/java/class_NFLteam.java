import java.util.Objects;

public class class_NFLteam implements Comparable<class_NFLteam>{
    // modify code below this line

    // Team properties; does not change
    public String teamName; // Standard Name of NFL Team
    public int teamID; // ID value between 1-32 to reference NFL teams
    public int division; // 0,4 = East, 1,5 = North, 2,6 = South, 3,7 = West
    public int conference; // 0 = AFC, 1 = NFC

    // Assigned values; changes by season
    public double teamStrength; // randomly assigned value that determines likelihood that a team wins an individual game
    public int strengthRank; // The teams relative strength rank (strongest = 1, weakest = 32)

    // Determined By Simulation
    public int regSeasonW;
    public int regSeasonL;
    public boolean r1Result;
    public boolean r2Result;
    public boolean r3Result;
    public boolean SBResult;

    // Calculated based on season results
    public boolean divisionBestRecord;
    public boolean divisionChamp;
    public boolean playoff; // Does the team make the playoff? - assigned after the regular season is simulated
    public int playoffSeed; // Teams playoff seed
    public int finalRank; // Where the team finishes in the league
    public int regSeasonRank; // Rank of regular season record

    // Variable to help with tiebreakers
    public double tiebreakDouble;

    // Constructors and getters/setters
    public double getTiebreakDouble() {
        return tiebreakDouble;
    }

    public void setTiebreakDouble(double tiebreakDouble) {
        this.tiebreakDouble = tiebreakDouble;
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

    public boolean isSBResult() {
        return SBResult;
    }

    public void setSBResult(boolean SBResult) {
        this.SBResult = SBResult;
    }

    public int getRegSeasonRank() {
        return regSeasonRank;
    }

    public void setRegSeasonRank(int regSeasonRank) {
        this.regSeasonRank = regSeasonRank;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public class_NFLteam(String teamName, int teamID, int division, int conference) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.division = division;
        this.conference = conference;

    }

    public class_NFLteam(String teamName) {
        this.teamName = teamName;
    }

    public class_NFLteam(int conference, int playoffSeed) {
        this.conference = conference;
        this.playoffSeed = playoffSeed;
    }

    // method to compare teams based on regular season wins
    @Override
    public int compareTo(class_NFLteam comparestu) {
        int compareWins = ((class_NFLteam) comparestu).getRegSeasonW();

        //  For Ascending order
        //return this.regSeasonW - compareWins;

        // For Descending order
        return compareWins-this.regSeasonW;

    }

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        class_NFLteam that = (class_NFLteam) o;
        return conference == that.conference && playoffSeed == that.playoffSeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conference, playoffSeed);
    }

    @Override
    public String toString() {
        return "class_NFLteam{" +
                "teamName='" + teamName + '\'' +
                ", teamID=" + teamID +
                ", division=" + division +
                ", conference=" + conference +
                ", teamStrength=" + teamStrength +
                ", strengthRank=" + strengthRank +
                ", regSeasonW=" + regSeasonW +
                ", regSeasonL=" + regSeasonL +
                ", r1Result=" + r1Result +
                ", r2Result=" + r2Result +
                ", r3Result=" + r3Result +
                ", SBResult=" + SBResult +
                ", divisionBestRecord=" + divisionBestRecord +
                ", divisionChamp=" + divisionChamp +
                ", playoff=" + playoff +
                ", playoffSeed=" + playoffSeed +
                ", finalRank=" + finalRank +
                ", regSeasonRank=" + regSeasonRank +
                ", tiebreakDouble=" + tiebreakDouble +
                '}';
    }
}

