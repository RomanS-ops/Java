package individual.task1;

import java.util.*;

public class RecordFootballTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FootballTeam> footballTeams = new ArrayList<>();
        System.out.println("Enter count footballTeams:");
        Integer count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++){
            System.out.println("Football team " + i);
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("City: ");
            String city = sc.nextLine();
            System.out.println("Position:");
            Integer position = sc.nextInt();
            System.out.println("Count Wins:");
            Integer countWins = sc.nextInt();
            sc.nextLine();
            footballTeams.add(new FootballTeam(name,city, position, countWins));
        }
        // Show all footballTeams.
        System.out.println("All footballTeams");
        showFootballTeams(footballTeams);

        //Show footballTeams where wins > average.
        System.out.println("Football teams where count wins > average.");
        showFootballTeams(FootballTeam.getFootballTeamsCountWinsAboveAverage(footballTeams));

        //Show most win team.
        System.out.println("Most win team.");
        System.out.println(FootballTeam.getMaxCountWinsFootballTeam(footballTeams));
        //sorting array footballTeams
        FootballTeam.sortByLeaguePosition(footballTeams);
        System.out.println("FootballTeams after sorting");
        showFootballTeams(footballTeams);
        //search footballTeam by name.
        System.out.println("Enter name for search: ");
        System.out.println(FootballTeam.searchByName(footballTeams, sc.nextLine()));
        // Edit footballTeam.
        System.out.println("Enter name team for update");
        FootballTeam footballTeamForUpdate = FootballTeam.searchByName(footballTeams, sc.nextLine());
        updateFootballTeam(footballTeamForUpdate);

    }


    public static void showFootballTeams(ArrayList<FootballTeam> footballTeamList){
        System.out.println("name\tCity\tPosition\tCount wins");
        for(FootballTeam footballTeam : footballTeamList){
            System.out.println(footballTeam);
        }
    }
    public static void updateFootballTeam(FootballTeam footballTeam){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name field for update: (name, city, position, countWins)" );
        String nameField = sc.nextLine().toLowerCase();
        try {
            if (Objects.equals(nameField, "name")){
                System.out.println("Enter new name:");
                String name = sc.nextLine();
                footballTeam.setName(name);
                System.out.println("Updated!");
            }

            else if (Objects.equals(nameField, "city")){
                System.out.println("Enter new country: ");
                String city = sc.nextLine();
                footballTeam.setCity(city);
                System.out.println("Updated!");
            }

            else if (Objects.equals(nameField, "position")) {
                System.out.println("Enter new leagueposition: ");
                Integer position = sc.nextInt();
                sc.nextLine();
                footballTeam.setPosition(position);
                System.out.println("Updated!");
            }
            else if (Objects.equals(nameField, "countwins")) {
                System.out.println("Enter new count wins: ");
                Integer countWins = sc.nextInt();
                sc.nextLine();
                footballTeam.setCountWins(countWins);
                System.out.println("Updated!");
            }
            else System.out.println("Illegal value!");
        }
        catch (InputMismatchException exception){
            System.out.println("Illegal value!");
        }
    }
}
