package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString){
        validate(pathString);
        validate(temperatures);
        Path files = Path.of(pathString);
        try {
            Files.write(files, temperatures.getData());
        } catch (IOException e) {
            throw new IllegalStateException("No file found",e);
        }


    }

    private void validate(String text){
        if(text == null || text.isBlank()){
            throw new IllegalArgumentException("Text can not be empty or null!");
        }
    }

    private void validate(Temperatures temperatures){
        if(temperatures == null){
            throw new IllegalArgumentException("Temperatures can not be null");
        }
    }
}
