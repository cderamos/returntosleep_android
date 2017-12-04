package ca.uottawa.householdchoremanagersystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by keirt on 2017-12-04.
 */

public class ChoreList extends ArrayAdapter<Chore> {
    private Activity context;
    List<Chore> chores;

    public ChoreList(Activity context, List<Chore> chores){
        super(context, R.layout.layout_chore_list, chores);
        this.context = context;
        this.chores = chores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parennt){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_chore_list, null, true);

        TextView textViewName= (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewMem = (TextView) listViewItem.findViewById(R.id.textViewPrice);

        Chore chore = chores.get(position);
        textViewName.setText(chore.getChoreName());
        textViewMem.setText(String.valueOf(chore.getAssignedTo()));
        return listViewItem;
    }
}
