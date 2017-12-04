package ca.uottawa.householdchoremanagersystem;
import java.util.ArrayList;

/**
 * Created by jenniferliu on 2017-12-01.
 */

public class MemberManager {
    public static final String intentIndexTitle = "selectedChore";
    private static MemberManager instance = null;
    private ArrayList<Member> memberList;

    protected MemberManager() {
        // to defeat instantiation

        String[] values = new String[]{
            "jen", "keirt"
        };

        memberList = new ArrayList<>();

        for (int i = 0; i < values.length ; i++) {
            Member newMember = new Member(values[i]);
            memberList.add(newMember);
        }
    }

    public static MemberManager getInstance() {
        if (instance == null) {
            instance = new MemberManager();
        }
        return instance;
    }

    public ArrayList<Member> getMemList() {
        return memberList;
    }

}

