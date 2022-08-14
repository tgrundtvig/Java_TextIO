package org.abstractica.util.textio.example;

import org.abstractica.util.textio.TextIO;
import org.abstractica.util.textio.TextIOFactory;
import org.abstractica.util.textio.language.TextIOLanguage;

public class TextIOExample
{
	public static void main(String[] args)
	{
		TextIO textIO = TextIOFactory.createSystemTextIO(TextIOLanguage.Language.ENGLISH);

		textIO.println("Hello from textIO!");
		textIO.print("Enter an integer: ");
		int i = textIO.getInteger();
		textIO.println(i + " is a great choice!");
		textIO.print("Enter an integer between -5 and 5: ");
		i = textIO.getInteger(-5, 5);
		textIO.println(i + " was not a bad choice!");
		textIO.print("Enter any number: ");
		float f = textIO.getFloat();
		textIO.println(f + " is a great choice!");
		textIO.print("Enter a number between -1 and 1: ");
		f = textIO.getFloat(-1.0f, 1.0f);
		textIO.println(f + " was not a bad choice!");
		String[] choices = {"Green", "Red", "Blue", "Yellow"};
		int choice = textIO.selectItem("What is your favorite color?", choices, "Please choose: ");
		textIO.println("I like " + choices[choice].toLowerCase() + " too :-)");
	}
}
