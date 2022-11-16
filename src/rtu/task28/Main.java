package rtu.task28;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Path: ");
        Scanner scanner = new Scanner(System.in);
        try {
            CatalogToList(scanner.nextLine());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void CatalogToList(String path) throws Exception {
        File file = new File(path);

        if(!file.exists() || !file.isDirectory())
        {
            throw new Exception("Wrong path!");
        }

        List<String> filesName = Arrays.asList(Objects.requireNonNull(file.list()));

        for (int i = 0; i < filesName.size() && i < 5; i++) {
            System.out.println(filesName.get(i));
        }
    }
}
