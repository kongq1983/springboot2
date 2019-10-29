package com.kq.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.kq.dto.User;

public interface IEmployeeService {

    public static final String CACHE_NAME = "employee:";

    /**
     * 默认key: employee:[2]
     * @param userId
     * @return
     */
    @Cached(name=CACHE_NAME, expire = 3600,cacheType = CacheType.BOTH)
    User getUserById(Long userId);


    /**
     * 默认key:    employee:[2,\"king\",1]
     * @param userId
     * @param name
     * @param type
     * @return
     */
    @Cached(name=CACHE_NAME, expire = 3600,cacheType = CacheType.BOTH)
    User getUserBySearch(Long userId,String name,int type);

    @CacheUpdate(name = CACHE_NAME, key = "#u.id", value = "result", condition = "#u.id!=null")
    public void update(User u);


    @CacheInvalidate(name = CACHE_NAME, key = "#userId")
    public void delete(Long userId);

}
