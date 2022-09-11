package org.theledgerco;

import org.theledgerco.Handler.Handler;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String path;

        if(args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter file path : ");
            path = scanner.nextLine();
        }else{
            path = args[0];
        }

        File file = new File(path);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        Handler handler = new Handler();

        String line;

        while ((line = bufferedReader.readLine()) != null){
            String[] input = line.split(" ");

            switch(input[0]){
                case "LOAN":
                    handler.processLoan(input);
                    break;
                case "BALANCE" :
                    handler.processBalance(input);
                    break;
                case "PAYMENT" :
                    handler.processPayment(input);
                    break;
                default:
                    break;
            }
        }

    }
}
