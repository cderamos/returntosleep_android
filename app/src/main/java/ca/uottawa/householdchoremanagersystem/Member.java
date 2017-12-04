package ca.uottawa.householdchoremanagersystem;

import java.util.ArrayList;

/**
 * Created by jenniferliu on 2017-12-01.
 */

public class Member {
    private ArrayList<Member> members;


    String name, id;
    Chore[] chores;

    public Member(String x) {
        name = x;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    String getName() {
        return name;
    }

    void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return this.name;
    }
}