package demo;
import demo.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.messaging.handler.annotation.Payload;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class Application {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);
    }

    @StreamListener(Processor.INPUT)
    public void onEventByString(@Payload String productChanged){
        System.out.println(productChanged);
    }
}
