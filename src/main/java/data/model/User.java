package data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private Name name;

    public User(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
