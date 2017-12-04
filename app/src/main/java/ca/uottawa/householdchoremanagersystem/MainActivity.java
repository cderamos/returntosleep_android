package ca.uottawa.householdchoremanagersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);


        Button groupCreateBtn = (Button) findViewById(R.id.familyButton);
        groupCreateBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intentMain = new Intent(MainActivity.this, CreateGroupActivity.class);
                MainActivity.this.startActivity(intentMain);
            }
        });
    }
}
