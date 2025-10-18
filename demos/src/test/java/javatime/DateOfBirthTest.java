package javatime;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateOfBirthTest {

    private DateOfBirth myBirth;
    private DateOfBirth friendBirth;


    @Before
    public void setup(){
        myBirth = new DateOfBirth("1990-05-15", "yyyy-MM-dd");
    }

}