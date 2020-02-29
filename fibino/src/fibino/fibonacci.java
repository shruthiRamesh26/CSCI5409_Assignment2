package fibino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class fibonacci {
	
	
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
	
	
// for recursion 
	static int calFib(int N) {
		int result = (N <= 1) ? N : calFib(N - 1) + calFib(N - 2);
		return result;
	}

	static ArrayList<Integer> Fibonacci(int N) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// if the input is a negative number
		if (N < 0) {
			System.out
					.println("Please enter positive number. Fibonacci series of negative numbers cannot be calculated");
		}
		else if (N == 0) {
			result.add(0);
		}
		// if the input is a 1
		else if (N == 1) {
			result.add(0);
		}
		// if the input is a 2
		else if (N == 2) {
			result.add(1);
		} else {
			for (int i = 1; i <= N; i++) {
				
				result.add(calFib(i));
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		
		File out = new File("outputFibonacci.txt");
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
			  ArrayList<Integer> result=Fibonacci(Integer.parseInt(st));
			  long eT = System.nanoTime();
			  //time to calculate factorial for given number
			  long tt = (eT - sT);
			  String listString ="";
			  // convert array to string
			  for (Integer s : result)
			  {
				  listString += " "+s;
			  }
			  String data = "RequestID: "+count+"\t Number: "+Integer.parseInt(st)+"\t Factorial: "+listString+"\t ProcessingTime:"+tt;
			  pr.println(data);
			  count++;
		  }
		//record end time
		  long endTime = System.nanoTime();
		  
		//calculate the time taken to calculate factorial series of the all numbers
		  long durationInNano = (endTime - startTime); 
		  pr.println("Time taken to calculate fibonacci series of 100 random number is "+durationInNano+" Nano seconds");
		  
		  pr.close();
		  br.close();
		  bw.close();
		  fw.close();
}
}
