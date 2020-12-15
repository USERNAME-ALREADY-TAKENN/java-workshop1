package com.coderslab;

import java.util.Scanner;

public class Main {
    public static String DATA_FILENAME = "data.csv";
    public static String[] MENU = {
            "Pokaż listę zadań",
            "Dodaj zadanie",
            "Usuń zadanie",
            "Zapisz do pliku",
            "Wyjdź"
    };

    public static void main(String[] args) {
        String[] fileData = MyFiles.readFile(DATA_FILENAME);
        chooseAction(fileData);
    }
    public static int getInput() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("\tZła wartość. Podaj liczbę pomiędzy 1 a " + (MENU.length+1) + ": ");
        }
        int chosenOption = scan.nextInt();
        return chosenOption;
    }
    public static void chooseAction(String[] fileData) {
        Display.showList(fileData, MENU);
        int chosenOption = getInput();

        switch (chosenOption) {
            case 1: Display.showList(fileData, MENU);
                break;
            case 2: fileData = Modify.addTask(fileData);
                MyFiles.saveToFile(fileData, DATA_FILENAME);
                break;
            case 3: fileData = Modify.removeTask(fileData);
                break;
            case 4: MyFiles.saveToFile(fileData, DATA_FILENAME);
                    break;
            case 5:
            default:
                MyFiles.saveToFile(fileData, DATA_FILENAME);
                return;
        }
        chooseAction(fileData);
    }
}
