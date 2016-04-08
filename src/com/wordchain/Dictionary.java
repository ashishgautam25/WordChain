package com.wordchain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Dictionary class is separately created as different entity.
public class Dictionary{
	private final Driver driver;
	public Dictionary(Driver d)
	{
		this.driver=d;
	}
void loadDictionary(int wordlength)
{
	String filepath="src/words.txt";     //ATTENTION: Please update filepath variable to use your own file.
	BufferedReader br=null;
	try {
		 br=new BufferedReader(new FileReader(new File(filepath)));
		String word;
		while((word=br.readLine())!=null)
		{
			if(word.length()==wordlength){ //only those words having same length as Starting word is added.
				driver.dictionary.add(word);
			}
		}
	} catch (FileNotFoundException e) {
		System.out.println("File not found, bro!");
		e.printStackTrace();
		System.exit(0);
	} catch(IOException e){
		e.printStackTrace();
	} finally
	{
		if(br!=null)
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}


}

