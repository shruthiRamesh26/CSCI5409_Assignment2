package fact;

import java.io.File; // Import the File class
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class factorial {

	static void createInputFile() {
		File out = new File("inputFile.txt");
		FileWriter fw = null;
		// for IO exception
		try {
			// file writer object
			fw = new FileWriter(out);
			// create a buffer stream for writer object
			BufferedWriter writer = new BufferedWriter(fw);
			int line;

			Random random = new Random();
			// generate 100 random integers
			for (int i = 0; i < 100; i++) {
				// create a integer and write it to the output file
				line = random.nextInt(10);
				writer.write(Integer.toString(line));
				writer.newLine();

			}
			// Close the stream
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static int calcFactorical(int N) {

	int fact = 1;

	// if the input is a negative number",
	if(N<0)
	{
		fact=0;
		System.out.println("Please enter positive number. Factorial cannot be calculated for negative numbers");
	}
	// if the input is a zero
	else if(N==0)
	{
		fact=1;
	}
	else
	{
	    // if the input is a positive and non-zero number",
		for(int i=1;i<=N;i++){    
			fact=fact*i; 
		  } 
	    }

	return fact;
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File out = new File("outputFactorial.txt");
		FileWriter fw = new FileWriter(out.getAbsoluteFile(), true);;
		BufferedWriter bw = new BufferedWriter(fw);;
		PrintWriter pr = new PrintWriter(bw);
		
		
		
		//create input file with 100 random integers
	    createInputFile();
	    
		File file = new File("inputFile.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  String st; 
		//record start time
		  long startTime = System.nanoTime();
		  int count=0;
		//calculate factorial for each and every number present in the input file
		  while ((st = br.readLine()) != null) {
			  long sT = System.nanoTime();
			  int result=calcFactorical(Integer.parseInt(st));
			  long eT = System.nanoTime();
			  //time to calculate factorial for given number
			  long tt = (eT - sT); 
			  String data = "RequestID: "+count+"\t Number: "+Integer.parseInt(st)+"\t Factorial: "+result+"\t ProcessingTime:"+tt;
			  pr.println(data);
			  count++;
		  }
		//record end time
		  long endTime = System.nanoTime();
		  
		//calculate the time taken to calculate factorial series of the all numbers
		  long durationInNano = (endTime - startTime); 
		  pr.println("Time taken to calculate factorial of 100 random number is "+durationInNano+" Nano seconds");
		  
		  pr.close();
		  br.close();
		  bw.close();
		  fw.close();
		 
	}

}