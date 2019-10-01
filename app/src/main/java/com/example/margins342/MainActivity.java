package com.example.margins342;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

import static com.example.margins342.Utils.*;

public class MainActivity extends AppCompatActivity {
    Spinner switch_language;
    Button btn_switch;
    Spinner switching_margins;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select = switch_language.getSelectedItemPosition();
                Locale locale = null;
                if (select==0) {
                    locale = new Locale("ru");}
                else {
                    locale = new Locale("en");
                }

                int selected_margin = switching_margins.getSelectedItemPosition();
                switch (selected_margin) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BIG);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, THEME_DEFAULT);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, THEME_SMALL);
                        break;
                }

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initView() {
        switch_language = findViewById(R.id.switching);
        btn_switch = findViewById(R.id.btn_switch);
        switching_margins = findViewById(R.id.switching_margins);
    }
}
