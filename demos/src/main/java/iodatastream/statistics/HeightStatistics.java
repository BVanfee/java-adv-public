package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    /*Az iodatastream.statistics csomagba készíts egy HeightStatistics osztályt,
     bele pedig egy saveHeights() metódust. A metódus egy kosárcsapat tagjainak
      testmagasságát kapja meg List<Integer> típusú paraméterben. A paraméterben
       kapott Path objektumként reprezentált fájlba menti először a lista méretét,
        majd egyenként a lista elemeit.*/

    public void saveHeights(List<Integer> heights, Path path){
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            dos.writeInt(heights.size());
            for (Integer height : heights) {
               dos.writeInt(height);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
