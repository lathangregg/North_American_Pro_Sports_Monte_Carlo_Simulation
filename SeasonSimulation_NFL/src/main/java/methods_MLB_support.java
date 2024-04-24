import java.util.ArrayList;
import java.util.Collections;

public class methods_MLB_support {

    public static void determineDivisionWinners(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results) {
        // takes in arrayList of teams with potential division winners
        // sets divisionChamp to true for division winners

        ArrayList<class_MLBteam> orderedAL = new ArrayList<>();

        if (teams.size() == 1) {
            teams.get(0).setDivisionChamp(true);
        } else if (teams.size() == 2) {
            orderedAL = twoTeamTiebreaker(teams, results);
            orderedAL.get(0).setDivisionChamp(true);
        }
        else if (teams.size() > 2) {
            orderedAL = multiTeamTiebreaker(teams, results);
            orderedAL.get(0).setDivisionChamp(true);
        }
        else {
            System.out.println("Error: No teams in division");
        }
    }

    public static void seedDivisionWinners(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results) {
        // takes in arrayList of 3 teams division winners
        // assigns a seed 1-3 to each team

        // sort division winners by wins
        // if there is a tie, call tiebreaker
        // assign seeds 1-3 to teams

        ArrayList<class_MLBteam> orderedAL = new ArrayList<>();
        ArrayList<class_MLBteam> tempAL = new ArrayList<>();

        teams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());


        //ToDo: Fix this method to ensure that the seeds are assigned correctly

