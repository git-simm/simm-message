package simm.test.message.rabbit.bindings;

import org.springframework.cloud.stream.annotation.EnableBinding;
import simm.test.message.rabbit.channels.InstallCallbackOutputChannel;

/**
 * 生产消息
 * @author miscr
 */
@EnableBinding(InstallCallbackOutputChannel.class)
public class InstallCallbackSender {
//    @Bean
//    @InboundChannelAdapter(value = InstallCallbackOutputChannel.OUTPUT,poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<Date> timerMessagaSource(){
//        return ()->new GenericMessage<>(new Date());
//    }
}
