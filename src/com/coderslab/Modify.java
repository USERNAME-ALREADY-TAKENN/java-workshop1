package com.coderslab;

import java.util.Arrays;
import java.util.Scanner;

public class Modify {
    public static String[] addTask (String[] stringArray) {
        System.out.println("\t" + "Podaj nowe zadania w osobnych liniach, wpisz 'quit' aby zakończyć");
        System.out.println("\t" + "Format zadania: 'treść zadania, ważne: true lub false'");

        Scanner scan = new Scanner(System.in);
        String line;
        while (true) {
            System.out.print('\t');
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
