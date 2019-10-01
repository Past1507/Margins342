package com.example.margins342;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int selectedTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_SMALL = 1;
    public final static int THEME_BIG = 2;

    public static void changeToTheme(Activity activity, int theme)
    {
        selectedTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (selectedTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.medium_margins);
                break;
            case THEME_SMALL:
                activity.setTheme(R.style.small_margins);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.big_margins);
                break;
        }
    }
}
