package collectionsautobixing;

import java.util.HashMap;
import java.util.Map;

public class Vote {
    /*Az országgyűlés egy fontos törvényjavaslatot készül megszavazni
    név szerinti szavazással. Készíts ehhez először egy VoteResult
    nevű enumot, amelyben három érték legyen: YES, NO és ABSTAIN (tartózkodik)!
     Legyen ezután egy Vote osztály, amelyben legyen egy
     Map<VoteResult, Integer> getResult(Map<String, VoteResult>)
     metódus! Ez a metódus megkapja a szavazás személyenkénti eredményét egy Map-ben,
     valahogy így:*/

    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> votes) {
        Map<VoteResult, Integer> result = new HashMap<>();
        for (Map.Entry<String, VoteResult> vote : votes.entrySet()) {
            if (!result.containsKey(vote.getValue())) {
                result.put(vote.getValue(), 1);
            } else {
                result.replace(vote.getValue(), result.get(vote.getValue()) + 1);
            }
        }
        return result;
    }
}
