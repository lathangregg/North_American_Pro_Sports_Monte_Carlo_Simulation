import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class methods_NBA_general {

    public static void generateNBATeams(ArrayList<class_NBAteam> teams){

        // Creates an NBA team object for each team and adds it to an array list

        // Atlantic Division
        teams.add(new class_NBAteam("Boston Celtics", 1, 0, 0));
        teams.add(new class_NBAteam("Brooklyn Nets", 2, 0, 0));
        teams.add(new class_NBAteam("New York Knicks", 3, 0, 0));
        teams.add(new class_NBAteam("Philadelphia 76ers", 4, 0, 0));
        teams.add(new class_NBAteam("Toronto Raptors", 5, 0, 0));

        // Central Division
        teams.add(new class_NBAteam("Chicago Bulls", 6, 1, 0));
        teams.add(new class_NBAteam("Cleveland Cavaliers", 7, 1, 0));
        teams.add(new class_NBAteam("Detroit Pistons", 8, 1, 0));
        teams.add(new class_NBAteam("Indiana Pacers", 9, 1, 0));
        teams.add(new class_NBAteam("Milwaukee Bucks", 10, 1, 0));

        // Southeast Division
        teams.add(new class_NBAteam("Atlanta Hawks", 11, 2, 0));
        teams.add(new class_NBAteam("Charlotte Hornets", 12, 2, 0));
        teams.add(new class_NBAteam("Miami Heat", 13, 2, 0));
        teams.add(new class_NBAteam("Orlando Magic", 14, 2, 0));
        teams.add(new class_NBAteam("Washington Wizards", 15, 2, 0));

        // Northwest Division
        teams.add(new class_NBAteam("Denver Nuggets", 16, 3, 1));
        teams.add(new class_NBAteam("Minnesota Timberwolves", 17, 3, 1));
        teams.add(new class_NBAteam("Oklahoma City Thunder", 18, 3, 1));
        teams.add(new class_NBAteam("Portland Trail Blazers", 19, 3, 1));
        teams.add(new class_NBAteam("Utah Jazz", 20, 3, 1));

        // Pacific Division
        teams.add(new class_NBAteam("Golden State Warriors", 21, 4, 1));
        teams.add(new class_NBAteam("Los Angeles Clippers", 22, 4, 1));
        teams.add(new class_NBAteam("Los Angeles Lakers", 23, 4, 1));
        teams.add(new class_NBAteam("Phoenix Suns", 24, 4, 1));
        teams.add(new class_NBAteam("Sacramento Kings", 25, 4, 1));

        // Southwest Division
        teams.add(new class_NBAteam("Dallas Mavericks", 26, 5, 1));
        teams.add(new class_NBAteam("Houston Rockets", 27, 5, 1));
        teams.add(new class_NBAteam("Memphis Grizzlies", 28, 5, 1));
        teams.add(new class_NBAteam("New Orleans Pelicans", 29, 5, 1));
        teams.add(new class_NBAteam("San Antonio Spurs", 30, 5, 1));


    }

    public static void resetNBASeason(ArrayList<class_NBAteam> teams, ArrayList<class_NBAGameResult> results, ArrayList<class_NBAteam> sortedTeamsByStrength, ArrayList<class_NBAteam> sortedTeamsByWins, ArrayList<class_NBAteam> sortedTeamsByFinalStanding) {
        // reset the season
        for (int i = 0; i < 30; i++) {
            teams.get(i).setRegSeasonW(0);
            teams.get(i).setRegSeasonL(0);
            teams.get(i).setPlayInResult(false);
            teams.get(i).setR1Result(false);
            teams.get(i).setR2Result(false);
            teams.get(i).setR3Result(false);
            teams.get(i).setChampResult(false);
            teams.get(i).setDivisionChamp(false);
            //teams.get(i).setDivisionBestRecord(false);
            teams.get(i).setPlayoff(false);
            teams.get(i).setPlayoffSeed(0);
            teams.get(i).setFinalStandings(0);
            teams.get(i).setPlayoffSeed(0);
            teams.get(i).setStrengthRank(0);
        }
        results.clear();
        sortedTeamsByStrength.clear();
        sortedTeamsByWins.clear();
        sortedTeamsByFinalStanding.clear();
    }

    public static void assignNBATeamStrengths(ArrayList<class_NBAteam> teams){
        for (class_NBAteam team : teams) {
            team.setTeamStrength(Math.random());
        }
    }

    public static void generateNBASchedule(int[][] schedule){
        // Generates the NBA schedule

        // Sets the default value to 0
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                schedule[i][j] = 0;
            }
        }

        // each team plays 4 games against each team in their division
            // the first team in each division plays the other 4 teams in their division 4 times
        int count = 0;

        for (int i = 0; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 4) {
                    schedule[i][j] = 4;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the second team plays every team in the division 4 times except for the first team (already accounted for)
        for (int i = 1; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 3) {
                    schedule[i][j] = 4;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the third team plays every team in the division 4 times except for the first two teams (already accounted for)
        for (int i = 2; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 2) {
                    schedule[i][j] = 4;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the fourth team plays every team in the division 4 times except for the first three teams (already accounted for)
        for (int i = 3; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 1) {
                    schedule[i][j] = 4;
                    count++;
                }
                else {
                    break;
                }
            }
        }

        // every team plays teams in the opposite conference twice
        for (int i = 0; i < 15; i++) {
            for (int j = 15; j < 30; j++) {
                if (schedule[i][j] == 0) {
                    schedule[i][j] = 2;
                }
            }
        }
        // every team plays teams in the same conference but different division 3 times
        for (int i = 0; i < 30; i++) {
            for (int j = i+1; j < 30; j++) {
                if (schedule[i][j] == 0) {
                    schedule[i][j] = 3;
                }
            }
        }

        // every team plays six non-divisional league opponents 4 times
        // The first team plays the second, third, and fourth teams in the other 2 divisions 4
        for (int i = 0; i < 30; i=i+5) {
            for (int j = 1; j < 30; j=j+5) { //second team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 2; j < 30; j=j+5) { //third team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 3; j < 30; j=j+5) { //fourth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
        }

        // The second team plays the fifth, first, and second teams in the other 2 divisions 4
        for (int i = 1; i < 30; i=i+5) {
            for (int j = 4; j < 30; j=j+5) { //fifth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 0; j < 30; j=j+5) { //first team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 1; j < 30; j=j+5) { //second team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
        }

        // The third team plays the third, fourth, and fifth teams in the other 2 divisions 4
        for (int i = 2; i < 30; i=i+5) {
            for (int j = 2; j < 30; j=j+5) { //third team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 3; j < 30; j=j+5) { //fourth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 4; j < 30; j=j+5) { //fifth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
        }

        // The fourth team plays the first, second, and third teams in the other 2 divisions 4
        for (int i = 3; i < 30; i=i+5) {
            for (int j = 0; j < 30; j=j+5) { //first team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 1; j < 30; j=j+5) { //second team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 2; j < 30; j=j+5) { //third team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
        }

        // the fifth team plays the fourth, fifth, and first teams in the other 2 divisions 4
        for (int i = 4; i < 30; i=i+5) {
            for (int j = 3; j < 30; j=j+5) { //fourth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 4; j < 30; j=j+5) { //fifth team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
            for (int j = 0; j < 30; j=j+5) { //first team in the other 2 divisions
                if (schedule[i][j] == 3) {
                    schedule[i][j] = 4;
                }
            }
        }

        // print the number of games each team plays
        for (int i = 0; i < 30; i++) {
            int numGames = 0;
            for (int j = 0; j < 30; j++) {
                //numGames = numGames + schedule[i][j];
                //numGames = numGames + schedule[j][i];
            }
            //System.out.println("Team " + i + " plays " + numGames + " games.");
        }
        // print the schedule array
        /*for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(schedule[i][j] + " ");
            }
            System.out.println();
        }*/

    }

    public static void simulateNBAGame(class_NBAteam team1, class_NBAteam team2, ArrayList<class_NBAGameResult> results) {
        // simulate a game between two teams
        // INPUT: 1 classNFL team object for the home team and away team (need correct indexes)
        // Result: Update regSeasonW and regSeasonL for both team objects
        double homeStrength = team1.getTeamStrength(); // home team latent strength value(random value between 0 and 1)
        double awayStrength = team2.getTeamStrength(); // away team latent strength value (random value between 0 and 1)
        double totalStrength = homeStrength + awayStrength; // sum of both teams strength values (random value between 0 and 2)
        int homeStrRank = team1.getStrengthRank(); // home team strength rank
        int awayStrRank = team2.getStrengthRank(); // away team strength rank
        int rankDifference = homeStrRank - awayStrRank; // difference in strength rank between the two teams
        int skill = 10;

        //double homeRelStrength = homeStrength / totalStrength; // percent chance home team has to win
        double awayRelStrength = 0.5 + (skill * rankDifference / 100.0);
        double homeRelStrength = 1 - awayRelStrength; // percent chance away team has to win

        double determineWinner = Math.random(); // Generate a random number between 0 and 1

        if (determineWinner < homeRelStrength) { // if the random number is less than the home team's relative strength, the home team wins
            team1.setRegSeasonW(team1.getRegSeasonW() + 1); // update home team's regular season wins
            team2.setRegSeasonL(team2.getRegSeasonL() + 1); // update away team's regular season losses
            class_NBAGameResult newGame = new class_NBAGameResult(team1.getTeamName(), team2.getTeamName(), team1.getTeamName(), team1.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        } else { // if the random number is greater than the home team's relative strength, the away team wins
            team2.setRegSeasonW(team2.getRegSeasonW() + 1); // update away team's regular season wins
            team1.setRegSeasonL(team1.getRegSeasonL() + 1); // update home team's regular season losses
            class_NBAGameResult newGame = new class_NBAGameResult(team1.getTeamName(), team2.getTeamName(), team2.getTeamName(), team2.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        }

    }

    public static void simulateNBARegularSeason(ArrayList<class_NBAteam> teams, ArrayList<class_NBAGameResult> results, int[][] schedule){
    // simulate the NBA regular season
        // INPUT: 1 array list of classNFL team objects, 1 array list of classNFL game result objects, 1 2D array of the schedule
        // Result: Update the regular season wins and losses for each team object, add game results to the results array list
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for(int k = 0; k < schedule[i][j]; k++){
                    simulateNBAGame(teams.get(i), teams.get(j), results);
                }
            }
        }
    }

    public static void determineNBASeeding(ArrayList<class_NBAteam> teams, ArrayList<class_NBAGameResult> results){
        // Assign regSeasonRank to each team based on regular season wins
        ArrayList<class_NBAteam> sortedTeams = new ArrayList<class_NBAteam>(teams);
        sortedTeams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());
        for (int i = 0; i < 30; i++) {
            sortedTeams.get(i).setRegSeasonRank(i+1);
        }


        // determine the seeding for the NBA playoffs
        // ToDo: Handle tiebreakers
        // ToD: Handle play-in tournament

        // The top 8 teams by regular season wins in each conference make the playoffs
        ArrayList<class_NBAteam> eastTeams = new ArrayList<class_NBAteam>();
        ArrayList<class_NBAteam> westTeams = new ArrayList<class_NBAteam>();

        for (class_NBAteam team: teams){
            if (team.getConference() == 0) {
                eastTeams.add(team);
            } else {
                westTeams.add(team);
            }
        }

        // sort the teams by regular season wins
        eastTeams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());
        westTeams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());

        // determine the playoff seeding
        for (int i = 0; i < 10; i++) {
            eastTeams.get(i).setPlayoffSeed(i + 1);
            westTeams.get(i).setPlayoffSeed(i + 1);
        }

    }

    public static void simulateNBAPlayIn(ArrayList<class_NBAteam> teams, ArrayList<class_NBAGameResult> results){

        // simulate the NBA play-in tournament
        // INPUT: 1 array list of classNFL team objects
        // Result: Assign seeds 7 and 8 in each conference

        class_NBAteam east7 = null;
        class_NBAteam east8 = null;
        class_NBAteam east9 = null;
        class_NBAteam east10 = null;
        class_NBAteam west7 = null;
        class_NBAteam west8 = null;
        class_NBAteam west9 = null;
        class_NBAteam west10 = null;

        for (class_NBAteam team: teams){
            if (team.getPlayoffSeed() == 7 && team.getConference() == 0){
                east7 = team;
            } else if (team.getPlayoffSeed() == 8 && team.getConference() == 0){
                east8 = team;
            } else if (team.getPlayoffSeed() == 9 && team.getConference() == 0){
                east9 = team;
            } else if (team.getPlayoffSeed() == 10 && team.getConference() == 0){
                east10 = team;
            } else if (team.getPlayoffSeed() == 7 && team.getConference() == 1){
                west7 = team;
            } else if (team.getPlayoffSeed() == 8 && team.getConference() == 1){
                west8 = team;
            } else if (team.getPlayoffSeed() == 9 && team.getConference() == 1){
                west9 = team;
            } else if (team.getPlayoffSeed() == 10 && team.getConference() == 1){
                west10 = team;
            }
        }
        assert east7 != null;
        assert east8 != null;
        assert east9 != null;
        assert east10 != null;
        assert west7 != null;
        assert west8 != null;
        assert west9 != null;
        assert west10 != null;

        // simulate the play-in tournament
        class_NBAteam game1Winner = null;
        class_NBAteam game1Loser = null;
        class_NBAteam game2Winner = null;

        simulateNBAGame(east7, east8, results);
        if (results.get(results.size() - 1).getWinningTeam().equals(east7.getTeamName())){
            game1Winner = east7;
            game1Loser = east8;
        } else {
            game1Winner = east8;
            game1Loser = east7;
        }
        simulateNBAGame(east9, east10, results);
        if (results.get(results.size() - 1).getWinningTeam().equals(east9.getTeamName())){
            game2Winner = east9;
            east10.setPlayoffSeed(0);
        } else {
            game2Winner = east10;
            east9.setPlayoffSeed(0);
        }
        game1Winner.setPlayoffSeed(7);
        simulateNBAGame(game1Loser, game2Winner, results);
        if (results.get(results.size() - 1).getWinningTeam().equals(game1Loser.getTeamName())){
            game1Loser.setPlayoffSeed(8);
            game2Winner.setPlayoffSeed(0);
        } else {
            game2Winner.setPlayoffSeed(8);
            game1Loser.setPlayoffSeed(0);
        }

    }

    public static void simulateNBAPlayoffs(ArrayList<class_NBAteam> teams, ArrayList<class_NBAGameResult> results) {

        class_NBAteam east1 = null;
        class_NBAteam east2 = null;
        class_NBAteam east3 = null;
        class_NBAteam east4 = null;
        class_NBAteam east5 = null;
        class_NBAteam east6 = null;
        class_NBAteam east7 = null;
        class_NBAteam east8 = null;

        class_NBAteam west1 = null;
        class_NBAteam west2 = null;
        class_NBAteam west3 = null;
        class_NBAteam west4 = null;
        class_NBAteam west5 = null;
        class_NBAteam west6 = null;
        class_NBAteam west7 = null;
        class_NBAteam west8 = null;

        for (int i = 0; i < 30; i++) {
            if (teams.get(i).getPlayoffSeed() == 1 && teams.get(i).getConference() == 0) {
                east1 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 2 && teams.get(i).getConference() == 0) {
                east2 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 3 && teams.get(i).getConference() == 0) {
                east3 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 4 && teams.get(i).getConference() == 0) {
                east4 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 5 && teams.get(i).getConference() == 0) {
                east5 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 6 && teams.get(i).getConference() == 0) {
                east6 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 7 && teams.get(i).getConference() == 0) {
                east7 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 8 && teams.get(i).getConference() == 0) {
                east8 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 1 && teams.get(i).getConference() == 1) {
                west1 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 2 && teams.get(i).getConference() == 1) {
                west2 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 3 && teams.get(i).getConference() == 1) {
                west3 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 4 && teams.get(i).getConference() == 1) {
                west4 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 5 && teams.get(i).getConference() == 1) {
                west5 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 6 && teams.get(i).getConference() == 1) {
                west6 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 7 && teams.get(i).getConference() == 1) {
                west7 = teams.get(i);
            } else if (teams.get(i).getPlayoffSeed() == 8 && teams.get(i).getConference() == 1) {
                west8 = teams.get(i);
            }

        }

        // simulate the NBA playoffs

        // Round 1
        class_NBAteam east_R1_1v8 = methods_NBA_support.simulatePlayoffSeries(east1, east8, results, 1);
        class_NBAteam east_R1_2v7 = methods_NBA_support.simulatePlayoffSeries(east2, east7, results, 1);
        class_NBAteam east_R1_3v6 = methods_NBA_support.simulatePlayoffSeries(east3, east6, results, 1);
        class_NBAteam east_R1_4v5 = methods_NBA_support.simulatePlayoffSeries(east4, east5, results, 1);

        class_NBAteam west_R1_1v8 = methods_NBA_support.simulatePlayoffSeries(west1, west8, results, 1);
        class_NBAteam west_R1_2v7 = methods_NBA_support.simulatePlayoffSeries(west2, west7, results, 1);
        class_NBAteam west_R1_3v6 = methods_NBA_support.simulatePlayoffSeries(west3, west6, results, 1);
        class_NBAteam west_R1_4v5 = methods_NBA_support.simulatePlayoffSeries(west4, west5, results, 1);

        // Round 2
        class_NBAteam east_R2_1v4 = methods_NBA_support.simulatePlayoffSeries(east_R1_1v8, east_R1_4v5, results, 2);
        class_NBAteam east_R2_2v3 = methods_NBA_support.simulatePlayoffSeries(east_R1_2v7, east_R1_3v6, results, 2);

        class_NBAteam west_R2_1v4 = methods_NBA_support.simulatePlayoffSeries(west_R1_1v8, west_R1_4v5, results, 2);
        class_NBAteam west_R2_2v3 = methods_NBA_support.simulatePlayoffSeries(west_R1_2v7, west_R1_3v6, results, 2);

        // Round 3
        class_NBAteam east_R3 = methods_NBA_support.simulatePlayoffSeries(east_R2_1v4, east_R2_2v3, results, 3);
        class_NBAteam west_R3 = methods_NBA_support.simulatePlayoffSeries(west_R2_1v4, west_R2_2v3, results, 3);

        // Round 4
        class_NBAteam NBAChampion = methods_NBA_support.simulatePlayoffSeries(east_R3, west_R3, results, 4);
    }

    public static void updateNBAResults(ArrayList<class_NBAteam> teams, int[] finalsWinsByRank, int[][] finishingPositionByRank, double[] spearmanRankCorrelationCoefficients, double[] regSznSCR, int currSeason){

        // Finals wins by rank
        for(class_NBAteam team : teams){
            if(team.isChampResult()) {
                //System.out.println(team.getTeamName() + " wins: " + team.getRegSeasonW() + " seed: " + team.getPlayoffSeed() + " strength: "+ team.getTeamStrength());
                for (int j = 0; j < teams.size(); j++) {
                    if (team.getStrengthRank() == j+1) {
                        finalsWinsByRank[j]++; // Increments counter for the latent team rank that won the super bowl
                    }
                }
            }
            //System.out.println(team.teamName + " | Division: " + team.getDivision() + " | Division Champ: " + team.isDivisionChamp() +" | Playoff Seed: " + team.getPlayoffSeed()+ " | Wins: " +team.getRegSeasonW());
        }

        // Finishing position by rank
        for(int i = 0; i < teams.size(); i++){
            for(int j = 0; j < teams.size(); j++){
                for(class_NBAteam team : teams){
                    if(team.getFinalStandings() == i+1 && team.getStrengthRank() == j+1){
                        finishingPositionByRank[j][i] = finishingPositionByRank[j][i] + 1;
                    }
                }
            }
        }

        // Spearman's rank correlation coefficient to compare the rank of the teams by strength and their final rank
        double[] strengthRank = new double[teams.size()];
        double[] finalRank = new double[teams.size()];
        double[] regSznRank = new double[teams.size()];
        for(int i = 0; i < teams.size(); i++){
            strengthRank[i] = teams.get(i).getStrengthRank();
            finalRank[i] = teams.get(i).getFinalStandings();
            regSznRank[i] = teams.get(i).getRegSeasonRank();
        }

        // Calculate the correlation coefficient
        double spearman = new SpearmansCorrelation().correlation(strengthRank, finalRank);
        spearmanRankCorrelationCoefficients[currSeason] = spearman;
        double spearmanRegSzn = new SpearmansCorrelation().correlation(regSznRank, finalRank);
        regSznSCR[currSeason] = spearmanRegSzn;
    }
}
