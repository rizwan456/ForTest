package com.maya.testfrost.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

public class HeadSetActionReceiver extends BroadcastReceiver {
    private static final String TAG_MEDIA = "MEDIA";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction))
        {
            Log.i(TAG_MEDIA, "no media button information");
            return;
        }
        KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            Log.i(TAG_MEDIA, "no key press");
            return;
        }


        if(event.getKeyCode() ==  KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
        {
            VideoPlayerFragment.iHeadSetsController.applyAction();
            return;
        }

        if(event.getKeyCode() == KeyEvent.KEYCODE_HEADSETHOOK)
        {
            VideoPlayerFragment.iHeadSetsController.applyAction();
            return;
        }
    }
}
