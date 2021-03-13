import decorator.*;
import memento.*;
import state.*;
import command.*;

import java.text.NumberFormat;
import java.util.Scanner;

public class OnlineJerseyStore {

    public static void  main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        JerseyStoreState state = new JerseyStoreState();
        System.out.println("Welcome to the Jersey Shop!");


        Jersey jersey = jerseySelection(scanner, state);

        JerseyCustomizationHistory history = new JerseyCustomizationHistory();

        Jersey initial = jersey;

        while (true) {
            jersey = initial;
            if (history.customizationStates.size() != 0) {
                System.out.println("Your previous selections were:\n");
                for(int i = 0; i < history.customizationStates.size(); i++) {
                    JerseyCustomizationState cusState = history.customizationStates.get(i);
                    System.out.println("Selection " + i + "\nName: " + cusState.getJerseyNameCustomizations() + "\nNumber: " + cusState.getJerseyNumberCustomizations());
                }
            }

            JerseyCustomizationState jerseyState = new JerseyCustomizationState();

            while (true) {
            	String customName = getInput(scanner, state, "Would you like to add a custom name? Yes or No.");
            	jerseyState.setJerseyNameCustomizations(customName);
            	if (customName.equalsIgnoreCase("Yes")) {
            		jersey = new NameCustomization(jersey);
            		break;
            	}
            	if (customName.equalsIgnoreCase("no")) {
            		break;
            	}
            	System.out.println("That is not an option.");
            }

            while (true) {
            	String customNumber = getInput(scanner, state, "Would you like to add a custom number? Yes or No.");
            	jerseyState.setJerseyNumberCustomizations(customNumber);
            	if (customNumber.equalsIgnoreCase("yes")) {
            		jersey = new NumberCustomization(jersey);
            		break;
            	}
            	if (customNumber.equalsIgnoreCase("no")) {
            		break;
            	}
            	System.out.println("That is not an option.");
            }

            history.push(jerseyState);

            String done = getInput(scanner, state, "Are you happy with your order? Yes or No.\n" + jersey.getDescription());
            if (done.equalsIgnoreCase("yes")) {
                break;
            }
        }

        String creditCardNumber;
        while (true) {
            creditCardNumber = getInput(scanner, state, "Please enter your 16 digit credit card number for payment:");

            if (creditCardNumber.replaceAll("[^0-9]", "").length() == 16) {
                state.enterPaymentInformation();
                System.out.println("Thank you for entering your payment information.");
                break;
            }
            System.out.println("The credit card number you have entered is not the correct length. Please enter the information again.");
        }
        
        System.out.println("Here is your order:\n");
        String jerseyCost = NumberFormat.getCurrencyInstance().format(jersey.cost());
        System.out.println(jersey.getDescription() + ", " + jerseyCost);
        
        while (true) {
        	System.out.println("\nPlease enter 'Place Order' when you are ready to submit your order.");
        	String submitOrder = scanner.nextLine();
        	if (submitOrder.equalsIgnoreCase("place order")) {
        		var checkout = new Checkout();
            	var orderCommand = new PlaceOrderCommand(checkout);
            	var placeOrder = new PlaceOrder(orderCommand);
            	placeOrder.click();
                state.placeOrder();
                break;
        	}
        	System.out.println("Could not submit order. Please try again.");
        }
    }

    private static Jersey jerseySelection(Scanner scanner, JerseyStoreState state) {
        String teamName;
        Jersey jersey;
        while (true) {
            teamName = getInput(scanner, state, "We currently have jerseys for Arsenal, Chelsea, Liverpool, and Manchester City.\nPlease enter the name of the team whose jersey you would like to purchase:");

            if (teamName.equalsIgnoreCase("arsenal")) {
                jersey = new ArsenalJersey();
                break;
            }
            if (teamName.equalsIgnoreCase("chelsea")) {
                jersey = new ChelseaJersey();
                break;
            }
            if (teamName.equalsIgnoreCase("liverpool")) {
                jersey = new LiverpoolJersey();
                break;
            }
            if (teamName.equalsIgnoreCase("manchester city")) {
                jersey = new ManchesterCityJersey();
                break;
            }
            System.out.println("We do not carry a jersey for that team.");
        }
        return jersey;
    }

    private static String getInput(Scanner scanner, JerseyStoreState state, String prompt) {
        String answer = "";
        while (true) {
            System.out.println(prompt);
            answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("place order")) {
                state.placeOrder();
            }
            else {
                break;
            }
        }
        return answer;
    }

}
