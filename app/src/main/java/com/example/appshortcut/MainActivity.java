package com.example.appshortcut;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ShortcutManager shortcutManager;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            shortcutManager = getSystemService(ShortcutManager.class);

            Intent dynamicIntent = new Intent(this, Main2Activity.class);
            dynamicIntent.setAction(Intent.ACTION_VIEW);
            ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "dynamic_shortcut")
                    .setShortLabel("Activity 2")
                    .setLongLabel("Launch Activity 2")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                    .setIntent(dynamicIntent)
                    .build();
            shortcutManager.setDynamicShortcuts(Collections.singletonList(dynamicShortcut));
        }
    }
}
