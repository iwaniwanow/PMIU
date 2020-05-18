package com.example.calculator;

import android.util.Log;

public class Calculator {
    private static final String TAG = "calculator";

    public enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        PERCENTAGE,
        SQUARE_ROOT,
    }

    private double currentResult;
    private double secondOperand;
    private double memoryValue;


    private Operation currentOperation;

    private boolean justCleared;
    private boolean isNewInput;
    private boolean hasNewResult;
    private boolean justCalculated;

    public Calculator() {
        this.clear();
    }

    public double getResult() {
        return this.currentResult;
    }

    public boolean newResult() {

        return hasNewResult;
    }

    public boolean newInput() {
        return isNewInput;
    }

    public void displayValue(double newValue) {
        if (this.justCalculated) {
            clear();
            this.justCalculated = false;
        }

        if (this.justCleared) {
            this.currentResult = newValue;
            this.hasNewResult = true;
        } else {
            this.secondOperand = newValue;
        }
        this.isNewInput = false;
    }
    public void clear() {
        this.justCleared = true;
        this.currentResult = 0;
        this.currentOperation = null;
        this.isNewInput = true;
        this.secondOperand = 0;
        this.hasNewResult = false;
        this.justCalculated = false;
    }




    public void allClear() {
        clear();
        this.memoryValue = 0;
    }

    public void clearMemory() {
        this.memoryValue = 0;
    }

    public void addToMemory() {
        this.memoryValue += this.currentResult;
    }

    public void subtractFromMemory() {
        this.memoryValue -= this.currentResult;
    }

    public void memoryRead() {
        this.currentResult = this.memoryValue;
        hasNewResult = true;
    }



    public void newOperation(Operation newOperation) {
        this.justCalculated = false;
        if (hasNewResult) {
            Log.d(TAG, "In operation..");
            if (this.currentOperation != null && this.currentOperation == newOperation && !isNewInput) {
                this.calculate();
            }

            this.justCleared = false;
            this.isNewInput = true;
            this.currentOperation = newOperation;
            Log.d(TAG, "newOperation - " + currentOperation.toString());
        }
    }



    private void squareRoot() {
        this.currentResult = Math.sqrt(this.currentResult);
    }

    private void percentage() {
        this.currentResult  = this.currentResult / 100;
    }

    public void changeSign() {
        this.currentResult = -currentResult;
        hasNewResult = true;
    }


    public void calculate() {
        if (currentOperation != null) {
            Log.d(TAG, "calc");
            switch (currentOperation) {
                case ADDITION:
                    add();
                    break;
                case SUBTRACTION:
                    subtract();
                    break;
                case MULTIPLICATION:
                    multiply();
                    break;
                case DIVISION:
                    divide();
                    break;
                case PERCENTAGE:
                    percentage();
                    break;
                case SQUARE_ROOT:
                    squareRoot();
                    break;
            }
            isNewInput = true;
            hasNewResult = true;
            justCalculated = true;
        }
    }
    private void add() {
        this.currentResult += this.secondOperand;
        Log.d(TAG, "Plus - " + this.currentResult);
    }

    private void subtract() {
        this.currentResult -= this.secondOperand;
        Log.d(TAG, "Minus - " + this.currentResult);
    }

    private void multiply() {
        this.currentResult *= this.secondOperand;
        Log.d(TAG, "Multiply - " + this.currentResult);
    }

    private void divide() {
        try {
            this.currentResult /= this.secondOperand;
            Log.d(TAG, "Divide - " + this.currentResult);
        } catch (ArithmeticException e) {
            if (this.currentResult > 0)
                this.currentResult = Double.POSITIVE_INFINITY;
            else
                this.currentResult = Double.NEGATIVE_INFINITY;
        }
    }



}
