package com.example.tourethiopia;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity {


//    TextView language_dialog,text1;
//    boolean lang_selected;
//    Context context;
//    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadlocale();
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
//        ActionBar actionBar= getSupportActionBar();
//        actionBar.setTitle(getResources().getString(R.string.app_name));

        showchangeLangugeDialog();


//                language_dialog = (TextView)findViewById(R.id.dialog_language);
//                text1=(TextView)findViewById(R.id.text1);
//
//                language_dialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        final String[] Language = {"ENGLISH", "हिन्दी"};
//                        final int checkedItem;
//
//                        if(lang_selected)
//                        {
//                            checkedItem=0;
//                        }else
//                        {
//                            checkedItem=1;
//                        }
//
//                        final AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
//                        builder.setTitle("Select a Language...")
//                                .setSingleChoiceItems(Language, checkedItem, new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(SettingActivity.this,""+which,Toast.LENGTH_SHORT).show();
//                                        language_dialog.setText(Language[which]);
//                                        lang_selected= Language[which].equals("ENGLISH");
//                                        //if user select prefered language as English then
//                                        if(Language[which].equals("ENGLISH"))
//                                        {
//                                            context = LocaleHelper.setLocale(SettingActivity.this, "en");
//                                            resources = context.getResources();
//
//                                            text1.setText(resources.getString(R.string.language));
//                                        }
//                                        //if user select prefered language as Hindi then
//                                        if(Language[which].equals("हिन्दी"))
//                                        {
//                                            context = LocaleHelper.setLocale(SettingActivity.this, "hi");
//                                            resources = context.getResources();
//
//                                            text1.setText(resources.getString(R.string.language));
//                                        }
//                                    }
//                                })
//                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.dismiss();
//                                    }
//                                });
//                        builder.create().show();
//                    }
//
//                });
            }

    private void showchangeLangugeDialog() {
        final String[] listitems={"አማርኛ","English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SettingActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i==0){
                    setLocale("am");
                    recreate();
                }


                else if (i==1){
                    setLocale("en");
                    recreate();
                }

                dialogInterface.dismiss();

            }
        });

        AlertDialog mDialog= mBuilder.create();
        mDialog.show();
    }

    private  void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config= new Configuration();
        config.locale=locale;

        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor= getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }

    public  void loadlocale(){
        SharedPreferences pref= getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language= pref.getString("My_Lang","");
        setLocale(language);
    }

}