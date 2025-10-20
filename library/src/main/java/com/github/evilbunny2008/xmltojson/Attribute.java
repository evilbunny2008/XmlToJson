package com.github.evilbunny2008.xmltojson;

@SuppressWarnings("unused")
class Attribute
{
	final String mKey;
	final String mValue;

	Attribute(String key, String value)
	{
		mKey = key;
		mValue = value;
	}

	String getKey()
	{
		return mKey;
	}

	String getValue()
	{
		return mValue;
	}
}
