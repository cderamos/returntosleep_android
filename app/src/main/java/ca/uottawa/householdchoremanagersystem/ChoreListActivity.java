package ca.uottawa.householdchoremanagersystem;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



public class ChoreListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chore_list);
    }

    // Get ListView object from xml layout
    ListView listView = (ListView) findViewById(R.id.choreList);

    //Getting ChoreManager Instance
    ChoreManager manager = ChoreManager.getInstance();

    //Defining Array values to show in ListView
    ChoreArrayAdapter adapter = new ChoreArrayAdapter(this, manager.getChoreList());
    // listView.setAdapter(adapter);

    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent launchTeamEditorIntent = new Intent(getApplicationContext(), ChoreEditorActivity.class);
                launchTeamEditorIntent.putExtra(ChoreManager.intentIndexTitle, position);
                startActivityForResult(launchTeamEditorIntent, 0);
            }
        });
    }
}