import java.util.ArrayList;
import java.util.Collections;

public class methods_NBA_support {

    public static class_NBAteam simulatePlayoffSeries(class_NBAteam team1, class_NBAteam team2, ArrayList<class_NBAGameResult> results, int round) {
        // takes in two teams and number of games in series
        // simulates series and returns winner

        int team1Wins = 0;
        int team2Wins = 0;

        for (int i = 0; i < 7; i++) {
            if (team1.getTeamStrength() == 0 || team2.getTeamStrength() == 0) {
                System.out.println("Error: Team strength is 0");
                return null;
            }
            methods_NBA_general.simulateNBAGame(team1, team2, results);
            if (results.get(results.size() - 1).getWinningTeam() == team1.getTeamName()) {
                team1Wins++;
            }
            else {
                team2Wins++;
            }
        }


        if (team1Wins > team2Wins) {
            if (round == 1) {
                team1.setR1Result(true);
            }
            else if (round == 2) {
                team1.setR2Result(true);
            }
            else if (round == 3) {
                team1.setR3Result(true);
            }
            else if (round == 4) {
                team1.setChampResult(true);
                team1.setFinalStandings(1);
                team2.setFinalStandings(2);
            }
            return team1;
        }
        else {
            if (round == 1) {
                team2.setR1Result(true);
            }
            else if (round == 2) {
                team2.setR2Result(true);
            }
            else if (round == 3) {
                team2.setR3Result(true);
            }
            else if (round == 4) {
                team2.setChampResult(true);
                team2.setFinalStandings(1);
                team1.setFinalStandings(2);
            }
            return team2;
        }
    }

    public static void strengthRanks(ArrayList<class_NBAteam> teams, ArrayList<class_NBAteam> sortedTeams) {
        // accepts teams AL and sets strengthRank for each team
        // sorts teams AL by teamStrength
        // sets strengthRank for each team
        // sorts teams AL by teamID
        // returns teams AL

        sortedTeams.sort((o1, o2) -> Double.compare(o2.getTeamStrength(), o1.getTeamStrength()));
        int rank = 1;
        for (class_NBAteam team: sortedTeams){
            team.setStrengthRank(rank);
            rank++;
        }
        // Sets the strengthRank for each team in team to the rank of the team in sortedTeams
        for (class_NBAteam team: teams){
            for (class_NBAteam sortedTeam: sortedTeams){
                if (team.getTeamID() == sortedTeam.getTeamID()){
                    team.setStrengthRank(sortedTeam.getStrengthRank());
                }
            }
        }
    }

    public static void duplicateTeamsAL(ArrayList<class_NBAteam> teams, ArrayList<class_NBAteam> sortedTeamsByStrength, ArrayList<class_NBAteam> sortedTeamsByWins, ArrayList<class_NBAteam> sortedTeamsByFinalStanding){
        for(class_NBAteam team: teams){
            sortedTeamsByWins.add(team);
            sortedTeamsByStrength.add(team);
            sortedTeamsByFinalStanding.add(team);
        }
    }

    public static void setFinalRank(ArrayList<class_NBAteam> teams){
        // Assigns final ranks form a list of teams eliminated at the same point in the playoffs

        ArrayList<class_NBAteam> nonPlayoffTeams = new ArrayList<class_NBAteam>();

        // Set Final Ranks for non-playoff teams
        // Assign finishing position for every team who did not make the playoffs
        // Add teams with playoff seeds greater than 7 or less than 1 to arraylist
        for (class_NBAteam team : teams) {
            if (team.getPlayoffSeed() > 8 || team.getPlayoffSeed() < 1) {
                nonPlayoffTeams.add(team);
            }
        }

        Collections.sort(nonPlayoffTeams);
        for (int i = 0; i < nonPlayoffTeams.size(); i++) {
            nonPlayoffTeams.get(i).setFinalStandings(i + 17);
        }

        // Set Final Ranks for playoff teams who lost in the first round

        ArrayList<class_NBAteam> firstRoundLosers = new ArrayList<class_NBAteam>();
        for (class_NBAteam team : teams) {
            if (!team.isR1Result() && team.getPlayoffSeed() <= 8 && team.getPlayoffSeed() >= 1) {
                firstRoundLosers.add(team);
            }
        }

        Collections.sort(firstRoundLosers);
        for (int i = 0; i < firstRoundLosers.size(); i++) {
            firstRoundLosers.get(i).setFinalStandings(i + 9);
        }

        // Set Final Ranks for playoff teams who lost in the second round

        ArrayList<class_NBAteam> secondRoundLosers = new ArrayList<class_NBAteam>();
        for (class_NBAteam team : teams) {
            if (!team.isR2Result() && team.isR1Result()) {
                secondRoundLosers.add(team);
            }
        }

        Collections.sort(secondRoundLosers);
        for (int i = 0; i < secondRoundLosers.size(); i++) {
            secondRoundLosers.get(i).setFinalStandings(i + 5);
        }

        // Set Final Ranks for playoff teams who lost in the conference finals

        ArrayList<class_NBAteam> conferenceFinalsLosers = new ArrayList<class_NBAteam>();
        for (class_NBAteam team : teams) {
            if (!team.isR3Result() && team.isR2Result()) {
                conferenceFinalsLosers.add(team);
            }
        }

        Collections.sort(conferenceFinalsLosers);
        for (int i = 0; i < conferenceFinalsLosers.size(); i++) {
            conferenceFinalsLosers.get(i).setFinalStandings(i + 3);
        }


    }

    public static void seedByStrengthRank(ArrayList<class_NBAteam> teams){
        // Assign teams seeds by strength rank

        ArrayList<class_NBAteam> WesternTeams = new ArrayList<class_NBAteam>();
        ArrayList<class_NBAteam> EasternTeams = new ArrayList<class_NBAteam>();

        for (class_NBAteam team : teams){
            if (team.getConference() == 1){
                WesternTeams.add(team);
            }
            else{
                EasternTeams.add(team);
            }
        }

        // Sort teams by strength rank from lowest to highest
        WesternTeams.sort((o1, o2) -> Integer.compare(o1.getStrengthRank(), o2.getStrengthRank()));
        EasternTeams.sort((o1, o2) -> Integer.compare(o1.getStrengthRank(), o2.getStrengthRank()));


        // Assign seeds to Western Conference teams
        for (int i = 0; i < WesternTeams.size(); i++){
            WesternTeams.get(i).setPlayoffSeed(i + 1);
        }

        // Assign seeds to Eastern Conference teams
        for (int i = 0; i < EasternTeams.size(); i++){
            EasternTeams.get(i).setPlayoffSeed(i + 1);
        }

    }
}
