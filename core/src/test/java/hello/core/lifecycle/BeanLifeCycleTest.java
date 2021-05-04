package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }
    @Configuration
    static class LifeCycleConfig{
        // destroyMethod의 defalut는 (inferred)로 close나 shotdown의 이름의 Method를 추론 가능
        // 수정할 수 없는 외부 라이브러리에 적용할 떄 사용
        //@Bean(initMethod = "init", destroyMethod = "close")
        //@Bean(initMethod = "init")
        @Bean
        public NetworkClient networkClient(){
            NetworkClient  networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.dev");
            return networkClient;
        }



    }
}
