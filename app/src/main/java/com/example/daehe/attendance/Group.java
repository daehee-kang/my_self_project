package com.example.daehe.attendance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daehee on 2018-02-09.
 */

public class Group {
    private String mName;
    private Cycle mCycle;
    private Date mStartDate;
    private List<Person> mPeople;

    public Group(String name, Cycle cycle, Date startDate, List<Person> people){
        mName = name;
        mCycle = cycle;
        mStartDate = startDate;
        mPeople = people;
    }

    public Group(String name){ this(name, Cycle.Daily, new Date(), new ArrayList<Person>()); }
    public Group(String name, Cycle cycle){ this(name, cycle, new Date(), new ArrayList<Person>());}
    public Group(String name, Cycle cycle, Date startDate){ this(name, cycle, startDate, new ArrayList<Person>());}

    public String getName(){    return mName;   }
    public Cycle getCycle(){    return mCycle;  }
    public Date getStartDate(){ return mStartDate;  }
    public List<Person> getListOfPeople(){  return mPeople; }

    public void setName(String name){   mName = name;   }
    public void setCycle(Cycle cycle){  mCycle = cycle; }
    public void setStartDate(Date startDate){   mStartDate = startDate; }
    public void setListOfPeople(List<Person> people){   mPeople = people;   }

    @Override
    public String toString(){
        return mName + "(" + mCycle.toString() + ", " + mPeople.size() + ")";
    }
}