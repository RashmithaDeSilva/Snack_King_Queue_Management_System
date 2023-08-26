package Task_1;
import java.io.*;
import java.util.Scanner;


public class SnackKingQueueManagementSystem implements Serializable {

    private String[] q1 = new String[2];
    private String[] q2 = new String[3];
    private String[] q3 = new String[5];
    private int pizzaStock = 100;

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
                    SKQMS_obj.viewAllEmptyQueues();
                    break;
                case "102", "ACQ":
                    SKQMS_obj.addCustomer();
                    break;
                case "103", "RCQ":
                    SKQMS_obj.removeCustometr();
                    break;
                case "104", "PCQ":
                    SKQMS_obj.removeServedCustometr();
                    break;
                case "105", "VCS":
                    SKQMS_obj.sortedNames();
                    break;
                case "106", "SPD":
                    SKQMS_obj.storeProgramDataIntoFile(SKQMS_obj);
                    break;
                case "107", "LPD":
                    SKQMS_obj = SKQMS_obj.loadProgramDataFromFile();
                    break;
                case "108", "STK":
                    SKQMS_obj.viewRemainingPizzaStock();
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


    // Name validation
    private String nameValidation(String name) {
        if (name.matches("[a-zA-Z\\s]+")) {
            return name;
        } else {
            return null;
        }
    }


