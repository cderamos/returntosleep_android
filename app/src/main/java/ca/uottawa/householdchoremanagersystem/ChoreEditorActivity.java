package ca.uottawa.householdchoremanagersystem;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChoreEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chore_detail);

        //Getting the incoming intent
        Intent intent = getIntent();
        int choreIndex = intent.getIntExtra(ChoreManager.intentIndexTitle,0); //0 is a "default return value"

        //Getting TextFields we are about to update
        final TextView choreName = (TextView) findViewById(R.id.line1);
        final EditText choreDescriptionline = (EditText) findViewById(R.id.line2);


        //Getting corresponding chore
        final Chore chore = ChoreManager.getInstance().getChoreAt(choreIndex);

        //Updating contents in this screen
        choreName.setText(chore.getChoreName());
        choreDescriptionline.setText(chore.getDescription());

        //Updating Function of OnClick Button (Save)
        Button saveButton = (Button) findViewById(R.id.Edit);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Updating contents in variable
                chore.setChoreName(choreName.getText().toString());
                chore.setDescription(choreDescriptionline.getText().toString());

                //TODO: Save changed chore information


                finish();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
