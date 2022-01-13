package com.example.android.audio_player;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
        TextView starti,pausei,stopi;
    public void relaseMediaPlayer(MediaPlayer temp)
    {
        if(temp!=null)
        {
            temp.release();
            temp=null;
        }
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            starti = (TextView) findViewById(R.id.play);
            pausei = (TextView) findViewById(R.id.pause);
            stopi = (TextView) findViewById(R.id.stop);
            //creating media player
            MediaPlayer  mMediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.song);


            starti.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            Toast.makeText(MainActivity.this,"I'm Done",Toast.LENGTH_SHORT).show();
                        }
                    });
                    relaseMediaPlayer(mMediaPlayer);
                }
            });


            pausei.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMediaPlayer.pause();
                }
            });
//            stopi.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mMediaPlayer.stop();
//                }
//            });

        }
    }
