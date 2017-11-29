package com.wk.simplerpc.impl;

import com.wk.simplerpc.entity.Spittle;
import com.wk.simplerpc.service.ISpittle;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PackageName com.wk.simplerpc.impl
 * Created by wangkang on 2017/11/29.
 */
public class SpittleRepository implements ISpittle {
    public List<Spittle> findSpittles(long max, int count) throws Exception {
        List<Spittle> spittles = new ArrayList<Spittle>();
        if (max - count < 0 ){
            throw new Exception("max must > count!");
        }
        long id = max - count;
        while (id < max){
            Spittle ss = new Spittle(id++,new Date(),"wk");
            spittles.add(ss);
        }
        return spittles;
    }
}
