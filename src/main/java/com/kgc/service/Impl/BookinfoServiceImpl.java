package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Atuthor;
import com.kgc.entity.Bookinfo;
import com.kgc.entity.BookinfoExample;
import com.kgc.entity.Name;
import com.kgc.mapper.AtuthorMapper;
import com.kgc.mapper.BookinfoMapper;
import com.kgc.mapper.NameMapper;
import com.kgc.service.BookinfoService;
import com.kgc.utils.BookParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookinfoServiceImpl implements BookinfoService {
    @Autowired
    private BookinfoMapper bookinfoMapper;
    @Autowired
    private AtuthorMapper atuthorMapper;
    @Autowired
    private NameMapper nameMapper;
    @Override
    public PageInfo<Bookinfo> getBookPage(Integer pageIndex, Integer pageSize, BookParam bookParam) {
        BookinfoExample bookinfoExample=new BookinfoExample();
        BookinfoExample.Criteria criteria = bookinfoExample.createCriteria();
        if(bookParam!=null){
            if(bookParam.getBookname()!=null&&!bookParam.getBookname().equals( "" )){
                criteria.andBooknameLike( "%"+bookParam.getBookname()+"%" );
            }
            if(bookParam.getBooktype()!=null&&bookParam.getBooktype()!=-1){
                criteria.andBooktypeEqualTo( bookParam.getBooktype() );
            }
            if(bookParam.getIsborrow()!=null&&bookParam.getIsborrow()!=-1){
                criteria.andIsborrowEqualTo( bookParam.getIsborrow() );
            }
        }
        PageHelper.startPage( pageIndex,pageSize );
        List<Bookinfo> list = bookinfoMapper.selectByExample( bookinfoExample );
        if(list!=null&&list.size()>0){
            for(Bookinfo bookinfo:list){
                Integer bookatuthor = bookinfo.getBookatuthor();
                Integer booktype = bookinfo.getBooktype();
                Atuthor atuthor = atuthorMapper.selectByPrimaryKey( bookatuthor );
                Name name = nameMapper.selectByPrimaryKey( booktype );
                bookinfo.setAtuthor( atuthor );
                bookinfo.setName( name );
            }
        }
        PageInfo<Bookinfo> info=new PageInfo<>( list );
        return info;
    }

    @Override
    public boolean add(Bookinfo bookinfo) {
        return bookinfoMapper.insertSelective( bookinfo )>0?true:false;
    }

    @Override
    public boolean delete(Integer bookid) {
        return false;
    }

    @Override
    public boolean update(Bookinfo bookinfo) {
        return false;
    }

    @Override
    public Bookinfo getBookById(Integer bookid) {
        return null;
    }
}
