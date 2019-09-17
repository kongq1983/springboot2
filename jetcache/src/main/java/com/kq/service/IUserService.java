package com.kq.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.kq.dto.User;

public interface IUserService {

//    public static final String CACHE_NAME = "IUserService.getUserById";
    public static final String CACHE_NAME = "user";

//    @Cached(name=CACHE_NAME, expire = 3600,cacheType = CacheType.LOCAL)
//    @Cached(name=CACHE_NAME, key = "#userId", expire = 3600,cacheType = CacheType.LOCAL)
    @Cached(name=CACHE_NAME, key = "#userId", expire = 3600,cacheType = CacheType.BOTH)
    User getUserById(Long userId);

    @CacheUpdate(name = CACHE_NAME, key = "#u.id", value = "result", condition = "#u.id!=null")
    public void update(User u);


    @CacheInvalidate(name = CACHE_NAME, key = "#userId")
    public void delete(Long userId);

}
