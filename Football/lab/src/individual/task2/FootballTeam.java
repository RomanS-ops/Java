package individual.task2;

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
