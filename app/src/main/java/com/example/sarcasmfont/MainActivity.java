package com.example.sarcasmfont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText thetext;
    public String newtext="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        thetext=findViewById(R.id.editText);

    }

    public void submitText(View view) {
        String name_hai = (String) thetext.getText().toString();
        String jatin=name_hai;
        newtext="";
        int n= jatin.length();
        jatin=jatin.toLowerCase();
        for(int i=0;i<n;i++){
            if (i%2!=0){
                if(i==n){
                    break;
                }
                else{
                    newtext = newtext+(jatin.substring(i,i+1).toUpperCase());
                }

            }
            else{
                if(i==n){
                    break;
                }
                else{
                    newtext=newtext+(jatin.substring(i,i+1));

                }
            }

        }

        createtext(newtext);

    }

    private void createtext(String newtext) {
        TextView showTextView=findViewById(R.id.editText);
        showTextView.setText("");
        showTextView.setText(newtext);
    }


    public void copytoclipboard(View view) {
        if (newtext==""){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Enter your SaRcAsM",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
        else if(thetext.toString()==""){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "first enter your SaRcAsM",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
        else{
            ClipboardManager clipboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip =ClipData.newPlainText("SarcasmText",newtext);
            clipboard.setPrimaryClip(clip);
            Toast toast=Toast.makeText(getApplicationContext(),"Sarcasm Copied:)",Toast.LENGTH_SHORT);
            toast.show();

        }

    }
}
