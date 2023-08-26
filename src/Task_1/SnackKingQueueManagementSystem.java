package Task_1;

import java.util.Scanner;

public class SnackKingQueueManagementSystem {

    private Boolean[] q1 = {false, false};
    private Boolean[] q2 = {false, false, false};
    private Boolean[] q3 = {false, false, false, false, false};

    // Main method -----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        SnackKingQueueManagementSystem SKQMS_obj = new SnackKingQueueManagementSystem();
        boolean runProgram = true;

        while (runProgram) {
            switch (SKQMS_obj.mainMenu()) {
                case "100", "VFQ":
                    SKQMS_obj.viewAllQueues();
                    break;
                case "101", "VEQ":
                    System.out.println("101");
                    break;
                case "102", "ACQ":
                    System.out.println("102");
                    break;
                case "103", "RCQ":
                    System.out.println("103");
                    break;
                case "104", "PCQ":
                    System.out.println("104");
                    break;
                case "105", "VCS":
                    System.out.println("105");
                    break;
                case "106", "SPD":
                    System.out.println("106");
                    break;
                case "107", "LPD":
                    System.out.println("107");
                    break;
                case "108", "STK":
                    System.out.println("108");
                    break;
                case "109", "AFS":
                    System.out.println("109");
                    break;
                case "999", "EXT":
                    runProgram = false;
                    break;
                default:
                    System.out.println("This input is invalid !");
                    break;
            }
        }

    }


    // Main menu -------------------------------------------------------------------------------------------------------
    private String mainMenu() {
        printWindowName("Main Menu ");
        System.out.println("\t100 or VFQ:\tView all queues");
        System.out.println("\t101 or VEQ:\tView all empty queues");
        System.out.println("\t102 or ACQ:\tAdd customer to a queue");
        System.out.println("\t103 or RCQ:\tRemove a customer from a queue");
        System.out.println("\t104 or PCQ:\tRemove a served customer");
        System.out.println("\t105 or VCS:\tView customer sorted in alphabetical order");
        System.out.println("\t106 or SPD:\tStore program data into file");
        System.out.println("\t107 or LPD:\tLoad program data from file");
        System.out.println("\t108 or STK:\tView remaining pizza stock");
        System.out.println("\t109 or AFS:\tAdd pizza to stock");
        System.out.println("\t999 or EXT:\tExit the program\n");
        return getStringInput("> ");
    }


    // Print window name -----------------------------------------------------------------------------------------------
    private void printWindowName(String windowName) {
        for (int i=0;i<70;i++) {
            System.out.print("*");
        }
        System.out.print("\n*");
        int len = 34 - (windowName.length()/2);
        for (int i=0;i<len;i++) {
            System.out.print(" ");
        }
        System.out.print(windowName);
        for (int i=0;i<len;i++) {
            System.out.print(" ");
        }
        System.out.print("*\n");
        for (int i=0;i<70;i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    // Get string user input -------------------------------------------------------------------------------------------
    private String getStringInput(String inputLabelName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(inputLabelName);
        return scanner.nextLine();
    }


    // View all queues (100 or VFQ)
    private void viewAllQueues() {
        printWindowName("View All Queues ");
        System.out.println("\t\t\t\t\t\t\tQ1\tQ2\tQ3");
        System.out.println("\t\t\t\t\t\t\t----------");
        for (int i=0;i<q3.length;i++) {
            if (i<2) {
                System.out.print(q1[i] ? "\t\t\t\t\t\t\tX\t" : "\t\t\t\t\t\t\tO\t");
                System.out.print(q2[i] ? "X\t" : "O\t");
                System.out.print(q3[i] ? "X\t" : "O\t");

            } else if (i == 2) {
                System.out.print("\t\t\t\t\t\t\t \t");
                System.out.print(q2[i] ? "X\t" : "O\t");
                System.out.print(q3[i] ? "X\t" : "O\t");

            } else {
                System.out.print("\t\t\t\t\t\t\t \t");
                System.out.print(" \t");
                System.out.print(q3[i] ? "X\t" : "O\t");
            }
            System.out.println();
        }
    }



}
