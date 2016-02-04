package com.okunev.catgirls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by 777 on 1/20/2016.
 */
public class Settings extends Activity {
    private Drawer.Result drawerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
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
                                intent = new Intent(Settings.this, SkillsActivity.class);
                                startActivity(intent);
                                break;
                            case 0:
                                intent = new Intent(Settings.this, MainActivity.class);
                                startActivity(intent);
                                break;
                        }
                    }
                }).withSelectedItem(2)
                .build();
    }
}