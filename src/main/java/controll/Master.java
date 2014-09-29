package controll;

import model.service.WojtekService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class Master {

    public Master(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
        WojtekService wojtekService = (WojtekService)context.getBean( "wojtekServiceBean" );
    }
}
