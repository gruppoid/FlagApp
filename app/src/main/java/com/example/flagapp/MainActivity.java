package com.example.flagapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_show;
    ImageView img_flag;
    EditText et_contry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_show=findViewById(R.id.button);
        img_flag=findViewById(R.id.imageView);
        et_contry=findViewById(R.id.editText);
        et_contry.addTextChangedListener(etWatcher);
        btn_show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (et_contry.getText().toString()) {
                    case "Россия":
                        img_flag.setImageResource(R.drawable.flag_rf);
                        break;
                    case "Аргентина":
                        img_flag.setImageResource(R.drawable.argent);
                        break;
                    case "Ямайка":
                        img_flag.setImageResource(R.drawable.jamaika);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Такой страны нет",
                                Toast.LENGTH_SHORT).show();
                        img_flag.setImageResource(R.drawable.flag1);
                        break;
                }
            }
        });
    }
    TextWatcher etWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            //btn_show.setEnabled(!et_contry.getText().toString().isEmpty());
            //btn_show.setEnabled(!et_contry.getText().toString().isEmpty());
            if (!et_contry.getText().toString().isEmpty()){
                btn_show.setEnabled(true);
                btn_show.setBackgroundResource(R.drawable.btn_gradient);
            } else {
                btn_show.setEnabled(false);
                btn_show.setBackgroundResource(R.color.colorBtnDisabled);
            }
        }
    };
}
