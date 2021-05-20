package com.rookie.rabbit.modular.controller;

import com.rookie.rabbit.modular.config.MqSendMessage;
import com.rookie.rabbit.modular.entity.EmailQueueMessage;
import com.rookie.rabbit.modular.entity.NoticeQueueMessage;
import com.rookie.rabbit.modular.entity.SysPushQueueMessage;
import com.rookie.rabbit.modular.entity.UserQueueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MqSendMessage mqSendMessage;

    @RequestMapping("test1")
    public void test1(){
        mqSendMessage.sendMsg(new EmailQueueMessage().setMessage("hahaha"));
    }

    @RequestMapping("test2")
    public void test2(){
        mqSendMessage.sendMsg(new UserQueueMessage().setMessage("你好啊"));
    }

    @RequestMapping("test3")
    public void test3(){
        mqSendMessage.sendMsg(new NoticeQueueMessage().setMessage("再见"));
    }

    @RequestMapping("test4")
    public void test4(){
        mqSendMessage.sendMsg(new SysPushQueueMessage().setMessage("说再见"));
    }
}
