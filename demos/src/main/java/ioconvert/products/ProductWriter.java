package ioconvert.products;

import java.io.*;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream os, List<Product> products){
        try(PrintStream ps = new PrintStream(os)){
            for (Product product : products) {
                ps.print(product.getName());
                ps.print(";");
                ps.print(product.getPrice());
                ps.println();

            }
        }
    }
}
