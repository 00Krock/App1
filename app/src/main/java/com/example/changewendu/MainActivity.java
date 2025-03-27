package com.example.changewendu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText heightInput, weightInput;
    private TextView resultText, adviceText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        resultText = findViewById(R.id.resultText);
        adviceText = findViewById(R.id.adviceText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);
            resultText.setText(String.format("BMI: %.2f", bmi));

            if (bmi < 18.5) {
                adviceText.setText("体重过轻，建议多食用富含脂肪蛋白质的食物");
            } else if (bmi >= 18.5 && bmi < 24.9) {
                adviceText.setText("体重正常，非常健康。");
            } else if (bmi >= 25 && bmi < 29.9) {
                adviceText.setText("体重超重，建议多运动，并合理饮食。");
            } else {
                adviceText.setText("肥胖，建议严格控制饮食并尽量前往医院就诊。");
            }
        } else {
            resultText.setText("请输入身高和体重：");
            adviceText.setText("");
        }
    }
}