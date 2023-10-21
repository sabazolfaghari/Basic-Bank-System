import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class myFileReader{
	public static int count; //static variable for helping with assigning account number to clients outside of file
	public Account[] reader(){
		Account x[] = new Account[100];
		try{
			FileReader fr = new FileReader("F:\\Saba\\File.txt"); //using java`s FileReader to create a file to read from!
			Scanner scanner = new Scanner(fr);
			int j = 0;
			while(scanner.hasNextLine()){
				x[j] = new Account("owner", 0, 0);
				x[j].setOwner(scanner.nextLine());
				String balance = scanner.nextLine();
				x[j].setBalance(Double.parseDouble(balance));
				String accNum = scanner.nextLine();
				x[j].setAccNum(Integer.parseInt(accNum));
				j++;
			}
			count += j; //this is for knowing how many clients we have in file so that when we intend to add new client in main, it starts from the last person in file!
			scanner.close();
		}catch(FileNotFoundException e){
			System.out.println("File not Found!");
		}
		return x;
	}
}

