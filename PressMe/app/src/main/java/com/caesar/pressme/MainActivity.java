package com.caesar.pressme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;

    private int Index = 0;

    private Character[] mCharacters = new Character[]{
        new Character(R.string.Android),
            new Character(R.string.is),
            new Character(R.string.cool),
            new Character(R.string.and),
            new Character(R.string.awesome),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.PressMeBtn);
        mTextView = (TextView) findViewById(R.id.myText);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        R.string.press,
                        Toast.LENGTH_SHORT).show();
                Index = Index + 1;
                if(Index > 4){
                    Index = 0;
                }
                update();
            }
        });
    }

    private void update(){
        int character = mCharacters[Index].getTextResId();
        mTextView.setText(character);
    }
}
