
package com.example.admin.w3d3desingpat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maintainer {

    @SerializedName("github")
    @Expose
    private String github;

    /**
     * 
     * @return
     *     The github
     */
    public String getGithub() {
        return github;
    }

    /**
     * 
     * @param github
     *     The github
     */
    public void setGithub(String github) {
        this.github = github;
    }


}
