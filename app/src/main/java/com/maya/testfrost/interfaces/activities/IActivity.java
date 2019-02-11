package com.maya.testfrost.interfaces.activities;

import android.app.Activity;

/**
 * Created by Gokul Kalagara (Mr.Psycho) on 15/10/18.
 */

public interface IActivity
{
    public void changeTitle(String title);
    public void showSnackBar(String snackBarText, int type);
    public Activity activity();
}
