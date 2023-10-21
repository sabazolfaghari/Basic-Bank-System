
class Account{
	private String owner;
	private int accNum;
	private double balance;
	
	public Account(String owner, double balance, int accNum){ //constructor of Account class
		owner = "Unassigned";
		balance = 0;
		accNum = 0;
	}
	
	public String getOwner(){ //this method is for being able to reach and use owner of an object of Account class
		return owner;
	}
	
	public void setOwner(String owner){ //this method is for making changes to the owner of an object of Account class
		this.owner = owner;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public int getAccNum(){
		return accNum;
	}
	
	public void setAccNum(int accNum){
		this.accNum = accNum;
	}
	
	public void deposit(double amount){
		balance += amount;
	}
	
	public void withdraw(double amount){
		if(balance >= amount){
			balance -= amount;
		}
		else{
			System.out.println("Your balance is not enough!");
		}
	}
	
	public void showAccount(){ //method for showing the information of clients
		System.out.println("owner:" +owner+ ", account number:" +accNum+ ", balance:" +balance);
	}
	
	boolean search1(String name){ //a method for comparison between given name and current owners to do certain things like showing the information if that name exist!
		if(owner.equals(name)){
			showAccount();
			return(true);
		}
		return(false);
	}
	
	boolean search2(double money){ //a method for comparison between given amount and current balances of the owners!
		if(money <= balance){
			return(true);
		}
		return(false);
	}
	
	boolean search3(int accountNumber){ //a method for comparison between given number and current account numbers of owners!
		if(accountNumber == accNum){
			return(true);
		}
		return(false);
	}
 }