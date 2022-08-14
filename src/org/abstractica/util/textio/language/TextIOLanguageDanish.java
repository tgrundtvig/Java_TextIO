package org.abstractica.util.textio.language;

public class TextIOLanguageDanish implements TextIOLanguage
{
	@Override
	public Language getLanguage()
	{
		return Language.DANISH;
	}

	@Override
	public String retryInteger()
	{
		return "Indtast venligst et heltal: ";
	}

	@Override
	public String retryInteger(int min, int max)
	{
		return "Indtast venligst et heltal mellem " + min + " og " + max + " (begge inklusive): ";
	}

	@Override
	public String retryFloat()
	{
		return "Indtast venligst et tal: ";
	}

	@Override
	public String retryFloat(float min, float max)
	{
		return "Indtast venligst et tal mellem " + min + " og " + max + " (begge inklusive): ";
	}

	@Override
	public boolean evaluateYesOrNo(String yesOrNo) throws IllegalArgumentException
	{
		String yOrN = yesOrNo.trim().toLowerCase();
		if("j".equals(yOrN) || "ja".equals(yOrN) || "'j'".equals(yOrN) || "'ja'".equals(yOrN))
		{
			return true;
		}
		if("n".equals(yOrN) || "nej".equals(yOrN) || "'n'".equals(yOrN) || "'nej'".equals(yOrN))
		{
			return false;
		}
		throw new IllegalArgumentException("Could not parse " + yesOrNo + " as yes or no!");
	}

	@Override
	public String retryYesOrNo()
	{
		return "Skriv venligst 'j' eller 'ja' for ja, eller skriv 'n' eller 'nej' for nej: ";
	}
}
