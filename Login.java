package Miniproject;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Login 
{
	//declared as static because it will change
	static double amount = 1000.00;

	public static void main(String[] args)
	{
		//Used Hashmap to store data
		HashMap<Integer,Camera> cam = new HashMap<Integer,Camera>();

//		Camera c1 = new Camera(11,"Something","Some",1200.0,"Rented");
//		Camera c2 = new Camera(12,"Some","Another",100.0,"Available");
//		Camera c3 = new Camera(14,"NIKON","A100",800.0,"Available");
//		Camera c4 = new Camera(15,"Sony","B001",500.0,"Available");
//		Camera c5 = new Camera(17,"Samsung","C123",200.0,"Rented");
//		Camera c6 = new Camera(19,"SONY","D145",100.0,"Available");
//		Camera c7 = new Camera(20,"Canon","E345",700.0,"Available");
//		Camera c8 = new Camera(21,"Nikon","F234",1000.0,"Rented");
//
//		//Input the data into hashmap
//		cam.put(c1.ID, c1);
//		cam.put(c2.ID, c2);
//		cam.put(c3.ID, c3);
//		cam.put(c4.ID, c4);
//		cam.put(c5.ID, c5);
//		cam.put(c6.ID, c6);
//		cam.put(c7.ID, c7);
//		cam.put(c8.ID, c8);

		System.out.println("+------------------------------+");
		System.out.println("| WELCOME TO CAMERA RENTAL APP |");
		System.out.println("+------------------------------+");

		//Login credentials
		System.out.println("PLEASE LOGIN TO CONTINUE - ");
		Scanner sc = new Scanner(System.in);
		System.out.print("USERNAME - ");
		String uname = sc.next();
		System.out.print("PASSWORD - ");
		String Password = sc.next();

		//username - admin
		//Password - admin123
		if((uname.equals("admin")) && (Password.equals("admin123")))
		{
			while(true)
			{
				System.out.println("1. MY CAMERA");
				System.out.println("2. RENT A CAMERA");
				System.out.println("3. VIEW ALL CAMERAS");
				System.out.println("4. MY WALLET");
				System.out.println("5. EXIT");

				//Select the category
				int number = sc.nextInt();
				if(number == 1)
				{				
					while(true)
					{
						System.out.println("1. ADD");
						System.out.println("2. REMOVE");
						System.out.println("3. VIEW MY CAMERAS");
						System.out.println("4. GO TO PREVIOUS MENU");

						//Select the category
						int number1 = sc.nextInt();
						if(number1 == 1)
						{
							//ADD
							System.out.print("ENTER THE CAMERA BRAND - ");
							String brand = sc.next();
							System.out.print("ENTER THE MODEL - ");
							String Model = sc.next();
							System.out.print("ENTER THE PER DAY PRICE (INR) - ");
							double Price = sc.nextDouble();


							Camera cam1 = new Camera(sc.nextInt(),brand,Model,Price,"Available");
							cam.put(cam1.ID, cam1);
							System.out.print("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
							System.out.println();
						}

						else if(number1 == 2)
						{
							int total = cam.size();
							if(total!=0)
							{
								//REMOVE
								System.out.println("===========================================================");
								System.out.printf("%-5s %-10s %-15s %-10s %-10s%n", "ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS");
								System.out.println("===========================================================");

								// Print each entry
								for (Entry<Integer, Camera> entry : cam.entrySet()) {
									Integer id = entry.getKey();
									Camera details = entry.getValue();
									System.out.printf("%-5d %-10s %-15s %-10s %-10s%n", id, details.Brand, details.Model, details.Price, details.Status);
								}
								System.out.println("===========================================================");

								System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
								int camid = sc.nextInt();

								cam.remove(camid);
								System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
								System.out.println("===========================================================");
								System.out.printf("%-5s %-10s %-15s %-10s %-10s%n", "ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS");
								System.out.println("===========================================================");

								// Print each entry
								for (Entry<Integer, Camera> entry : cam.entrySet()) {
									Integer id = entry.getKey();
									Camera details = entry.getValue();
									System.out.printf("%-5d %-10s %-15s %-10s %-10s%n", id, details.Brand, details.Model, details.Price, details.Status);
								}
								System.out.println("===========================================================");
							}
							else
							{
								System.out.println("NOT CAMERA AVAILABLE");
							}
						}

						else if(number1 == 3)
						{
							int total = cam.size();
							if(total!=0)
							{
								//MY RENTED CAMERA
								System.out.println("===========================================================");
								System.out.printf("%-5s %-10s %-15s %-10s %-10s%n", "ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS");
								System.out.println("===========================================================");

								for (Entry<Integer, Camera> entry : cam.entrySet()) {

									Integer id = entry.getKey();
									Camera details = entry.getValue();
									if(details.Status.equals("Rented")) 
									{
										System.out.printf("%-5d %-10s %-15s %-10s %-10s%n", id, details.Brand, details.Model, details.Price, details.Status);
									}

								}
								System.out.println("===========================================================");

							}
							else
							{
								System.out.println("NOT CAMERA AVAILABLE");
							}
						}
						else if(number1 == 4)
						{
							break;
						}
					}
				}

				else if(number == 2)
				{
					int total = cam.size();
					if(total!=0)
					{
						System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
						System.out.println("===========================================================");
						System.out.printf("%-5s %-10s %-15s %-10s %-10s%n|", "ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS");
						System.out.println("===========================================================");

						for (Entry<Integer, Camera> entry : cam.entrySet()) {

							Integer id = entry.getKey();
							Camera details = entry.getValue();
							if(details.Status.equals("Available")) 
							{
								System.out.printf("%-5d %-10s %-15s %-10s %-10s%n", id, details.Brand, details.Model, details.Price, details.Status);
							}
						}
						System.out.println("===========================================================");

						System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
						int rent = sc.nextInt();

						// Update the price and status for key 17
						Camera item = cam.get(rent);
						if (item.Price < amount)
						{
							item.Status = "Rented";   
							amount = amount - item.Price;
							System.out.println("YOUR TRANSACTION FOR CAMERA - "+item.Brand+" "+item.Model+" WITH RENT INR."+item.Price+" HAS SUCCESSFULLY COMPLETED.");
						}
						else
						{
							System.out.println("ERROR : TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
						} 
					}
					else
					{
						System.out.println("NOT CAMERA AVAILABLE");
					}
				}
				else if(number == 3)
				{
					int total = cam.size();
					if(total!=0)
					{
						// Print table header
						System.out.println("===========================================================");
						System.out.printf(" %-5s %-10s %-15s %-10s %-10s%n", "ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS");
						System.out.println("===========================================================");

						// Print each entry
						for (Entry<Integer, Camera> entry : cam.entrySet()) {
							Integer id = entry.getKey();
							Camera details = entry.getValue();
							System.out.printf("%-5d %-10s %-15s %-10s %-10s%n", id, details.Brand, details.Model, details.Price, details.Status);
						}
						System.out.println("===========================================================");
					}
					else
					{
						System.out.println("NOT CAMERA AVAILABLE");
					}
				}
				else if(number == 4)
				{
					System.out.println("YOUR CURRENT WALLET BALANCE IS - INR."+amount);
					System.out.print("DO YOU WANT TO DEPOSIT MORE MORE AMOUNT TO OUR WALLET?(1.YES 2.NO)");
					int num = sc.nextInt();
					if(num == 1)
					{
						System.out.print("ENTER THE AMOUNT (INR) -");
						double amt = sc.nextDouble();
						amount = amount + amt;
						System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY.");
						System.out.println("CURRENT WALLET BALANCE - INR."+amount);
					}
				}
				else if(number == 5)
				{
					break;
				}
			}
		}

		else
		{
			System.out.println("Invaid Username or Password");
		}
		sc.close();
	}
}
