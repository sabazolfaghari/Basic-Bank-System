import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class myFileWriter{
	public void writer(Account[] x, int y){ //int y is the current size of Array which is AccountArrayLength
		try{
			FileWriter f = new FileWriter("F:\\Saba\\File.txt",true); //making a new object of java`s FileWriter to write to file!
			BufferedWriter fw = new BufferedWriter(f);
			for(int j = myFileReader.count; j<y; j++){
				fw.write(x[j].getOwner());
				fw.newLine();
				String balance = Double.toString(x[j].getBalance());
				fw.write(balance);
				fw.newLine();
				String accNum = Integer.toString(x[j].getAccNum());
				fw.write(accNum);
				fw.newLine();
			}			
			fw.close();
		}catch(IOException ex){
			System.out.println("File not Found!");
		}
	}
}

