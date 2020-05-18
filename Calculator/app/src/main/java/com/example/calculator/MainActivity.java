package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView memoryText;
    TextView mainText;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button allClearButton;
    Button clearButton;
    Button memoryClear;
    Button memoryRead;
    Button memorySubtract;
    Button memoryAdd;
    Button plus;
    Button substract;
    Button multiply;
    Button division;
    Button percent;
    Button squareRoot;
    Button changeSign;
    Button point;
    Button result;
    Calculator calculator;
    private String userInput;
    private boolean memorySet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView();

        calculator = new Calculator();
        calculatorDisplay();
    }

    private View.OnClickListener digitListener = v -> {
        Button button = (Button) v;
        if (userInput == null) {
            userInput = "";
        }

        if (calculator.newInput()) {
            userInput = "";
        }

        userInput += button.getText().toString();
        calculator.displayValue(Double.parseDouble(userInput));
        mainText.setText(userInput);
    };

    private View.OnClickListener operationListener = v -> {
        switch (v.getId()) {
            case R.id.plusButton:
                calculator.newOperation(Calculator.Operation.ADDITION);
                break;
            case R.id.minusButton:
                calculator.newOperation(Calculator.Operation.SUBTRACTION);
                break;
            case R.id.multiplyButton:
                calculator.newOperation(Calculator.Operation.MULTIPLICATION);
                break;
            case R.id.divideButton:
                calculator.newOperation(Calculator.Operation.DIVISION);
                break;
            case R.id.percentButton:
                calculator.newOperation(Calculator.Operation.PERCENTAGE);
                calculator.calculate();
                break;
            case R.id.squareRootButton:
                calculator.newOperation(Calculator.Operation.SQUARE_ROOT);
                calculator.calculate();
                break;
            case R.id.plushSlashMinusButton:
                calculator.changeSign();
                break;
            case R.id.mPlusButton:
                calculator.addToMemory();
                memorySet = true;
                memoryDisplay();
                break;
            case R.id.mMinusButton:
                calculator.subtractFromMemory();
                memorySet = true;
                memoryDisplay();
                break;
            case R.id.mrButton:
                calculator.memoryRead();
                break;
            case R.id.mcButton:
                calculator.clearMemory();
                memorySet = false;
                memoryDisplay();
                break;
            case R.id.cButton:
                calculator.clear();
                calculatorDisplay();
                break;
            case R.id.acButton:
                calculator.allClear();
                memorySet = false;
                calculatorDisplay();
                memoryDisplay();
                break;
            case R.id.resultButton:
                calculator.calculate();
                break;
        }

        if (calculator.newResult()) {
            calculatorDisplay();
        }
    };


    public void setContentView(){
        zero= findViewById(R.id.zeroButton);
        one=findViewById(R.id.oneButton);
        two=findViewById(R.id.twoButton);
        three=findViewById(R.id.threeButton);
        four=findViewById(R.id.fourButton);
        five=findViewById(R.id.fiveButton);
        six=findViewById(R.id.sixButton);
        seven=findViewById(R.id.sevenButton);
        eight=findViewById(R.id.sevenButton);
        nine=findViewById(R.id.sevenButton);

        allClearButton=findViewById(R.id.acButton);
        clearButton=findViewById(R.id.cButton);
        memoryClear=findViewById(R.id.mcButton);
        memoryRead=findViewById(R.id.mrButton);
        memorySubtract=findViewById(R.id.mMinusButton);
        memoryAdd=findViewById(R.id.mPlusButton);
        plus=findViewById(R.id.plusButton);
        substract=findViewById(R.id.minusButton);
        multiply=findViewById(R.id.multiplyButton);
        division=findViewById(R.id.divideButton);
        percent=findViewById(R.id.percentButton);
        squareRoot=findViewById(R.id.squareRootButton);
        changeSign=findViewById(R.id.plushSlashMinusButton);
        point=findViewById(R.id.pointButton);
        result=findViewById(R.id.resultButton);
        mainText=findViewById(R.id.mainText);
        memoryText=findViewById(R.id.memoryTextView);




        zero.setOnClickListener(digitListener);
        one.setOnClickListener(digitListener);
        two.setOnClickListener(digitListener);
        three.setOnClickListener(digitListener);
        four.setOnClickListener(digitListener);
        five.setOnClickListener(digitListener);
        six.setOnClickListener(digitListener);
        seven.setOnClickListener(digitListener);
        seven.setOnClickListener(digitListener);
        eight.setOnClickListener(digitListener);
        nine.setOnClickListener(digitListener);
        memoryRead.setOnClickListener(operationListener);
        memorySubtract.setOnClickListener(operationListener);
        memoryAdd.setOnClickListener(operationListener);
        memoryClear.setOnClickListener(operationListener);
        plus.setOnClickListener(operationListener);
        substract.setOnClickListener(operationListener);
        multiply.setOnClickListener(operationListener);
        division.setOnClickListener(operationListener);
        percent.setOnClickListener(operationListener);
        squareRoot.setOnClickListener(operationListener);
        changeSign.setOnClickListener(operationListener);
        result.setOnClickListener(operationListener);
        allClearButton.setOnClickListener(operationListener);
        clearButton.setOnClickListener(operationListener);
        point.setOnClickListener(l -> {
            Log.d(TAG, "userInput = " + userInput);
            userInput += ".";
            mainText.setText(userInput);
            Log.d(TAG, "userInput = " + userInput);
            calculator.displayValue(Double.parseDouble(userInput));
        });
    }
    private void calculatorDisplay() {

        double result = calculator.getResult();

        userInput = String.valueOf(result);
        if (userInput.substring(userInput.length() - 2 ).equals(".0")) {
            userInput = userInput.substring(0, userInput.length() - 2);
        }
        Log.d(TAG, "Mainactivity result =  " + result);
        mainText.setText(userInput);
    }

    private void memoryDisplay() {
        if (memorySet) {
            memoryText.setText("M");
        } else {
            memoryText.setText("");
        }
    }
    public static final String TAG = "MAINACTIVITY";
}
