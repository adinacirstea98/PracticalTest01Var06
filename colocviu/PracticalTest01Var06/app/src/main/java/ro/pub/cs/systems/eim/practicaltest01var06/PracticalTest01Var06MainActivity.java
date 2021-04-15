package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private EditText text1, text2, text3;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button play;

    public int count = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.play_button:
                    if (checkBox1.isChecked()) {
                        count++;
                        int rand = ThreadLocalRandom.current().nextInt(1, 4);
                        text1.setText(String.valueOf(rand));
                    } else {
                        text1.setText("*");
                    }
                    if (checkBox2.isChecked()) {
                        count++;
                        int rand = ThreadLocalRandom.current().nextInt(1, 4);
                        text2.setText(String.valueOf(rand));
                    } else {
                        text2.setText("*");
                    }
                    if (checkBox3.isChecked()) {
                        count++;
                        int rand = ThreadLocalRandom.current().nextInt(1, 4);
                        text3.setText(String.valueOf(rand));
                    } else {
                        text3.setText("*");
                    }

                    Toast.makeText(getApplicationContext(), "the numbers are: " + text1.getText().toString() + ", "
                            + text2.getText().toString() + ", " + text3.getText().toString(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06MainActivity.class);
                    intent.setType("count");
                    intent.putExtra("count", count);
                    startActivityForResult(intent, 3);
                    count = 0;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        play = (Button)findViewById(R.id.play_button);
        play.setOnClickListener(buttonClickListener);

        text1 = (EditText) findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        text3 = (EditText) findViewById(R.id.text3);

        checkBox1 = (CheckBox)findViewById(R.id.check_box1);
        checkBox2 = (CheckBox)findViewById(R.id.check_box2);
        checkBox3 = (CheckBox)findViewById(R.id.check_box3);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("nr1", text1.getText().toString());
        savedInstanceState.putString("nr2", text2.getText().toString());
        savedInstanceState.putString("nr3", text3.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("nr1")) {
            text1.setText(savedInstanceState.getString("nr1"));
        } else {
            text1.setText("");
        }
        if (savedInstanceState.containsKey("nr2")) {
            text2.setText(savedInstanceState.getString("nr2"));
        } else {
            text2.setText("");
        }
        if (savedInstanceState.containsKey("nr3")) {
            text3.setText(savedInstanceState.getString("nr3"));
        } else {
            text3.setText("");
        }
    }
}