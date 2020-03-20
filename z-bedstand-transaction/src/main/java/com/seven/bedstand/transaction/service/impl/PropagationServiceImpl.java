package com.seven.bedstand.transaction.service.impl;

import com.seven.bedstand.transaction.dal.dataobject.User;
import com.seven.bedstand.transaction.dal.mapper.UserMapper;
import com.seven.bedstand.transaction.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/20 11:09
 **/
@Service("propagationServiceDev")
public class PropagationServiceImpl implements PropagationService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void propagationSupports() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        // 此方法一定抛出一个运行时异常
        throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void propagationMandatory() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        // 此方法一定抛出一个运行时异常
        throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        // 此方法一定抛出一个运行时异常
        // throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        // 此方法一定抛出一个运行时异常
        throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    @Override
    public void propagationNever() {
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void propagationNested() {

        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(105);
        userMapper.updateById(lisi);

        // 此方法一定抛出一个运行时异常
        // throwRuntimeException();

        User wangwu = new User();
        wangwu.setId(3);
        wangwu.setAccount(105);
        userMapper.updateById(wangwu);
    }

    private void throwRuntimeException() {
        throw new RuntimeException("手动RuntionExcetion异常");
    }
}
