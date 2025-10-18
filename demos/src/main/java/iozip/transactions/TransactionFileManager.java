package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    /*Az iozip.transactions csomagba készíts egy Transaction immutable
    osztályt, melyben a tranzakció azonosítója (long id), a tranzakció
    pontos időpontja (LocalDateTime time), az érintett bankszámla száma
    (String account) és a tranzakció összege (double amount) található.

A TransactionFileManager osztály saveTransactions() metódusa a paraméterként
kapott Path-ra elmenti a Transaction listában kapott tranzakciókat tömörítve.
Minden tranzakció külön szöveges fájlba kerüljön! A fájl neve a tranzakció
azonosítója legyen! Tartalma sortöréssel (\n) elválasztva az időpont, a
bankszámlaszám és az összeg.*/

    public void saveTransactions(Path path, List<Transaction> transactions) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Transaction transaction : transactions) {
                zos.putNextEntry(new ZipEntry(Long.toString(transaction.getId())));
                String outputString = transaction.getTime().toString() + "\n"
                        + transaction.getAccount() + "\n" + transaction.getAmount();
                zos.write(outputString.getBytes());
                zos.closeEntry();
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot write zip file.",e);
        }
    }
}
