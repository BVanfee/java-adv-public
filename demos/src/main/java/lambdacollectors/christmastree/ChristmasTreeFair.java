package lambdacollectors.christmastree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasTreeFair {

    private List<ChristmasTree> trees;

    public ChristmasTreeFair(List<ChristmasTree> trees) {
        this.trees = trees;
    }

    public Map<PineTreeType, Long> getCountByType(){
        return trees
                .stream()
                .collect(Collectors.groupingBy(ChristmasTree::getType,
                        Collectors.counting()));
    }

    public double getMaxHeightByType(PineTreeType type){
        return trees
                .stream()
                .filter(pine ->pine.getType()==type)
                .collect(Collectors.maxBy(Comparator.comparingDouble(ChristmasTree::getHeight)))
                .map(ChristmasTree::getHeight)
                .orElse(0.0);
    }

    public double getAveragePrice(){
        return trees
                .stream()
                .collect(Collectors.averagingDouble(tree -> tree.getHeight()*tree.getType().getPrice()));

//        return trees
//                .stream()
//                .mapToDouble(tree -> tree.getType().getPrice()*tree.getHeight())
//                .average()
//                .orElse(0.0);

    }

    public List<ChristmasTree> getTrees() {
        return new ArrayList<>(trees);
    }
}
