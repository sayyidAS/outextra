package com.example.outextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements
        View.OnClickListener {
    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;
    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity =
                (Button)findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject =
                (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(Main2Activity.this, Move.class);
                startActivity(moveIntent);

                break;

            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(Main2Activity.this,
                        MoveWithData.class);
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME,
                        "Sayyid Alwy Sanusi");
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE,
                        10);
                startActivity(moveWithDataIntent);

                break;

            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Sayyid Alwy Sanusi")  ;
                mPerson.setAge(10);

                mPerson.setEmail("sayyidalwy01@gmail.com");

                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(Main2Activity.this,
                        MoveWithObject.class);
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);

                break;

            case R.id.btn_dial_number:
                String phoneNumber = "081224850964";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);

                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(Main2Activity.this,
                        MoveForResult.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResult.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}