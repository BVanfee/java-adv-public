package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ResultCalculator {
    /*Ebben a feladatban egy tehetségkutató showt fogunk szimulálni.
    A feladat kicsit összetettebb. A talents.txt tartalmazza az indulók listáját,
    míg a votes.txt a leadott szavazatokat, azaz az előadó kódját.

A te feladatod, hogy készíts egy kimutatást egy fájlba. A fájlnak tartalmaznia
a kódot az előadás nevét illetve, hogy az adott előadás hány szavazatot kapott!
Ezen felül az utolsó sornak tartalmaznia kell a győztes nevét a következő formátumban:
 Winner: győztes neve.

A megoldáshoz használj nyugodtan private metódusokat.*/
    public static final String SEPARATOR_FOR_PRODUCT_FILE = " ";
    public static final String SEPARATOR_FOR_VOTE_FILE = " ";

    private final List<Production> productions = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();

    public void writeResultListWithWinner(Path outPutFile) {

        Map<Integer, Integer> resultList = getResultForProduction();
        String winnerName = findNameById(findWinnersId(resultList));
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outPutFile))) {
            for (Production production : productions) {
                writer.print(production.getId() + " " +
                        production.getName() + " " +
                        resultList.get(production.getId()) + "\n");
            }
            writer.print("Winner: " + winnerName);

        } catch (IOException e) {
            throw new IllegalStateException("File can not write", e);
        }


    }

    public void readProductionsFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addProduction(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File can not read", e);
        }
    }

    public void readVotesFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null) {
                addVote(line, id++);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File can not read", e);
        }
    }

    private String findNameById(int id) {
        for (Production production : productions) {
            if (production.getId() == id) {
                return production.getName();
            }
        }
        throw new IllegalArgumentException("No winner!");
    }

    private int findWinnersId(Map<Integer, Integer> results) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(results.entrySet());
        list.sort((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

        return list.get(0).getKey();
    }

    private Map<Integer, Integer> getResultForProduction() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Production production : productions) {
            result.put(production.getId(), 0);
        }
        for (Vote vote : votes) {
            result.put(vote.getNumber(), result.get(vote.getNumber()) + 1);
        }
        return result;
    }

    private void addVote(String line, int id) {
        votes.add(new Vote(id, Integer.parseInt(line)));
    }

    private void addProduction(String line) {
        String[] dataFromFile = line.split(SEPARATOR_FOR_PRODUCT_FILE);
        productions.add(new Production(Integer.parseInt(dataFromFile[0]), dataFromFile[1]));
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }
}
