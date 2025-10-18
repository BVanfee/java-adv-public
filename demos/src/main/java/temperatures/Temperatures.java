package temperatures;

import java.util.Arrays;

public class Temperatures {
    /*Az előző 365 nap hőmérsékleti adatait fájlban tároljuk.
    A Temperatures osztály attribútumában ezek találhatók egy byte[]-ben.
    Az osztály konstruktorban kapja meg a hőmérsékleti adatokat. A getYearAverage()
    metódusa a teljes év átlaghőmérsékletét adja vissza, a getMonthAverage() az
    utolsó 30 napét. Készíts egy TemperatureReader osztályt, mely egyetlen
    readTemperatures() metódusa bináris fájlból beolvassa az eltárolt
    hőmérsékleteket, és egy Temperatures példánnyal tér vissza! Ugyanennek
     mintájára készíts egy TemperaturesWriter osztályt, amelynek a writeTemperatures()
     metódusa a paraméterként kapott Temperatures példányból bináris fájlba
     írja a hőmérsékleti adatokat!*/

    public static final int NUMBER_OF_DAYS_FOR_YEAR_AVERAGE = 365;
    public static final int NUMBER_OF_DAYS_FOR_MONTH_AVERAGE = 30;

    private final byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage() {
        validate();
        int checkedNumberOfTemperatures = NUMBER_OF_DAYS_FOR_YEAR_AVERAGE;
        int sumValueOfData = 0;
        checkedNumberOfTemperatures = getCheckedNumberOfTemperatures(checkedNumberOfTemperatures);
        sumValueOfData = getSumValueOfData(checkedNumberOfTemperatures, sumValueOfData);
        return (double) Math.round(sumValueOfData / (double) checkedNumberOfTemperatures * 100) / 100;
    }

    public double getMonthAverage() {
        validate();
        int checkedNumberOfTemperatures = NUMBER_OF_DAYS_FOR_MONTH_AVERAGE;
        int sumValueOfData = 0;
        checkedNumberOfTemperatures = getCheckedNumberOfTemperatures(checkedNumberOfTemperatures);
        sumValueOfData = getSumValueOfData(checkedNumberOfTemperatures, sumValueOfData);
        return (double) Math.round(sumValueOfData / (double) checkedNumberOfTemperatures * 100) / 100;
    }

    private void validate() {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data is empty");
        }
    }

    private int getCheckedNumberOfTemperatures(int checkedNumberOfTemperatures) {
        if (data.length < checkedNumberOfTemperatures) {
            checkedNumberOfTemperatures = data.length;
        }
        return checkedNumberOfTemperatures;
    }

    private int getSumValueOfData(int checkedNumberOfTemperatures, int sumValueOfData) {
        int index = data.length - checkedNumberOfTemperatures;
        for (int i = index; i < data.length; i++) {
            sumValueOfData += Byte.valueOf(data[i]);
        }
        return sumValueOfData;
    }


    public byte[] getData() {
        return data;
    }
}
