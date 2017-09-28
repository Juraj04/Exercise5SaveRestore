package com.example.janik.exercise5saverestore;

import android.app.DialogFragment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        TextEntryDialogFragment.TextEntryDialogListener{

    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textView1);
        if(savedInstanceState != null){
            if(savedInstanceState.containsKey(TEXTVIEW_STATEKEY)){
                String text = savedInstanceState.getString(TEXTVIEW_STATEKEY);
                tv.setText(text);
            }
        }
    }

    public void buttonClicked(View view) {
        TextEntryDialogFragment eDialog = new TextEntryDialogFragment();
        eDialog.show(getFragmentManager(),"Text Dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(text);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(this,"cancel",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        outState.putString(TEXTVIEW_STATEKEY,tv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(savedInstanceState.getString(TEXTVIEW_STATEKEY));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }
}
