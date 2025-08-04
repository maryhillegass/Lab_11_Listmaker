import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {


    public static void main(String[] args) {
        //make a looping menu until confirmed quit
        Scanner in = new Scanner(System.in);
        boolean done = false;
        //Create the array list
        ArrayList<String> inputList = new ArrayList<>();

        do{
            displayList(inputList);
            displayMenu();
            String menuInput = SafeInput.getRegExString(in, "Select a menu option", "[AaDdIiPpQq]");

            switch (menuInput.toLowerCase()){
                case "q":
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;

                case "a":
                    inputList.add(SafeInput.getNonZeroLenString(in,"What would you like to add to the end of the list?"));
                    break;

                case "d":
                    if (inputList.size() == 0) {
                        System.out.println("There is nothing to delete.");
                        break;
                    }
                    int delLocation = SafeInput.getRangedInt(in, "What position in the like would you like to delete?", 1,inputList.size()) - 1;
                    inputList.remove(delLocation);
                    break;

                case "i":
                    if (inputList.size() == 0){
                        inputList.add(SafeInput.getNonZeroLenString(in,"What would you like to insert to list?"));
                        break;
                    }
                    int insLocation = SafeInput.getRangedInt(in, "What position in the like would you like to insert?", 1,inputList.size()) - 1;
                    inputList.add(insLocation, SafeInput.getNonZeroLenString(in, "What would you like to insert into the list?"));
                    break;

                case "p":
                    displayList(inputList);
                    break;
            }

            /*
            replaced with switch
            if (menuInput.equalsIgnoreCase("q")){
                done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
            }*/

            } while (!done);
    }


    /*
    Displays the numbered array list
     */
    private static void displayList(ArrayList<String> arrayList){
        System.out.println("Here is your list:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i+1) + "\t" + arrayList.get(i));
        }
        System.out.println();
    }

    /*
    Displays the menu
     */
    private static void displayMenu(){
        System.out.printf("What would you like to do?" +
                "\nA - Add an item to the list" +
                "\nD – Delete an item from the list" +
                "\nI – Insert an item into the list" +
                "\nP – Print (i.e. display) the list" +
                "\nQ – Quit the program\n");
    }
}
