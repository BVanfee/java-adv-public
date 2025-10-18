package ioreader.states;

public class State {
    /*USA tagállamok
A következő feladatban a states csomagban kell dolgoznod! A stateregister.txt állomány
 tartalmazza az Amerikai Egyesült Államok államait és azok fővárosait kötőjellel elválasztva.
  Neked ezt a fájlt kell feldolgoznod és egy keresés algoritmust készítened!

Hozzd létre a State java osztályt melynek két attribútuma az állam neve stateName és
a főváros neve capital! (Konstruktor,getterek!)

A StateRegister osztály felelős a file beolvasásáért és a State objektumok létrehozásáért,
valamint a keresésért. Legyen benne egy lista states , State generikussal, amibe a
readStatesfromFile(stringFileName) eltárolja a beolvasott adatokat.
A findCapitalByStateName(String stateName) megkeresi a paraméterül kapott állam fővárosát.
Ha nincs ilyen állam akkor IllegalArgument exception-t dob!*/
    private String stateName;
    private String capital;

    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }
}
