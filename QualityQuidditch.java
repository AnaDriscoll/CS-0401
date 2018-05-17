/* Author: Ana Driscoll
Created: 9/12/2017
Last Edited: 9/23/2017
CS0401 Dr. Ramirez T/TH 1:00-2:15
Assignment One
This is a class containing methods and objects necessary to run the QualityQuidditch store*/ 

import java.util.Scanner; 
import java.lang.*; 

public class QualityQuidditch
{
	private String password; //stores correct password to get discounts
	private int numHousePin, numQuaffle, numBroomstick, numQuaffleBox; //stores number of each item sold
	private int numGryffindor, numHufflepuff, numSlytherin, numRavenclaw; //stores number of each type of team pin
	private int totalMoneyGiven, change; //stores how much customer has paid, how much change they need
	private int priceHousePin, priceQuaffle, priceQuaffleBox, priceBroomstick; //stores prices (per item) of each item sold
	private int housePinSubtotal, quaffleBoxSubtotal, quaffleSubtotal, broomstickSubtotal; //stores prices (total) of each item sold
	private double priceTotal; //stores total purchase price
	private boolean isDiscount; //stores if user has earned discount
	private Scanner scan = new Scanner(System.in);

	public QualityQuidditch() //constructor with preset password 
	{
		numHousePin = numQuaffle = numBroomstick = numQuaffleBox = 0;
		numGryffindor = numHufflepuff = numSlytherin = numRavenclaw = 0; 
		password = "quidditch"; 
		isDiscount = false;
	}
	
	public boolean getDiscountStatus()
	{
		return isDiscount;
	} 
	
	public void setDiscountStatus(boolean b)
	{
		isDiscount = b;
	} 
	
	public void comparePassword() //compares user's guess to specified password
	{
		String guess;
		System.out.println("What is the password?"); 
		for(int i = 0; i < 2; i++)
		{
			guess = scan.next();
			if(guess.compareTo(password) == 0)
			{
				i += 2; //ends loop
				isDiscount = true;
			}
			else
			{
				System.out.println("Sorry, that's the wrong password." + 
				"\nYou have " + (1 - i) + " more tries."); 
			}
		}
	} 
	
	public void displayPriceDiscount()
	{
		System.out.println("Here is our price list with discounts applied: " + 
		"\nHouse pins: 20 knuts" +
		"\n\tPrice reduced to 18 knuts each if you purchase more than 10" + 
		"\n\tAvailable in Gryffindor, Hufflepuff, Slytherin, and Ravenclaw" +
		"\nQuaffles (individual): 145 knuts" + "\nQuaffles (box of 5): 580 knuts" +
		"\nBroomstick service kits: 899 knuts" +
		"\n10% off your total order if your order is 3 galleons or more" +
		"\nafter the above discounts are applied\n"); 
	}
	
	public void displayPriceList()
	{
		System.out.println("Here is our price list: " + "\nHouse pins: 20 knuts" +
		"\n\tAvailable in Gryffindor, Hufflepuff, Slytherin, and Ravenclaw" +
		"\nQuaffles (individual): 145 knuts" + "\nQuaffles (box of 5): 638 knuts" +
		"\nBroomstick service kits: 986 knuts\n"); 
	} 
	
