package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path folder){
        Path file = folder.resolve(account.getAccountNumber()+".dat");
        try (DataOutputStream dos = new DataOutputStream( new BufferedOutputStream(Files.newOutputStream(file)))){
            dos.writeUTF(account.getAccountNumber());
            dos.writeUTF(account.getName());
            dos.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot save bank account data",e);
        }
    }

    public BankAccount loadAccount(InputStream inputStream){
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(inputStream))) {
            String accountNumber = dis.readUTF();
            String name = dis.readUTF();
            double balance = dis.readDouble();
            return new BankAccount(accountNumber,name,balance);

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read bank account data",e);
        }
    }
}
