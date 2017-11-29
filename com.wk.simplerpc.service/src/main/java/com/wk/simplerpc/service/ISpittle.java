package com.wk.simplerpc.service;

import com.wk.simplerpc.entity.Spittle;

import java.util.List;

/**
 * PackageName com.wk.simplerpc.service
 * Created by wangkang on 2017/11/29.
 */
public interface ISpittle {
    List<Spittle> findSpittles(long max, int count) throws Exception;
}
