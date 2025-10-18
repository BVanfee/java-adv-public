package collectionsclass;

public class ExamResult {
    /*Készíts egy ExamResult osztályt, amely egy felvételi vizsgán részt
    vevő személy eredményét tárolja! Két attribútuma a felvételiző neve
    és az eredménye (pontszám formájában). Majd készítsd el az Exam osztályt,
    amelynek List<ExamResult> attribútuma tárolja a felvételi eredményeket!
    A lista értékét konstruktorban kapja meg! Legyen egy
    List<String> getNamesOfSucceededPeople(int places), amely visszaadja azok listáját,
     akik felvételt nyertek (a places paraméter mondja meg, hogy hány helyre vesznek föl
     embereket)! A listában a felvett emberek neve az eredményeik szerinti sorrendben
     szerepeljen, tehát legelöl legyen a legtöbb pontot elért ember neve!
     Kezeld a metódusban azt is, ha a felvételi helyek száma több,
     mint ahányan egyáltalán jelentkeztek!*/

    private String name;
    private int result;

    public ExamResult(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }
}
