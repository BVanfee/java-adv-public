package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    /*A timesheet.TimeSheetItem osztály tartalmazza, hogy egy alkalmazott
    mikor, min dolgozott. Van egy String employee, String project,
    LocalDateTime from és egy LocalDateTime to attribútuma.

Legyen egy konstruktora, mely ezekkel az adatokkal inicializálja!
Azonban legyen egy copy konstruktora is, mely paraméterül kap
egy TimeSheetItem példányt, és annak adatait átmásolja az új példányba!

Legyen egy copyWithDifferentEmployee(TimeSheetItem timeSheetItem, String newEmployee)
metódusa is, mely lemásolja a paraméterként átadott bejegyzést, az alkalmazott
nevét kicseréli a második paraméterként kapottra, de a többi attribútumot
érintetlenül hagyja! Ez a metódus hívja a copy konstruktort!*/

    private String employee;
    private String project;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    public TimeSheetItem(String employee, String project, LocalDateTime fromDate, LocalDateTime toDate) {
        this.employee = employee;
        this.project = project;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        employee = timeSheetItem.employee;
        project = timeSheetItem.project;
        fromDate = timeSheetItem.fromDate;
        toDate = timeSheetItem.toDate;
    }

    public TimeSheetItem copyWithDifferentEmployee(TimeSheetItem timeSheetItem, String newEmployee) {
        TimeSheetItem copyItem = new TimeSheetItem(timeSheetItem);
        copyItem.employee = newEmployee;
        return copyItem;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

}
