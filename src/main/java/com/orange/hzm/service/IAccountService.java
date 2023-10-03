package com.orange.hzm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.hzm.pojo.dto.AccountInfo;
import com.orange.hzm.pojo.entity.Account;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author orange
 * @since 2023-09-30
 */
public interface IAccountService extends IService<Account> {
    /**
     * @param userName
     * @author orange
     * @date 2023/09/30
     * @apiNote 根据名称获取用户对象
     * @todo
     **/
    AccountInfo getAccountByName(String userName);

    /**
     * @param id
     * @author orange
     * @date 2023/09/30
     * @apiNote 根据Id获取用户对象
     * @todo
     **/
    Account getAccountById(Integer id);
}
