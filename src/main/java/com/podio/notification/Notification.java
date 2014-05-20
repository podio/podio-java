/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.podio.notification;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Direktor
 */
public class Notification {
    private List<NotificationMini> nots;
    private NotificationContext context;
    @JsonProperty("notifications")
    public List<NotificationMini> getNotifications(){
        return this.nots;
    }
    public NotificationContext getContext(){
        return this.context;
    }
    public void setContext(NotificationContext context){
        this.context=context;
    }

    @JsonProperty("notifications")
    public void setNotifications(List<NotificationMini> nots){
        this.nots=nots;
    }
}
