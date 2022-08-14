package org.abstractica.util.textio;

import java.util.Scanner;

public class SysOut implements TextIO
{
	private final static Scanner keyboard = new Scanner(System.in);

	public static TextIO newTextUI()
	{
		return new SysOut();
	}

	private SysOut()
	{}

	@Override
	public void print(String s)
	{
		System.out.print(s);
	}

	@Override
	public String get()
	{
		return keyboard.nextLine();
	}

	@Override
	public void clear()
	{
		for(int i = 0; i < 100; ++i)
		{
			System.out.println("");
		}
	}
}
