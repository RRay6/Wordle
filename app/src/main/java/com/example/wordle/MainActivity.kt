package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val word = FourLetterWordList.getRandomFourLetterWord();
        var currentGuess = 1;
        var restart = 0;

        val a1 = findViewById<TextView>(R.id.firstWordLetterOne);
        val a2 = findViewById<TextView>(R.id.firstWordLetterTwo);
        val a3 = findViewById<TextView>(R.id.firstWordLetterThree);
        val a4 = findViewById<TextView>(R.id.firstWordLetterFour);

        val a = arrayOf(a1, a2, a3, a4);

        val b1 = findViewById<TextView>(R.id.secondWordLetterOne);
        val b2 = findViewById<TextView>(R.id.secondWordLetterTwo);
        val b3 = findViewById<TextView>(R.id.secondWordLetterThree);
        val b4 = findViewById<TextView>(R.id.secondWordLetterFour);

        val b = arrayOf(b1, b2, b3, b4);

        val c1 = findViewById<TextView>(R.id.thirdWordLetterOne);
        val c2 = findViewById<TextView>(R.id.thirdWordLetterTwo);
        val c3 = findViewById<TextView>(R.id.thirdWordLetterThree);
        val c4 = findViewById<TextView>(R.id.thirdWordLetterFour);

        val c = arrayOf(c1, c2, c3, c4);

        val editText = findViewById<EditText>(R.id.editText);

        val button = findViewById<Button>(R.id.button);

        button.setOnClickListener {
            //Toast.makeText(this, "Hello to you too!", Toast.LENGTH_SHORT).show()

            val guess = editText.text.toString();

            if (restart == 0 && guess.length < 4) {
                Toast.makeText(this, "Guess must be 4 letters! Nothing more, nothing less! >:(", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }

            if (currentGuess == 1)
            {
                Log.v("word", word);
                Log.v("word", guess);

                for (i in 0..3) {

                    a[i].setText("" + guess[i].uppercase());
                    currentGuess = 2;

                    if (guess.lowercase() == word.lowercase()) {
                        currentGuess = 4;
                    }

                    if (guess[i].lowercase() == word[i].lowercase()) {
                        a[i].setBackgroundColor(Color.parseColor("#538d4e"));
                    } else if (guess[i].lowercase() in word.lowercase()) {
                        a[i].setBackgroundColor(Color.parseColor("#e1cd07"));
                    }
                }
            }
            else if (currentGuess == 2)
            {
                for (i in 0..3) {

                    b[i].setText("" + guess[i].uppercase());
                    currentGuess = 3;

                    if (guess.lowercase() == word.lowercase()) {
                        currentGuess = 4;
                    }

                    if (guess[i].lowercase() == word[i].lowercase()) {
                        b[i].setBackgroundColor(Color.parseColor("#538d4e"));
                    } else if (guess[i].lowercase() in word.lowercase()) {
                        b[i].setBackgroundColor(Color.parseColor("#e1cd07"));
                    }
                }
            }
            else if (currentGuess == 3)
            {
                for (i in 0..3) {

                    c[i].setText("" + guess[i].uppercase());

                    if (guess[i].lowercase() == word[i].lowercase()) {
                        c[i].setBackgroundColor(Color.parseColor("#538d4e"));
                    } else if (guess[i].lowercase() in word.lowercase()) {
                        c[i].setBackgroundColor(Color.parseColor("#e1cd07"));
                    }
                }

                currentGuess = 4;
            }

            if (restart == 1)
            {
                currentGuess = 1;

                for (i in 0..3) {
                    a[i].setText("");
                    a[i].setBackgroundColor(Color.parseColor("#3a3a3c"));
                    b[i].setText("");
                    b[i].setBackgroundColor(Color.parseColor("#3a3a3c"));
                    c[i].setText("");
                    c[i].setBackgroundColor(Color.parseColor("#3a3a3c"));
                }

                editText.setHint("Enter a Four Letter Word");
                editText.isEnabled = true;
                button.setText("Guess!");

                restart = 0;
            }

            if (currentGuess == 4)
            {
                button.setText("Restart");
                editText.setHint("Play again!");
                editText.isEnabled = false;

                restart = 1;
            }

            editText.setText("");
        }

        editText.addTextChangedListener(object : TextWatcher
        {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                editText.setTextColor(Color.parseColor("#FFFFFF"));

                if (currentGuess == 1)
                {
                    if (editText.text.toString().length == 0) {
                        a1.setText("");
                        a2.setText("");
                        a3.setText("");
                        a4.setText("");
                    }

                    if (editText.text.toString().length == 1) {
                        a1.setText((""+editText.text.toString()[0]).uppercase());
                        a2.setText("");
                        a3.setText("");
                        a4.setText("");
                    }

                    if (editText.text.toString().length == 2) {
                        a2.setText((""+editText.text.toString()[1]).uppercase());
                        a3.setText("");
                        a4.setText("");
                    }

                    if (editText.text.toString().length == 3) {
                        a3.setText((""+editText.text.toString()[2]).uppercase());
                        a4.setText("");
                    }

                    if (editText.text.toString().length == 4) {
                        a4.setText((""+editText.text.toString()[3]).uppercase());
                    }
                }
                else if (currentGuess == 2)
                {
                    if (editText.text.toString().length == 0) {
                        b1.setText("");
                        b2.setText("");
                        b3.setText("");
                        b4.setText("");
                    }

                    if (editText.text.toString().length == 1) {
                        b1.setText((""+editText.text.toString()[0]).uppercase());
                        b2.setText("");
                        b3.setText("");
                        b4.setText("");
                    }

                    if (editText.text.toString().length == 2) {
                        b2.setText((""+editText.text.toString()[1]).uppercase());
                        b3.setText("");
                        b4.setText("");
                    }

                    if (editText.text.toString().length == 3) {
                        b3.setText((""+editText.text.toString()[2]).uppercase());
                        b4.setText("");
                    }

                    if (editText.text.toString().length == 4) {
                        b4.setText((""+editText.text.toString()[3]).uppercase());
                    }
                }
                else if (currentGuess == 3)
                {
                    if (editText.text.toString().length == 0) {
                        c1.setText("");
                        c2.setText("");
                        c3.setText("");
                        c4.setText("");
                    }

                    if (editText.text.toString().length == 1) {
                        c1.setText((""+editText.text.toString()[0]).uppercase());
                        c2.setText("");
                        c3.setText("");
                        c4.setText("");
                    }

                    if (editText.text.toString().length == 2) {
                        c2.setText((""+editText.text.toString()[1]).uppercase());
                        c3.setText("");
                        c4.setText("");
                    }

                    if (editText.text.toString().length == 3) {
                        c3.setText((""+editText.text.toString()[2]).uppercase());
                        c4.setText("");
                    }

                    if (editText.text.toString().length == 4) {
                        c4.setText((""+editText.text.toString()[3]).uppercase());
                    }
                }
            }
        })
    }
}