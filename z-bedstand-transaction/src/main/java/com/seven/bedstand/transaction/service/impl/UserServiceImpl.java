package com.seven.bedstand.transaction.service.impl;

import com.seven.bedstand.transaction.dal.dataobject.User;
import com.seven.bedstand.transaction.dal.mapper.UserMapper;
import com.seven.bedstand.transaction.service.MainService;
import com.seven.bedstand.transaction.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/19 20:34
 **/
@Service("userService")
public class UserServiceImpl implements MainService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    @Qualifier("propagationServiceDev")
    private PropagationService propagationServiceDev;

    @Override
    // @Transactional 不做事务
    public void noTransaction() {
        // user表中初始化了两条数据分别是张三100块 李四100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        // 该方法将一定抛出一个异常
        throwRuntimeException();

        // 2. 李四账户增加10块，金额变更为110
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);


        // 结果：张三90  李四100
    }

    private void throwRuntimeException() {
        throw new RuntimeException("手动RuntionExcetion异常");
    }

    @Override
    @Transactional
    public void withTransaction() {
        // user表中初始化了两条数据分别是张三100块 李四100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        // 该方法将一定抛出一个运行时异常
        throwRuntimeException();

        // 2. 李四账户增加10块，金额变更为110
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);
        // 结果：张三100  李四100
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void byExcetion() throws Exception {
        // user表中初始化了两条数据分别是张三100块 李四100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        // 该方法将一定抛出一个Exception异常
        throwException();

        // 2. 李四账户增加10块，金额变更为110
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);
        // 结果：张三100  李四100
    }

    private void throwException() throws Exception {
        throw new Exception("手动Exception异常");
    }

    @Override
    public void callSelf() {
        userService.updateUser();
    }

    @Transactional
    public void updateUser() {
        // user表中初始化了两条数据分别是张三100块 李四100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        // 该方法将一定抛出一个Exception异常
        throwRuntimeException();

        // 2. 李四账户增加10块，金额变更为110
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);
        // 结果：张三100  李四100
    }

    @Override
    @Transactional
    public void disappearedException() {
        // user表中初始化了两条数据分别是张三100块 李四100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        try {
            // 该方法将一定抛出一个Exception异常
            throwRuntimeException();
        } catch (RuntimeException ex) {
            // do something
        }

        // 2. 李四账户增加10块，金额变更为110
        User lisi = new User();
        lisi.setId(2);
        lisi.setAccount(110);
        userMapper.updateById(lisi);
        // 结果：张三100  李四100  注意，这里虽然张三和李四的账户对上了，但是在抛出异常的地方，我们是不知道张三是不是还给其他人转账的。因此不能因为这里是正确的就以为捕捉异常对事务没有影响
    }

    @Override
    // @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationRequired();
    }

    @Override
    public void propagationSupports() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationSupports();
    }

    @Override
    public void propagationMandatory() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(90);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationMandatory();
    }

    @Override
    @Transactional
    public void propagationRequiresNew() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(80);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationRequiresNew();

        // 该方法一定抛出一个运行时异常
        throwRuntimeException();

        User zhaoliu = new User();
        zhaoliu.setId(4);
        zhaoliu.setAccount(110);
        userMapper.updateById(zhaoliu);
    }

    @Override
    @Transactional
    public void propagationNotSupported() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(80);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationNotSupported();

        User zhaoliu = new User();
        zhaoliu.setId(4);
        zhaoliu.setAccount(110);
        userMapper.updateById(zhaoliu);
    }

    @Override
    public void propagationNever() {
        // do something
    }

    @Override
    @Transactional
    public void propagationNested() {
        // user表中初始化了两条数据分别是张三100块 李四100块 王五100块
        // 1. 张三账户减去10块，金额变更为90
        User zhangsan = new User();
        zhangsan.setId(1);
        zhangsan.setAccount(80);
        userMapper.updateById(zhangsan);

        propagationServiceDev.propagationNested();

        User zhaoliu = new User();
        zhaoliu.setId(4);
        zhaoliu.setAccount(110);
        userMapper.updateById(zhaoliu);
    }
}
