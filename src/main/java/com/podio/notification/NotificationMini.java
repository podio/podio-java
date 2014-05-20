/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.podio.notification;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author MrBr
 */
public class NotificationMini {
    private int id;//notification_id
    private String textShort;
    private String text;
    private NotificationData data;
    private String viewedOn;
    private Boolean starred;
    @JsonProperty("notification_id")
    public int getId(){
        return this.id;
    }
    @JsonProperty("viewed_on")
    public String getViewedOn(){
        return this.viewedOn;
    }
    public Boolean getStarred(){
        return this.starred;
    }

    public String getText(){
        return this.text;
    }
    public String getNotificationShortText(){
        return textShort;
    }
    @JsonProperty("notification_id")
    public void setId(int id){
        this.id=id;
    }
    @JsonProperty("viewed_on")
    public void setViewedOn(String viewedOn){
        this.viewedOn=viewedOn;
    }
    public void setStarred(Boolean starred){
        this.starred=starred;
    }

    public void setText(String text){
        this.text=text;
    }
    @JsonProperty("text_short")
    public void setNotificationShortText(String TextShort){
        textShort=TextShort;
    }
    public NotificationData getData(){
        return this.data;
    }
    public void setData(NotificationData data){
        this.data=data;
    }
}
