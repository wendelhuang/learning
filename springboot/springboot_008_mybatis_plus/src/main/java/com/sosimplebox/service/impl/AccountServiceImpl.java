package com.sosimplebox.service.impl;

import com.sosimplebox.model.auto.Account;
import com.sosimplebox.mapper.auto.AccountMapper;
import com.sosimplebox.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangww
 * @since 2020-08-21
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
