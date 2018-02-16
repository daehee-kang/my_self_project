package com.example.daehe.attendance;

/**
 * Created by Daehee on 2018-02-09.
 */

public class Person {
    private String mLastName;
    private String mFirstName;
    private String mPhone;
    private int mAge;
    private String mAddress;

    public Person(String lastName, String firstName, String phone, int age, String address){
        mLastName = lastName;
        mFirstName = firstName;
        mPhone = phone;
        mAge = age;
        mAddress = address;
    }

    public Person(String lastName, String firstName, String phone){  this(lastName, firstName, phone, 0, ""); }

    public String getFirstName(){   return mFirstName;  }
    public String getLastName(){    return mLastName;   }
    public String getFullName(){    return mFirstName + " " + mLastName;    }
    public int getAge(){    return mAge;    }
    public String getPhone(){   return mPhone;  }
    public String getAddress(){ return mAddress;    }

    public void setFirstName(String firstName){ mFirstName = firstName; }
    public void setLastName(String lastName){   mLastName = lastName;  }
    public void setFullName(String firstName, String lastName){ mFirstName = firstName; mLastName = lastName;   }
    public void setAge(int age){    mAge = age; }
    public void setPhone(String phone){ mPhone = phone; }
    public void setAddress(String address){ mAddress = address; }

    @Override
    public String toString(){
        return mFirstName + " " + mLastName + " (" + mAge + ")";
    }
}
