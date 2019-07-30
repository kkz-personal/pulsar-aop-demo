package com.example.mybatis.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kmz
 */
@Data
public class Class implements Serializable {
    private Integer id;

    private String className;

    private Integer stuCno;

    private Integer stuNum;

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

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
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
        sb.append(", stuNum=").append(stuNum);
        sb.append(", teacherCno=").append(teacherCno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}