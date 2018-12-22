package project2.test.cst.medical;

import java.io.Serializable;

/**
 * Created by user_1 on 17-12-2018.
 */

public class Mainbean implements Serializable {
    String id;
    String name;
    String father;
    String age;
    String stage;
    String evidence;
    String marks;
    String sign;
    String exname;
    String exsign;
    String designation;
    String regis;

    public Mainbean(String name, String father, String age, String stage, String evidence, String marks, String sign, String exname, String exsign, String designation, String regis) {
        this.name = name;
        this.father = father;
        this.age = age;
        this.stage = stage;
        this.evidence = evidence;
        this.marks = marks;
        this.sign = sign;
        this.exname = exname;
        this.exsign = exsign;
        this.designation = designation;
        this.regis = regis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getExname() {
        return exname;
    }

    public void setExname(String exname) {
        this.exname = exname;
    }

    public String getExsign() {
        return exsign;
    }

    public void setExsign(String exsign) {
        this.exsign = exsign;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRegis() {
        return regis;
    }

    public void setRegis(String regis) {
        this.regis = regis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