	public void makePurchase()
	{
		//start with a blank slate 
		numHousePin = numQuaffle = numQuaffleBox = numBroomstick = 0;
		numGryffindor = numHufflepuff = numSlytherin = numRavenclaw = 0; 
		totalMoneyGiven = change = 0;
		housePinSubtotal = quaffleSubtotal = quaffleBoxSubtotal = broomstickSubtotal = 0; 
		
		int decision = 0;  //will store info on what user chooses to order 
		do
		{
			System.out.println("Please choose an option: " + "\n\t1. Update pin order" + "\n\t2. Update quaffles order" +
			"\n\t3. Update broomstick kit order" + "\n\t4. Show price list" + "\n\t5. Check out"); 
			decision = scan.nextInt(); 
			switch(decision)
			{
				case 1: //Pin order
				{
					int team; //will store user decision on team pin 
					do
					{ 
						System.out.println("Here is your current order: " + "\n\t" + numHousePin + " Team Pins:");
						if(numGryffindor > 0)
							System.out.println("\t\t" + numGryffindor + " Gryffindor"); 
						if(numHufflepuff > 0)
							System.out.println("\t\t" + numHufflepuff + " Hufflepuff");
						if(numSlytherin > 0)
							System.out.println("\t\t" + numSlytherin + " Slytherin");
						if(numRavenclaw > 0)
							System.out.println("\t\t" + numRavenclaw + " Ravenclaw");
						System.out.println("For which team would you like to order pins? Press the corresponding number." +
						"\n\t1. Gryffindor" + "\n\t2. Hufflepuff" + "\n\t3. Slytherin" + "\n\t4. Ravenclaw" +
						"\n\t5. Finished with pin order");
						team = scan.nextInt(); 
						int num = 0; //temporarily stores number of pins ordered
						switch(team)
						{
							case 1: //Gryffindor
							{
								System.out.println("How many Gryffindor pins would you like to order?");
								num = scan.nextInt(); 
								while(num < 0) 
								{
									System.out.println("Please provide valid input.");
									num = scan.nextInt(); 
								}
								numGryffindor = num;
								break;
							}
							case 2: //Hufflepuff
							{
								System.out.println("How many Hufflepuff pins would you like to order?");
								num = scan.nextInt(); 
								while(num < 0) 
								{
									System.out.println("Please provide valid input.");
									num = scan.nextInt(); 
								}
								numHufflepuff = num;
								break;
							}
							case 3: //Slytherin
							{
								System.out.println("How many Slytherin pins would you like to order?");
								num = scan.nextInt(); 
								while(num < 0) 
								{
									System.out.println("Please provide valid input.");
									num = scan.nextInt(); 
								}
								numSlytherin = num;
								break;
							}
							case 4: //Ravenclaw
							{
								System.out.println("How many Ravenclaw pins would you like to order?");
								num = scan.nextInt(); 
								while(num < 0) 
								{
									System.out.println("Please provide valid input.");
									num = scan.nextInt(); 
								}
								numRavenclaw = num;
								break;
							} 
							case 5: 
							{
								break;
							} 
							default:
							{
								System.out.println("Please provide valid input.");
								break;
							}
						}
						if(team == 1 || team == 2 || team == 3 || team == 4)
							numHousePin += num; 
					}while(team != 5); //while order isn't finished
					break; 
				}
				case 2: //Quaffles order
				{
					int numQ = 0; //placeholder for quaffles before division into boxes 
					System.out.println("Here is your current order: "); 
					if(numQuaffle == 0 && numQuaffleBox == 0)
						System.out.println("No Quaffles ordered"); 
					else if(numQuaffle > 0 && numQuaffleBox == 0) 
						System.out.println(numQuaffle + " Quaffles");
					else if(numQuaffle == 0 && numQuaffleBox > 0)
						System.out.println(numQuaffleBox + " boxes of Quaffles"); 
					else
						System.out.println(numQuaffleBox + " boxes of Quaffles" + "\n" + 
						numQuaffle + " Quaffles"); 
					System.out.println("\nHow many Quaffles would you like for: " + "\n\t145 knuts each" +
					"\n\t638 knuts for a box of 5" + "\n(Please indicate only the total number you would like.");
					numQ = scan.nextInt(); 
					while(numQ <= 0) 
					{
						System.out.println("Please provide valid input.");
						numQ = scan.nextInt(); 
					} 
					numQuaffleBox = numQ / 5; //integer division will truncate 
					numQuaffle = numQ % 5; 
					
					break;
				}
				case 3: //broomstick kit order 
				{
					int numB = 0; //placeholder for number of broomstick service kits 
					System.out.println("Here is your current order: ");
					if(numBroomstick == 0)
						System.out.println("No broomstick service kits ordered");
					else
						System.out.println(numBroomstick + " broomstick service kits");
					System.out.println("How many broomstick service kits would you like?");
					numB = scan.nextInt();
					while(numB <= 0) 
					{
						System.out.println("Please provide valid input.");
						numB = scan.nextInt(); 
					} 
					numBroomstick = numB;
					break;
				}
				case 4: //show price list 
				{
					if(isDiscount == true) 
						System.out.println("Here is our price list with discounts applied: " + 
						"\nHouse pins: 20 knuts" +
						"\n\tPrice reduced to 18 knuts each if you purchase more than 10" + 
						"\n\tAvailable in Gryffindor, Hufflepuff, Slytherin, and Ravenclaw" +
						"\nQuaffles (individual): 145 knuts" + "\nQuaffles (box of 5): 580 knuts" +
						"\nBroomstick service kits: 899 knuts" +
						"\n10% off your total order if your order is 3 galleons or more" +
						"\nafter the above discounts are applied\n"); 
					else 
						System.out.println("Here is our price list: " + "\nHouse pins: 20 knuts" +
						"\n\tAvailable in Gryffindor, Hufflepuff, Slytherin, and Ravenclaw" +
						"\nQuaffles (individual): 145 knuts" + "\nQuaffles (box of 5): 638 knuts" +
						"\nBroomstick service kits: 986 knuts\n"); 
					break;
				} 
				case 5: //finish order, will move to check out 
				{
					break;
				}
				default:
				{
					System.out.println("Please provide valid input."); 
					break;
				}
			}
		}while(decision != 5); //while customer has not decided to check out
	}
	
	//methods to calculate totals in knuts 
	
	public void calculateTotal()
	{
		priceHousePin = 20;
		priceQuaffle = 145;
		priceQuaffleBox = 638;
		priceBroomstick = 986; 
		
		housePinSubtotal = numHousePin * priceHousePin;
		quaffleBoxSubtotal = (numQuaffle / 5) * priceQuaffleBox;
		quaffleSubtotal = (numQuaffle % 5) * priceQuaffle; 
		broomstickSubtotal = numBroomstick * priceBroomstick;
		
		priceTotal = (double)(housePinSubtotal + quaffleBoxSubtotal + quaffleSubtotal + broomstickSubtotal); 	
	}
	
