package com.example.soundboarddemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<SoundboardButton> soundboardList = new ArrayList<SoundboardButton>();
    private LinearLayout scrollContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollContent = (LinearLayout)findViewById(R.id.llScrollContent);

        //How to add a btn : Define the source in assets folder , then the name, you can also add a description if you want
        soundboardList.add(new SoundboardButton("test.mp3", "New Xbox 720!", "Test Desc"));
        soundboardList.add(new SoundboardButton("sheep.mp3", "Screaming Sheep"));
        soundboardList.add(new SoundboardButton("Helicopter Cat Meow.mp3", "Helicopter Cat!"));
        soundboardList.add(new SoundboardButton("test.mp3", "New Xbox 720!", "Test Desc"));
        soundboardList.add(new SoundboardButton("sheep.mp3", "Screaming Sheep"));
        soundboardList.add(new SoundboardButton("Helicopter Cat Meow.mp3", "Helicopter Cat!"));
        soundboardList.add(new SoundboardButton("test.mp3", "New Xbox 720!", "Test Desc"));
        soundboardList.add(new SoundboardButton("sheep.mp3", "Screaming Sheep"));
        soundboardList.add(new SoundboardButton("Helicopter Cat Meow.mp3", "Helicopter Cat!"));
        soundboardList.add(new SoundboardButton("test.mp3", "New Xbox 720!", "Test Desc"));
        soundboardList.add(new SoundboardButton("sheep.mp3", "Screaming Sheep"));
        soundboardList.add(new SoundboardButton("Helicopter Cat Meow.mp3", "Helicopter Cat!"));

        //instantiates buttons with sound attached
        createSoundboardButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createSoundboardButtons(){
        for(int i = 0; i < soundboardList.size(); i++) {
            soundboardList.get(i).createSound(getBaseContext());
            soundboardList.get(i).createButton(getBaseContext(), scrollContent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for(int i = 0; i < soundboardList.size(); i++){
            soundboardList.get(i).destroySound();
        }
    }
}
