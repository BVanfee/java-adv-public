package sorting;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient {

    private String name;
    private LocalDateTime date;
    private String ssn;

    public Patient(String name, String ssn, LocalDateTime date) {
        this.name = name;
        this.date = date;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getSsn() {
        return ssn;
    }


}
