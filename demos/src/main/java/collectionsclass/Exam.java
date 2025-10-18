package collectionsclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exam {

    private List<ExamResult> examResults;

    public Exam(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        List<String> result = new ArrayList<>();
        List<ExamResult> examResultListOrdered = resultOrderedByResult();
        if (examResultListOrdered.size() < places) {
            places = examResultListOrdered.size();
        }
        for (int i = 0; i < places; i++) {
            result.add(examResultListOrdered.get(i).getName());
        }
        return result;
    }

    private List<ExamResult> resultOrderedByResult() {
        List<ExamResult> ordered = new ArrayList<>(examResults);
        ordered.sort(new Comparator<ExamResult>() {
            @Override
            public int compare(ExamResult o1, ExamResult o2) {
                return o2.getResult() - o1.getResult();
            }
        });
        return ordered;
    }
}
