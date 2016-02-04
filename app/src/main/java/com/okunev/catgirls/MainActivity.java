package com.okunev.catgirls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends Activity {
    private Drawer.Result drawerResult = null;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
     //   ActionBar actionBar = getActionBar();
     //   actionBar.hide();

        String[] options = getResources().getStringArray(R.array.options000);
        String storyT = getResources().getString(R.string.part_000);
        add(storyT, options);

        drawerResult = new Drawer()
                .withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("История").withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),
                        new PrimaryDrawerItem().withName("Навыки").withIcon(FontAwesome.Icon.faw_gamepad).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Хуйпиздаджигурда").withIcon(FontAwesome.Icon.faw_eye).withIdentifier(2)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        Intent intent;
                        switch ((int) id) {
                            case 1:
                                intent = new Intent(MainActivity.this, SkillsActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, Settings.class);
                                startActivity(intent);
                                break;
                        }
                    }
                }).withSelectedItem(0)
                .build();

    }


    public void add(String storyT, String[] options) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_main1, null);

        // Find the ScrollView
        LinearLayout sv = (LinearLayout) v.findViewById(R.id.container1);
        TextView story = (TextView) v.findViewById(R.id.story);
        story.setTextColor(Color.BLACK);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.y;
        int max = width / 2;
        story.setMaxHeight(max);
        story.setMovementMethod(new ScrollingMovementMethod());
        //  Toast.makeText(this, ""+max,Toast.LENGTH_LONG).show();
        story.setText(storyT);

        // Create a LinearLayout element
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        RadioGroup radioGroup = new RadioGroup(this);
        for (String option : options) {
            RadioButton option1 = new RadioButton(this);
            option1.setTextColor(Color.BLACK);
            option1.setText(option);
            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (((RadioButton) v).getText().toString()) {
                        case "[Попытаться отвлечь его и отобрать оружие]":
                            String[] options = getResources().getStringArray(R.array.options001);
                            String storyT = getResources().getString(R.string.part_001);
                            add(storyT, options);
                            break;
                        case "":
                            break;
                    }



                }
            });
            radioGroup.addView(option1);
        }

        ll.addView(radioGroup);

        // Add the LinearLayout element to the ScrollView
        sv.addView(ll);

        // Display the view
        setContentView(v);
    }
}
