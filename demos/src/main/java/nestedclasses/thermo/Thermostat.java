package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {
    /*Készíts egy thermo.Thermostat osztályt, amely szabályozza adott épületben levő,
    hőmérővel rendelkező helyiségek fűtését! Egy épületben tetszőleges számú hőmérő lehet.
    A termosztát rendelkezik egy roomsToHeat listával, amely azon szobák neveit tartalmazza,
    amelyet fűt. A hőmérők (thermo.ThermoMeter osztály) értesítéseket kell küldjenek,
    amikor a hőmérséklet megváltozik (a példában ez a hőmérő setTemperature() metódusának
    meghívásával történhet meg). Az értesítéseket a figyelő objektumok kapják,

    akik a termosztátban beállított hőmérséklettől függően módosítják a roomsToHeat listáját.

A ThermometerObserver interfész tartalmazza azon metódus deklarációját,
amellyel a hőmérő értesíti a figyelőket: void handleTemperatureChange(int temp, String room)

A Thermometer osztály egy hőmérő.

Rendelkezik a szoba neve és hőmérséklete adatokkal,
valamint egy ThermometerObserver referenciával, akit értesíteni kell!
Általában tetszőleges számú figyelő lehet, de most legyen csak egyetlen figyelő!)
Létrehozáskor a szoba nevét és a hőmérsékletét lehet megadni, figyelő nincsen (értéke null)!
Legyenek getterei a tagokhoz!
Legyen egy metódusa (onTemperatureChanged()), amely ha van bejegyzett
figyelő meghívja a figyelő handleTemperatureChange metódusát!
Legyen setter metódus a hőmérséklet adatra (setTemperature),
amelyik az adatbeállításon kívül még meghívja az onTemperatureChanged metódust!
Legyen metódusa, amely meghívásával a figyelő bejegyezheti magát
mint figyelő (setThermometerObserver(ThermometerObserver observer))!
(Figyeljünk rá, hogy a figyelő bejegyzése hőmérséklet változásnak számít.)

A Thermostat osztály reprezentálja a termosztátot.

Rendelkezik egy Thermometer listával, egy fűtött szobák nevének listájával,
valamint egy temperatureLimit attribútummal, amely a termosztáton beállított (minimum) hőmérséklet.
Létrehozáskor a két lista üres legyen és a hőmérséklet limit értéke legyen 23!
Legyen egy addThermometer(Thermometer thermometer) metódusa,
amellyel egy újabb hőmérőt adhatunk a termosztáthoz!
A hőmérő hozzáadásakor jegyezzünk be hozzá egy figyelő objektumot
(mely egy ThermometerObserver típusú névtelen belső osztály),
amelyet a bejegyzés utasításában definiáljunk. Implementálja a
ThermometerObserver interface-t úgy, hogy ha a szoba hőmérséklete kisebb,
mint a termosztát limit-je, akkor tegye be a fűtött szobák listájába a szobát,
ha nem akkor vegye ki onnan.
Legyen getter a fűtött szobák listájára*/

    private List<Thermometer> thermometers;
    private List<String> roomsToHeat;
    private int temperatureLimit;

    public Thermostat() {
        this.thermometers = new ArrayList<>();
        this.roomsToHeat = new ArrayList<>();
        this.temperatureLimit = 23;
    }

    public void addThermometer(Thermometer thermometer) {
        if (thermometer == null) {
            throw new IllegalArgumentException("Thermometer can not be null");
        }
        thermometers.add(thermometer);
        thermometer.setThermometerObserver(new ThermometerObserver() {
            @Override
            public void handleTemperatureChange(int temp, String room) {
                if (temp < temperatureLimit) {
                    roomsToHeat.add(room);
                } else {
                    roomsToHeat.remove(room);
                }
            }
        });
    }

    public List<String> getRoomsToHeat() {
        return new ArrayList<>(roomsToHeat);
    }
}
