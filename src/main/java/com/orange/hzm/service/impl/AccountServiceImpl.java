package com.orange.hzm.service.impl;
import com.orange.hzm.mapper.AccountMapper;
import com.orange.hzm.pojo.dto.AccountInfo;
import com.orange.hzm.pojo.entity.Account;
import com.orange.hzm.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author orange
 * @since 2023-09-30
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public AccountInfo getAccountByName(String userName) {
        Map<String,Object> params = new HashMap<>();
        params.put("account_name",userName);
        List<Account> accountList = accountMapper.selectByMap(params);
        if (accountList != null && accountList.size() != 0){
            AccountInfo accountInfo = new AccountInfo();
            Account account = accountList.get(0);
            accountInfo.setId(account.getId());
            accountInfo.setAccountName(account.getAccountName());
            accountInfo.setRoleIds(account.getRoleIds());
            return accountInfo;
        }
        return null;
    }

    @Override
    public Account getAccountById(Integer id) {

        return accountMapper.selectById(id);
    }
}
