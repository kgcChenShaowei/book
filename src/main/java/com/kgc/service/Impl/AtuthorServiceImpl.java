package com.kgc.service.Impl;

import com.kgc.entity.Atuthor;
import com.kgc.mapper.AtuthorMapper;
import com.kgc.service.AtuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AtuthorServiceImpl implements AtuthorService {
    @Autowired
    private AtuthorMapper atuthorMapper;

    @Override
    public List<Atuthor> getAtuthorList() {
        return atuthorMapper.selectByExample( null );
    }
}
