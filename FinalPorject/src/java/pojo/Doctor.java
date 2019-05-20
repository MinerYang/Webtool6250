/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.*;

/**
 *
 * @author cestdrama
 */
public class Doctor {
    private int docid;
    private String docname;
    private String pwd;
    private Set<MedRecord> dset=new HashSet();

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Set<MedRecord> getDset() {
        return dset;
    }

    public void setDset(Set<MedRecord> dset) {
        this.dset = dset;
    }

    
}
