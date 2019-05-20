/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author cestdrama
 */
public class MedRecord {
    private int medid;
    private Integer docid;
    private String description;
    private String treatment;
    private User user;

    public MedRecord() {
    }

    public MedRecord(String descriptoin, String treatment, User user) {
        this.description = descriptoin;
        this.treatment = treatment;
        this.user = user;
    }  

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

   
   
    
    

    public int getMedid() {
        return medid;
    }

    public void setMedid(int medid) {
        this.medid = medid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }   

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
