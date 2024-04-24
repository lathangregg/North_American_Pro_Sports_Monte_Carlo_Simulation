import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import java.util.ArrayList;
import java.util.Random;

public class methods_MLB_general {

    public static void generateMLBTeams(ArrayList<class_MLBteam> teams) {
        // create MLB teams with name, teamid, division, and league
        class_MLBteam team1 = new class_MLBteam("Baltimore Orioles", 1, 0, 0);
        class_MLBteam team2 = new class_MLBteam("Boston Red Sox", 2, 0, 0);
        class_MLBteam team3 = new class_MLBteam("New York Yankees", 3, 0, 0);
        class_MLBteam team4 = new class_MLBteam("Tampa Bay Rays", 4, 0, 0);
        class_MLBteam team5 = new class_MLBteam("Toronto Blue Jays", 5, 0, 0);
        class_MLBteam team6 = new class_MLBteam("Chicago White Sox", 6, 1, 0);
        class_MLBteam team7 = new class_MLBteam("Cleveland Guardians", 7, 1, 0);
        class_MLBteam team8 = new class_MLBteam("Detroit Tigers", 8, 1, 0);
        class_MLBteam team9 = new class_MLBteam("Kansas City Royals", 9, 1, 0);
        class_MLBteam team10 = new class_MLBteam("Minnesota Twins", 10, 1, 0);
        class_MLBteam team11 = new class_MLBteam("Houston Astros", 11, 2, 0);
        class_MLBteam team12 = new class_MLBteam("Los Angeles Angels", 12, 2, 0);
        class_MLBteam team13 = new class_MLBteam("Oakland Athletics", 13, 2, 0);
        class_MLBteam team14 = new class_MLBteam("Seattle Mariners", 14, 2, 0);
        class_MLBteam team15 = new class_MLBteam("Texas Rangers", 15, 2, 0);
        class_MLBteam team16 = new class_MLBteam("Atlanta Braves", 16, 3, 1);
        class_MLBteam team17 = new class_MLBteam("Miami Marlins", 17, 3, 1);
        class_MLBteam team18 = new class_MLBteam("New York Mets", 18, 3, 1);
        class_MLBteam team19 = new class_MLBteam("Philadelphia Phillies", 19, 3, 1);
        class_MLBteam team20 = new class_MLBteam("Washington Nationals", 20, 3, 1);
        class_MLBteam team21 = new class_MLBteam("Chicago Cubs", 21, 4, 1);
        class_MLBteam team22 = new class_MLBteam("Cincinnati Reds", 22, 4, 1);
        class_MLBteam team23 = new class_MLBteam("Milwaukee Brewers", 23, 4, 1);
        class_MLBteam team24 = new class_MLBteam("Pittsburgh Pirates", 24, 4, 1);
        class_MLBteam team25 = new class_MLBteam("St. Louis Cardinals", 25, 4, 1);
        class_MLBteam team26 = new class_MLBteam("Arizona Diamondbacks", 26, 5, 1);
        class_MLBteam team27 = new class_MLBteam("Colorado Rockies", 27, 5, 1);
        class_MLBteam team28 = new class_MLBteam("Los Angeles Dodgers", 28, 5, 1);
        class_MLBteam team29 = new class_MLBteam("San Diego Padres", 29, 5, 1);
        class_MLBteam team30 = new class_MLBteam("San Francisco Giants", 30, 5, 1);

        // add teams to the arraylist
        teams.add(0, team1);
        teams.add(1, team2);
        teams.add(2, team3);
        teams.add(3, team4);
        teams.add(4, team5);
        teams.add(5, team6);
        teams.add(6, team7);
        teams.add(7, team8);
        teams.add(8, team9);
        teams.add(9, team10);
        teams.add(10, team11);
        teams.add(11, team12);
        teams.add(12, team13);
        teams.add(13, team14);
        teams.add(14, team15);
        teams.add(15, team16);
        teams.add(16, team17);
        teams.add(17, team18);
        teams.add(18, team19);
        teams.add(19, team20);
        teams.add(20, team21);
        teams.add(21, team22);
        teams.add(22, team23);
        teams.add(23, team24);
        teams.add(24, team25);
        teams.add(25, team26);
        teams.add(26, team27);
        teams.add(27, team28);
        teams.add(28, team29);
        teams.add(29, team30);

        // Assign interleague rivals
        // Mets-Yankees, Cubs-White Sox, Dodgers-Angels, Giants-Athletics, Reds-Indians, Marlins-Rays, Orioles-Nationals,
        // Royals-Cardinals, Brewers-Twins, Red Sox-Braves, Pirates-Tigers, Phillies-Blue Jays, Rangers-Diamondbacks,
        // Astros-Rockies and Padres-Mariners

        // Mets-Yankees
        team18.setInterleagueRival(3);
        team3.setInterleagueRival(18);

        // Cubs-White Sox
        team21.setInterleagueRival(6);
        team6.setInterleagueRival(21);

        // Dodgers-Angels
        team28.setInterleagueRival(12);
        team12.setInterleagueRival(28);

        // Giants-Athletics
        team30.setInterleagueRival(13);
        team13.setInterleagueRival(30);

        // Reds-Indians
        team22.setInterleagueRival(7);
        team7.setInterleagueRival(22);

        // Marlins-Rays
        team17.setInterleagueRival(5);
        team5.setInterleagueRival(17);

        // Orioles-Nationals
        team2.setInterleagueRival(20);
        team20.setInterleagueRival(2);

        // Royals-Cardinals
        team9.setInterleagueRival(25);
        team25.setInterleagueRival(9);

        // Brewers-Twins
        team23.setInterleagueRival(10);
        team10.setInterleagueRival(23);

        // Red Sox-Braves
        team1.setInterleagueRival(16);
        team16.setInterleagueRival(1);

        // Pirates-Tigers
        team24.setInterleagueRival(11);
        team11.setInterleagueRival(24);

        // Phillies-Blue Jays
        team19.setInterleagueRival(4);
        team4.setInterleagueRival(19);

        // Rangers-Diamondbacks
        team14.setInterleagueRival(26);
        team26.setInterleagueRival(14);

        // Astros-Rockies
        team15.setInterleagueRival(27);
        team27.setInterleagueRival(15);

        // Padres-Mariners
        team29.setInterleagueRival(8);
        team8.setInterleagueRival(29);


    }

