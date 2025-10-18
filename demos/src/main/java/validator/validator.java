package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator {

    /*Hozzunk létre egy reguláris kifejezéseken alapuló validátor osztályt a gyakrabban
    előforduló validálási feladatokra.

    A validateEmail() metódus olyan stringet fogadjon csak el, ami e-mail formátumú.
    Az e-mail formátumot a következőképp definiáljuk:

    Van benne @ karakter
    A @ előtt elfogadható kis- és nagybetű, számjegy, aláhúzásjel, kötőjel és pont
    A @ utáni rész a domain
    A domain bármennyi ponttal elválasztott tagot tartalmazhat
    Az utolsó tagon kívül szerepelhet kis- és nagybetű, számjegy, aláhúzásjel és kötőjel
    Az utilsó tag 2-4 darab kis- vagy nagybetűt tartalmazhat

    A validateAcademicYear() metódus két évszámot vár kötőjellel elválasztva.
    Az évszámnak 2000 és 2099 között bármi elfogadható. Nem kell figyelni arra,
    hogy az első kisebb legyen, mint a második.

    A validateYear() metódus 2000 és 2999 bármilyen évszámot elfogadhat.

      Hibakezelés
    null vagy üres string, illetve évszám validálás esetén a null érték dobjon IllegalArgumentException-t

      Megvalósítás
    Használjuk a String matches() metódust és a Pattern és Matcher osztályokat is felváltva a különböző validátorokban.

    publikus metódusok:

    Copy Code
    public boolean validateEmail(String email)
    public boolean validateAcademicYear(String academicYear)
    public boolean validateYearString(String yearString)
    Tippek
    Az összeállított reguláris kifejezéseket konstansként adjuk meg!
    A paraméter ellenőrzésére hozzunk létre egy boolean isEmpty(String str) metódust!*/

    public static final String VALIDATOR_FOR_EMAIL_CHECK =
            "^[A-Za-z0-9._-]+@[A-Za-z0-9_-]+(?:\\.[A-Za-z0-9_-]+)*\\.[A-Za-z]{2,4}$";
    public static final String VALIDATOR_FOR_ACADEMIC_YEARS_CHECK = "^20\\d{2}-20\\d{2}$";
    public static final String VALIDATOR_FOR_YEAR_CHECK = "^2\\d{3}$";


    private Pattern pattern;
    private Matcher matcher;


    public boolean validateEmail(String email){
        validate(email);
        pattern = Pattern.compile(VALIDATOR_FOR_EMAIL_CHECK);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateAcademicYear(String academicYear){
        validate(academicYear);
        pattern = Pattern.compile(VALIDATOR_FOR_ACADEMIC_YEARS_CHECK);
        matcher = pattern.matcher(academicYear);
        return matcher.matches();
    }

    public boolean validateYearString(String yearString){
        validate(yearString);
        pattern = Pattern.compile(VALIDATOR_FOR_YEAR_CHECK);
        matcher = pattern.matcher(yearString);
        return matcher.matches();
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    private void validate(String text){
        if(text== null || text.isBlank()){
            throw new IllegalArgumentException("Text can not be empty or null.");
        }
    }


}
