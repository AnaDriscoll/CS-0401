/* Author: Ana Driscoll
Created: 9/12/2017
Last Edited: 9/23/2017
CS0401 Dr. Ramirez T/TH 1:00-2:15
Assignment One
Runs store using QualityQuidditch class*/ 

import java.util.*;

public class AssignmentOne
{
	public static void main (String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		QualityQuidditch store = new QualityQuidditch(); 
		
		int isCustomer = 0; //will store info about whether customer is in line 
								
		System.out.println("Welcome to Quality Quidditch supplies!"); 
		
		do
		{
			store.setDiscountStatus(false); //starts each purchase with clean slate
			System.out.println("\nIs there a customer to be waited on?" + "\nPress 1 for yes or 2 for no.");
			isCustomer = scan.nextInt(); 
			scan.nextLine(); 
			switch(isCustomer)
			{
				case 1:
				{
					store.comparePassword(); //user will input password, get discount if correct
					if(store.getDiscountStatus() == true)
						store.displayPriceDiscount();
					else
						store.displayPriceList(); 
					store.makePurchase(); 
					if(store.getDiscountStatus() == true)
						store.calculateDiscountTotal(); 
					else
						store.calculateTotal(); 
					store.displaySubtotal(); 
					store.takeMoney(); //collects money from and delivers change to user 
					System.out.println("Thank you for making a purchase from us today!"); 
					break;
				}
				case 2: 
				{
					System.out.println("Thank you for visiting Quality Quidditch Supplies. Have a great day!");
					break;
				}
				default:
				{
					System.out.println("Please provide valid input.");
					break;
				}
			}
		}while(isCustomer != 2); //runs unless user explicitly states there are no more customers	
	}
}
		
		
