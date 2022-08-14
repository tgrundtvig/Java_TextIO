package org.abstractica.util.textio;

public interface TextOut
{
	String newLine();
	void print(String s);

	//default utility methods
	default void println() { print(newLine()); }

	default void println(String s)
	{
		print(s + newLine());
	}

	default void makeList(String[] items, String begin, String separator, String end)
	{
		print(begin);
		boolean first = true;
		for(String item : items)
		{
			if(first)
			{
				first = false;
			}
			else
			{
				print(separator);
			}
		}
		print(end);
	}

	default int numberedlist(String[] items)
	{
		return numberedList(1, items, "", " - ", newLine());
	}

	default int numberedlist(String[] items, String preNumber)
	{
		return numberedList(1, items, preNumber, " - ", newLine());
	}

	default int numberedList(int first, String[] items, String preNumber, String separator, String postItem)
	{
		int i = first;
		for(String item : items)
		{
			print(preNumber);
			print(Integer.toString(i));
			print(separator);
			print(item);
			print(postItem);
			++i;
		}
		return items.length;
	}

	default int numberedlist(Iterable<String> items)
	{
		return numberedList(1, items, "", " - ", newLine());
	}

	default int numberedlist(Iterable<String> items, String pre)
	{
		return numberedList(1, items, pre, " - ", newLine());
	}

	default int numberedList(int first, Iterable<String> items, String pre, String separator, String post)
	{
		int count = 0;
		int i = first;
		for(String item : items)
		{
			print(pre);
			print(Integer.toString(count + i));
			print(separator);
			print(item);
			print(post);
			++count;
		}
		return count;
	}
}
