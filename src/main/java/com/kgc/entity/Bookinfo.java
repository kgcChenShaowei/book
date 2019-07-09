package com.kgc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bookinfo {
    private Integer bookid;

    private String bookcode;

    private String bookname;

    private Integer booktype;

    private Integer bookatuthor;

    private String publishpress;

    private Date publishdate;

    private Integer isborrow;

    private String createdby;

    private Date creationtime;

    private Date lastupdatetime;

    private Atuthor atuthor;

    private Name name;

    public Atuthor getAtuthor() {
        return atuthor;
    }

    public void setAtuthor(Atuthor atuthor) {
        this.atuthor = atuthor;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookcode() {
        return bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode == null ? null : bookcode.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBooktype() {
        return booktype;
    }

    public void setBooktype(Integer booktype) {
        this.booktype = booktype;
    }

    public Integer getBookatuthor() {
        return bookatuthor;
    }

    public void setBookatuthor(Integer bookatuthor) {
        this.bookatuthor = bookatuthor;
    }

    public String getPublishpress() {
        return publishpress;
    }

    public void setPublishpress(String publishpress) {
        this.publishpress = publishpress == null ? null : publishpress.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getIsborrow() {
        return isborrow;
    }

    public void setIsborrow(Integer isborrow) {
        this.isborrow = isborrow;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    public Date getCreationtime() {
        return creationtime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}