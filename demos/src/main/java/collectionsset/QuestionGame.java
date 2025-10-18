package collectionsset;

import java.util.*;

public class QuestionGame {
    public static final int NUMBER_OF_WINNERS = 5;

    List<RightAnswer> rightAnswers = new ArrayList<>();
    Random random = new Random();

    public QuestionGame(List<RightAnswer> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public List<RightAnswer> getRightAnswers() {
        return new ArrayList<>(rightAnswers);
    }

    public Set<String> drawWinners() {
        int drawIndex = 0;
        Set<String> result = new LinkedHashSet<>();

        while (result.size() != NUMBER_OF_WINNERS) {
            if(rightAnswers.isEmpty()){
                throw new IllegalArgumentException("Not enough right answers!");
            }
            drawIndex = random.nextInt(rightAnswers.size());

            String winner = rightAnswers.get(drawIndex).getName();
            rightAnswers.remove(drawIndex);
            result.add(winner);
        }
        return result;
    }
}
