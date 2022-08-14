package org.abstractica.util.textio.language;

public interface TextIOLanguage
{
	enum Language{ENGLISH, DANISH}

	Language getLanguage();

	String retryInteger();

	String retryInteger(int min, int max);

	String retryFloat();

	String retryFloat(float min, float max);

	boolean evaluateYesOrNo(String yesOrNo) throws IllegalArgumentException;

	String retryYesOrNo();
}
