package com.seven.bedstand.transaction.service;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/19 20:31
 **/
public interface MainService {

    void noTransaction();
    void withTransaction();

    void byExcetion() throws Exception;

    void callSelf();

    void disappearedException();


    void propagationRequired();
    void propagationSupports();
    void propagationMandatory();
    void propagationRequiresNew();
    void propagationNotSupported();
    void propagationNever();
    void propagationNested();
}
