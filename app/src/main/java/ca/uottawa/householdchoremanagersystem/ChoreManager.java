package ca.uottawa.householdchoremanagersystem;

/**
 * Created by leah mccormick on 2017-11-29.
 */

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ChoreManager {



        public static final String intentIndexTitle = "selectedChore";
        private static ChoreManager instance = null;
        private ArrayList<Chore> choreList;



        protected ChoreManager() {
            // to defeat instantiation

            String[] values = new String[]{
                    "Rake", "Wash Dishes", "Laundry", "Cook Dinner", "Groceries", "empty", "empty", "empty", "empty", "empty"
            };

            choreList = new ArrayList<>();



            for (int i = 0; i < values.length ; i++) {
                Chore newChore = new Chore(values[i]);
                choreList.add(newChore);
            }
        }

        public static ChoreManager getInstance() {
            if (instance == null) {
                instance = new ChoreManager();
            }
            return instance;
        }

        public ArrayList<Chore> getChoreList() {
            return choreList;
        }

        public Chore getChoreAt(int index) {
            return choreList.get(index);
        }
        // need to add remove method
        public void removeChore(int i){
                    choreList.remove(i);
        }
    }


