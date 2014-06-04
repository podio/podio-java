/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.podio.notification;

/**
 *
 * @author MrBr
 */
public class NotificationRef {
    private int id;
    private String type;
    public void setValue(int id){
        this.id=id;
    }
    public int getValue(){
        return this.id;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
    public String getInfoValue(){
        if("status".equals(type)){
            return "Liked";
        }else{
            return "UNKNOW TYPE";
        }
    }
}
