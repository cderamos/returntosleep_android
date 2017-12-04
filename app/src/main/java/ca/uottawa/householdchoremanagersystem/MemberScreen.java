package ca.uottawa.householdchoremanagersystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

/**
 * Created by keirt on 2017-11-24.
 */

public class MemberScreen extends AppCompatActivity{

    private EditText password;


    private EditText memberName;
    private EditText edit;
    ListView membersList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {

        final AlertDialog.Builder alertPW = new AlertDialog.Builder(MemberScreen.this);
        final AlertDialog.Builder alertMem = new AlertDialog.Builder(MemberScreen.this);

        alertPW.setTitle("Unlock Features");
        alertPW.setMessage("Enter Password");
        alertPW.setCancelable(true);

        alertMem.setTitle("Add New Member");
        alertMem.setMessage("Enter Member Name:");
        alertMem.setCancelable(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.members_page);

        //Get info from create_group layout
        Intent intent = getIntent();
        String group_name = intent.getStringExtra("GROUP_NAME");
        String group_password = intent.getStringExtra( "GROUP_PASSWORD");
        TextView groupName = (TextView) findViewById(R.id.groupName);
        groupName.setText(group_name);

        //Password insertion
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child("userInput").setValue(group_password);
        Toast.makeText(MemberScreen.this, "Group Successfully Created!", Toast.LENGTH_SHORT).show();

        final FloatingActionButton lockBtn = (FloatingActionButton) findViewById(R.id.lockBtn);
        final FloatingActionButton unlockBtn = (FloatingActionButton) findViewById(R.id.unlockBtn);
        final FloatingActionButton addMemberBtn = (FloatingActionButton) findViewById(R.id.addMemberBtn);

        lockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = new EditText(MemberScreen.this);
                alertPW.setView(password);
                alertPW.setPositiveButton("Unlock", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myRef.child("userInput").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String passwordInput = password.getText().toString().trim();
                                String pwCheck = dataSnapshot.getValue().toString();
                                if (passwordInput.equals(pwCheck)) {
                                    lockBtn.setVisibility(View.GONE);
                                    unlockBtn.setVisibility(View.VISIBLE);
                                    addMemberBtn.setVisibility(View.VISIBLE);
                                } else {
                                    Toast.makeText(MemberScreen.this,"Invalid Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                    }
                });
                alertPW.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
               alertPW.show();
            }
        });

        unlockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lockBtn.setVisibility(View.VISIBLE);
                unlockBtn.setVisibility(View.GONE);
                addMemberBtn.setVisibility(View.GONE);
            }
        });

        addMemberBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                memberName = new EditText(MemberScreen.this);
                alertMem.setView(memberName);
                alertMem.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Initialize variables
                        list = new ArrayList<String>();
                        membersList = (ListView) findViewById(R.id.membersList);
                        adapter = new ArrayAdapter<String>(MemberScreen.this, android.R.layout.simple_list_item_1, list);
                        membersList.setAdapter(adapter);
                        //add member into the list
                        String result = memberName.getText().toString();
                        list.add(result);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertMem.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertMem.show();
            }

        });
    }
}