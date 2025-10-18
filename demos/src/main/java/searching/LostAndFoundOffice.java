package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {

    private List<LostProperty> lostProperties = new ArrayList<>();

    public void addProperty(LostProperty lostProperty) {
        if (lostProperty != null) {
            lostProperties.add(lostProperty);
        }
    }

    public LostProperty findLostProperty(LostProperty searched) {
        int index = Collections.binarySearch(lostProperties, searched);
        if (index < 0) {
            throw new IllegalArgumentException("Property not found.");
        }
        return lostProperties.get(index);
    }
}
