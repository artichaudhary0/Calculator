package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private  EditText editText;
    private Button submitBtn ;
    private TextView result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // binding
        editText = findViewById(R.id.inputText);
        submitBtn = findViewById(R.id.submit_area);
        result = findViewById(R.id.result);



        // listner
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString(); // data from edit text


                // valid input

                if(data.isEmpty())
                {
                    editText.setError("Input field can not be empty");
                    Toast.makeText(MainActivity.this,"Please enter data",Toast.LENGTH_SHORT).show();
                }else {
                    // display the input
                    result.setText("Your input is : "+ data);
                    Toast.makeText(MainActivity.this,"Input submitted successfully",Toast.LENGTH_SHORT).show();


                }






            }
        });












//        Button button = findViewById(R.id.button1);
//        EditText text = findViewById(R.id.edit_text_id);
//
//        Button button2 = findViewById(R.id.button2);


//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String input = text.getText().toString();
//
//                if (input.isEmpty() && input.equals(""))
//                {
//                    text.setError("This field is empty");
//
//                    Toast.makeText(getApplicationContext(),"This field is empty",Toast.LENGTH_SHORT).show();
//
//                }else{
//                    Toast.makeText(getApplicationContext(),input,Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String inputText = editText.getText().toString();
//                if(inputText.isEmpty()){
//                    editText.setError("This field is empty");
//                }else{
//                    Toast.makeText(getApplicationContext(),inputText,Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Button Clicked!",Toast.LENGTH_SHORT).show();
//            }
//        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}