	public void calculateDiscountTotal() 
	{
		if(numHousePin >= 10)
			priceHousePin = 18;
		else
			priceHousePin = 20;
		
		priceQuaffle = 145;
		priceQuaffleBox = 29 * 20; //conversion to knuts
		priceBroomstick = 899; 
		
		housePinSubtotal = numHousePin * priceHousePin;
		quaffleBoxSubtotal = numQuaffleBox * priceQuaffleBox;
		quaffleSubtotal = (numQuaffle % 5) * priceQuaffle; 
		broomstickSubtotal = numBroomstick * priceBroomstick;
		
		if(priceTotal > (493 * 3)) //conversion from galleons to knuts, applies 10% off order
		{
			priceTotal = 0.9 * (double)(housePinSubtotal + quaffleBoxSubtotal + quaffleSubtotal + broomstickSubtotal); 
			priceTotal = Math.round(priceTotal);
		} 
		else
			priceTotal = (housePinSubtotal + quaffleBoxSubtotal + quaffleSubtotal + broomstickSubtotal); 
	} 
	
	public void displaySubtotal()
	{
		System.out.println("Here is your subtotal in knuts:"); 
		if(numHousePin > 0)
			System.out.println("\t" + numHousePin + " house pins at " + priceHousePin + " ea:" + "\t\t\t\t\t" + housePinSubtotal); 
		if(numQuaffleBox > 0)
			System.out.println("\t" + numQuaffleBox + " boxes of Quaffles at " + priceQuaffleBox + " ea:" + "\t\t\t\t" + quaffleBoxSubtotal); 
		if(numQuaffle > 0) 
			System.out.println("\t" + numQuaffle + " Quaffles at " + priceQuaffle + " ea:" + "\t\t\t\t\t" + quaffleSubtotal); 
		if(numBroomstick > 0)
			System.out.println("\t" + numBroomstick + " broomstick service kits at " + priceBroomstick + " ea:" + "\t\t\t" + broomstickSubtotal); 
		System.out.println(" ");
		System.out.println("\tTotal: " + "\t\t\t\t\t\t\t" + (int)priceTotal);
		if(priceTotal > 493 * 3 && isDiscount == true)
			System.out.println("\t(Takes discount of 10% off total for orders >3 galleons into account)");
	}
	
	public void takeMoney() 
	{
		int money = 0; //placeholder for money given
		String currency; //currency specified by user
		if(priceTotal == 0)
			System.out.println("No purchase was made. Have a great day!"); 
		else
		{
			System.out.println("Please enter a payment amount in the following format: " + 
			"\n<amount><space><currency>" + "\n\tWhere <amount> = an integer" + 
			"\n\tWhere <space> = a blank space" + "\n\tWhere <currency> = knuts, sickles, or galleons"); 
			System.out.println("You may enter as many times as you like. Each entry will be added " +
			"\nto your total until sufficient funds have been obtained.");
			System.out.println("Recall the currency exchange: " + "\n\t29 knuts = 1 sickle" +
			"\n\t493 knuts = 17 sickles = 1 galleon"); 
			while(priceTotal > totalMoneyGiven)
			{
				money = scan.nextInt();
				currency = scan.next(); 
				while(money <= 0)
				{
					System.out.println("Please input a valid amount of money.");
					money = scan.nextInt();
				}
				while(currency.compareToIgnoreCase("galleons") != 0 && currency.compareToIgnoreCase("sickles") != 0 && currency.compareToIgnoreCase("knuts") !=0)
				{
					System.out.println("Please input a valid currency.");
					currency = scan.next(); 
				} 
				if(currency.compareToIgnoreCase("galleons") == 0)
				{
					totalMoneyGiven += (493 * money); //conversion to knuts
				}
				else if(currency.compareToIgnoreCase("sickles") == 0)
				{
					totalMoneyGiven += (17 * money); //conversion to knuts
				}
				else
				{
					totalMoneyGiven += money; 
				} 
				System.out.println("You have added " + money + " " + currency + " to your total." +
				"\nYou have paid " + totalMoneyGiven + " out of " + (int)priceTotal + " knuts."); 
			}
			
			change = totalMoneyGiven - (int)priceTotal; 
			System.out.println("Here is your change: "); 
			if(change / 493 > 0) //if at least one galleon
			{
				System.out.println("\t" + (change / 493) + " galleons");
				change = change - (493 * (change / 493)); //removes galleons from remaining change
			} 
			if(change / 17 > 0) //if at least one sickle 
			{
				System.out.println("\t" + change / 17 + " sickles");
				change = change - (17 * (change / 17)); //removes sickles from remaining change
			} 
			if(change > 0) //remaining knuts after galleons and sickles taken out 
				System.out.println("\t" + change + " knuts"); 
			if(change == 0)
				System.out.println("0 knuts"); 
		} 
	}	
}
	
	
		
		
	


	