package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Bookinfo;
import com.kgc.utils.BookParam;

public interface BookinfoService {
    public PageInfo<Bookinfo> getBookPage(Integer pageIndex, Integer pageSize, BookParam bookParam);
    public boolean add(Bookinfo bookinfo);
    public boolean delete(Integer bookid);
    public boolean update(Bookinfo bookinfo);
    public Bookinfo getBookById(Integer bookid);
}
