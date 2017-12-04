package ca.uottawa.householdchoremanagersystem;

/**
 * Created by leah mccormick on 2017-11-29.
 */

public class Chore {
    private String choreID="";
    private String choreName="Not yet defined";
    private String deadline="Not yet defined";
    private Boolean hasPoints=false;
    private int pointValue=0;
    private Boolean hasPassword=false;
    private Boolean isCompleted=false;
    private String password="Not yet defined";
    private Boolean isAssigned=false;
    private String description="Not yet defined";
    private String assignedTo="Not yet defined";

    public Chore(){}

    public Chore(String id, String name) {
        this.choreName = name;
        this.choreID = id;

    }

    public String getChoreID(){
        return choreID;
    }

    public String getChoreName(){
        return choreName;
    }

    public String getDeadline(){
        return deadline;
    }
    public Boolean hasPoints(){
        return hasPoints;
    }
    public int getPointValue(){
        return pointValue;
    }
    public Boolean getHasPassword(){
        return hasPassword;
    }
    public Boolean getIsCompleted(){
        return isCompleted;
    }
    public String getPassword(){
        return password;
    }
    public Boolean getIsAssigned(){
        return isAssigned;
    }
    public String getDescription(){
        return description;
    }
    public String getAssignedTo() {return assignedTo;}

    public void setChoreID(String choreID){
        choreID=this.choreID;
    }

    public void setChoreName(String choreName){
        choreName=this.choreName;
    }

    public void setDeadline(String deadline){
        deadline=this.deadline;
    }
    public void setHasPoints(Boolean hasPoints){
        hasPoints= this.hasPoints;
    }
    public void setPointValue(int pointValue){
        pointValue= this.pointValue;
    }
    public void setHasPassword(Boolean hasPassword){
        hasPassword= this.hasPassword;
    }
    public void setIsCompleted(Boolean isCompleted){
        isCompleted=this.isCompleted;
    }
    public void setPassword(String password){
        password=this.password;
    }
    public void setIsAssigned(Boolean isAssigned){
        isAssigned=this.isAssigned;
    }
    public void setDescription(String description){
        description=this.description;
    }
    public void setAssignedTo(Member member) {assignedTo = member.getName();}

}
