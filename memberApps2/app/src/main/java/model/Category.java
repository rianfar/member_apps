package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("term_id")
    @Expose
    private String term_Id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getTerm_Id() {
        return term_Id;
    }

    public void setTermId(String term_Id) {
        this.term_Id = term_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
