package com.rsmith.wordup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LetterGridActivity extends AppCompatActivity {

    private LetterGenerator letterGen;
    private TextView[] lettersTextView = new TextView[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_grid);
        letterGen = new LetterGenerator();
        String letters = new String(letterGen.getLetters());
        lettersTextView[0] = this.findViewById(R.id.textView00);
        lettersTextView[1] = this.findViewById(R.id.textView01);
        lettersTextView[2] = this.findViewById(R.id.textView02);
        lettersTextView[3] = this.findViewById(R.id.textView03);
        lettersTextView[4] = this.findViewById(R.id.textView04);
        lettersTextView[5] = this.findViewById(R.id.textView10);
        lettersTextView[6] = this.findViewById(R.id.textView11);
        lettersTextView[7] = this.findViewById(R.id.textView12);
        lettersTextView[8] = this.findViewById(R.id.textView13);
        lettersTextView[9] = this.findViewById(R.id.textView14);
        lettersTextView[10] = this.findViewById(R.id.textView20);
        lettersTextView[11] = this.findViewById(R.id.textView21);
        lettersTextView[12] = this.findViewById(R.id.textView22);
        lettersTextView[13] = this.findViewById(R.id.textView23);
        lettersTextView[14] = this.findViewById(R.id.textView24);
        lettersTextView[15] = this.findViewById(R.id.textView30);
        lettersTextView[16] = this.findViewById(R.id.textView31);
        lettersTextView[17] = this.findViewById(R.id.textView32);
        lettersTextView[18] = this.findViewById(R.id.textView33);
        lettersTextView[19] = this.findViewById(R.id.textView34);
        lettersTextView[20] = this.findViewById(R.id.textView40);
        lettersTextView[21] = this.findViewById(R.id.textView41);
        lettersTextView[22] = this.findViewById(R.id.textView42);
        lettersTextView[23] = this.findViewById(R.id.textView43);
        lettersTextView[24] = this.findViewById(R.id.textView44);

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                char[] letters = new char[25];
                letters = letterGen.getLetters();
                for (int i = 0; i < 25; i++){
                    lettersTextView[i].setText(Character.toString(letters[i]));
                }
            }
        });
    }


}
