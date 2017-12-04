package ca.uottawa.householdchoremanagersystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by charmainederamos on 2017-11-27.
 */

public class CreateGroupActivity extends AppCompatActivity {
    private Button createGroupBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        createGroupBtn = (Button) findViewById(R.id.enter);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final String groupName = editText2.getText().toString();
        final String passwordName = editText.getText().toString();

            createGroupBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick (View v){
                    EditText editText2 = (EditText)findViewById(R.id.editText2);
                    EditText editText = (EditText)findViewById(R.id.editText);
                    String groupName = editText2.getText().toString();
                    String passwordName = editText.getText().toString();
                    if(!groupName.isEmpty() && !passwordName.isEmpty()) {
                        Intent intentMain = new Intent(CreateGroupActivity.this, MemberScreen.class);
                        CreateGroupActivity.this.startActivity(intentMain);
                        intentMain.putExtra("GROUP_NAME", "Welcome, " + editText2.getText().toString());
                        intentMain.putExtra("GROUP_PASSWORD", editText.getText().toString());
                        startActivity(intentMain);
                    } else{
                        Toast.makeText(CreateGroupActivity.this, "Please enter group NAME and PASSWORD", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
