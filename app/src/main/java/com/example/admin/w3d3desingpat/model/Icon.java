
package com.example.admin.w3d3desingpat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {

    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Width")
    @Expose
    private String width;

    /**
     * 
     * @return
     *     The uRL
     */
    public String getURL() {
        return uRL;
    }

    /**
     * 
     * @param uRL
     *     The URL
     */
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    /**
     * 
     * @return
     *     The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The Height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The Width
     */
    public void setWidth(String width) {
        this.width = width;
    }

}
