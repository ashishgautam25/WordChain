package com.wordchain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FindChain {
	private final static Character[] letters = { 'a', 'b', 'c', 'd', 'e', 'f',
			   'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			   't', 'u', 'v', 'w', 'x', 'y', 'z' };

			  public static final ArrayList<Character> alLetters = new ArrayList<Character>(
			   Arrays.asList(FindChain.letters));   //list of all the english characters. It is used when replacing characters to form new words.

	private Driver driver;
	private final ArrayList<String> wordChain = new ArrayList<String>(); //Final chains are stored in wordChain list.
public FindChain(Driver d)
{
	this.driver=d;
}
ArrayList<String> getChain(String chain,String end){ 
	int k=1;
	List<String> nextwords=this.getNext(chain,end);
	while(true)
	{   
		if(this.wordChain.size()>0)
		{
			break;
		}
		final List<String> newchain=new ArrayList<String>(nextwords);
		nextwords=new ArrayList<String>();
		k++;
		for(String new_word:newchain)
		{
			nextwords.addAll(this.getNext(new_word, end)); //all the next words are generated for the last word in the strings in newchain list.
		}
		if(k>=26)
			break;
	}
	System.out.println("Length of Minimum Chain is "+(k+1));
	return this.wordChain;
}
List<String> getNext(String chain, String end)
{   final String word = this.lastWord(chain);
	   final ArrayList<String> al = new ArrayList<String>();

	    for (int i = 0; i < word.length(); i++) {              //i'th character is replaced at every iteration
	    for (int j = 0; j < FindChain.alLetters.size(); j++) { //each element from alletters is replaced one at a time.
	     final char[] newString = word.toCharArray();
	     newString[i] = FindChain.alLetters.get(j);
	     final String newword = String.valueOf(newString);
	     if (newword.equals(end)) {
	      this.wordChain.add(chain + "_" + newword);      //if newword mathces end word, it is added to wordchain
	     } else if (!newword.equals(word)                 //conditions to check that a duplicate word should not be added to the nextwords.
	       && !chain.startsWith(newword + "_")
	       && !chain.contains("_" + newword + "_")
	       && driver.dictionary.contains(newword)) {
	      al.add(chain + "_" + newword);
	     }
	    }
	   }
	   return al;
}
String lastWord(String chain)                          //Method to get the last word of the chains.
{
	String [] chainArray=chain.split("_");
	return chainArray[chainArray.length-1];
}
}
