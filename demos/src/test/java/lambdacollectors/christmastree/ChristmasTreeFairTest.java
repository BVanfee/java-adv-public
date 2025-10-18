package lambdacollectors.christmastree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class ChristmasTreeFairTest {

    ChristmasTreeFair fair;

    @BeforeEach
    void init() {
        List<ChristmasTree> christmasTrees = Arrays.asList(
                new ChristmasTree(PineTreeType.NORDMANN, 1.23),
                new ChristmasTree(PineTreeType.NORDMANN, 1.78),
                new ChristmasTree(PineTreeType.SPRUCE, 0.60),
                new ChristmasTree(PineTreeType.SILVER, 2.54),
                new ChristmasTree(PineTreeType.SPRUCE, 2.82),
                new ChristmasTree(PineTreeType.SILVER, 0.96),
                new ChristmasTree(PineTreeType.SPRUCE, 1.46)
        );
        fair = new ChristmasTreeFair(christmasTrees);
    }

    @Test
    void testGetCountByType() {
        Map<PineTreeType, Long> expected = Map.of(
                PineTreeType.NORDMANN, 2L,
                PineTreeType.SILVER, 2L,
                PineTreeType.SPRUCE, 3L
        );

        assertEquals(expected, fair.getCountByType());
    }

    @Test
    void testGetCountByTypeEmptyList() {
        fair = new ChristmasTreeFair(new ArrayList<>());
        Map<PineTreeType, Long> expected = new HashMap<>();

        assertEquals(expected, fair.getCountByType());
    }

    @Test
    void testGetMaxHeightByType() {
        assertEquals(2.82, fair.getMaxHeightByType(PineTreeType.SPRUCE), 0.001);
    }

    @Test
    void testGetMaxHeightByTypeNoSuchType() {
        fair = new ChristmasTreeFair(Arrays.asList(
                new ChristmasTree(PineTreeType.NORDMANN, 1.23),
                new ChristmasTree(PineTreeType.SILVER, 2.54)));

        assertEquals(0.0, fair.getMaxHeightByType(PineTreeType.SPRUCE), 0.0001);
    }

    @Test
    void testGetMaxHeightByTypeEmptyList() {
        fair = new ChristmasTreeFair(new ArrayList<>());
        assertEquals(0.0, fair.getMaxHeightByType(PineTreeType.SPRUCE), 0.0001);
    }

    @Test
    void testGetAveragePrice() {
        assertEquals(11088.57142, fair.getAveragePrice(), 0.0001);
    }

    @Test
    void testGetAveragePriceEmptyList() {
        fair = new ChristmasTreeFair(new ArrayList<>());

        assertEquals(0.0, fair.getAveragePrice(), 0.0001);
    }
}