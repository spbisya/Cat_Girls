package com.okunev.catgirls;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by 777 on 2/4/2016.
 */
public class SuyActivity extends Activity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suck);

        mediaPlayer = MediaPlayer.create(this, R.raw.s1);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.stop();
    }
}
