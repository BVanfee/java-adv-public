package iowriter.music;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BandTest {

    Band band = new Band("Metallica", 1981);

    @Test
    void createBand() {
        assertEquals("Metallica", band.getName());
        assertEquals(1981, band.getYear());
    }

}
