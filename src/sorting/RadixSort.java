package sorting;

//Import the necessary Libraries
import java.io.*;
import java.util.*;

public class RadixSort
{
	//Declare radix method
	static void radix(int arrayToSort[])
	{
		//get the max value
		int max = arrayToSort[0];
		for(int i = 1; i < 10; i++)
		{
			if(arrayToSort[i] > max)
			{
				max = arrayToSort[i];
			}
		}
		
		//Bulk of the sorting Algorithm
		for(int powerTen = 1; max/powerTen > 0; powerTen *= 10)
		{
			int[] sortedArray = new int[10];
			int[] placement = new int[10];
			
			for(int i = 0; i < 10; i++)
			{
				int num = (arrayToSort[i] / powerTen) % 10;
				placement[num]++;
			}
			
			for(int i = 1; i < 10; i++)
			{
				placement[i] += placement[i - 1];
			}
			
			for(int i = 9; i >= 0; i--)
			{
				int num = (arrayToSort[i] / powerTen % 10);
				sortedArray[placement[num] - 1] = arrayToSort[i];
				placement[num]--;
			}
			
			//update array.
			for(int i = 0; i < 10; i++)
			{
				arrayToSort[i] = sortedArray[i];
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//Look for Input and Output files
		java.io.File inFile = new java.io.File("input.txt");
		java.io.File outFile = new java.io.File("output.txt");
		
		//Allow read and write privilieges for input and output
		Scanner input = new Scanner(inFile);
		java.io.PrintWriter output = new java.io.PrintWriter(outFile);
		
		//Declare the Initial Array
		int[] initialArray = new int[10];
		
		System.out.println("Extracting Integers from 'input.txt' into Array...");
		for(int i = 0; i < 10; i++)
		{
			//Copy input file into array
			initialArray[i] = input.nextInt();
		}
		
		//Test to see if initialArray was filled
		System.out.println("\nInitial Array: ");
		for(int i : initialArray)
		{
			System.out.println(i);
		}
		
		//call radix method
		System.out.print( "\n Beginning Radix Sort...");
		radix(initialArray);
		System.out.println("Array Sorted, Writing to 'output.txt' ...");
		
		//Test to see if array was sorted.
		//write to output file
		System.out.println("\nSorted Array: ");
		for(int i : initialArray)
		{
			System.out.println(i);
			output.println(i);
		}
		
		//close Files
		input.close();
		output.close();
	}
}
        
  
		

