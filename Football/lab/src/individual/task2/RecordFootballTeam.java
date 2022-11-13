package individual.task2;

import java.util.*;

public class RecordFootballTeam {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter count footballTeams: ");
        Integer countFilms = sc.nextInt();
        sc.nextLine();
        ArrayList<FootballTeam> footballTeams = new ArrayList<>();
        for (int i = 0; i < countFilms; i++){
            System.out.println("Football team N" + (i+1));
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("City: ");
            String city = sc.nextLine();
            System.out.println("League position:");
            Integer leaguePosition = sc.nextInt();
            System.out.println("Rental price:");
            Integer countWins = sc.nextInt();
            sc.nextLine();
            footballTeams.add(new FootballTeam(name, city, leaguePosition, countWins));
        }

        // Return all footballTeams.
        System.out.println("All footballTeams");
        System.out.println("name" + "\t" + "city" + "\t" + "leaguePosition" + "\t" + "countWins");
        for (FootballTeam footballTeam : footballTeams){
            System.out.println(footballTeam.toString());
        }

        FootballTeam footballTeamMaxCountWins = footballTeams.get(0);
        for (int i = 1; i < footballTeams.size(); i++){
            if (footballTeamMaxCountWins.getCountWins() < footballTeams.get(i).getCountWins()){
                footballTeamMaxCountWins = footballTeams.get(i);
            }
        }
        System.out.println("Team with max count wins");
        System.out.println(footballTeamMaxCountWins);


        int avg = 0;
        for (FootballTeam footballTeam : footballTeams){
            avg += footballTeam.getCountWins() / footballTeams.size();
        }

        ArrayList<FootballTeam> footballTeamsCountWinsAboveAverage = new ArrayList<>();
        for (FootballTeam footballTeam : footballTeams){
            if (footballTeam.getCountWins() > avg){
                footballTeamsCountWinsAboveAverage.add(footballTeam);
            }
        }
        // Return all footballTeams.
        System.out.println("All footballTeams where count wins above average");
        System.out.println("name" + "\t" + "city" + "\t" + "leaguePosition" + "\t" + "countWins");
        for (FootballTeam footballTeam : footballTeamsCountWinsAboveAverage){
            System.out.println(footballTeam.toString());
        }


        ArrayList<FootballTeam> footballTeamsSorted = (ArrayList<FootballTeam>) footballTeams.clone();
        footballTeamsSorted.sort(new Comparator<FootballTeam>() {
            @Override
            public int compare(FootballTeam o1, FootballTeam o2) {
                if (o1.getLeaguePosition() != o2.getLeaguePosition()){
                    return o1.getLeaguePosition().compareTo(o2.getLeaguePosition());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        // Return all footballTeams.
        System.out.println("All footballTeams after sorting");
        System.out.println("name" + "\t" + "city" + "\t" + "leaguePosition" + "\t" + "countWins");
        for (FootballTeam footballTeam : footballTeamsSorted){
            System.out.println(footballTeam.toString());
        }


        System.out.println("Enter name for search and update");
        String nameForSearch = sc.nextLine();
        for (FootballTeam footballTeam : footballTeams){
            if (footballTeam.getName() == nameForSearch){
                System.out.println(footballTeam);
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
    }
}
