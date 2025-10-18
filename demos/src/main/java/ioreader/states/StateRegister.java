package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    public static final String STATE_SEPARATOR = "-";

    List<State> states = new ArrayList<>();

    public void readStatesFromFile(String stringFileName) {
        validate(stringFileName);
        Path path = Path.of("src/main/resources/ioreader/" + stringFileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addState(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public String findCapitalByStateName(String stateName) {
        return states
                .stream()
                .filter(state -> state.getStateName().equalsIgnoreCase(stateName))
                .map(State::getCapital)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No state with this name!"));
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    private void addState(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("State and capitol can not be empty or null" + line);
        } else if (!line.contains(STATE_SEPARATOR)) {
            throw new IllegalArgumentException("Wrong or missing separator" + line);
        }
        String[] stateData = line.split(STATE_SEPARATOR);
        states.add(new State(stateData[0], stateData[1]));
    }

    private void validate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text can not be null.");
        }
    }
}
