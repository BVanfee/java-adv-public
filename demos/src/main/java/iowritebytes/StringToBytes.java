package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {
        /*Hozz létre egy StringToBytes osztályt és készíts benne egy
        writeAsBytes() metódust! A metódus a paraméterként kapott szöveg
        listából az "_" jellel kezdődő szövegeken kívül minden mást kiír
        a szintén paraméterül kapott path-ra bináris fájlba.*/


    public void writeAsBytes(List<String> words, Path path) {
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String word : words) {
                if(!word.startsWith("_")){
                    outputStream.write(word.getBytes());
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
