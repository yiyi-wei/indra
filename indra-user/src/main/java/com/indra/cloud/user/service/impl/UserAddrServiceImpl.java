package com.indra.cloud.user.service.impl;

import com.indra.cloud.user.service.UserAddrService;
import org.springframework.stereotype.Service;

/**
 * TODO 地址相关
 * @Author lth
 * @Date 2021/7/1 17:38
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Override
    public void deleteUserAddrByUserId(Long addrId, Long userId) {

    }

    @Override
    public int countByUserId(Long userId) {
        return 0;
    }

    @Override
    public void removeUserDefaultAddrCacheByUserId(Long userId) {

    }
}
