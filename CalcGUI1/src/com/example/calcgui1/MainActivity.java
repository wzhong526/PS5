package com.example.calcgui1;

import CalcEngine.CalcEngine;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	double investmentAmount;
	double years;
	double yearlyInterestRate;
	double yearlyInterest;
	Button eButton;
	EditText EditText1, EditText2, EditText3, EditText4;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eButton = (Button)this.findViewById(R.id.button1);
        EditText1 = (EditText)this.findViewById(R.id.editText1);
        EditText2 = (EditText)this.findViewById(R.id.editText2);
        EditText3 = (EditText)this.findViewById(R.id.editText3);
        EditText4 = (EditText)this.findViewById(R.id.editText4);
        eButton.setOnClickListener(new Button.OnClickListener(){
        	 public void onClick(View v)  {
        		 investmentAmount = Double.parseDouble(EditText1.getText().toString());
        		 years = Double.parseDouble(EditText2.getText().toString());
        		 yearlyInterestRate = Double.parseDouble(EditText3.getText().toString());
        		 CalcEngine engine = new CalcEngine();
        		 yearlyInterest = engine.futureInvestmentValue(investmentAmount,yearlyInterestRate, years);
        		 String A = Double.toString(yearlyInterest);
        		 EditText4.setText(A);
        		 
        	 }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
