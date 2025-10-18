package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    /*Legyen egy soccer.Championship osztály, amellyel
    egy focibajnokság eredményeit megadva megkaphatjuk a tabellát!
    A feladathoz szükség van egy soccer.TeamStatistics osztályra,
    amely egy tabella sor adatait tartalmazza.
    A Championship osztály tartalmazzon egy
    GameResult static nested classt, amely egy meccs eredményét tartalmazza!
    Ennek alapján kell a TeamStatistics példányokat módosítani.

TeamStatistics osztály:
Sok adatra van szüksége: csapat neve (teamName),
lejátszott meccsek száma (played), győzelmek (won),
döntetlenek (tied), vereségek (lost), rúgott gólok
(goalsFor), kapott gólok (goalsAgainst), pontszám (points).
Ezek egy részét szervezd ki egy belső osztályba az osztályon belül,
és legyen a TeamStatistics-nek egy ilyen belső osztály típusú attribútuma!
getterek
egy void played(int plusGoalsFor, int plusGoalsAgainst) metódus,
amely egy lejátszott meccs eredményeit kapja paraméterül,
és ez alapján módosítja az adatokat. Ez a metódus minden adatot módosítson,
tehát a kapott és rúgott gólok számán kívül az összes lejátszott mérkőzések számát,
a nyert, döntetlen vagy vesztett mérkőzések számát (természetesen a megkapott meccseredménytől függően),
valamint a csapat összpontszámát!
(A nyert mérkőzések 3, a döntetlenek 1, a vesztett mérkőzések 0 pontot érnek.)

Championship osztály:
Adata: TeamStatistics leagueTable lista
Legyen hozzá getter
Legyen egy metódus, amivel egy meccseredményt megadhatunk
(public void addGame(GameResult result), a GameResult belső osztály leírását lásd alább)
GameResult belső osztály:
Adatai: teamHome, teamGuest, goalHome, goalGuest
Konstruktorra szükség van, de getterekre, setterekre nincs,
mivel a külső osztály látja a tagosztály private attribútumait is.

Befejezetlennek jelölés

*/

    List<TeamStatistics> leagueTable = new ArrayList<>();

    public List<TeamStatistics> getLeagueTable() {
        return new ArrayList<>(leagueTable);
    }

    public void addTeam(TeamStatistics teamStatistics) {
        if (teamStatistics == null) {
            throw new IllegalArgumentException("Team can not be null");
        }
        boolean alreadyExits = false;
        for (TeamStatistics statistics : leagueTable) {
            if (statistics.getTeamName().equals(teamStatistics.getTeamName())) {
                alreadyExits = true;
            }
        }
        if (!alreadyExits) {
            leagueTable.add(teamStatistics);
        }
    }

    public void addGame(GameResult result) {
        if (result == null) {
            throw new IllegalArgumentException("Result can not be null!");
        }
        addTeam(new TeamStatistics(result.teamGuest));
        addTeam(new TeamStatistics(result.teamHome));
        for (TeamStatistics teamStatistics : leagueTable) {
            if (teamStatistics.getTeamName().equals(result.teamHome)) {
                teamStatistics.played(result.goalHome, result.goalGuest);
            } else if (teamStatistics.getTeamName().equals(result.teamGuest)) {
                teamStatistics.played(result.goalGuest, result.goalHome);
            }
        }
    }

    public static class GameResult {

        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }
}
