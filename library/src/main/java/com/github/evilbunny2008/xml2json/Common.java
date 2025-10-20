package com.github.evilbunny2008.xml2json;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

@SuppressWarnings({"unused","SameParameterValue"})
class Common
{
	static final private boolean debug_on = true;

	/** @noinspection CallToPrintStackTrace*/
	static void doStackOutput(Exception e)
	{
		e.printStackTrace();
	}

	static void LogMessage(String value)
	{
		LogMessage(value, false);
	}

	static void LogMessage(String value, boolean showAnyway)
	{
		if (debug_on || showAnyway)
		{
			int len = value.indexOf("\n");
			if (len <= 0)
				len = value.length();
			Log.i("weeWX Weather", "message='" + value.substring(0, len) + "'");
		}
	}

	public static Activity getActivity(Context context)
	{
		while(context instanceof android.content.ContextWrapper)
		{
			if(context instanceof Activity)
				return (Activity) context;

			context = ((ContextWrapper)context).getBaseContext();
		}

		return null;
	}
}