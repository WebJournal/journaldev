package com.journaldev.androidrealmdatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;


public class Skill extends RealmObject {

    public static final String PROPERTY_SKILL = "skillName";

    @PrimaryKey
    @Required
    public String skillName;
}
