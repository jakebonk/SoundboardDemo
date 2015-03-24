package com.example.soundboarddemo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * Created by jacob on 3/23/2015.
 */
public class SoundboardButton {

    private MediaPlayer player = null;
    private String source,file_name,file_description;
    private boolean isOn = false;
    private Button btn;

    public SoundboardButton(String src, String name){
        source = src;
        file_name = name;
    }

    public SoundboardButton(String src, String name, String description){
        source = src;
        file_name = name;
        file_description = description;
    }

    public void createButton(Context c,LinearLayout s){
        btn = new Button(c);
        btn.setText(file_name);
        s.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    public void createSound(Context c){
        player = new MediaPlayer();
        try{
            AssetFileDescriptor afd = c.getAssets().openFd(source);
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            player.prepare();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer player) {
                    isOn = false;
                    if(btn != null){
                        btn.setText(file_name);
                    }
                }
            });
        }catch (Exception e){
            //Problem finding the file
            e.printStackTrace();
            Toast.makeText(c,"Nope",Toast.LENGTH_SHORT).show();
        }
    }

    public void pause(){
        if(player != null){
            player.pause();
            isOn = false;
        }
    }

    public void stop(){
        if(player != null) {
            player.pause();
            player.seekTo(0);
            if (btn != null) {
                btn.setText(file_name);
            }
            isOn = false;
        }
    }

    public void start(){
        if (player != null){
            player.start();
            isOn = true;
        }
    }

    public void toggle(){
            if(isOn){
                stop();
                if(btn != null){
                    btn.setText(file_name);
                }
            }else{
                start();
                btn.setText("Pause");
            }
    }

    public void destroySound(){
        if (player != null){
            player.stop();
            player.release();
            player = null;
        }
    }

}
