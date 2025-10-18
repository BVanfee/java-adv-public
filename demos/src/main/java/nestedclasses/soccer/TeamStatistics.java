package nestedclasses.soccer;

public class TeamStatistics {

    private String teamName;
    private Game game;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
        this.game = new Game();
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        this.game.played++;
        if (plusGoalsFor > plusGoalsAgainst) {
            this.game.won++;
        } else if (plusGoalsFor < plusGoalsAgainst) {
            this.game.lost++;
        } else {
            this.game.tied++;
        }
        this.goalsFor += plusGoalsFor;
        this.goalsAgainst += plusGoalsAgainst;
        this.points = this.game.won * 3 + this.game.tied;
    }

    public String getTeamName() {
        return teamName;
    }

    public Game getGame() {
        return game;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public int getPlayed(){
        return this.game.played;
    }

    public int getWon(){
        return this.game.won;
    }

    public int getTied(){
        return this.game.tied;
    }

    public int getLost(){
        return this.game.lost;
    }

    @Override
    public String toString() {
        return teamName + " " + game + " " + game.won + " " + game.tied + " " + game.lost
                + " " + goalsFor + " - " + goalsAgainst + ", " + points;
    }

    public class Game {
        private int played;
        private int won;
        private int tied;
        private int lost;
    }

}