    public static void resetMLBSeason(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results, ArrayList<class_MLBteam> sortedTeamsByStrength, ArrayList<class_MLBteam> sortedTeamsByWins, ArrayList<class_MLBteam> sortedTeamsByFinalStanding) {
        // reset the season for all MLB teams
        for (int i = 0; i < 30; i++) {
            teams.get(i).setRegSeasonW(0);
            teams.get(i).setRegSeasonL(0);
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

    public static void assignMLBTeamStrengths(ArrayList<class_MLBteam> teams, int numTeams) {
        // Randomly assign team strengths
        // Distribution of regular season winning percentages should correlate with league
        Random generator = new Random();
        for (int i = 0; i < numTeams; i++) {
            //teams.get(i).setTeamStrength(Math.random());
            teams.get(i).setTeamStrength(generator.nextGaussian()+5);
        }
    }

    public static void generateMLBSchedule(int[][] scheduleMLB, ArrayList<class_MLBteam> teams) {
        // generate the MLB schedule
        // the value of the array represents the number of times the combination of team1 vs team2 games in a season

        // set the schedule to 0
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                scheduleMLB[i][j] = 0;
            }
        }
        // Teams can't play themselves. Change to -1
        for (int i = 0; i < 30; i++) {
            scheduleMLB[i][i] = -1;
        }


        // set the schedule
        // if division is the same, play 13 games

        // the first team in every division plays the other four teams 13 times
        int count = 0; // count to stop when the first team in the division has played all other division teams
        for (int i = 0; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 4) {
                    scheduleMLB[i][j] = 13;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the second team plays every team in the division 13 times except for the first team (already accounted for)
        for (int i = 1; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 3) {
                    scheduleMLB[i][j] = 13;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the third team plays every team in the division 13 times except for the first two teams (already accounted for)
        for (int i = 2; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 2) {
                    scheduleMLB[i][j] = 13;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // the fourth team plays every team in the division 13 times except for the first three teams (already accounted for)
        for (int i = 3; i < 30; i=i+5) {
            count = 0;
            for (int j = i + 1; j < 30; j++) {
                if (count < 1) {
                    scheduleMLB[i][j] = 13;
                    count++;
                }
                else {
                    break;
                }
            }
        }

        // Every team plays their interleague rival 4 times
        // Only assign games for the AL teams
        for (int i = 0; i < 15; i++) {
            scheduleMLB[i][teams.get(i).getInterleagueRival() - 1] = 4;
        }


        // Every team plays remaining opposite league teams 3 times
        for (int i = 0; i < 15; i++) {
            for (int j = 15; j < 30; j++) {
                if (scheduleMLB[i][j] == 0) {
                    scheduleMLB[i][j] = 3;
                }
            }
        }

        // Every team plays non-divisional league teams. Each team plays 6 6-game series and 4 7-game series
        // Set each non-divisional league game number to 6
        for (int i = 0; i < 30; i++) {
            for (int j = i+1; j < 30; j++) {
                if (scheduleMLB[i][j] == 0) {
                    scheduleMLB[i][j] = 6;
                }
            }
        }
        // The first team in each division plays the second and third teams in the other two divisions 7 times
        for (int i = 0; i < 30; i=i+5) {
            for (int j = 1; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
            for (int j = 2; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
        }
        // The second team in each division plays the third and fourth teams in the other two divisions 7 times
        for (int i = 1; i < 30; i=i+5) {
            for (int j = 2; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
            for (int j = 3; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
        }
        // The third team in each division plays the fourth and fifth teams in the other two divisions 7 times
        for (int i = 2; i < 30; i=i+5) {
            for (int j = 3; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
            for (int j = 4; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
        }
        // The fourth team in each division plays the fifth and first team in the other two divisions 7 times
        for (int i = 3; i < 30; i=i+5) {
            for (int j = 4; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
            for (int j = 0; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
        }
        // The fifth team in each division plays the first and second team in the other two divisions 7 times
        for (int i = 4; i < 30; i=i+5) {
            for (int j = 0; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
            for (int j = 1; j < 30; j=j+5) {
                if (scheduleMLB[i][j] == 6) {
                    scheduleMLB[i][j] = 7;
                }
            }
        }


        // print out the schedule as a table
        //System.out.println("MLB Schedule");
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                //System.out.print(scheduleMLB[i][j] + " ");
            }
            //System.out.println();
        }

        // print the number of games each team plays
        for (int i = 0; i < 30; i++) {
            int totalGames = 0;
            for (int j = 0; j < 30; j++) {
                totalGames += scheduleMLB[i][j];
                totalGames += scheduleMLB[j][i];
            }
            //System.out.println("Team " + (i+1) + " plays " + totalGames + " games");
        }

        // print the schedule
        /*for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(scheduleMLB[i][j] + " ");
            }
            System.out.println();
        }*/

    }

    public static void simulateMLBGame(class_MLBteam team1, class_MLBteam team2, ArrayList<class_MLBGameResult> results) {
        // simulate a game between two teams

        // INPUT: 1 classNFL team object for the home team and away team (need correct indexes)
        // Result: Update regSeasonW and regSeasonL for both team objects
        double homeStrength = team1.getTeamStrength(); // home team latent strength value(random value between 0 and 1)
        double awayStrength = team2.getTeamStrength(); // away team latent strength value (random value between 0 and 1)
        double totalStrength = homeStrength + awayStrength; // sum of both teams strength values (random value between 0 and 2)
        double homeStrRank = team1.getStrengthRank(); // home team strength rank
        double awayStrRank = team2.getStrengthRank(); // away team strength rank
        double rankDifference = homeStrRank - awayStrRank; // difference in strength rank between home and away team
        int skill = 10;

       //double homeRelStrength = homeStrength / totalStrength; // percent chance home team has to win
        double awayRelStrength = 0.5 + (skill * rankDifference / 100.0);
        double homeRelStrength = 1 - awayRelStrength; // percent chance away team has to win

        double determineWinner = Math.random(); // Generate a random number between 0 and 1

        if (determineWinner < homeRelStrength) { // if the random number is less than the home team's relative strength, the home team wins
            team1.setRegSeasonW(team1.getRegSeasonW() + 1); // update home team's regular season wins
            team2.setRegSeasonL(team2.getRegSeasonL() + 1); // update away team's regular season losses
            class_MLBGameResult newGame = new class_MLBGameResult(team1.getTeamName(), team2.getTeamName(), team1.getTeamName(), team1.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        } else { // if the random number is greater than the home team's relative strength, the away team wins
            team2.setRegSeasonW(team2.getRegSeasonW() + 1); // update away team's regular season wins
            team1.setRegSeasonL(team1.getRegSeasonL() + 1); // update home team's regular season losses
            class_MLBGameResult newGame = new class_MLBGameResult(team1.getTeamName(), team2.getTeamName(), team2.getTeamName(), team2.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        }

    }

    public static void simulateMLBRegularSeason(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results, int[][] schedule){
        // Each team plays full schedule with wins and losses calculated
        // input: schedule and array list of teams
        // output: Records for every team after regular season
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for(int k = 0; k < schedule[i][j]; k++){
                    simulateMLBGame(teams.get(i), teams.get(j), results);
                }
                }
            }
        }

    public static void determineMLBSeeding(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results){
        // Assign regSeasonRank to each team based on regular season wins
        ArrayList<class_MLBteam> sortedTeams = new ArrayList<class_MLBteam>(teams);
        sortedTeams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());
        for (int i = 0; i < 30; i++) {
            sortedTeams.get(i).setRegSeasonRank(i+1);
        }

        // determine division winners

            // potential winners ArrayList
        ArrayList<class_MLBteam> potentialDivisionWinners = new ArrayList<class_MLBteam>();

            // loop through every division
        int division = 0;
        for (int i = 0; i < 6; i++) {
            int maxWins = 0;
            potentialDivisionWinners.clear();
            // get the number of wins for the team with the most wins in the division
        for (class_MLBteam team : teams) {
            if (team.getDivision() == i){
                if (team.getRegSeasonW() > maxWins) {
                    maxWins = team.getRegSeasonW();
                }
            }
        }
        // add teams with the most wins to the potential winners ArrayList
        for (class_MLBteam team : teams) {
            if (team.getRegSeasonW() == maxWins && team.getDivision() == i){
                potentialDivisionWinners.add(team);
            }
        }
        // call determineDivisionWinners method to set division winner field to true for the division winner
        methods_MLB_support.determineDivisionWinners(potentialDivisionWinners, results);
        }


        // determine the seeding for the division winners
        ArrayList<class_MLBteam> divisionWinnersAmerican = new ArrayList<class_MLBteam>();
        ArrayList<class_MLBteam> divisionWinnersNational = new ArrayList<class_MLBteam>();
        for (class_MLBteam team : teams) {
            if (team.isDivisionChamp()) {
                if (team.getLeague() == 0) {
                    divisionWinnersAmerican.add(team);
                } else {
                    divisionWinnersNational.add(team);
                }
            }
        }
        // call seedDivisionWinners method to set the seed the division winners
        methods_MLB_support.seedDivisionWinners(divisionWinnersAmerican, results);
        methods_MLB_support.seedDivisionWinners(divisionWinnersNational, results);

        // determine the wildcard teams
        ArrayList<class_MLBteam> nonDivisionWinners = new ArrayList<class_MLBteam>();
        for (class_MLBteam team : teams) {
            if (!team.isDivisionChamp()) {
                    nonDivisionWinners.add(team);
            }
        }
        // call seedRemainingTeams method to set the seed for the wildcard teams
        methods_MLB_support.seedRemainingTeams(nonDivisionWinners, results);


    }

    public static void simulateMLBPlayoffs(ArrayList<class_MLBteam> teams, ArrayList<class_MLBGameResult> results){
        // 3 seed plays 6 seed in a best of 3 series
        // 4 seed plays 5 seed in a best of 3 series
        // 1 seed plays winner of 4/5 in a best of 5 series
        // 2 seed plays winner of 3/6 in a best of 5 series
        // winners of 1/4/5 and 2/3/6 play in a best of 7 series
        // winners of each side play in a best of 7 series for the championship

        class_MLBteam AL1Seed = null;
        class_MLBteam AL2Seed = null;
        class_MLBteam AL3Seed = null;
        class_MLBteam AL4Seed = null;
        class_MLBteam AL5Seed = null;
        class_MLBteam AL6Seed = null;
        class_MLBteam NL1Seed = null;
        class_MLBteam NL2Seed = null;
        class_MLBteam NL3Seed = null;
        class_MLBteam NL4Seed = null;
        class_MLBteam NL5Seed = null;
        class_MLBteam NL6Seed = null;

        for (class_MLBteam team : teams) {
            if (team.getPlayoffSeed() == 1 && team.getLeague() == 0) {
                AL1Seed = team;
            } else if (team.getPlayoffSeed() == 2 && team.getLeague() == 0) {
                AL2Seed = team;
            } else if (team.getPlayoffSeed() == 3 && team.getLeague() == 0) {
                AL3Seed = team;
            } else if (team.getPlayoffSeed() == 4 && team.getLeague() == 0) {
                AL4Seed = team;
            } else if (team.getPlayoffSeed() == 5 && team.getLeague() == 0) {
                AL5Seed = team;
            } else if (team.getPlayoffSeed() == 6 && team.getLeague() == 0) {
                AL6Seed = team;
            } else if (team.getPlayoffSeed() == 1 && team.getLeague() == 1) {
                NL1Seed = team;
            } else if (team.getPlayoffSeed() == 2 && team.getLeague() == 1) {
                NL2Seed = team;
            } else if (team.getPlayoffSeed() == 3 && team.getLeague() == 1) {
                NL3Seed = team;
            } else if (team.getPlayoffSeed() == 4 && team.getLeague() == 1) {
                NL4Seed = team;
            } else if (team.getPlayoffSeed() == 5 && team.getLeague() == 1) {
                NL5Seed = team;
            } else if (team.getPlayoffSeed() == 6 && team.getLeague() == 1) {
                NL6Seed = team;
            }
        }

        // if one of the objects is null, print the object name and return
        if(AL1Seed == null){
            System.out.println("Error: AL1Seed not set properly");
            return;
        }
        if(AL2Seed == null){
            System.out.println("Error: AL2Seed not set properly");
            return;
        }
        if(AL3Seed == null){
            System.out.println("Error: AL3Seed not set properly");
            return;
        }
        if(AL4Seed == null){
            System.out.println("Error: AL4Seed not set properly");
            return;
        }
        if(AL5Seed == null){
            System.out.println("Error: AL5Seed not set properly");
            return;
        }
        if(AL6Seed == null){
            System.out.println("Error: AL6Seed not set properly");
            return;
        }
        if(NL1Seed == null){
            System.out.println("Error: NL1Seed not set properly");
            return;
        }
        if(NL2Seed == null){
            System.out.println("Error: NL2Seed not set properly");
            return;
        }
        if(NL3Seed == null){
            System.out.println("Error: NL3Seed not set properly");
            return;
        }
        if(NL4Seed == null){
            System.out.println("Error: NL4Seed not set properly");
            return;
        }
        if(NL5Seed == null){
            System.out.println("Error: NL5Seed not set properly");
            return;
        }
        if(NL6Seed == null){
            System.out.println("Error: NL6Seed not set properly");
            return;
        }


        if(AL1Seed == null || AL2Seed == null || AL3Seed == null || AL4Seed == null || AL5Seed == null || AL6Seed == null || NL1Seed == null || NL2Seed == null || NL3Seed == null || NL4Seed == null || NL5Seed == null || NL6Seed == null){
            System.out.println("Error: Seeds not set properly");
            return;
        }

        // AL Wild Card Games
        class_MLBteam AL_WC1_3v6 = methods_MLB_support.simulatePlayoffSeries(AL3Seed, AL6Seed, results, 3, 1);
        class_MLBteam AL_WC2_4v5 = methods_MLB_support.simulatePlayoffSeries(AL4Seed, AL5Seed, results, 3, 1);

        // NL Wild Card Games
        class_MLBteam NL_WC1_3v6 = methods_MLB_support.simulatePlayoffSeries(NL3Seed, NL6Seed, results, 3, 1);
        class_MLBteam NL_WC2_4v5 = methods_MLB_support.simulatePlayoffSeries(NL4Seed, NL5Seed, results, 3, 1);

        // AL Division Series
        class_MLBteam AL_DS1 = methods_MLB_support.simulatePlayoffSeries(AL1Seed, AL_WC2_4v5, results, 5, 2);
        class_MLBteam AL_DS2 = methods_MLB_support.simulatePlayoffSeries(AL2Seed, AL_WC1_3v6, results, 5, 2);

        // NL Division Series
        class_MLBteam NL_DS1 = methods_MLB_support.simulatePlayoffSeries(NL1Seed, NL_WC2_4v5, results, 5, 2);
        class_MLBteam NL_DS2 = methods_MLB_support.simulatePlayoffSeries(NL2Seed, NL_WC1_3v6, results, 5, 2);

        // Championship Series
        class_MLBteam AL_CS = methods_MLB_support.simulatePlayoffSeries(AL_DS1, AL_DS2, results, 7, 3);
        class_MLBteam NL_CS = methods_MLB_support.simulatePlayoffSeries(NL_DS1, NL_DS2, results, 7, 3);

        // World Series
        class_MLBteam WS = methods_MLB_support.simulatePlayoffSeries(AL_CS, NL_CS, results, 7, 4);

        //System.out.println("World Series Champion: " + WS.getTeamName() + " | Wins: " + WS.getRegSeasonW() + " | " + WS.isChampResult());

    }

    public static void updateMLBResults(ArrayList<class_MLBteam> teams, int[] worldSeriesWinsByRank, int[][] finishingPositionByRank, double[] spearmanRankCorrelationCoefficients, double[] regSznSRC, int currSeason){

        // World Series Wins by Rank
        for(class_MLBteam team : teams){
            if(team.isChampResult()) {
                //System.out.println(team.getTeamName() + " wins: " + team.getRegSeasonW() + " seed: " + team.getPlayoffSeed() + " strength: "+ team.getTeamStrength());
                for (int j = 0; j < teams.size(); j++) {
                    if (team.getStrengthRank() == j+1) {
                        worldSeriesWinsByRank[j]++; // Increments counter for the latent team rank that won the super bowl
                    }
                }
            }
            //System.out.println(team.teamName + " | Division: " + team.getDivision() + " | Division Champ: " + team.isDivisionChamp() +" | Playoff Seed: " + team.getPlayoffSeed()+ " | Wins: " +team.getRegSeasonW());
        }

        // Finishing Position by Rank

        for(int i = 0; i < teams.size(); i++){
            for(int j = 0; j < teams.size(); j++){
                for(class_MLBteam team : teams){
                    if(team.getFinalStandings() == i+1 && team.getStrengthRank() == j+1){
                        finishingPositionByRank[j][i] = finishingPositionByRank[j][i] + 1;
                    }
                }
            }
        }

        // sort teams by regular season wins most to fewest

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
        double spearmanRegSzn = new SpearmansCorrelation().correlation(strengthRank, regSznRank);
        regSznSRC[currSeason] = spearmanRegSzn;

    }

}



