package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BandManager {
    public final static String SEPARATOR = ";";

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addBand(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }


    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Band band : getBandsBefore(year)) {
                writer.write(band.getName() + ";" + band.getYear() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file");
        }

    }

    public List<Band> getBands() {
        return new ArrayList<>(bands);
    }

    private List<Band> getBandsBefore(int year) {
        return bands
                .stream()
                .filter(band -> band.getYear() < year)
                .collect(Collectors.toList());
    }

    private void addBand(String line) {
        String[] dataFromLine = line.split(SEPARATOR);
        Band band = new Band(dataFromLine[0], Integer.parseInt(dataFromLine[1]));
        if (!bands.contains(band)) {
            bands.add(band);
        }
    }
}
