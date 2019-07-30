package com.example.pulsaraopdemo.mybatis.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class StuClass implements Serializable {
    private Integer id;

    private String className;

    private Integer stuCno;

    private Integer classCno;

    private Integer teacherCno;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getStuCno() {
        return stuCno;
    }

    public void setStuCno(Integer stuCno) {
        this.stuCno = stuCno;
    }

    public Integer getClassCno() {
        return classCno;
    }

    public void setClassCno(Integer classCno) {
        this.classCno = classCno;
    }

    public Integer getTeacherCno() {
        return teacherCno;
    }

    public void setTeacherCno(Integer teacherCno) {
        this.teacherCno = teacherCno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", className=").append(className);
        sb.append(", stuCno=").append(stuCno);
        sb.append(", classCno=").append(classCno);
        sb.append(", teacherCno=").append(teacherCno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}