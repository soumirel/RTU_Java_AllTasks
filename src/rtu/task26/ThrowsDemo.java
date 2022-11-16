package rtu.task26;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print("Enter Key ");
        String key = myScanner.nextLine();
        try {
            printDetails( key );
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message ); }
    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}


class Main {
    public static void main(String[] args) {
        ThrowsDemo td = new ThrowsDemo();
        td.getKey();
    }
}