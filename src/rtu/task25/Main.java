package rtu.task25;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new FilesApp();
    }
}

class FilesApp {
    public FilesApp() {
        try(FileWriter writer = new FileWriter("C:\\Users\\soumireL\\Code\\Java\\RTU\\src\\rtu\\task25\\text.txt", true))
        {
            Scanner scanner = new Scanner(System.in);
            String consoleInput = scanner.nextLine();
            writer.write(consoleInput);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}