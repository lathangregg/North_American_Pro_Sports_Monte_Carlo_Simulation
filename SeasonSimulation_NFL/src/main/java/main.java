import java.util.ArrayList;


public class main {
    public static void main(String[] args) {

        /* NBA SIMULATOR */
        // Initialize variables
        int numNBATeams = 30;
        int numNBASeasons = 0;// number of repetitions

        int[][] scheduleNBA = new int[numNBATeams][numNBATeams];
        int[][] NBAFinishingPositionByRank = new int[numNBATeams][numNBATeams];
        ArrayList<class_NBAGameResult> results_AL_NBA = new ArrayList<>();
        double[] NBASpearmanCorrelations = new double[numNBASeasons];
        double[] NBARegSznSpearmanCorrelations = new double[numNBASeasons];

        // keeps track of how many times each team wins the NBA Finals
        int[] finalsWinByRank = new int[numNBATeams];
        for (int i = 0; i < numNBATeams; i++) {
            finalsWinByRank[i] = 0;
            for (int j = 0; j < numNBATeams; j++) {
                NBAFinishingPositionByRank[i][j] = 0;
            }
        }

        // Create ArrayLists
        ArrayList<class_NBAteam> NBA_teams_AL = new ArrayList<>(numNBATeams); // create arraylist "NBA_teams_AL"
        ArrayList<class_NBAteam> NBA_teams_AL_SortedByStrength = new ArrayList<>();
        ArrayList<class_NBAteam> NBA_teams_AL_SortedByRegularSeasonWins = new ArrayList<>();
        ArrayList<class_NBAteam> NBA_teams_AL_SortedByFinalStandings = new ArrayList<>();

        // Create NBA teams
        methods_NBA_general.generateNBATeams(NBA_teams_AL); // Populate NBA_teams_AL with 30 objects of classNBATeams
        methods_NBA_general.generateNBASchedule(scheduleNBA); // Generate Schedule

        // print NBA schedule
        for (int i = 0; i < numNBATeams; i++) {
            for (int j = 0; j < numNBATeams; j++) {
                //System.out.print(scheduleNBA[i][j] + " ");
            }
            //System.out.println();
        }
        for (int i = 0; i < numNBASeasons; i++) {
            methods_NBA_general.resetNBASeason(NBA_teams_AL, results_AL_NBA, NBA_teams_AL_SortedByStrength, NBA_teams_AL_SortedByRegularSeasonWins, NBA_teams_AL_SortedByFinalStandings); // Reset team objects
            methods_NBA_general.assignNBATeamStrengths(NBA_teams_AL); // Assign team strengths

            methods_NBA_support.duplicateTeamsAL(NBA_teams_AL, NBA_teams_AL_SortedByStrength, NBA_teams_AL_SortedByRegularSeasonWins, NBA_teams_AL_SortedByFinalStandings); // Duplicate teams

            methods_NBA_support.strengthRanks(NBA_teams_AL, NBA_teams_AL_SortedByStrength); // Sort teams by strength

            methods_NBA_general.simulateNBARegularSeason(NBA_teams_AL, results_AL_NBA, scheduleNBA); // Simulate NBA season
            methods_NBA_general.determineNBASeeding(NBA_teams_AL, results_AL_NBA); // seed NBA Playoffs
            //methods_NBA_support.seedByStrengthRank(NBA_teams_AL);
            methods_NBA_general.simulateNBAPlayoffs(NBA_teams_AL, results_AL_NBA); // Simulate Playoffs
            methods_NBA_support.setFinalRank(NBA_teams_AL); // Set final standings
            methods_NBA_general.updateNBAResults(NBA_teams_AL_SortedByStrength, finalsWinByRank, NBAFinishingPositionByRank, NBASpearmanCorrelations, NBARegSznSpearmanCorrelations, i); // Update Results

        }

        /* MLB SIMULATOR */

        // Initialize variables
        int numMLBTeams = 30;
        int numMLBSeasons = 0;// number of repetitions

        int[][] scheduleMLB = new int[numMLBTeams][numMLBTeams];
        int[][] MLBFinishingPositionByRank = new int[numMLBTeams][numMLBTeams];
        ArrayList<class_MLBGameResult> results_AL_MLB = new ArrayList<>();
        double[] MLBSpearmanCorrelations = new double[numMLBSeasons];
        double[] MLBRegSznSpearmanCorrelations = new double[numMLBSeasons];

        // keeps track of how many times each team wins the WorldSeries
        int[] worldSeriesWinByRank = new int[numMLBTeams];
        for (int i = 0; i < numMLBTeams; i++) {
            worldSeriesWinByRank[i] = 0;
            for (int j = 0; j < numMLBTeams; j++) {
                MLBFinishingPositionByRank[i][j] = 0;
            }
        }

        // Create ArrayLists
        ArrayList<class_MLBteam> MLB_teams_AL = new ArrayList<>(numMLBTeams); // create arraylist "MLB_teams_AL"
        ArrayList<class_MLBteam> MLB_teams_AL_SortedByStrength = new ArrayList<>();
        ArrayList<class_MLBteam> MLB_teams_AL_SortedByRegularSeasonWins = new ArrayList<>();
        ArrayList<class_MLBteam> MLB_teams_AL_SortedByFinalStandings = new ArrayList<>();

        // Create MLB teams
        methods_MLB_general.generateMLBTeams(MLB_teams_AL); // Populate MLB_teams_AL with 30 objects of classMLBteams
        methods_MLB_general.generateMLBSchedule(scheduleMLB, MLB_teams_AL); // Generate Schedule

        // in loop
        for (int i = 0; i < numMLBSeasons; i++){

        methods_MLB_general.resetMLBSeason(MLB_teams_AL, results_AL_MLB, MLB_teams_AL_SortedByStrength, MLB_teams_AL_SortedByRegularSeasonWins, MLB_teams_AL_SortedByFinalStandings); // Reset team objects
        methods_MLB_general.assignMLBTeamStrengths(MLB_teams_AL, MLB_teams_AL.size()); // Assign team strengths

        methods_MLB_support.duplicateTeamsAL(MLB_teams_AL, MLB_teams_AL_SortedByStrength, MLB_teams_AL_SortedByRegularSeasonWins, MLB_teams_AL_SortedByFinalStandings); // Duplicate teams
        methods_MLB_support.strengthRanks(MLB_teams_AL, MLB_teams_AL_SortedByStrength); // Sort teams by strength

        methods_MLB_general.simulateMLBRegularSeason(MLB_teams_AL, results_AL_MLB, scheduleMLB); // Simulate Regular Season
        methods_MLB_general.determineMLBSeeding(MLB_teams_AL, results_AL_MLB); // Seed MLB Playoffs
        //methods_MLB_support.seedByStrengthRank(MLB_teams_AL);
        methods_MLB_general.simulateMLBPlayoffs(MLB_teams_AL, results_AL_MLB); // Simulate Playoffs
        methods_MLB_support.setFinalRank(MLB_teams_AL); // Set final standings
        methods_MLB_general.updateMLBResults(MLB_teams_AL_SortedByStrength, worldSeriesWinByRank, MLBFinishingPositionByRank, MLBSpearmanCorrelations, MLBRegSznSpearmanCorrelations,i); // Update Results

    }

        /* NFL SIMULATOR */

        // Initialize variables
        int numTeams = 32;
        int numSeasons = 1;// number of repetitions
        int stopCondition = 0;
        int numWeeks = 18;

        int[][][] schedule = new int[numWeeks][numTeams][numTeams];
        ArrayList<class_GameResult> results_AL = new ArrayList<>();
        int[][] NFLFinishingPositionByRank = new int[numTeams][numTeams];
        double[] NFLSpearmanCorrelations = new double[numSeasons];
        double[] NFLRegSznSpearmanCorrelations = new double[numSeasons];

        // keeps track of how many times each team wins the super bowl
        int[] superBowlWinsByRank = new int[numTeams];
        for (int i = 0; i < numTeams; i++) {
            superBowlWinsByRank[i] = 0;
            for (int j = 0; j < numTeams; j++) {
                NFLFinishingPositionByRank[i][j] = 0;
            }
        }

        // Create Teams
        ArrayList<class_NFLteam> NFL_teams_AL = new ArrayList<>(numTeams); // create arraylist "NFL_teams_AL"
        ArrayList<class_NFLteam> NFL_teams_AL_SortedByStrength = new ArrayList<>();
        ArrayList<class_NFLteam> NFL_teams_AL_SortedByRegSeasonRec = new ArrayList<>();
        ArrayList<class_NFLteam> NFL_teams_AL_SortedByFinalStandings = new ArrayList<>();

        //ArrayList<class_NFLteam> NFL_teams_AL_SortedByStrength = new ArrayList<>(numTeams); // create arraylist "NFL_teams_AL_SortedByStrength"
        // creates copy of NFL_teams_AL called NFL_teams_AL_SortedByStrength

        methods_general.generateNFLTeams(NFL_teams_AL); // Populate NFL_teams_AL with 32 objects of classNFLteams

        methods_general.generateSchedule(schedule); // Generate Schedule

        // Main Loop
        for (int i = 0; i < numSeasons; i++) {

            methods_general.resetSeason(NFL_teams_AL, results_AL, NFL_teams_AL_SortedByStrength, NFL_teams_AL_SortedByRegSeasonRec, NFL_teams_AL_SortedByFinalStandings); // Reset team objects

            methods_general.assignTeamStrengths(NFL_teams_AL, NFL_teams_AL.size()); // Generate Team Strengths

            methods_support.duplicateTeamsAL(NFL_teams_AL, NFL_teams_AL_SortedByStrength, NFL_teams_AL_SortedByRegSeasonRec, NFL_teams_AL_SortedByFinalStandings); // Duplicate NFL_teams_AL to NFL_teams_AL_SortedByStrength

            methods_support.strengthRanks(NFL_teams_AL, NFL_teams_AL_SortedByStrength); // Order teams by strength and generates strength rank

            // Assign Schedule (Moved outside loop since it doesn't change)

            methods_general.simulateRegularSeason(NFL_teams_AL, schedule, results_AL); // Simulate regular season

            methods_support.recordRanks(NFL_teams_AL, NFL_teams_AL_SortedByRegSeasonRec); // Sort NFL_teams_AL_SortedByRegSeasonRec by regular season record

            methods_general.determineSeeding(NFL_teams_AL_SortedByRegSeasonRec, results_AL); // Determine Playoff seeding

            //methods_support.seedByStrength(NFL_teams_AL);

            methods_general.simulateFirstRound(NFL_teams_AL, results_AL);

            methods_general.simulateSecondRound(NFL_teams_AL, results_AL);

            methods_general.simulateThirdRound(NFL_teams_AL, results_AL);

            methods_general.simulateFinalRound(NFL_teams_AL, results_AL);

            methods_general.updateResults(NFL_teams_AL_SortedByStrength, superBowlWinsByRank, NFLFinishingPositionByRank, NFLSpearmanCorrelations, NFLRegSznSpearmanCorrelations, i); // Updates Simulation Results

            // increases the number of wins for the latent rank of the super bowl winner

        }

        // Print Results

        // Best Team Wins
        System.out.println("Finals Wins by Best Team: " + finalsWinByRank[0]);
        System.out.println("World Series Wins by Best Team: " + worldSeriesWinByRank[0]);
        System.out.println("Super Bowl Wins by Best Team: " + superBowlWinsByRank[0]);
        System.out.println();

        // Finishing Position By Rank

        //NFL
/*
        System.out.println("NFL Finishing Position By Rank: ");
        for (int j = 0; j < numTeams; j++) {
            for (int k = 0; k < numTeams; k++) {
                System.out.print(NFLFinishingPositionByRank[j][k] + " ");
            }
            System.out.println();
        }
*/
        //NBA

        System.out.println("NBA Finishing Position By Rank: ");
        for (int j = 0; j < numNBATeams; j++) {
            for (int k = 0; k < numNBATeams; k++) {
                System.out.print(NBAFinishingPositionByRank[j][k] + " ");
            }
            System.out.println();
        }
        //MLB
        /*System.out.println("MLB Finishing Position By Rank: ");
        for (int j = 0; j < numMLBTeams; j++) {
            for (int k = 0; k < numMLBTeams; k++) {
                System.out.print(MLBFinishingPositionByRank[j][k] + " ");
            }
            System.out.println();
        }*/

        // Average Spearman Correlation
        double NFLSpearmanCorrelationSum = 0;
        for (double spearmanCorrelation : NFLSpearmanCorrelations) {
            NFLSpearmanCorrelationSum += spearmanCorrelation;
        }
        double NBASpearmanCorrelationSum = 0;
        for (double spearmanCorrelation : NBASpearmanCorrelations) {
            NBASpearmanCorrelationSum += spearmanCorrelation;
        }
        double MLBSpearmanCorrelationSum = 0;
        for (double spearmanCorrelation : MLBSpearmanCorrelations) {
            MLBSpearmanCorrelationSum += spearmanCorrelation;
        }

        // Average Spearman Correlations for regular season ranks
        double NFLSpearmanCorrelationSumRS = 0;
        for (double spearmanCorrelation : NFLRegSznSpearmanCorrelations) {
            NFLSpearmanCorrelationSumRS += spearmanCorrelation;
        }
        double NBASpearmanCorrelationSumRS = 0;
        for (double spearmanCorrelation : NBARegSznSpearmanCorrelations) {
            NBASpearmanCorrelationSumRS += spearmanCorrelation;
        }
        double MLBSpearmanCorrelationSumRS = 0;
        for (double spearmanCorrelation : MLBRegSznSpearmanCorrelations) {
            MLBSpearmanCorrelationSumRS += spearmanCorrelation;
        }

        // Print Average Spearman Correlation
        System.out.println("Average Spearman Correlation in NFL: " + NFLSpearmanCorrelationSum / numSeasons);
        System.out.println("Average Spearman Correlation in NBA: " + NBASpearmanCorrelationSum / numNBASeasons);
        System.out.println("Average Spearman Correlation in MLB: " + MLBSpearmanCorrelationSum / numMLBSeasons);

        // Print Average Spearman Correlations for regular season ranks
        System.out.println("Average Spearman Correlation in NFL: " + NFLSpearmanCorrelationSumRS / numSeasons);
        System.out.println("Average Spearman Correlation in NBA: " + NBASpearmanCorrelationSumRS / numNBASeasons);
        System.out.println("Average Spearman Correlation in MLB: " + MLBSpearmanCorrelationSumRS / numMLBSeasons);

        /*
        // print the total number of games played
        //System.out.println("Total games played: " + results_AL.size());
        for (int i = 0; i < numTeams; i++) {
            //System.out.println("Rank " + (i+1) + ": " + superBowlWinsByRank[i]);
        }

        // Print super bowl wins by rank
        System.out.println("NFL");
        for (int i = 0; i < superBowlWinsByRank.length; i++) {
            //System.out.println("Team " + i + " wins: " + superBowlWinsByRank[i]);
        }
        System.out.println();


        // Print world series wins by rank
        System.out.println("MLB");
        for (int i = 0; i < worldSeriesWinByRank.length; i++) {
            //System.out.println("Team " + i + " wins: " + worldSeriesWinByRank[i]);
        }
        System.out.println(); */

        // Print results for each league
/*
        // NBA

        for(int i = 0; i < NBA_teams_AL.size(); i++) {
            System.out.println(NBA_teams_AL.get(i).getTeamName() + " | " + NBA_teams_AL.get(i).getRegSeasonW() + " - " + NBA_teams_AL.get(i).getRegSeasonL() + " | " + NBA_teams_AL.get(i).isChampResult());
        }
        System.out.println();


        // MLB
        for(int i = 0; i < MLB_teams_AL.size(); i++) {
            System.out.println(MLB_teams_AL.get(i).getTeamName() + " | " + MLB_teams_AL.get(i).getRegSeasonW() + " - " + MLB_teams_AL.get(i).getRegSeasonL() + " | " + MLB_teams_AL.get(i).isChampResult());
        }
        System.out.println();

        // NFL
        for(int i = 0; i < NFL_teams_AL.size(); i++) {
            System.out.println(NFL_teams_AL.get(i).getTeamName() + " | " + NFL_teams_AL.get(i).getRegSeasonW() + " - " + NFL_teams_AL.get(i).getRegSeasonL() + " | " + NFL_teams_AL.get(i).isSBResult());
        }
        System.out.println();
*/

    }
}
