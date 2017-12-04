package ca.uottawa.householdchoremanagersystem;

/**
 * Created by jenniferliu on 2017-12-01.
 */

public class Member {

    String name;
    Chore[] chores;

    public Member(String n){
        name=n;
    }

    String getName(){
        return name;
    }
}
