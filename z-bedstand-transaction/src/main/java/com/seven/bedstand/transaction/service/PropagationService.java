package com.seven.bedstand.transaction.service;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/20 11:09
 **/
public interface PropagationService {
    void propagationRequired();

    void propagationSupports();

    void propagationMandatory();

    void propagationRequiresNew();

    void propagationNotSupported();

    void propagationNever();

    void propagationNested();
}
