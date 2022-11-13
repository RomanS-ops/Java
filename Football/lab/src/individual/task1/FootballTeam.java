package individual.task1;

import java.util.ArrayList;
import java.util.Comparator;

public class FootballTeam {
    private String name;
    private String city;
    private Integer leaguePosition;
    private Integer countWins;

    public FootballTeam() {
    }

    public FootballTeam(String name, String city, Integer leaguePosition, Integer countWins) {
        this.name = name;
        this.city = city;
        this.leaguePosition = leaguePosition;
        this.countWins = countWins;
    }

    public static FootballTeam getMaxCountWinsFootballTeam(ArrayList<FootballTeam> footballTeams){
        FootballTeam footballTeamMaxCountWins = footballTeams.get(0);
        for (int i = 1; i < footballTeams.size(); i++){
            if (footballTeamMaxCountWins.getCountWins() < footballTeams.get(i).getCountWins()){
                footballTeamMaxCountWins = footballTeams.get(i);
            }
        }
        return  footballTeamMaxCountWins;
    }

    private static int averageCountWins(ArrayList<FootballTeam> footballTeams){
        int avg = 0;
        for (FootballTeam footballTeam : footballTeams){
            avg += footballTeam.getCountWins() / footballTeams.size();
        }
        return avg;
    }
    public static ArrayList<FootballTeam> getFootballTeamsCountWinsAboveAverage(ArrayList<FootballTeam> footballTeams){
        int avg = averageCountWins(footballTeams);
        ArrayList<FootballTeam> footballTeamsCountWinsAboveAverage = new ArrayList<>();
        for (FootballTeam footballTeam : footballTeams){
            if (footballTeam.getCountWins() > avg){
                footballTeamsCountWinsAboveAverage.add(footballTeam);
            }
        }
        return footballTeamsCountWinsAboveAverage;
    }

    public static void sortByLeaguePosition(ArrayList<FootballTeam> footballTeams){
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
    }

    public static FootballTeam searchByName(ArrayList<FootballTeam> footballTeams, String name){
        FootballTeam.sortByLeaguePosition(footballTeams);
        int startPoint = 0;
        int middlePoint = 0;
        int endPoint = footballTeams.size() - 1;
        while (startPoint <= endPoint){
            middlePoint = (startPoint + endPoint) / 2;
            if (footballTeams.get(middlePoint).getName().compareTo(name) == 0){
                return footballTeams.get(middlePoint);
            } else if (footballTeams.get(middlePoint).getName().compareTo(name) < 0){
                startPoint = middlePoint + 1;
            } else if (footballTeams.get(middlePoint).getName().compareTo(name) > 0){
                endPoint = middlePoint - 1;
            }
        }
        return new FootballTeam("empty", "empty", 0,0);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLeaguePosition() {
        return leaguePosition;
    }

    public void setPosition(Integer leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public Integer getCountWins() {
        return countWins;
    }

    public void setCountWins(Integer countWins) {
        this.countWins = countWins;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", position=" + leaguePosition +
                ", countWins=" + countWins +
                '}';
    }
}
