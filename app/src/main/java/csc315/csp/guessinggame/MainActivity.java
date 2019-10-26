package csc315.csp.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int random = new Random().nextInt(101) + 0;
    int tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputText = findViewById(R.id.inputText);
        //inputText.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
    }

    public void guessingGame(View view) {
        EditText inputText = findViewById(R.id.inputText);
        int input = Integer.valueOf(inputText.getText().toString());

        tries += 1;

        EditText outputText = findViewById(R.id.outputText);

        if(input == random) {
            okDialog dialog = new okDialog();
            dialog.show(getSupportFragmentManager(),"ok dialog");

            outputText.setText("Correct guess! It took " + tries + " tries.");

            random = new Random().nextInt(101) + 0;
        } else if(input > random) {
            outputText.setText("Too high.");
        } else if(input < random) {
            outputText.setText("Too low.");
        }
    }

    public void quit(View view) {
        EditText inputText = findViewById(R.id.inputText);

        inputText.setText("");

        EditText outputText = findViewById(R.id.outputText);

        outputText.setText("Answer is " + random);

        random = new Random().nextInt(101) + 0;

        tries = 0;
    }

    public void newGame(View view) {
        EditText inputText = findViewById(R.id.inputText);

        EditText outputText = findViewById(R.id.outputText);

        outputText.setText("");
        inputText.setText("");


        random = new Random().nextInt(101) + 0;

        tries = 0;
    }
}
