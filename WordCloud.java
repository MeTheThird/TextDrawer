import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import zen.core.Zen;


public class WordCloud {

	public static void main(String[] args) throws FileNotFoundException { 
		Zen.create(800, 800);
		//Made a list of words.
		ArrayList <String> words = new ArrayList <String> ();
		HashMap  <String, Integer> count = new HashMap  <String, Integer> ();
		
		//How to read a file 101
		//1. Make a File object and a Scanner with that file.
		File f = new File("text");
		Scanner s = new Scanner(f);
		
		while (s.hasNext()) {
			String word = s.next();
			word = word.toLowerCase();
			word = word.replaceAll("[^a-z]", " ");
			words.add(word);
			//There are two cases
			if (count.containsKey(word)) {
				int current = count.get(word);
				count.put(word, current + 1);
			}
			else {
				count.put(word, 1);
			}
		}
		
		//Added a bunch of stuff to the list.
		words.add("ROHAN IS AWESOME!!!!!");
		words.add("I AM COOL!!!!!!!!!!!");
		words.add("#RohanIsCool");

		
		//For each word in the list:
		for (String word : count.keySet()) {
			//Picked a random font size.
			Zen.setFont("Helvetica", count.get(word));
			//Picked a random color
			Zen.setColor(Zen.getRandomNumber(0, 250), Zen.getRandomNumber(0, 250), Zen.getRandomNumber(0, 250));
			//Drew the text at a random coordinate.
			Zen.drawText(word, Zen.getRandomNumber(100, 700), Zen.getRandomNumber(100, 700));
		}
	}

}
