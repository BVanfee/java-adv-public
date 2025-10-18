package filescanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BucketList {
    /*A bakancslistánkat egy szöveges fájlba írtuk, minden
    pontot külön-külön sorba. A bucketlist.txt a projekt gyökérkönyvtárában
     található. Listázd ki a fájl tartalmát a képernyőre a BucketList osztály main()
     metódusában! Amennyiben hiba történik a fájl megnyitásakor vagy olvasása közben,
      jelezd a hibát a felhasználónak!*/

    public void readFromFile(){
        try(Scanner scanner =new Scanner( BucketList.class.getResourceAsStream("/bucketlist.txt"))){
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }

    }

    public static void main(String[] args) {
        BucketList bucketList = new BucketList();

        bucketList.readFromFile();

    }
}
