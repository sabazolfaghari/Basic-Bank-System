import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
 class Bank{
	 public static int accNumCount = 0; //static variable for account number
	 public static void main(String[] args) throws FileNotFoundException{
		 Scanner scanner = new Scanner(System.in);
		 Account[] a = new Account[100]; //an array of objects(object is class Account)
		 myFileReader fr = new myFileReader(); //object of class myFileReader
		 a = fr.reader(); //if the file has some clients, they will be settled as the first elements of array a and passed to a as well! 
		 int AccountArrayLength = myFileReader.count; //the static count of myFileReader will be assigned to an int parameter that determines the last number of clients! 
		 accNumCount = AccountArrayLength + 1; //assigning an account number to clients(+1 is because AccountArrayLength starts from zero!
		 int choice; //switch case variable
		 cls();
		 date();
		 do{
			 System.out.println(" 1.Add an Account \n 2.Show all Accounts \n 3.Individual Search \n 4.Group Search(by balance) \n 5.Transfer Money \n 6.Exit");
			 System.out.print("your choice: ");
			 choice = scanner.nextInt();
			 switch(choice){
				 
				 case 1: //adding new account
					cls();
					date();
					a[AccountArrayLength] = new Account("owner", 0, 0);
					System.out.println("Enter the owner`s name!");
					a[AccountArrayLength].setOwner(scanner.next());
					System.out.println("Enter the balance of the owner!");
					a[AccountArrayLength].setBalance(scanner.nextDouble());
					a[AccountArrayLength].setAccNum(accNumCount);
					System.out.println("The owner`s account number is:" +accNumCount);
					accNumCount++;
					AccountArrayLength++;
					break;
					
				 case 2: //show all accounts
					cls();
					date();
					for(int j=0; j<AccountArrayLength; j++)
						a[j].showAccount();
					break;
					
				 case 3: //individual search
					cls();
					date();
					System.out.println("1.Search by Name 2.Search by Account Number 3.Exit");
					int ch1 = scanner.nextInt();
					switch(ch1){
						case 1:
							cls();
							date();
							System.out.println("Enter the name of the person you want to search!");
							String name = scanner.next();
							boolean user1 = false;
							for(int j=0; j<AccountArrayLength; j++){
								user1 = a[j].search1(name);
								if(user1){
									break;
								}
							}
							if(!user1){
								System.out.println("This owner doesn`t exist!");
							}
							break;
							
						case 2:
							cls();
							date();
							System.out.println("Enter the account number of the person you want to search!");
							int number = scanner.nextInt();
							boolean user3 = false;
							for(int j=0; j<AccountArrayLength; j++){
								user3 = a[j].search3(number);
								if(user3){
									break;
								}
							}
							if(!user3){
								System.out.println("This Account Number doesn`t exist!");
							}
							break;
							
						case 3:
							break;
							
						default: 
							cls();
							date();
							System.out.println("Invalid Input!");
							break;
					}
				 break;
							
				 case 4: //group search by balance
					cls();
					date();
					System.out.println("Enter the amount you wish to see how many clients have more balance than!");
					double amount1 = scanner.nextDouble();
					boolean user2 = false;
					for(int j=0; j<AccountArrayLength; j++){
						user2 = a[j].search2(amount1);
						if(user2){
							a[j].showAccount();
						}
					}
						if(!user2){
							System.out.println("No clients have more balance than the amount you entered!");
						}
					break;
					
				 case 5: //transfering money
					cls();
					date();
					System.out.println("1.Deposit 2.Withdraw 3.Exit");
					int ch = scanner.nextInt();
					switch(ch){

						case 1:
							cls();
							date();
							System.out.println("Enter the account number you wish to make a deposit into");
							int number1 = scanner.nextInt();
							boolean user3 = false;
							for(int j=0; j<AccountArrayLength; j++){
								user3 = a[j].search3(number1);
								if(user3){
									System.out.println("Enter the amount you wish to deposit into this account!");
									double amount2 = scanner.nextDouble();
									a[j].deposit(amount2);
									System.out.println(a[j].getOwner()+"`s new balance is:" +a[j].getBalance());
									break;
								}
							}
								if(!user3){
									System.out.println("an owner with this account number doesn`t exist!");
								}
							break;
							
						case 2:
							cls();
							date();
							System.out.println("Enter the account number you wish to withdraw money from!");
							int number2 = scanner.nextInt();
							boolean user4 = false;
							for(int j=0; j<AccountArrayLength; j++){
								user4 = a[j].search3(number2);
								if(user4){
									System.out.println("Enter the amount you wish to withdraw from this account!");
									double amount3 = scanner.nextDouble();
									a[j].withdraw(amount3);
									System.out.println(a[j].getOwner()+"`s new balance is:" +a[j].getBalance());
									break;
								}		
							}
								if(!user4){
									System.out.println("an owner with this account number doesn`t exist!");
								}
							break;
							
						case 3:
							break;
								
						default:
							cls();
							date();
							System.out.println("Invalid Input");
							break;
					}
					break;
					
				 case 6:
					cls();
					date();
					myFileWriter fw = new myFileWriter(); //object of class myFileWriter
					fw.writer(a,AccountArrayLength); //writing all data changed in array to file!
					System.out.println("Have a good day!");
					break;
				
				default:
					cls();
					date();
					System.out.println("Invalid Input");
					break;
			 }
		 } while(choice!=6);
	 }
	 
	 public static void date(){ //a method for showing local date and time!
	 LocalDateTime dateTime = LocalDateTime.now(); //making an object of time
	 DateTimeFormatter formated = DateTimeFormatter.ofPattern("E, MMM dd yyyy \n\t HH:mm:ss");
	 String formattedDate = dateTime.format(formated);
	 System.out.println("\n********************************************");
	 System.out.println("\t" +formattedDate);
	 System.out.println("********************************************");
	 }
	 
	 public final static void cls(){
		  try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
	 }
 }
			 
			 
			 
		 
		 
	