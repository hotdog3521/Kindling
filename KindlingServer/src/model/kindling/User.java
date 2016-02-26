package model.kindling;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//the user class as described in the DDD
    private String name, userName, password;
    private int age, intelLevel;
    private int sexualOrientation; // 0 = into males, 1 = into females, 2 = into both
    private int sex; // 0 = male, 1 = female
    private Range intelRange;
    private Range ageRange;
    //add an image format tbd

    // Constructor
    public User() {}
    
    // Constructor - Username is required.
    public User(String _username){
        //possibly set to some default values
    	this.userName = _username;
    }

    public void setName (String _name){
        this.name = _name;
    }
    public String getName (){
        return name;
    }
    
    public void setUserName (String _userName){
        this.userName = _userName;
    }
    public String getUserName (){
        return userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Range getIntelRange() {
        return intelRange;
    }

    public void setIntelRange(Range intelRange) {
        this.intelRange = intelRange;
    }

    public Range getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Range ageRange) {
        this.ageRange = ageRange;
    }

    public int getIntelLevel() {
        return intelLevel;
    }

    public void setIntelLevel(int intelLevel) {
        this.intelLevel = intelLevel;
    }

    public int getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(int sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }
}