        if (teams.get(0).getRegSeasonW() == teams.get(1).getRegSeasonW() && teams.get(1).getRegSeasonW() == teams.get(2).getRegSeasonW()) {
            orderedAL = multiTeamTiebreaker(teams, results);
            orderedAL.get(0).setPlayoffSeed(1);
            orderedAL.get(0).setR1Result(true);
            orderedAL.get(1).setPlayoffSeed(2);
            orderedAL.get(1).setR1Result(true);
            orderedAL.get(2).setPlayoffSeed(3);
        }
        else if (teams.get(0).getRegSeasonW() == teams.get(1).getRegSeasonW()) {
            tempAL.add(teams.get(0));
            tempAL.add(teams.get(1));
            teams.get(2).setPlayoffSeed(3);
            orderedAL = twoTeamTiebreaker(tempAL, results);
            orderedAL.get(0).setPlayoffSeed(1);
            orderedAL.get(0).setR1Result(true);
            orderedAL.get(1).setPlayoffSeed(2);
            orderedAL.get(1).setR1Result(true);
        }
        else if (teams.get(1).getRegSeasonW() == teams.get(2).getRegSeasonW()) {
            teams.get(0).setPlayoffSeed(1);
            teams.get(0).setR1Result(true);
            tempAL.add(teams.get(1));
            tempAL.add(teams.get(2));
            orderedAL = twoTeamTiebreaker(tempAL, results);
            orderedAL.get(0).setPlayoffSeed(2);
            orderedAL.get(0).setR1Result(true);
            orderedAL.get(1).setPlayoffSeed(3);
        }
        else {
            teams.get(0).setPlayoffSeed(1);
            teams.get(0).setR1Result(true);
            teams.get(1).setPlayoffSeed(2);
            teams.get(1).setR1Result(true);
            teams.get(2).setPlayoffSeed(3);
        }

    }

    public static void seedRemainingTeams(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results) {
        // takes in arrayList of nonDivisionWinners
        // assigns a seed 4-6 to teams in AL and NL

        // sort nonDivisionWinners by wins
        // if there is a tie, call tiebreaker
        // assign seeds 4-6 to teams

        ArrayList<class_MLBteam> orderedAL = new ArrayList<>();
        ArrayList<class_MLBteam> orderedNL = new ArrayList<>();

        for (class_MLBteam team : teams) {
            if (team.getLeague() == 0) {
                orderedAL.add(team);
            }
            else {
                orderedNL.add(team);
            }
        }
        orderedAL.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());
        orderedNL.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());

        ArrayList<class_MLBteam> tiedTeams = new ArrayList<>();
        ArrayList<class_MLBteam> sortedTiedTeams = new ArrayList<>();

        //ToDo: add tiebreaker for AL and NL
        orderedAL.get(0).setPlayoffSeed(4);
        orderedAL.get(1).setPlayoffSeed(5);
        orderedAL.get(2).setPlayoffSeed(6);
        orderedNL.get(0).setPlayoffSeed(4);
        orderedNL.get(1).setPlayoffSeed(5);
        orderedNL.get(2).setPlayoffSeed(6);

        /*
        int maxWins = 0;

        // if the second team does not have as many wins as the first team, assign seed 4 to the first team and remove from list
        if (orderedAL.get(0).getRegSeasonW() > orderedAL.get(1).getRegSeasonW()) {
            orderedAL.get(0).setPlayoffSeed(4);
        }
        // if the second team has as many wins as the first team, check to see if any other teams are tied and add all teams to the tiedTeams ArrayList
        else {
            maxWins = orderedAL.get(0).getRegSeasonW();
            tiedTeams.add(orderedAL.get(0));
            tiedTeams.add(orderedAL.get(1));
            for (int i = 2; i < orderedAL.size(); i++) {
                if (orderedAL.get(i).getRegSeasonW() == maxWins) {
                    tiedTeams.add(orderedAL.get(i));
                }
                else {
                    break;
                }
            }
            if (tiedTeams.size() == 2) {
                sortedTiedTeams = twoTeamTiebreaker(tiedTeams, results);
                sortedTiedTeams.get(0).setPlayoffSeed(4);
                sortedTiedTeams.get(1).setPlayoffSeed(5);
            }
            else {
                sortedTiedTeams = multiTeamTiebreaker(tiedTeams, results);
                for (int i = 0; i < tiedTeams.size(); i++) {
                    tiedTeams.get(i).setPlayoffSeed(4 + i);
                }
            }
            tiedTeams = multiTeamTiebreaker(tiedTeams, results);
            for (int i = 0; i < tiedTeams.size(); i++) {
                tiedTeams.get(i).setPlayoffSeed(4 + i);
            }
        } */


    }

    public static ArrayList<class_MLBteam> twoTeamTiebreaker(ArrayList<class_MLBteam> tiedTeams, ArrayList<class_MLBGameResult> results) {
        // takes in AL with two tied teams
        // orders AL based on tiebreaker rules
        // returns AL with sorted teams

        return tiedTeams;
    }

    public static ArrayList<class_MLBteam> multiTeamTiebreaker(ArrayList<class_MLBteam> tiedTeams, ArrayList<class_MLBGameResult> results) {
        // takes in AL with three or more tied teams
        // orders AL based on tiebreaker rules
        // returns AL with sorted teams

        return tiedTeams;
    }

    public static class_MLBteam simulatePlayoffSeries(class_MLBteam team1, class_MLBteam team2, ArrayList<class_MLBGameResult> results, int games, int round) {
        // takes in two teams and number of games in series
        // simulates series and returns winner

        int team1Wins = 0;
        int team2Wins = 0;

        for (int i = 0; i < games; i++) {
            if (team1.getTeamStrength() == 0 || team2.getTeamStrength() == 0) {
                System.out.println("Error: Team strength is 0");
                return null;
            }
            methods_MLB_general.simulateMLBGame(team1, team2, results);
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

    public static void strengthRanks(ArrayList<class_MLBteam> teams, ArrayList<class_MLBteam> sortedTeams) {
        // accepts teams AL and sets strengthRank for each team
        // sorts teams AL by teamStrength
        // sets strengthRank for each team
        // sorts teams AL by teamID
        // returns teams AL

        sortedTeams.sort((o1, o2) -> Double.compare(o2.getTeamStrength(), o1.getTeamStrength()));
        int rank = 1;
        for (class_MLBteam team: sortedTeams){
            team.setStrengthRank(rank);
            rank++;
        }
        // Sets the strengthRank for each team in team to the rank of the team in sortedTeams
        for (class_MLBteam team: teams){
            for (class_MLBteam sortedTeam: sortedTeams){
                if (team.getTeamID() == sortedTeam.getTeamID()){
                    team.setStrengthRank(sortedTeam.getStrengthRank());
                }
            }
        }
    }

    public static void duplicateTeamsAL(ArrayList<class_MLBteam> teams, ArrayList<class_MLBteam> sortedTeamsByStrength, ArrayList<class_MLBteam> sortedTeamsByWins, ArrayList<class_MLBteam> sortedTeamsByFinalStanding){
        for(class_MLBteam team: teams){
            sortedTeamsByWins.add(team);
            sortedTeamsByStrength.add(team);
            sortedTeamsByFinalStanding.add(team);
        }
    }

    public static void setFinalRank(ArrayList<class_MLBteam> teams){
        // Assigns final ranks form a list of teams eliminated at the same point in the playoffs

        ArrayList<class_MLBteam> nonPlayoffTeams = new ArrayList<class_MLBteam>();

        // Set Final Ranks for non-playoff teams
        // Assign finishing position for every team who did not make the playoffs
        // Add teams with playoff seeds greater than 7 or less than 1 to arraylist
        for (class_MLBteam team : teams) {
            if (team.getPlayoffSeed() > 6 || team.getPlayoffSeed() < 1) {
                nonPlayoffTeams.add(team);
            }
        }

        Collections.sort(nonPlayoffTeams);
        for (int i = 0; i < nonPlayoffTeams.size(); i++) {
            nonPlayoffTeams.get(i).setFinalStandings(i + 13);
        }

        // Set Final Ranks for playoff teams who lost in the first round

        ArrayList<class_MLBteam> firstRoundLosers = new ArrayList<class_MLBteam>();
        for (class_MLBteam team : teams) {
            if (!team.isR1Result() && team.getPlayoffSeed() <= 6 && team.getPlayoffSeed() >= 1) {
                firstRoundLosers.add(team);
            }
        }

        Collections.sort(firstRoundLosers);
        for (int i = 0; i < firstRoundLosers.size(); i++) {
            firstRoundLosers.get(i).setFinalStandings(i + 9);
        }

        // Set Final Ranks for playoff teams who lost in the second round

        ArrayList<class_MLBteam> secondRoundLosers = new ArrayList<class_MLBteam>();
        for (class_MLBteam team : teams) {
            if (!team.isR2Result() && team.isR1Result()) {
                secondRoundLosers.add(team);
            }
        }

        Collections.sort(secondRoundLosers);
        for (int i = 0; i < secondRoundLosers.size(); i++) {
            secondRoundLosers.get(i).setFinalStandings(i + 5);
        }

        // Set Final Ranks for playoff teams who lost in the conference finals

        ArrayList<class_MLBteam> conferenceFinalsLosers = new ArrayList<class_MLBteam>();
        for (class_MLBteam team : teams) {
            if (!team.isR3Result() && team.isR2Result()) {
                conferenceFinalsLosers.add(team);
            }
        }

        Collections.sort(conferenceFinalsLosers);
        for (int i = 0; i < conferenceFinalsLosers.size(); i++) {
            conferenceFinalsLosers.get(i).setFinalStandings(i + 3);
        }

    }

    public static void seedByStrengthRank(ArrayList<class_MLBteam> teams){
        // Seeds teams by strength rank

        // Create arraylist for each league and sort by strength rank from low to high
        ArrayList<class_MLBteam> sortedTeamsAL = new ArrayList<class_MLBteam>();
        ArrayList<class_MLBteam> sortedTeamsNL = new ArrayList<class_MLBteam>();
        for (class_MLBteam team: teams){
            if (team.getLeague() == 0){
                sortedTeamsAL.add(team);
            }
            else {
                sortedTeamsNL.add(team);
            }
        }

        sortedTeamsAL.sort((o1, o2) -> Integer.compare(o1.getStrengthRank(), o2.getStrengthRank()));
        sortedTeamsNL.sort((o1, o2) -> Integer.compare(o1.getStrengthRank(), o2.getStrengthRank()));

        // Assign seeds to AL teams
        for (int i = 0; i < sortedTeamsAL.size(); i++){
            sortedTeamsAL.get(i).setPlayoffSeed(i + 1);
        }

        // Assign seeds to NL teams
        for (int i = 0; i < sortedTeamsNL.size(); i++){
            sortedTeamsNL.get(i).setPlayoffSeed(i + 1);
        }

    }
}
