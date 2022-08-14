package org.abstractica.util.textio;

import org.abstractica.util.textio.language.TextIOLanguage;
import org.abstractica.util.textio.language.TextIOLanguageDanish;
import org.abstractica.util.textio.language.TextIOLanguageEnglish;
import java.util.Scanner;

public class TextIOFactory
{
	private static SysIn sysIn;
	private static SysOut sysOut;


	public static TextIO createSystemTextIO(TextIOLanguage.Language language)
	{
		if(sysIn == null)
		{
			sysIn = new SysIn();
		}
		if(sysOut == null)
		{
			sysOut = new SysOut();
		}
		return createTextIO(sysIn, sysOut, language);
	}

	public static TextIO createTextIO(TextIn in, TextOut out, TextIOLanguage.Language language)
	{
		return
		switch(language)
		{
			case ENGLISH -> new TextIOImpl(in, out, new TextIOLanguageEnglish());
			case DANISH -> new TextIOImpl(in, out, new TextIOLanguageDanish());
			default -> throw new RuntimeException("The language " + language.name() + " has not been implemented!");
		};
	}

	private static class TextIOImpl implements TextIO
	{
		private final TextIn textIn;
		private final TextOut textOut;
		private final TextIOLanguage language;

		public TextIOImpl(TextIn textIn, TextOut textOut, TextIOLanguage language)
		{
			this.textIn = textIn;
			this.textOut = textOut;
			this.language = language;
		}

		@Override
		public int getInteger()
		{
			while(true)
			{
				String input = getLine();
				try
				{
					return Integer.parseInt(input);
				}
				catch(NumberFormatException exp)
				{
					print(language.retryInteger());
				}
			}
		}

		@Override
		public int getInteger(int min, int max)
		{
			while(true)
			{
				String input = getLine();
				try
				{
					int i = Integer.parseInt(input);
					if(i >= min && i <= max)
					{
						return i;
					}
					print(language.retryInteger(min, max));
				}
				catch(NumberFormatException exp)
				{
					print(language.retryInteger());
				}
			}
		}

		@Override
		public float getFloat()
		{
			while(true)
			{
				String input = getLine();
				try
				{
					return Float.parseFloat(input);
				}
				catch(NumberFormatException exp)
				{
					print(language.retryFloat());
				}
			}
		}

		@Override
		public float getFloat(float min, float max)
		{
			while(true)
			{
				String input = getLine();
				try
				{
					float f = Float.parseFloat(input);
					if(f >= min && f <= max)
					{
						return f;
					}
					print(language.retryFloat(min, max));
				}
				catch(NumberFormatException exp)
				{
					print(language.retryInteger());
				}
			}
		}

		@Override
		public int selectItem(String preList, Iterable<String> choices, String postList)
		{
			println(preList);
			int count = numberedlist(choices, "    ");
			print(postList);
			return getInteger(1,count)-1;
		}

		@Override
		public int selectItem(String preList, String[] choices, String postList)
		{
			println(preList);
			int count = numberedlist(choices, "    ");
			print(postList);
			return getInteger(1,count)-1;
		}

		@Override
		public boolean getYesOrNo()
		{
			while(true)
			{
				String yesOrNo = getLine();

				try
				{
					return language.evaluateYesOrNo(yesOrNo);
				} catch (IllegalArgumentException e)
				{
					print(language.retryYesOrNo());
				}
			}
		}

		@Override
		public String getLine()
		{
			return textIn.getLine();
		}

		@Override
		public String newLine()
		{
			return textOut.newLine();
		}

		@Override
		public void print(String s)
		{
			textOut.print(s);
		}
	}

	private static class SysIn implements TextIn
	{
		private final static Scanner keyboard = new Scanner(System.in);

		@Override
		public String getLine()
		{
			return keyboard.nextLine();
		}
	}

	private static class SysOut implements TextOut
	{
		@Override
		public String newLine()
		{
			return System.lineSeparator();
		}

		@Override
		public void print(String s)
		{
			System.out.print(s);
		}
	}
}