    // Get int user input ----------------------------------------------------------------------------------------------
    private int getIntInput(String inputLabelName) {
        System.out.print(inputLabelName);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\tInvalid input. Please enter an integer !");
            return -1;
        }
    }


    // View all queues (100 or VFQ) ------------------------------------------------------------------------------------
    private void viewAllQueues() {
        printWindowName("View All Queues ");
        System.out.println("\t\t\t\t\t\t\tQ1\tQ2\tQ3");
        System.out.println("\t\t\t\t\t\t\t----------");
        for (int i=0;i<q3.length;i++) {
            if (i<2) {
                System.out.print(q1[i] != null ? "\t\t\t\t\t\t\tO\t" : "\t\t\t\t\t\t\tX\t");
                System.out.print(q2[i] != null ? "O\t" : "X\t");
                System.out.print(q3[i] != null ? "O\t" : "X\t");

            } else if (i == 2) {
                System.out.print("\t\t\t\t\t\t\t \t");
                System.out.print(q2[i] != null ? "O\t" : "X\t");
                System.out.print(q3[i] != null ? "O\t" : "X\t");

            } else {
                System.out.print("\t\t\t\t\t\t\t \t");
                System.out.print(" \t");
                System.out.print(q3[i] != null ? "O\t" : "X\t");
            }
            System.out.println();
        }
    }


    // View all empty queues (101 or VFQ) ------------------------------------------------------------------------------
    private void viewAllEmptyQueues() {
        printWindowName("View All Empty Queues ");
        System.out.print("\t\t\tQueues 1:\t");
        for (int i=0;i< q1.length;i++) {
            if (q1[i] == null){
                System.out.print(i+1 + ",\t");
            }
        }
        System.out.print("\n\t\t\tQueues 2:\t");
        for (int i=0;i< q2.length;i++) {
            if (q2[i] == null){
                System.out.print(i+1 + ",\t");
            }
        }
        System.out.print("\n\t\t\tQueues 3:\t");
        for (int i=0;i< q3.length;i++) {
            if (q3[i] == null){
                System.out.print(i+1 + ",\t");
            }
        }
        System.out.println();
    }


    // Add customer to a queue (102 or ACQ) ----------------------------------------------------------------------------
    private void addCustomer() {
        printWindowName("Add Customer to a Queue ");
        boolean loopbreack = true;

        while (loopbreack) {
            int queueNumber = getIntInput("\nEnter queue number:\t");
            String customerName;
            boolean loopbreack2 = true;

            if (queueNumber == 1) {
                if (q1[q1.length-1] != null) {
                    System.out.println("\tThis queue is full. Try another queue !");
                    break;
                }

                for (int i=0;i<q1.length;i++) {
                    if (q1[i] == null) {
                        while (true) {
                            customerName = getStringInput("Enter customer name: ");
                            if (nameValidation(customerName) != null) {
                                q1[i] = customerName;
                                break;
                            } else {
                                System.out.println("\tInvalid customer name !");
                            }
                        }
                        System.out.println("\tSuccessfully add customer\n");
                        loopbreack2 = false;
                        break;
                    }
                }
                loopbreack = loopbreack2;

            } else if (queueNumber == 2) {
                if (q2[q2.length-1] != null) {
                    System.out.println("\tThis queue is full try another queue !");
                    break;
                }

                for (int i=0;i<q2.length;i++) {
                    if (q2[i] == null) {
                        while (true) {
                            customerName = getStringInput("Enter customer name: ");
                            if (nameValidation(customerName) != null) {
                                q2[i] = customerName;
                                break;
                            } else {
                                System.out.println("\tInvalid customer name !");
                            }
                        }
                        System.out.println("\tSuccessfully add customer\n");
                        loopbreack2 = false;
                        break;
                    }
                }
                loopbreack = loopbreack2;

            } else if (queueNumber == 3) {
                if (q3[q3.length-1] != null) {
                    System.out.println("\tThis queue is full try another queue !");
                    break;
                }
                for (int i=0;i<q3.length;i++) {
                    if (q3[i] == null) {
                        while (true) {
                            customerName = getStringInput("Enter customer name: ");
                            if (nameValidation(customerName) != null) {
                                q3[i] = customerName;
                                break;
                            } else {
                                System.out.println("\tInvalid customer name !");
                            }
                        }
                        System.out.println("\tSuccessfully add customer\n");
                        loopbreack2 = false;
                        break;
                    }
                }
                loopbreack = loopbreack2;

            } else if (queueNumber == -1) {
            } else {
                System.out.println("Invalid queue number !");
            }
        }

    }


    // Remove a customer from a queue (103 or RCQ) ---------------------------------------------------------------------
    private void removeCustometr() {
        printWindowName("Remove a Customer from a Queue");
        boolean loopbreack = true;

        while (loopbreack) {
            int queueNumber = getIntInput("\nEnter queue number:\t");
            int customerNumber = -1;
            if (queueNumber > 0 && queueNumber < 4) {
                customerNumber = getIntInput("Enter customer number:\t");
            }

            if (queueNumber == 1) {
                if (customerNumber == -1) {
                } else if ((customerNumber-1) > q1.length || 0 > (customerNumber-1)) {
                    System.out.println("\tInvalid customer number !\n");
                } else {
                    if (q1[customerNumber-1] == null) {
                        System.out.println("\tThis position is already empty");

                    } else {
                        for (int i=0;i<q1.length;i++) {
                            if (i == (customerNumber-1)) {
                                q1[i] = null;

                            } else if (i < (q1.length-1) && 0 < i && q1[i] != null && q1[i-1] == null) {
                                q1[i-1] = q1[i];
                            }
                        }
                        q1[q1.length-1] = null;
                        System.out.println("\tSuccessfully remove customer");
                    }
                    loopbreack = false;
                }

            } else if (queueNumber == 2) {
                if (customerNumber == -1) {
                } else if ((customerNumber-1) > q2.length || 0 > (customerNumber-1)) {
                    System.out.println("\tInvalid customer number !\n");
                } else {
                    if (q2[customerNumber-1] == null) {
                        System.out.println("\tThis position is already empty");

                    } else {
                        for (int i=0;i<q2.length;i++) {
                            if (i == (customerNumber-1)) {
                                q2[i] = null;

                            } else if (i < (q2.length-1) && 0 < i && q2[i] != null && q2[i-1] == null) {
                                q2[i-1] = q2[i];
                            }
                        }
                        q2[q2.length-1] = null;
                        System.out.println("\tSuccessfully remove customer");
                    }
                    loopbreack = false;
                }

            } else if (queueNumber == 3) {
                if (customerNumber == -1) {
                } else if ((customerNumber-1) > q3.length || 0 > (customerNumber-1)) {
                    System.out.println("\tInvalid customer number !\n");
                } else {
                    if (q3[customerNumber-1] == null) {
                        System.out.println("\tThis position is already empty");

                    } else {
                        for (int i=0;i<q3.length;i++) {
                            if (i == (customerNumber-1)) {
                                q3[i] = null;

                            } else if (i < (q3.length-1) && 0 < i && q3[i] != null && q3[i-1] == null) {
                                q3[i-1] = q3[i];
                            }
                        }
                        q3[q3.length-1] = null;
                        System.out.println("\tSuccessfully remove customer");
                    }
                    loopbreack = false;
                }

            } else if (queueNumber == -1) {
            } else {
                System.out.println("Invalid queue number !");
            }
        }
    }


    // Remove a served customer (104 or PCQ) ---------------------------------------------------------------------------
    private void removeServedCustometr() {
        printWindowName("Remove a Customer from a Queue");
        boolean loopbreack = true;

        while (loopbreack) {
            int queueNumber = getIntInput("\nEnter queue number:\t");

            if (queueNumber == 1) {
                for (int i=0;i<q1.length;i++) {
                    if (i == 0) {
                        q1[i] = null;

                    } else if (i < q1.length - 1 && q1[i] != null && q1[i - 1] == null) {
                        q1[i-1] = q1[i];
                    }
                }
                q1[q1.length-1] = null;
                pizzaStock -= 10;
                System.out.println("\tSuccessfully remove served customer");
                loopbreack = false;

            } else if (queueNumber == 2) {
                for (int i=0;i<q2.length;i++) {
                    if (i == 0) {
                        q2[i] =null;

                    } else if (i < q2.length - 1 && q2[i] != null && q2[i - 1] == null) {
                        q2[i-1] = q2[i];
                    }
                }
                q2[q2.length-1] = null;
                pizzaStock -= 10;
                System.out.println("\tSuccessfully remove served customer");
                loopbreack = false;

            } else if (queueNumber == 3) {
                for (int i=0;i<q3.length;i++) {
                    if (i == 0) {
                        q3[i] = null;

                    } else if (i < q3.length - 1 && q3[i] != null && q3[i - 1] == null) {
                        q3[i-1] = q3[i];
                    }
                }
                q3[q3.length-1] = null;
                pizzaStock -= 10;
                System.out.println("\tSuccessfully remove served customer");
                loopbreack = false;

            } else if (queueNumber == -1) {
            } else {
                System.out.println("Invalid queue number !");
            }
        }
    }


    // View customer sorted in alphabetical order (105 or VCS) ---------------------------------------------------------
    private void sortedNames() {
        System.out.print("Queue 1:\t");
        sortArray(q1);

        System.out.print("Queue 2:\t");
        sortArray(q2);

        System.out.print("Queue 3:\t");
        sortArray(q3);
    }


    // Sort Array ------------------------------------------------------------------------------------------------------
    private void sortArray(String[] array) {
        String[] tempArray = new String[array.length];
        for (int i=0;i<tempArray.length;i++) {
            tempArray[i] = array[i] != null ? array[i].toUpperCase() : "";
        }
        for (int j=0;j<tempArray.length;j++) {
            for (int i=j+1;i<tempArray.length; i++) {
                if (tempArray[i].compareTo(tempArray[j]) < 0) {
                    String temp = tempArray[j];
                    tempArray[j] = tempArray[i];
                    tempArray[i] = temp;
                }
            }
        }
        for (String s : tempArray) {
            if (!s.isEmpty()) {
                System.out.print(s + "\t");
            }
        }
        System.out.println("\n");
    }


    // Store program data into file (106 or SPD) -----------------------------------------------------------------------
    private void storeProgramDataIntoFile(SnackKingQueueManagementSystem SKQMS) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Data-file.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(SKQMS);
                System.out.println("\tSuccessfully save data into file");

        } catch (IOException e) {
            System.out.println("\tError occurred try again !");
        }
    }


    // Load program data from file (107 or LPD)
    private SnackKingQueueManagementSystem loadProgramDataFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream("Data-file.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            System.out.println("\tSuccessfully load data from file");
            return (SnackKingQueueManagementSystem) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\tError occurred try again !");
            return null;
        }
    }


    // View remaining pizza stock (108 or STK)
    private void viewRemainingPizzaStock() {
        System.out.println("\tRemaining pizza stock: " + pizzaStock);
    }



}
