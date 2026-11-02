package com.example.pizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentActivity extends AppCompatActivity {

    RadioGroup PayMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvSummary = findViewById(R.id.tvSummary);
        TextView tvPrice = findViewById(R.id.tvPrice);

        String size = getIntent().getStringExtra("size");
        String crust = getIntent().getStringExtra("crust");
        int price = getIntent().getIntExtra("price", 0);
        tvSummary.setText("ההזמנה שלך: פיצה " + size + ". עובי בצק: " + crust);
        tvPrice.setText("מחיר: " + price);

        PayMethod = findViewById(R.id.PayMethod);

        Button btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = PayMethod.getCheckedRadioButtonId();

                if(checkedId == R.id.card){
                    Toast.makeText(PaymentActivity.this, "שולם באשראי. תודה", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PaymentActivity.this, "שולם במזומן. תודה", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });


    }
}