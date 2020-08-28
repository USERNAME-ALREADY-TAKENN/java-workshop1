package com.coderslab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class modify {
    public static String[] addTask (String[] stringArray) {
        System.out.print("\t" + "Podaj nowe zadania w osobnych liniach, wpisz 'quit' aby zakończyć: ");

        Scanner scan = new Scanner(System.in);
        String line;
        while (true) {
            line = scan.nextLine();
            if(line.equals("quit")) break;
            stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
            stringArray[stringArray.length -1] = line;
        }
        return stringArray;
    }
    public static String[] removeTask(String[] stringArray) {
        System.out.print("\tWybierz element do usunięcia: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("\tZła wartość. Podaj liczbę: ");
        }
        int toRemove = scan.nextInt();

        String[] changedArray = new String[stringArray.length - 1];

        for (int i = 0; i < changedArray.length; i++) {
            if(i + 1 == toRemove) {
                for (int j = i; j < changedArray.length; j++) {
                    changedArray[j] = stringArray[j+1];
                }
                break;
            }
            else changedArray[i] = stringArray[i];

        }
        return changedArray;
    }
}
