package com.coderslab;

import java.util.Arrays;

public class Display {
    public static void showList (String[] dataList, String[] menu) {
        int lineLength = 80;
        String leftDecorator = "\t█\t";
        String rightDecorator = "█";
        String topDecorator = "█";
        String bottomDecorator = "█";

        String[][] values = new String[0][2];
        for (int i = 0; i < dataList.length; i++) {
            values = Arrays.copyOf(values, values.length + 1);
            values[i] = dataList[i].split(", ");
        }
        System.out.print(ConsoleColors.BLUE);
        System.out.println("\n\t" + fill("", lineLength + 5, topDecorator));
        System.out.print(leftDecorator + ConsoleColors.RED + fill("#  nazwa", lineLength - 10, " "));
        System.out.print(fill("wykonane", 10, " ") + ConsoleColors.BLUE + rightDecorator + "\n");

        for (int i = 0; i < dataList.length; i++) {
            String leftColumn = ConsoleColors.YELLOW + fill((i+1) + ". " + values[i][0], lineLength-10, " ");
            String rightColumn = fill(values[i][1], 10, " ") + ConsoleColors.BLUE;
            System.out.print(leftDecorator + leftColumn + rightColumn + rightDecorator + "\n");
        }
        System.out.println("\t" + fill("", lineLength + 5, bottomDecorator) + ConsoleColors.RESET);

        showMenu(menu);
    }
    public static String fill(String toFill, int lengthMatch, String fillString) {
        lengthMatch = lengthMatch - toFill.length();
        String filler = new String(new char[lengthMatch]).replace("\0", fillString);
        String filledString = toFill + filler;
        return filledString;
    }
    public static void showMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\t" + (i+1) + ". " + menu[i]);
        }
        System.out.print(ConsoleColors.RED + "\tWybierz opcję: " + ConsoleColors.RESET);
    }
}
