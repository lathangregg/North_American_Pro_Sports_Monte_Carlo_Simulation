import jsl.utilities.random.rvariable.DEmpiricalRV;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import java.util.Random;

public class methods_general {

    // NFL or shared methods
    public static void generateNFLTeams(ArrayList<class_NFLteam> teams) {
        // Takes an arraylist of class_NFLteam items and populates it with team information
        class_NFLteam team1 = new class_NFLteam("Buffalo Bills", 1, 0, 0);
        class_NFLteam team2 = new class_NFLteam("Miami Dolphins", 2, 0, 0);
        class_NFLteam team3 = new class_NFLteam("New England Patriots", 3, 0, 0);
        class_NFLteam team4 = new class_NFLteam("New York Jets", 4, 0, 0);
        class_NFLteam team5 = new class_NFLteam("Baltimore Ravens", 5, 1, 0);
        class_NFLteam team6 = new class_NFLteam("Cincinnati Bengals", 6, 1, 0);
        class_NFLteam team7 = new class_NFLteam("Cleveland Browns", 7, 1, 0);
        class_NFLteam team8 = new class_NFLteam("Pittsburgh Steelers", 8, 1, 0);
        class_NFLteam team9 = new class_NFLteam("Houston Texans", 9, 2, 0);
        class_NFLteam team10 = new class_NFLteam("Indianapolis Colts", 10, 2, 0);
        class_NFLteam team11 = new class_NFLteam("Jacksonville Jaguars", 11, 2, 0);
        class_NFLteam team12 = new class_NFLteam("Tennessee Titans", 12, 2, 0);
        class_NFLteam team13 = new class_NFLteam("Denver Broncos", 13, 3, 0);
        class_NFLteam team14 = new class_NFLteam("Kansas City Chiefs", 14, 3, 0);
        class_NFLteam team15 = new class_NFLteam("Las Vegas Raiders", 15, 3, 0);
        class_NFLteam team16 = new class_NFLteam("Los Angeles Chargers", 16, 3, 0);
        class_NFLteam team17 = new class_NFLteam("Dallas Cowboys", 17, 4, 1);
        class_NFLteam team18 = new class_NFLteam("New York Giants", 18, 4, 1);
        class_NFLteam team19 = new class_NFLteam("Philadelphia Eagles", 19, 4, 1);
        class_NFLteam team20 = new class_NFLteam("Washington Commanders", 20, 4, 1);
        class_NFLteam team21 = new class_NFLteam("Minnesota Vikings", 21, 5, 1);
        class_NFLteam team22 = new class_NFLteam("Chicago Bears", 22, 5, 1);
        class_NFLteam team23 = new class_NFLteam("Detroit Lions", 23, 5, 1);
        class_NFLteam team24 = new class_NFLteam("Green Bay Packers", 24, 5, 1);
        class_NFLteam team25 = new class_NFLteam("Atlanta Falcons", 25, 6, 1);
        class_NFLteam team26 = new class_NFLteam("Carolina Panthers", 26, 6, 1);
        class_NFLteam team27 = new class_NFLteam("New Orleans Saints", 27, 6, 1);
        class_NFLteam team28 = new class_NFLteam("Tampa Bay Buccaneers", 28, 6, 1);
        class_NFLteam team29 = new class_NFLteam("Arizona Cardinals", 29, 7, 1);
        class_NFLteam team30 = new class_NFLteam("Los Angeles Rams", 30, 7, 1);
        class_NFLteam team31 = new class_NFLteam("San Francisco 49ers", 31, 7, 1);
        class_NFLteam team32 = new class_NFLteam("Seattle Seahawks", 32, 7, 1);


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
        teams.add(30, team31);
        teams.add(31, team32);
    }

    public static void resetSeason(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results, ArrayList<class_NFLteam> sortedTeamsByStrength, ArrayList<class_NFLteam> sortedTeamsByWins, ArrayList<class_NFLteam> sortedTeamsByFinalStanding) {
        // Reset season statistics for each team
        for (int i = 0; i < 32; i++) {
            teams.get(i).setRegSeasonW(0);
            teams.get(i).setRegSeasonL(0);
            teams.get(i).setR1Result(false);
            teams.get(i).setR2Result(false);
            teams.get(i).setR3Result(false);
            teams.get(i).setSBResult(false);
            teams.get(i).setDivisionChamp(false);
            teams.get(i).setDivisionBestRecord(false);
            teams.get(i).setPlayoff(false);
            teams.get(i).setPlayoffSeed(0);
            teams.get(i).setFinalRank(0);
            teams.get(i).setPlayoffSeed(0);
        }
        results.clear();
        sortedTeamsByStrength.clear();
        sortedTeamsByWins.clear();
        sortedTeamsByFinalStanding.clear();
    }

    public static void assignTeamStrengths(ArrayList<class_NFLteam> teams, int numTeams) {
        // Randomly assign team strengths
        // Distribution of regular season winning percentages should correlate with league
        Random generator = new Random();
        for (int i = 0; i < numTeams; i++) {
            //teams.get(i).setTeamStrength(Math.random());
            teams.get(i).setTeamStrength(generator.nextGaussian());
        }
    }

