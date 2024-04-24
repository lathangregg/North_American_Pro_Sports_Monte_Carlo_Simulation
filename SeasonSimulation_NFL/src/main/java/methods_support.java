import java.lang.reflect.Array;
import java.util.ArrayList;

public class methods_support {
    public static void determineDivisionChamps(ArrayList<class_NFLteam> teams, ArrayList<class_GameResult> results){
        // accepts teams AL and results AL and sets division champ to true for division champions

        // loops through every division
            // if a single team has the most wins, adds them to potentialWinners AL
        ArrayList<class_NFLteam> potentialWinners = new ArrayList<>();

        for (int currentDivision = 0; currentDivision < 8; currentDivision++) { // loops through all 8 divisions

            int maxWins = 0; // whenever divisions change, reset maxWins to 0
            potentialWinners.clear(); // whenever divisions change, clear potentialWinners AL

            for(class_NFLteam team: teams) {
                if(team.getDivision() == currentDivision){
                    if(team.getRegSeasonW() >= maxWins){
                    maxWins = team.getRegSeasonW();
                    potentialWinners.add(team);
                    }
                }
            }
            if (potentialWinners.size() > 0){
                if (potentialWinners.size() != 1) {
                    ArrayList<class_NFLteam> sortedTiedTeams = new ArrayList<>();
                    sortedTiedTeams = breakTies(potentialWinners, results);
                    //System.out.println(" --- Tie in division: " + currentDivision);
                }
                potentialWinners.get(0).setDivisionChamp(true);
            }
            else{
                System.out.println("Logic Error: No team in division has the most or tied for the most wins");
            }

        }

        // Handles potentialWinners AL

    }

    public static ArrayList<class_NFLteam> breakTies(ArrayList<class_NFLteam> tiedTeams, ArrayList<class_GameResult> results){
        // takes an arraylist of tied teams and returns sorted ArrayList
            // something that allows you to deal with tiebreaking procedures
        ArrayList<class_NFLteam> sortedTiedTeams = new ArrayList<>();
        int numTeams = tiedTeams.size();

        if (numTeams < 2){
            System.out.println("Error: called tiebreaker with less than 2 teams in tied teams array");
        }
        if (numTeams == 2){
            sortedTiedTeams = twoTeamTieBreaker(tiedTeams, results);
        }
        if (numTeams > 2){
            sortedTiedTeams = threeTeamTieBreaker(tiedTeams, results);
        }

        return sortedTiedTeams;
    }

    private static ArrayList<class_NFLteam> threeTeamTieBreaker(ArrayList<class_NFLteam> tiedTeams, ArrayList<class_GameResult> results) {
        // takes arraylist of 3+ tied teams and sorts it based on tiebreakers
        ArrayList<class_NFLteam> sortedTiedTeams = new ArrayList<>();
        sortedTiedTeams = tiedTeams;
        return sortedTiedTeams;
    }

    public static ArrayList<class_NFLteam> twoTeamTieBreaker(ArrayList<class_NFLteam> tiedTeams, ArrayList<class_GameResult> results){
        // takes arraylist of two tied teams and sorts it based on tiebreakers
        ArrayList<class_NFLteam> sortedTiedTeams = new ArrayList<>();
        sortedTiedTeams = tiedTeams;
        // sorted tied teams based on alphebetical order of team name
        /*if (tiedTeams.get(0).getTeamName().compareTo(tiedTeams.get(1).getTeamName()) < 0){
            sortedTiedTeams.add(tiedTeams.get(0));
            sortedTiedTeams.add(tiedTeams.get(1));
        }
        else{
            sortedTiedTeams.add(tiedTeams.get(1));
            sortedTiedTeams.add(tiedTeams.get(0));
        }*/
        return sortedTiedTeams;
        
    }

    public static void strengthRanks(ArrayList<class_NFLteam> teams, ArrayList<class_NFLteam> sortedTeams){
        // accepts teams AL and sets strengthRank for each team
        // sorts teams AL by teamStrength
        // sets strengthRank for each team
        // sorts teams AL by teamID
        // returns teams AL

        sortedTeams.sort((o1, o2) -> Double.compare(o2.getTeamStrength(), o1.getTeamStrength()));
        int rank = 1;
        for (class_NFLteam team: sortedTeams){
            team.setStrengthRank(rank);
            rank++;
        }
        // Sets the strengthRank for each team in team to the rank of the team in sortedTeams
        for (class_NFLteam team: teams){
            for (class_NFLteam sortedTeam: sortedTeams){
                if (team.getTeamID() == sortedTeam.getTeamID()){
                    team.setStrengthRank(sortedTeam.getStrengthRank());
                }
            }
        }
    }

    public static void recordRanks(ArrayList<class_NFLteam> teams, ArrayList<class_NFLteam> sortedTeams){
        // accepts teams AL and orders teams by regSeasonW

        sortedTeams.sort((o1, o2) -> Integer.compare(o2.getRegSeasonW(), o1.getRegSeasonW()));
    }

    public static void sortWithTiebreakers(ArrayList<class_NFLteam> NonDivisionChamps, ArrayList<class_GameResult> results){
        for (class_NFLteam nonDivisionChamp : NonDivisionChamps) {
            //System.out.println(nonDivisionChamp.getRegSeasonW());
        }
        ArrayList<class_NFLteam> tiedTeams = new ArrayList<>();
        //NonDivisionChamps.get(0).setPlayoffSeed(5);
        //NonDivisionChamps.get(1).setPlayoffSeed(6);
        //NonDivisionChamps.get(2).setPlayoffSeed(7);


        // For i = 17 to 1
        int rank = 5;
        for (int i = 17; i >= 0; i--) {
            for (class_NFLteam nonDivisionChamp : NonDivisionChamps) {
                if (nonDivisionChamp.getRegSeasonW() == i) {
                    tiedTeams.add(nonDivisionChamp);
                }
            }
            if (tiedTeams.size() == 1) {
                tiedTeams.get(0).setPlayoffSeed(rank);
                rank++;
            }
            if (tiedTeams.size() > 1){
                tiedTeams = methods_support.breakTies(tiedTeams, results);
                for (class_NFLteam team: tiedTeams){
                    team.setPlayoffSeed(rank);
                    rank++;
                }
            }
            tiedTeams.clear();
        }
    }

    public static void duplicateTeamsAL(ArrayList<class_NFLteam> teams, ArrayList<class_NFLteam> sortedTeamsByStrength, ArrayList<class_NFLteam> sortedTeamsByWins, ArrayList<class_NFLteam> sortedTeamsByFinalStanding){
        for(class_NFLteam team: teams){
            sortedTeamsByWins.add(team);
            sortedTeamsByStrength.add(team);
            sortedTeamsByFinalStanding.add(team);
        }
    }

    public static void seedByStrength(ArrayList<class_NFLteam> teams){
        // Assigns teams seeds by strength rank

        for (class_NFLteam team: teams){
            team.setPlayoffSeed(team.getStrengthRank());
        }

    }
}
