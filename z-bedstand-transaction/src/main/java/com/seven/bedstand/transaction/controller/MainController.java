package com.seven.bedstand.transaction.controller;

import com.seven.bedstand.transaction.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/19 20:30
 **/
@RestController
public class MainController {
    @Autowired
    @Qualifier("userService")
    private MainService userService;

    @PutMapping("/transaction/no")
    public void noTransaction() {
        userService.noTransaction();
    }

    @PutMapping("/transaction/with")
    public void withTransaction() {
        userService.withTransaction();
    }

    @PutMapping("/transaction/excetion")
    public void byExcetion() throws Exception {
        userService.byExcetion();
    }

    @PutMapping("/transaction/callSelf")
    public void callSelf() {
        userService.callSelf();
    }

    @PutMapping("/transaction/required")
    public void propagationRequired() {
        userService.propagationRequired();
    }

    @PutMapping("/transaction/supports")
    public void propagationSupports() {
        userService.propagationSupports();
    }

    @PutMapping("/transaction/mandatory")
    public void propagationMandatory() {
        userService.propagationMandatory();
    }

    @PutMapping("/transaction/requiresnew")
    public void propagationRequiresNew() {
        userService.propagationRequiresNew();
    }

    @PutMapping("/transaction/notsupported")
    public void propagationNotSupported() {
        userService.propagationNotSupported();
    }

    @PutMapping("/transaction/never")
    public void propagationNever() {
        userService.propagationNever();
    }

    @PutMapping("/transaction/nested")
    public void propagationNested() {
        userService.propagationNested();
    }

}