    public static void generateSchedule(int[][][] schedule) {
        // Should correlate with general scheduling guidelines of leagues
        // output 17x32x32 3D matrix with 1 if home team hosts away team in a week

        for (int n = 1; n < schedule.length; n++) { // number of weeks
            for (int h = 1; h < schedule[n].length; h++) { // home team
                for (int a = 1; a < schedule[n][h].length; a++) { // away team
                    schedule[n][h][a] = 0;
                }
            }
        }

        // Seahawks Home Games
        schedule[0][31][12] = 1;
        schedule[2][31][24] = 1;
        schedule[5][31][28] = 1;
        schedule[7][31][17] = 1;
        schedule[11][31][14] = 1;
        schedule[13][31][25] = 1;
        schedule[14][31][30] = 1;
        schedule[16][31][3] = 1;
        schedule[17][31][29] = 1;

// 49ers Home Games
        schedule[1][30][31] = 1;
        schedule[3][30][29] = 1;
        schedule[6][30][13] = 1;
        schedule[9][30][15] = 1;
        schedule[11][30][26] = 1;
        schedule[12][30][1] = 1;
        schedule[13][30][27] = 1;
        schedule[15][30][19] = 1;
        schedule[17][30][28] = 1;

// Rams Home Games
        schedule[0][29][0] = 1;
        schedule[1][29][24] = 1;
        schedule[4][29][16] = 1;
        schedule[5][29][25] = 1;
        schedule[7][29][30] = 1;
        schedule[9][29][28] = 1;
        schedule[12][29][31] = 1;
        schedule[13][29][14] = 1;
        schedule[15][29][12] = 1;

// Cardinals Home Games
        schedule[0][28][13] = 1;
        schedule[2][28][29] = 1;
        schedule[4][28][18] = 1;
        schedule[6][28][26] = 1;
        schedule[8][28][31] = 1;
        schedule[10][28][30] = 1; // Neutral Site
        schedule[11][28][15] = 1;
        schedule[13][28][2] = 1;
        schedule[15][28][27] = 1;

// Buccs Home Games
        schedule[2][27][23] = 1;
        schedule[3][27][13] = 1;
        schedule[4][27][24] = 1;
        schedule[7][27][4] = 1;
        schedule[8][27][29] = 1;
        schedule[9][27][31] = 1; // Neutral Site
        schedule[12][27][26] = 1;
        schedule[14][27][5] = 1;
        schedule[16][27][25] = 1;

// Saints Home Games
        schedule[1][26][27] = 1;
        schedule[4][26][31] = 1;
        schedule[5][26][5] = 1;
        schedule[7][26][14] = 1;
        schedule[8][26][4] = 1;
        schedule[10][26][29] = 1;
        schedule[14][26][24] = 1;
        schedule[17][26][25] = 1;

// Panthers Home Games
        schedule[0][25][6] = 1;
        schedule[2][25][26] = 1;
        schedule[3][25][28] = 1;
        schedule[4][25][30] = 1;
        schedule[6][25][27] = 1;
        schedule[9][25][24] = 1;
        schedule[11][25][12] = 1;
        schedule[14][25][7] = 1;
        schedule[15][25][22] = 1;

// Falcons Home Games
        schedule[0][24][26] = 1;
        schedule[3][24][6] = 1;
        schedule[5][24][30] = 1;
        schedule[7][24][25] = 1;
        schedule[8][24][15] = 1;
        schedule[10][24][21] = 1;
        schedule[12][24][7] = 1;
        schedule[16][24][28] = 1;
        schedule[17][24][27] = 1;

// Packers Home Games
        schedule[1][23][21] = 1;
        schedule[3][23][2] = 1;
        schedule[4][23][17] = 1; // Neutral Site
        schedule[5][23][3] = 1;
        schedule[9][23][16] = 1;
        schedule[10][23][11] = 1;
        schedule[14][23][29] = 1;
        schedule[16][23][20] = 1;
        schedule[17][23][22] = 1;

// Lions Home Games
        schedule[0][22][18] = 1;
        schedule[1][22][19] = 1;
        schedule[3][22][31] = 1;
        schedule[7][22][1] = 1;
        schedule[8][22][23] = 1;
        schedule[11][22][0] = 1;
        schedule[12][22][10] = 1;
        schedule[13][22][20] = 1;
        schedule[16][22][21] = 1;

// Bears Home Games
        schedule[0][21][30] = 1;
        schedule[2][21][8] = 1;
        schedule[5][21][19] = 1;
        schedule[8][21][1] = 1;
        schedule[9][21][22] = 1;
        schedule[12][21][23] = 1;
        schedule[14][21][18] = 1;
        schedule[15][21][0] = 1;
        schedule[17][21][20] = 1;

// Vikings Home Games
        schedule[0][20][23] = 1;
        schedule[2][20][22] = 1;
        schedule[3][20][26] = 1; // Neutral Site
        schedule[4][20][21] = 1;
        schedule[7][20][28] = 1;
        schedule[10][20][16] = 1;
        schedule[11][20][2] = 1;
        schedule[12][20][3] = 1;
        schedule[14][20][9] = 1;
        schedule[15][20][17] = 1;

// Commanders Home Games
        schedule[0][19][10] = 1;
        schedule[2][19][18] = 1;
        schedule[4][19][11] = 1;
        schedule[6][19][23] = 1;
        schedule[8][19][20] = 1;
        schedule[11][19][24] = 1;
        schedule[14][19][17] = 1;
        schedule[16][19][6] = 1;
        schedule[17][19][16] = 1;

// Eagles Home Games
        schedule[1][18][20] = 1;
        schedule[3][18][10] = 1;
        schedule[5][18][16] = 1;
        schedule[7][18][7] = 1;
        schedule[9][18][19] = 1;
        schedule[11][18][23] = 1;
        schedule[12][18][11] = 1;
        schedule[16][18][26] = 1;
        schedule[17][18][17] = 1;

// Giants Home Games
        schedule[1][17][25] = 1;
        schedule[2][17][16] = 1;
        schedule[3][17][21] = 1;
        schedule[5][17][4] = 1;
        schedule[9][17][8] = 1;
        schedule[10][17][22] = 1;
        schedule[12][17][19] = 1;
        schedule[13][17][18] = 1;
        schedule[16][17][9] = 1;

// Cowboys Home Games
        schedule[0][16][27] = 1;
        schedule[1][16][5] = 1;
        schedule[3][16][19] = 1;
        schedule[6][16][22] = 1;
        schedule[7][16][21] = 1;
        schedule[11][16][17] = 1;
        schedule[12][16][9] = 1;
        schedule[13][16][8] = 1;
        schedule[15][16][18] = 1;

// Chargers Home Games
        schedule[0][15][14] = 1;
        schedule[2][15][10] = 1;
        schedule[5][15][12] = 1;
        schedule[6][15][31] = 1;
        schedule[10][15][13] = 1;
        schedule[13][15][1] = 1;
        schedule[14][15][11] = 1;
        schedule[16][15][29] = 1;

// Raiders Home Games
        schedule[1][14][28] = 1;
        schedule[3][14][12] = 1;
        schedule[6][14][8] = 1;
        schedule[9][14][9] = 1;
        schedule[12][14][15] = 1;
        schedule[14][14][2] = 1;
        schedule[16][14][30] = 1;
        schedule[17][14][13] = 1;

// Chiefs Home Games
        schedule[1][13][15] = 1;
        schedule[4][13][14] = 1;
        schedule[5][13][0] = 1;
        schedule[8][13][11] = 1;
        schedule[9][13][10] = 1;
        schedule[11][13][29] = 1;
        schedule[15][13][31] = 1;
        schedule[16][13][12] = 1;

// Broncos Home Games
        schedule[1][12][8] = 1;
        schedule[2][12][30] = 1;
        schedule[4][12][9] = 1;
        schedule[6][12][3] = 1;
        schedule[10][12][14] = 1;
        schedule[13][12][13] = 1;
        schedule[14][12][28] = 1;
        schedule[17][12][15] = 1;

// Titans Home Games
        schedule[0][11][17] = 1;
        schedule[2][11][14] = 1;
        schedule[6][11][9] = 1;
        schedule[9][11][12] = 1;
        schedule[11][11][5] = 1;
        schedule[13][11][10] = 1;
        schedule[15][11][8] = 1;
        schedule[16][11][16] = 1;

// Jaguars Home Games
        schedule[1][10][9] = 1;
        schedule[4][10][8] = 1;
        schedule[6][10][17] = 1;
        schedule[7][10][12] = 1;
        schedule[8][10][14] = 1;
        schedule[11][10][4] = 1;
        schedule[14][10][16] = 1;
        schedule[17][10][11] = 1;

// Colts Home Games
        schedule[2][9][13] = 1;
        schedule[3][9][11] = 1;
        schedule[5][9][10] = 1;
        schedule[7][9][19] = 1;
        schedule[10][9][18] = 1;
        schedule[11][9][7] = 1;
        schedule[15][9][15] = 1;
        schedule[17][9][8] = 1;

// Texans Home Games
        schedule[0][8][9] = 1;
        schedule[3][8][15] = 1;
        schedule[7][8][11] = 1;
        schedule[8][8][18] = 1;
        schedule[10][8][19] = 1;
        schedule[12][8][6] = 1;
        schedule[14][8][13] = 1;
        schedule[16][8][10] = 1;

//Steelers Home Games
        schedule[1][7][2] = 1;
        schedule[3][7][3] = 1;
        schedule[5][7][27] = 1;
        schedule[9][7][26] = 1;
        schedule[10][7][5] = 1;
        schedule[13][7][4] = 1;
        schedule[15][7][14] = 1;
        schedule[17][7][6] = 1;

// Browns Home Games
        schedule[1][6][3] = 1;
        schedule[2][6][7] = 1;
        schedule[4][6][15] = 1;
        schedule[5][6][2] = 1;
        schedule[7][6][5] = 1;
        schedule[10][6][0] = 1;
        schedule[11][6][27] = 1;
        schedule[14][6][4] = 1;
        schedule[15][6][26] = 1;


// Bengals Home Games
        schedule[0][5][7] = 1;
        schedule[3][5][1] = 1;
        schedule[6][5][24] = 1;
        schedule[8][5][25] = 1;
        schedule[12][5][13] = 1;
        schedule[13][5][6] = 1;
        schedule[16][5][0] = 1;
        schedule[17][5][4] = 1;

// Ravens Home Games
        schedule[1][4][1] = 1;
        schedule[3][4][0] = 1;
        schedule[4][4][5] = 1;
        schedule[6][4][6] = 1;
        schedule[10][4][25] = 1;
        schedule[12][4][12] = 1;
        schedule[15][4][24] = 1;
        schedule[16][4][7] = 1;

// Jets Home Games
        schedule[0][3][4] = 1;
        schedule[2][3][5] = 1;
        schedule[4][3][1] = 1;
        schedule[7][3][2] = 1;
        schedule[8][3][0] = 1;
        schedule[11][3][21] = 1;
        schedule[14][3][22] = 1;
        schedule[15][3][10] = 1;

// Patriots Home Games
        schedule[2][2][4] = 1;
        schedule[4][2][22] = 1;
        schedule[6][2][21] = 1;
        schedule[8][2][9] = 1;
        schedule[10][2][3] = 1;
        schedule[12][2][0] = 1;
        schedule[15][2][5] = 1;
        schedule[16][2][1] = 1;

// Dolphins Home Games
        schedule[0][1][2] = 1;
        schedule[2][1][0] = 1;
        schedule[5][1][20] = 1;
        schedule[6][1][7] = 1;
        schedule[9][1][6] = 1;
        schedule[11][1][8] = 1;
        schedule[15][1][23] = 1;
        schedule[17][1][3] = 1;


// Bills Home Games
        schedule[1][0][11] = 1;
        schedule[4][0][7] = 1;
        schedule[7][0][23] = 1;
        schedule[9][0][20] = 1;
        schedule[13][0][3] = 1;
        schedule[14][0][1] = 1;
        schedule[17][0][2] = 1;


        // create a 2 dimensional array with the number of games between each team and print the array
        int[][] gamesBetweenTeams = new int[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                gamesBetweenTeams[i][j] = 0;
            }
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                for (int k = 0; k < 18; k++) {
                    if (schedule[k][i][j] == 1) {
                        gamesBetweenTeams[i][j]++;
                    }
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (j > i) {
                    System.out.print(gamesBetweenTeams[i][j] + gamesBetweenTeams[j][i] + " ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }


    public static void simulateGame(class_NFLteam homeTeam, class_NFLteam awayTeam, ArrayList<class_GameResult> results, int week) {
        //public static void simulateGame(class_NFLteam homeTeam, class_NFLteam awayTeam, ArrayList<class_GameResult> results, int week, int gameID){
        // INPUT: 1 classNFL team object for the home team and away team (need correct indexes)
        // Result: Update regSeasonW and regSeasonL for both team objects
        double homeStrength = homeTeam.getTeamStrength(); // home team latent strength value(random value between 0 and 1)
        double awayStrength = awayTeam.getTeamStrength(); // away team latent strength value (random value between 0 and 1)
        double totalStrength = homeStrength + awayStrength; // sum of both teams strength values (random value between 0 and 2)
        int homeStrengthRank = homeTeam.getStrengthRank(); // home team's strength rank
        int awayStrengthRank = awayTeam.getStrengthRank(); // away team's strength rank
        int skill = 10;
        int rankDifference = homeStrengthRank - awayStrengthRank; // difference in strength rank between home and away team

        //double homeRelStrength = homeStrength / totalStrength; // percent chance home team has to win
        double awayRelStrength = 0.5 + (skill * rankDifference / 100.0);
        double homeRelStrength = 1 - awayRelStrength; // percent chance away team has to win

        double determineWinner = Math.random(); // Generate a random number between 0 and 1

        if (determineWinner < homeRelStrength) { // if the random number is less than the home team's relative strength, the home team wins
            homeTeam.setRegSeasonW(homeTeam.getRegSeasonW() + 1); // update home team's regular season wins
            awayTeam.setRegSeasonL(awayTeam.getRegSeasonL() + 1); // update away team's regular season losses
            class_GameResult newGame = new class_GameResult(homeTeam.getTeamName(), awayTeam.getTeamName(), week, homeTeam.getTeamName(), homeTeam.teamID, awayTeam.teamName, awayTeam.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        } else { // if the random number is greater than the home team's relative strength, the away team wins
            awayTeam.setRegSeasonW(awayTeam.getRegSeasonW() + 1); // update away team's regular season wins
            homeTeam.setRegSeasonL(homeTeam.getRegSeasonL() + 1); // update home team's regular season losses
            class_GameResult newGame = new class_GameResult(homeTeam.getTeamName(), awayTeam.getTeamName(), week, awayTeam.getTeamName(), awayTeam.teamID, homeTeam.teamName, homeTeam.teamID); // create a new game result object
            results.add(newGame); // add the new game result object to the results array list
        }


        /*
        double[] outcomes = {0,1}; // 0 = home team wins, 1 = away team wins
        double[] cdf = {homeRelStrength, 1};

        // Create a discrete empirical random variable
        DEmpiricalRV dRV = new DEmpiricalRV(outcomes, cdf);

        double winner = dRV.getValue();
        if (winner == 0){ // if home team wins
            homeTeam.setRegSeasonW(homeTeam.getRegSeasonW() + 1);
            awayTeam.setRegSeasonL(awayTeam.getRegSeasonL() + 1);
            class_GameResult newGame = new class_GameResult(homeTeam.getTeamName(), awayTeam.getTeamName(), week, homeTeam.getTeamName(), homeTeam.teamID);
            //class_GameResult newGame = new class_GameResult(gameID, homeTeam.getTeamName(), awayTeam.getTeamName(), week, homeTeam.getTeamName(), homeTeam.teamID);
            results.add(newGame);
            //System.out.println("The winner of game " + gameNum + " is: " + teamA.getTeamName());
        }
        else if(winner == 1){ // if away team wins
            homeTeam.setRegSeasonL(homeTeam.getRegSeasonL() + 1);
            awayTeam.setRegSeasonW(awayTeam.getRegSeasonW() + 1);
            class_GameResult newGame = new class_GameResult(homeTeam.getTeamName(), awayTeam.getTeamName(), week, awayTeam.getTeamName(), awayTeam.teamID);
            results.add(newGame);
            //System.out.println("The winner of game " + gameNum + " is: " + teamB.getTeamName());
        }
        else{
            System.out.println("Error. Problem in win assignment loops");
        } */
    }

    public static void simulateRegularSeason(ArrayList<class_NFLteam> teams, int[][][] schedule, ArrayList<class_GameResult> results) {
        // Each team plays full schedule with wins and losses calculated
        // input: schedule and array list of teams
        // output: Records for every team after regular season

        int gameID = 0;
        for (int n = 0; n < schedule.length; n++) { // for every week
            for (int h = 0; h < schedule[n].length; h++) { // for every potential home team
                for (int a = 0; a < schedule[n][h].length; a++) { // for every potential opponent
                    if (schedule[n][h][a] == 1) {
                        simulateGame(teams.get(h), teams.get(a), results, n + 1);
                        // simulateGame(teams.get(h), teams.get(a), results, n);
                        //gameID = gameID + 1;
                    }
                }
            }
        }
        // System.out.println("test");
        //results.clear();
    }

    public static void determineSeeding(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results) {
        // Assign regSeasonRank to each team based on regular season wins
        ArrayList<class_NFLteam> sortedTeams = new ArrayList<>(teams);
        sortedTeams.sort((team1, team2) -> team2.getRegSeasonW() - team1.getRegSeasonW());
        for (int i = 0; i < 32; i++) {
            sortedTeams.get(i).setRegSeasonRank(i+1);
        }

        // takes AL of teams and AL of games and sets the teams seeds (playoffTeam) and playoff boolean
        // clear the arraylists of playoff teams and playoff games

        ArrayList<class_NFLteam> NfcDivChampsAL = new ArrayList<>();
        ArrayList<class_NFLteam> AfcDivChampsAL = new ArrayList<>();
        ArrayList<class_NFLteam> nonPlayoffTeams = new ArrayList<>();

        // determine division champs
        methods_support.determineDivisionChamps(teams, results); //takes AL of teams and assigns divisionChamp boolean

        // seed division champs

        // add division champs to arraylist of division champs
        for (int i = 0; i < 2; i++) {
            for (class_NFLteam team : teams) {
                if (team.getConference() == i && team.isDivisionChamp()) {
                    if (i == 0) {
                        AfcDivChampsAL.add(team);
                    }
                    if (i == 1) {
                        NfcDivChampsAL.add(team);
                    }
                }
            }
        }

        // sort division champs based on number of wins
        Collections.sort(NfcDivChampsAL); // sorts division champs by number of wins
        Collections.sort(AfcDivChampsAL); // sorts division champs by number of wins
        // ToDo: Call tiebreaker if teams have equal wins

        for (int i = 0; i < 4; i++) {
            NfcDivChampsAL.get(i).setPlayoffSeed(i + 1); // assign seeds to division champs
            AfcDivChampsAL.get(i).setPlayoffSeed(i + 1);
        }

        // seed remaining teams
        /*for (int i = 0; i < 2; i++) {
            for (int j = 5; j < 31; j++) {
                if (j < 8) {
                    // ToDo: Only seed top 8
                    for (class_NFLteam team : teams) {
                        if (!team.isDivisionChamp() && team.getConference() == i) {
                            team.setPlayoffSeed(j);
                            j++;
                        }
                    }
                }
            }
        }*/

        // Assign seeds 5-7 to non-division champs with most wins in each Conference. All other teams assigned -1 for playoff seed.
        // If teams are tied, add tied teams to arraylist and call tiebreaker method
        ArrayList<class_NFLteam> AfcWildCardAL = new ArrayList<>();
        ArrayList<class_NFLteam> NfcWildCardAL = new ArrayList<>();
        for (class_NFLteam team : teams) {
            if (!team.isDivisionChamp() && team.getConference() == 0) {
                AfcWildCardAL.add(team);
            }
            if (!team.isDivisionChamp() && team.getConference() == 1) {
                NfcWildCardAL.add(team);
            }
        }
        //
        methods_support.sortWithTiebreakers(AfcWildCardAL, results);
        methods_support.sortWithTiebreakers(NfcWildCardAL, results);

        for (int i = 0; i < 3; i++) {
            //AfcWildCardAL.get(i).setPlayoffSeed(i + 5);
        }
        for (int i = 0; i < 3; i++) {
            //NfcWildCardAL.get(i).setPlayoffSeed(i + 5);
        }

        // Assign finishing position for every team who did not make the playoffs
        // Add teams with playoff seeds greater than 7 or less than 1 to arraylist
        for (class_NFLteam team : teams) {
            if (team.getPlayoffSeed() > 7 || team.getPlayoffSeed() < 1) {
                nonPlayoffTeams.add(team);
            }
        }

        Collections.sort(nonPlayoffTeams);
        for (int i = 0; i < nonPlayoffTeams.size(); i++) {
            nonPlayoffTeams.get(i).setFinalRank(i + 15);
        }

    }

    public static void simulateFirstRound(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results) {

        ArrayList<class_NFLteam> R1Losers = new ArrayList<>();

        // create team objects to store teams from each seed

        class_NFLteam Afc1 = null;
        class_NFLteam Afc2 = null;
        class_NFLteam Afc3 = null;
        class_NFLteam Afc4 = null;
        class_NFLteam Afc5 = null;
        class_NFLteam Afc6 = null;
        class_NFLteam Afc7 = null;
        class_NFLteam Nfc1 = null;
        class_NFLteam Nfc2 = null;
        class_NFLteam Nfc3 = null;
        class_NFLteam Nfc4 = null;
        class_NFLteam Nfc5 = null;
        class_NFLteam Nfc6 = null;
        class_NFLteam Nfc7 = null;

        // assign each team to the seed
        for (class_NFLteam team : teams) {
            if (team.playoffSeed == 1 && team.getConference() == 0) {
                Afc1 = team;
            } else if (team.playoffSeed == 2 && team.getConference() == 0) {
                Afc2 = team;
            } else if (team.playoffSeed == 3 && team.getConference() == 0) {
                Afc3 = team;
            } else if (team.playoffSeed == 4 && team.getConference() == 0) {
                Afc4 = team;
            } else if (team.playoffSeed == 5 && team.getConference() == 0) {
                Afc5 = team;
            } else if (team.playoffSeed == 6 && team.getConference() == 0) {
                Afc6 = team;
            } else if (team.playoffSeed == 7 && team.getConference() == 0) {
                Afc7 = team;
            }
            if (team.playoffSeed == 1 && team.getConference() == 1) {
                Nfc1 = team;
            } else if (team.playoffSeed == 2 && team.getConference() == 1) {
                Nfc2 = team;
            } else if (team.playoffSeed == 3 && team.getConference() == 1) {
                Nfc3 = team;
            } else if (team.playoffSeed == 4 && team.getConference() == 1) {
                Nfc4 = team;
            } else if (team.playoffSeed == 5 && team.getConference() == 1) {
                Nfc5 = team;
            } else if (team.playoffSeed == 6 && team.getConference() == 1) {
                Nfc6 = team;
            } else if (team.playoffSeed == 7 && team.getConference() == 1) {
                Nfc7 = team;
            }

        }

        // have teams play the round games

        Afc1.setR1Result(true);
        if (Afc2 != null && Afc7 != null) {
            simulateGame(Afc2, Afc7, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Afc2.getTeamName(), winningTeam)) {
                Afc2.setR1Result(true);
                R1Losers.add(Afc7);
            }
            if (Objects.equals(Afc7.getTeamName(), winningTeam)) {
                Afc7.setR1Result(true);
                R1Losers.add(Afc2);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        if (Afc3 != null && Afc6 != null) {
            simulateGame(Afc3, Afc6, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Afc3.getTeamName(), winningTeam)) {
                Afc3.setR1Result(true);
                R1Losers.add(Afc6);
            }
            if (Objects.equals(Afc6.getTeamName(), winningTeam)) {
                Afc6.setR1Result(true);
                R1Losers.add(Afc3);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        if (Afc4 != null && Afc5 != null) {
            simulateGame(Afc4, Afc5, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Afc4.getTeamName(), winningTeam)) {
                Afc4.setR1Result(true);
                R1Losers.add(Afc5);
            }
            if (Objects.equals(Afc5.getTeamName(), winningTeam)) {
                Afc5.setR1Result(true);
                R1Losers.add(Afc4);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        Nfc1.setR1Result(true);
        if (Nfc2 != null && Nfc7 != null) {
            simulateGame(Nfc2, Nfc7, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Nfc2.getTeamName(), winningTeam)) {
                Nfc2.setR1Result(true);
                R1Losers.add(Nfc7);
            }
            if (Objects.equals(Nfc7.getTeamName(), winningTeam)) {
                Nfc7.setR1Result(true);
                R1Losers.add(Nfc2);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        if (Nfc3 != null && Nfc6 != null) {
            simulateGame(Nfc3, Nfc6, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Nfc3.getTeamName(), winningTeam)) {
                Nfc3.setR1Result(true);
                R1Losers.add(Nfc6);
            }
            if (Objects.equals(Nfc6.getTeamName(), winningTeam)) {
                Nfc6.setR1Result(true);
                R1Losers.add(Nfc3);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        if (Nfc4 != null && Nfc5 != null) {
            simulateGame(Nfc4, Nfc5, results, 19);
            String winningTeam = results.get(results.size() - 1).getWinningTeam();
            if (Objects.equals(Nfc4.getTeamName(), winningTeam)) {
                Nfc4.setR1Result(true);
                R1Losers.add(Nfc5);
            }
            if (Objects.equals(Nfc5.getTeamName(), winningTeam)) {
                Nfc5.setR1Result(true);
                R1Losers.add(Nfc4);
            }
        } else {
            System.out.println("Required teams not found.");
        }

        // Assign finishing positions to the teams that lost in the first round
        Collections.sort(R1Losers);
        for (int i = 0; i < R1Losers.size(); i++) {
            R1Losers.get(i).setFinalRank(9 + i);
        }

    }

    public static void simulateSecondRound(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results) {
        ArrayList<Integer> AfcSeedsR2 = new ArrayList<>(); // seeds of the AFC teams that advanced to the second round
        ArrayList<Integer> NfcSeedsR2 = new ArrayList<>(); // seeds of the NFC teams that advanced to the second round
        ArrayList<class_NFLteam> R2Losers = new ArrayList<>(); // teams that lost in the second round

        for (class_NFLteam team : teams) {
            if (team.getConference() == 0 && team.isR1Result()) {
                AfcSeedsR2.add(team.getPlayoffSeed()); // add the seed of the team that advanced to the second round
            }
            if (team.getConference() == 1 && team.isR1Result()) {
                NfcSeedsR2.add(team.getPlayoffSeed()); // add the seed of the team that advanced to the second round
            }
        }
        Collections.sort(AfcSeedsR2);
        Collections.sort(NfcSeedsR2);

        class_NFLteam topAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR2.get(0)))); // get the team with the top seed that advanced to the second round from the AFC
        class_NFLteam secAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR2.get(1))));
        class_NFLteam thAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR2.get(2))));
        class_NFLteam lastAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR2.get(3))));

        class_NFLteam topNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR2.get(0))));
        class_NFLteam secNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR2.get(1))));
        class_NFLteam thNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR2.get(2))));
        class_NFLteam lastNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR2.get(3))));

        // Simulate games
        String winningTeam;
        // top seed vs lowest seeds
        // AFC
        simulateGame(topAfcSeed, lastAfcSeed, results, 20);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(topAfcSeed.getTeamName(), winningTeam)) {
            topAfcSeed.setR2Result(true);
            R2Losers.add(lastAfcSeed);
        }
        if (Objects.equals(lastAfcSeed.getTeamName(), winningTeam)) {
            lastAfcSeed.setR2Result(true);
            R2Losers.add(topAfcSeed);
        }
        // NFC
        simulateGame(topNfcSeed, lastNfcSeed, results, 20);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(topNfcSeed.getTeamName(), winningTeam)) {
            topNfcSeed.setR2Result(true);
            R2Losers.add(lastNfcSeed);
        }
        if (Objects.equals(lastNfcSeed.getTeamName(), winningTeam)) {
            lastNfcSeed.setR2Result(true);
            R2Losers.add(topNfcSeed);
        }

        // Middle seeds
        // AFC
        simulateGame(secAfcSeed, thAfcSeed, results, 20);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(secAfcSeed.getTeamName(), winningTeam)) {
            secAfcSeed.setR2Result(true);
            R2Losers.add(thAfcSeed);
        }
        if (Objects.equals(thAfcSeed.getTeamName(), winningTeam)) {
            thAfcSeed.setR2Result(true);
            R2Losers.add(secAfcSeed);
        }
        // NFC
        simulateGame(secNfcSeed, thNfcSeed, results, 20);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(secNfcSeed.getTeamName(), winningTeam)) {
            secNfcSeed.setR2Result(true);
            R2Losers.add(thNfcSeed);
        }
        if (Objects.equals(thNfcSeed.getTeamName(), winningTeam)) {
            thNfcSeed.setR2Result(true);
            R2Losers.add(secNfcSeed);
        }

        // Assign final rank for losing teams
        Collections.sort(R2Losers);
        R2Losers.get(0).setFinalRank(5);
        R2Losers.get(1).setFinalRank(6);
        R2Losers.get(2).setFinalRank(7);
        R2Losers.get(3).setFinalRank(8);

        /*for(Integer seed : AfcSeedsR2){
            //System.out.println(seed);
            if(seed == 2){
                twoSeeds++;
            }
        }
        for(Integer seed : NfcSeedsR2){
            //System.out.println(seed);
            if(seed == 2){
                twoSeeds++;
            }
        } */
    }

    public static void simulateThirdRound(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results) {
        ArrayList<Integer> AfcSeedsR3 = new ArrayList<>();
        ArrayList<Integer> NfcSeedsR3 = new ArrayList<>();
        ArrayList<class_NFLteam> R3Losers = new ArrayList<>();

        for (class_NFLteam team : teams) {
            if (team.getConference() == 0 && team.isR2Result()) {
                AfcSeedsR3.add(team.getPlayoffSeed());
            }
            if (team.getConference() == 1 && team.isR2Result()) {
                NfcSeedsR3.add(team.getPlayoffSeed());
            }
        }
        Collections.sort(AfcSeedsR3);
        Collections.sort(NfcSeedsR3);

        class_NFLteam topAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR3.get(0))));
        class_NFLteam secAfcSeed = teams.get(teams.indexOf(new class_NFLteam(0, AfcSeedsR3.get(1))));

        class_NFLteam topNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR3.get(0))));
        class_NFLteam secNfcSeed = teams.get(teams.indexOf(new class_NFLteam(1, NfcSeedsR3.get(1))));

        // Simulate games
        String winningTeam;
        // AFC
        simulateGame(topAfcSeed, secAfcSeed, results, 21);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(topAfcSeed.getTeamName(), winningTeam)) {
            topAfcSeed.setR3Result(true);
            R3Losers.add(secAfcSeed);
        }
        if (Objects.equals(secAfcSeed.getTeamName(), winningTeam)) {
            secAfcSeed.setR3Result(true);
            R3Losers.add(topAfcSeed);
        }
        // NFC
        simulateGame(topNfcSeed, secNfcSeed, results, 21);
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        if (Objects.equals(topNfcSeed.getTeamName(), winningTeam)) {
            topNfcSeed.setR3Result(true);
            R3Losers.add(secNfcSeed);
        }
        if (Objects.equals(secNfcSeed.getTeamName(), winningTeam)) {
            secNfcSeed.setR3Result(true);
            R3Losers.add(topNfcSeed);
        }

        // assign finishing position to losers
        // sort losers by wins highest to lowest
        Collections.sort(R3Losers);
        R3Losers.get(0).setFinalRank(3);
        R3Losers.get(1).setFinalRank(4);

    }

    public static void simulateFinalRound(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results) {
        ArrayList<Integer> AfcSeedsR4 = new ArrayList<>();
        ArrayList<Integer> NfcSeedsR4 = new ArrayList<>();
        class_NFLteam afcChamp = null;
        class_NFLteam nfcChamp = null;


        for (class_NFLteam team : teams) {
            if (team.getConference() == 0 && team.isR3Result()) {
                //AfcSeedsR4.add(team.getPlayoffSeed());
                afcChamp = team;
            }
            if (team.getConference() == 1 && team.isR3Result()) {
                nfcChamp = team;
            }
        }

        assert afcChamp != null;
        assert nfcChamp != null;
        simulateGame(afcChamp, nfcChamp, results, 22);

        String winningTeam;
        String losingTeam;
        // AFC
        winningTeam = results.get(results.size() - 1).getWinningTeam();
        losingTeam = results.get(results.size() - 1).getLosingTeam();
        if (Objects.equals(afcChamp.getTeamName(), winningTeam)) {
            afcChamp.setSBResult(true);
            afcChamp.setFinalRank(1);
            nfcChamp.setFinalRank(2);
        }
        if (Objects.equals(nfcChamp.getTeamName(), winningTeam)) {
            nfcChamp.setSBResult(true);
            nfcChamp.setFinalRank(1);
            afcChamp.setFinalRank(2);
        }
    }

    public static void updateResults(ArrayList<class_NFLteam> teams, int[] superBowlWinsByRank, int[][] finishingPositionByRank, double[] spearmanRankCorrelationCoefficients, double[] regSznSRC, int currSeason) {

        //Populate array with super bowl wins by rank and finishing position by rank

        // Super bowl wins by rank
        for(class_NFLteam team : teams){
            if(team.isSBResult()) {
                superBowlWinsByRank[team.getStrengthRank()-1]++;
            }
        }

        // Finishing position by rank
        for(int i = 0; i < teams.size(); i++){
            for(int j = 0; j < teams.size(); j++){
                for(class_NFLteam team : teams){
                    if(team.getFinalRank() == i+1 && team.getStrengthRank() == j+1){
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
            finalRank[i] = teams.get(i).getFinalRank();
            regSznRank[i] = teams.get(i).getRegSeasonRank();
        }
        // Calculate the correlation coefficient
        double spearman = new SpearmansCorrelation().correlation(strengthRank, finalRank);
        spearmanRankCorrelationCoefficients[currSeason] = spearman;
        double spearmanRegSzn = new SpearmansCorrelation().correlation(strengthRank, regSznRank);
        regSznSRC[currSeason] = spearmanRegSzn;

    }


}


