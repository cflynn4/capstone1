package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.MainActions;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {
	//We took inspiration from the provided menu, adding additional options for the purchase menu and money menu options.
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private static final String MONEY_MENU_OPTION_ONE = "Insert a 1 Dollar Bill";
	private static final String MONEY_MENU_OPTION_TWO = "Insert a 2 Dollar Bill";
	private static final String MONEY_MENU_OPTION_FIVE = "Insert a 5 Dollar Bill";
	private static final String MONEY_MENU_OPTION_TEN = "Insert a 10 Dollar Bill";
	private static final String MONEY_MENU_OPTION_TWENTY = "Insert a 20 Dollar Bill";
	private static final String[] MONEY_MENU_OPTIONS = {MONEY_MENU_OPTION_ONE, MONEY_MENU_OPTION_TWO,
			MONEY_MENU_OPTION_FIVE, MONEY_MENU_OPTION_TEN, MONEY_MENU_OPTION_TWENTY};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		//We used the menu structure that was provided. We call mainActions here as that's where the bulk of our methods are.
		MainActions mainActions = new MainActions();
		//createInventory here creates a new stock everytime the code runs, reading from a given file.
		mainActions.createInventory();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				mainActions.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true){
					BigDecimal balance = mainActions.getBalance();
					System.out.println("\nCurrent Money Provided: " + balance);
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					//Here is the added purchase menu options. Gets user input that we equate to dollar amounts fed.
					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)){
						String moneyMenuChoice = (String) menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);
						if (moneyMenuChoice.equals(MONEY_MENU_OPTION_ONE)) {
							mainActions.feedMoney(1);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TWO)) {
							mainActions.feedMoney(2);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_FIVE)) {
							mainActions.feedMoney(3);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TEN)) {
							mainActions.feedMoney(4);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TWENTY)){
							mainActions.feedMoney(5);
						}
					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
						//Displays inventory, gets user input, runs the purchase method.
						mainActions.displayInventory();
						System.out.println("Please enter the item code for the item you wish to purchase!");
						Scanner selection = new Scanner(System.in);
						String userSelection = selection.nextLine();
						mainActions.purchase(userSelection);

					} else if (purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						//completes the transaction. break sends the user back to the main menu.
						mainActions.completeTransaction();
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.out.println("Thanks for shopping!");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
