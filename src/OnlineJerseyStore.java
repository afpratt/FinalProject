import decorator.*;
import state.*;
import Memento.*;
import Command.*;

import java.text.NumberFormat;
import java.util.Scanner;

public class OnlineJerseyStore {

    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Jersey Shop!");
        System.out.println("We currently have jerseys for Arsenal, Chelsea, Liverpool, and Manchester City.");

        Jersey jersey;
        String teamName;
        while (true) {
            System.out.println("Please enter the name of the team whose jersey you would like to purchase:");
            teamName = scanner.nextLine();

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

        
        System.out.println("Would you like to add a custom name? Yes or No.");
        String customName = scanner.next();
        if (customName.equalsIgnoreCase("Yes")) {
           jersey = new NameCustomization(jersey);
        }

        System.out.println("Would you like to add a custom number? Yes or No.");
        String customNumber = scanner.next();
        if (customNumber.equalsIgnoreCase("yes")) {
            jersey = new NumberCustomization(jersey);
        }


        String creditCardNumber;
        while (true) {
            System.out.println("Please enter your 16 digit credit card number for payment:");
            creditCardNumber = scanner.nextLine().replaceAll("[^0-9]", "");

            if (creditCardNumber.length() == 16) {
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
            	break;
        	}
        	System.out.println("Could not submit order. Please try again.");
        }
    }

}
