/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.podio.notification;

import com.podio.status.StatusQuestion;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author MrBr
 */
public class NotificationData {
    private String value;
    private String text;
    private String type;
    private StatusQuestion questionOption;
    public void setValue(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return this.text;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
    @JsonProperty("question_option")
    public void setQuestionOption(StatusQuestion questionOption){
        this.questionOption=questionOption;
    }
    @JsonProperty("question_option")
    public StatusQuestion getQuestionOption(){
        return this.questionOption;
    }
    public String getInfoText(){
        if("like".equals(type)){
            return "Liked";
        }else if(value!=null){
            return value;
        }else if(text!=null){
            return text;
        }else if(questionOption!=null){
           return questionOption.getText();
        }else{
            return "";
        }
    }
}
