package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperature(String path){
        validate(path);
        Path files = Path.of(path);
        try {
            byte[]data = Files.readAllBytes(files);
            return new Temperatures(data);
        } catch (IOException e) {
            throw new IllegalStateException("No file found",e);
        }
    }

    private void validate(String text){
        if(text == null || text.isBlank()){
            throw new IllegalArgumentException("Text can not be empty or null!");
        }
    }
}
