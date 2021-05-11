package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PortotypeBean.class);
        System.out.println("find prototypeBean1");
        PortotypeBean portotypeBean1 = ac.getBean(PortotypeBean.class);

        System.out.println("find prototypeBean2");
        PortotypeBean portotypeBean2 = ac.getBean(PortotypeBean.class);

        System.out.println("portotypeBean1 = " + portotypeBean1);
        System.out.println("portotypeBean2 = " + portotypeBean2);

        assertThat(portotypeBean1).isNotSameAs(portotypeBean2);

        ac.close();
    }
    @Scope("prototype")
    static class PortotypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PortotypeBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("PortotypeBean.destroy");
        }
    }
}
