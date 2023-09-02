package com.xiangliheart.modules.frame.core.frame.persistence.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xiangliheart.modules.frame.core.frame.persistence.pagehelper.PageRequest;

public interface CurdService<T> {

    int save(T record);

    int saveList(List<T> records);

    int delete(T record);

    int delete(List<T> records);

    int update(T record);

    T findById(Long id);

    PageInfo findPage(PageRequest pageRequest);
}
