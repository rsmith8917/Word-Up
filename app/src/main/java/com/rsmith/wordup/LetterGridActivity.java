package com.rsmith.wordup;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LetterGridActivity extends AppCompatActivity {

    private LetterGenerator letterGen;
    private TextView[] lettersTextView = new TextView[25];
    private TextView word;
    private int[] upperLeft = new int[2];
    private int[] lowerRight = new int[2];
    private int lastCol = -1;
    private int lastRow = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_grid);
        word = findViewById(R.id.word);
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
                    if(letters[i] == 'Q'){
                        lettersTextView[i].setText("Qu");
                    } else {
                        lettersTextView[i].setText(Character.toString(letters[i]));
                    }
                }
            }
        });

    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        lettersTextView[0].getLocationOnScreen(upperLeft);
        lettersTextView[24].getLocationOnScreen(lowerRight);
        lowerRight[0] = lowerRight[0] + lettersTextView[24].getWidth();
        lowerRight[1] = lowerRight[1] + lettersTextView[24].getHeight() - upperLeft[1];
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        double x0 = event.getX() - upperLeft[0];
        double y0 = event.getY() - upperLeft[1];
        int col = 0;
        int row = 0;
        int index = 0;

        try{
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    double colDouble = ((x0 / lowerRight[0]) * 5);
                    double rowDouble = ((y0 / lowerRight[1]) * 5);
                    int colRemainder = (int)((colDouble * 10) % 10);
                    int rowRemainder = (int)((rowDouble * 10) % 10);
                    col = (int) colDouble;
                    row = (int) rowDouble;
                    index = col + (row * 5);
                    if (col != lastCol || row != lastRow) {
                        if (2 < colRemainder && 8 > colRemainder && 2 < rowRemainder && 8 > rowRemainder) {
                            String text = this.word.getText().toString() + lettersTextView[index].getText();
                            this.word.setText(text.toUpperCase());
                            for (int i = 0; i < 25; i++) {
                                if (i == index){
                                    lettersTextView[i].setTypeface(null, Typeface.BOLD);
                                    lettersTextView[i].setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                } else {
                                    lettersTextView[i].setTypeface(null, Typeface.NORMAL);
                                    lettersTextView[i].setBackgroundColor(0xFFFFFF);
                                }
                            }
                            lastCol = col;
                            lastRow = row;
                        }
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    colDouble = ((x0 / lowerRight[0]) * 5);
                    rowDouble = ((y0 / lowerRight[1]) * 5);
                    colRemainder = (int)((colDouble * 10) % 10);
                    rowRemainder = (int)((rowDouble * 10) % 10);
                    col = (int) colDouble;
                    row = (int) rowDouble;
                    index = col + (row * 5);
                    if (col != lastCol || row != lastRow) {
                        if (2 < colRemainder && 8 > colRemainder && 2 < rowRemainder && 8 > rowRemainder) {
                            String text = this.word.getText().toString() + lettersTextView[index].getText();
                            this.word.setText(text.toUpperCase());
                            for (int i = 0; i < 25; i++) {
                                if (i == index){
                                    lettersTextView[i].setTypeface(null, Typeface.BOLD);
                                    lettersTextView[i].setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                } else {
                                    lettersTextView[i].setTypeface(null, Typeface.NORMAL);
                                    lettersTextView[i].setBackgroundColor(0xFFFFFF);
                                }
                            }
                            lastCol = col;
                            lastRow = row;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    new OxfordDictionary().isWord(word.getText().toString().toLowerCase());
                    this.word.setText("");
                    for (int i = 0; i < 25; i++) {
                        lettersTextView[i].setTypeface(null, Typeface.NORMAL);
                        lettersTextView[i].setBackgroundColor(0xFFFFFF);
                    }
                    break;
            }
        } catch(IndexOutOfBoundsException e){

        }
        return false;
    }


}
