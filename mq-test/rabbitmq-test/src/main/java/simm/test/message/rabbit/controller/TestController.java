package simm.test.message.rabbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import simm.test.message.rabbit.channels.InstallCallbackOutputChannel;

import javax.annotation.Resource;

/**
 * 测试
 * @author miscr
 */
@RestController
@Slf4j
public class TestController {
    @Resource
    @Output(InstallCallbackOutputChannel.OUTPUT)
    private MessageChannel messageChannel;

    @GetMapping("/send")
    public void sendMessage() throws Exception {
        log.info("启动日志系统");
        messageChannel.send(MessageBuilder.withPayload("服务已经启动，准备安装消息").build());
    }
}
