package org.thisday;

import org.thisday.API.WikipediaOnThisDay;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        String ASCII =  "   ____           ________    _         ____             \n" +
                    "  / __ \\____     /_  __/ /_  (_)____   / __ \\____ ___  __\n" +
                    " / / / / __ \\     / / / __ \\/ / ___/  / / / / __ `/ / / /\n" +
                    "/ /_/ / / / /    / / / / / / (__  )  / /_/ / /_/ / /_/ / \n" +
                   "\\____/_/ /_/    /_/ /_/ /_/_/____/  /_____/\\__,_/\\__, /  \n" + "                                                /____/   ";


        System.out.println(Utility.ANSI_BLUE + ASCII + Utility.ANSI_RESET);

        System.out.println("Enter month number");
        int month = 0;
        try {
            month = scan.nextInt();
        } catch (Exception e) {
            System.out.println(Utility.ANSI_RED + "Only accepting numbers");
            System.exit(0);
        }
        System.out.println("Enter day number");
        int day = 0;
        try {
            day = scan.nextInt();
        } catch (Exception e) {
            System.out.println(Utility.ANSI_RED + "Only accepting numbers");
            System.exit(0);
        }
        System.out.println("Do you want to see events, births, or deaths?");
        System.out.println("Enter 1 for events, 2 for births, 3 for deaths");
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println(Utility.ANSI_RED + "Only accepting numbers");
            System.exit(0);
        }
        if (choice != 1 && choice != 2 && choice != 3) {
            System.out.println(Utility.ANSI_RED + "Only accepting numbers from 1 to 3");
            System.exit(0);
        }
        if (choice == 1) {
            System.out.println(WikipediaOnThisDay.top3Events(WikipediaOnThisDay.getOnThisDayEvents(month, day)));
        } else if (choice == 2) {
            System.out.println(WikipediaOnThisDay.top3Births(WikipediaOnThisDay.getOnThisDayBirths(month, day)));
        } else if (choice == 3) {
            System.out.println(WikipediaOnThisDay.top3Deaths(WikipediaOnThisDay.getOnThisDayDeaths(month, day)));
        }


    }
}