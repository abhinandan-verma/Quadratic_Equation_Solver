package com.example.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    String a;
    String b;
    String c;
    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }
    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public MyEquation() {
    }

    public void solveEquation(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        //Calculating the Discriminant
        double discriminant = b*b - 4*a*c;
        double x1, x2;
        if(discriminant > 0){
            //two real & distinct roots
            x1 = (-b + Math.sqrt(discriminant))/(2*a);
            x2 = (-b - Math.sqrt(discriminant))/(2*a);

            //Display the results in the textView
            binding.textView.setText("X1 = "+x1+"\nX2 = "+x2);
        }else if(discriminant == 0){
            x1 =  x2 = (-b)/(2*a);

            //displaying Solutions
            binding.textView.setText("X1 = X2 = "+x1);
        }else{
            //no real roots
           binding.textView.setText("No Real roots ");
        }
    }

    public void setEquation(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        binding.edit1.setText("");
        binding.edit2.setText("");
        binding.editText.setText("");
        binding.textView.setText("Enter Your Parameters");
    }
}
