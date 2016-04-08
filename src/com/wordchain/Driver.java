package com.wordchain;
/* Solution to word chain problem.
 * ATTENTION: Please change filepath variable to use your own Dictionary File.
 * Algorithm is a type of Breadth first search which uses List instead of graph.
 * Graph is required for getting the neighbors of a node but in this case we already know the Neiighbours are valid english
 * words that differ by one character. Hence Graph is not required. Following algorithm is implemented in JAVA.
 * 1)Get inputs(Start and End words) from the user.
 * 2)Insert all valid English words of length equal to that of Start word into the HashSet named Dictionary. 
 * 3)Initialize list named chain as Start word.
 * 4)Get the nextwords(words which differ by single character and are valid) for the last word of the chain.
 * 5)If any new nextword is same as end word, ADD it to the chain else add it to the nextwords list.
 * 6)Repeat 4,5 till end word is reached.
 * 7)Print the result
 * 
 * Certain checks like both the words should have same length and they must be valid english words is also kept in mind.
 * Thank You
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//Driver class which contains main method
public class Driver  {	
	final Set<String> dictionary = new HashSet<String>(); //Instance of Dictionary class
public static void main(String []args)
{   final Driver driver=new Driver();                     //References to the classes.
    final FindChain findchain=new FindChain(driver);
    Dictionary dict=new Dictionary(driver);
    ArrayList<String> wordchain=new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Starting word:");
	String start=sc.nextLine();
	System.out.println("Enter Ending word:");
	String end=sc.nextLine();
	if(start.length()!=end.length())
	{
		System.out.println("Starting and Ending words should be of same length!");
	}
	dict.loadDictionary(start.length()); //Loading Dictionary
	if(!(driver.dictionary.contains(start)&&driver.dictionary.contains(end))){
		System.out.println("Starting and Ending words should be valid English Words.");
	}
	wordchain=findchain.getChain(start, end);
	if(wordchain.isEmpty())
	{
		System.out.println("No word Chain exists!");
	}
	else
	for(String chain:wordchain)
	{
		String newchain=chain.replaceAll("_", "->");
		System.out.println(newchain);
	}
	}

}
