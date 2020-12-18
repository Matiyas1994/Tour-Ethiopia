package com.example.tourethiopia

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import java.util.*

class SettingActivity : AppCompatActivity() {
    //    TextView language_dialog,text1;
    //    boolean lang_selected;
    //    Context context;
    //    Resources resources;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadlocale()
        setContentView(R.layout.activity_setting)
        val toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        setSupportActionBar(toolbar)
        //        ActionBar actionBar= getSupportActionBar();
//        actionBar.setTitle(getResources().getString(R.string.app_name));
        showchangeLangugeDialog()


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

    private fun showchangeLangugeDialog() {
        val listitems = arrayOf("አማርኛ", "English")
        val mBuilder = AlertDialog.Builder(this@SettingActivity)
        mBuilder.setTitle("Choose Language...")
        mBuilder.setSingleChoiceItems(listitems, -1) { dialogInterface, i ->
            if (i == 0) {
                setLocale("am")
                recreate()
            } else if (i == 1) {
                setLocale("en")
                recreate()
            }
            dialogInterface.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String?) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }

    fun loadlocale() {
        val pref = getSharedPreferences("settings", Activity.MODE_PRIVATE)
        val language = pref.getString("My_Lang", "")
        setLocale(language)
    }
}