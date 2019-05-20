/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.pojo;

import java.util.*;

/**
 *
 * @author cestdrama
 */
public class Quiz {
    String num;
    String question;
    String ans;
    List<String> optionlist;
//    List<String> anslist1;
//    List<String> anslist2;
    Map<String,String> ansmap;
    public Quiz() {
    }
    
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public List<String> getOptionlist() {
        return optionlist;
    }

    public void setOptionlist(List<String> optionlist) {
        this.optionlist = optionlist;
    }

    public Map<String, String> getAnsmap() {
        return ansmap;
    }

    public void setAnsmap(Map<String, String> ansmap) {
        this.ansmap = ansmap;
    }

    
    
    
     
}
