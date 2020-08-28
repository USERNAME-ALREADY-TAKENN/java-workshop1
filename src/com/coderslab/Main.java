package com.coderslab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String dataFilename = "data.csv";
        String[] fileData = MyFiles.readFile(dataFilename);
        String[] menu = {
                "Pokaż listę zadań",
                "Dodaj zadanie",
                "Usuń zadanie",
                "Zapisz do pliku",
                "Wyjdź"
        };

        chooseAction(dataFilename, fileData, menu);
    }
    public static int getInput(int menuLength) {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("\tZła wartość. Podaj liczbę pomiędzy 1 a " + (menuLength+1) + ": ");
        }
        int chosenOption = scan.nextInt();
        return chosenOption;
    }
    public static void chooseAction(String dataFilename, String[] fileData, String[] menu) {
        display.showList(fileData, menu);
        int chosenOption = getInput(menu.length);

        switch (chosenOption) {
            case 1: display.showList(fileData, menu);;
                break;
            case 2: fileData = modify.addTask(fileData);
                MyFiles.saveToFile(fileData, dataFilename);
                break;
            case 3: fileData = modify.removeTask(fileData);
                break;
            case 4: MyFiles.saveToFile(fileData, dataFilename);
                    break;
            case 5:
            default:
                MyFiles.saveToFile(fileData, dataFilename);
                return;
        }
        chooseAction(dataFilename, fileData, menu);
    }
}
