package ioreader.states;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class StateTest {

    State state = new State("Wyoming", "Cheyenne");

    @Test
    public void createState() {
        assertEquals("Wyoming", state.getStateName());
        assertEquals("Cheyenne", state.getCapital());
    }

}
