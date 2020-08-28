package com.coderslab;

public class display {
    public static void showList (String[] dataList, String[] menu) {
        int lineLength = 50;
        String leftDecorator = "\t█\t";
        String rightDecorator = "█";
        String topDecorator = "█";
        String bottomDecorator = "█";

        System.out.println("\n\t" + fill("", lineLength + 3, topDecorator));
        for (int i = 0; i < dataList.length; i++) {
            String filledLine = fill(leftDecorator + (i+1) + ". " + dataList[i], lineLength + rightDecorator.length(), " ");
            System.out.print(filledLine + rightDecorator + "\n");
        }
        System.out.println("\t" + fill("", lineLength + 3, bottomDecorator));

        showMenu(menu);
    }
    public static String fill(String toFill, int lenghtMatch, String fillString) {
        lenghtMatch = lenghtMatch - toFill.length();
        String filler = new String(new char[lenghtMatch]).replace("\0", fillString);
        String filledString = toFill + filler;
        return filledString;
    }
    public static void showMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\t" + (i+1) + ". " + menu[i]);
        }
        System.out.print("\tWybierz opcję: ");
    }
}
