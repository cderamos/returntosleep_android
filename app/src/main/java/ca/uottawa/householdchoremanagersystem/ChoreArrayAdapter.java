package ca.uottawa.householdchoremanagersystem;

/**
 * Created by leah mccormick on 2017-11-29.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;




public class ChoreArrayAdapter extends ArrayAdapter<Chore>  {
    /**/
    private final Context context;
    private final ArrayList<Chore> chores;
    //change to correct xml file
    public ChoreArrayAdapter(Context context, ArrayList<Chore> values) {
        super(context, R.layout.activity_chore_list, values);
        this.context = context;
        this.chores = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Getting Chore
        Chore curChore = chores.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//Item name is whatever the text view for chore name is called
        View rowView = inflater.inflate(R.layout.activity_chore_list, parent, false);
        //TextView choreName = (TextView) rowView.findViewById(R.id.ItemName);

        //Placing content into chore List Item
        //place other details once it's working
        //choreName.setText(curChore.getChoreName());



        return rowView;
    }
}

