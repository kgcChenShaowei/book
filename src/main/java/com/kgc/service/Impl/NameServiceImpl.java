package com.kgc.service.Impl;

import com.kgc.entity.Name;
import com.kgc.mapper.NameMapper;
import com.kgc.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NameServiceImpl implements NameService {
    @Autowired
    private NameMapper nameMapper;
    @Override
    public List<Name> getNameLisr() {
        return nameMapper.selectByExample( null );
    }
}
