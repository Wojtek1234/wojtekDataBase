package controll;

import model.entity.AccountEntity;
import model.service.AccountService;
import model.service.WojtekService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class Master {

    public Master(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
        WojtekService wojtekService = (WojtekService)context.getBean( "wojtekServiceBean" );


        AccountService accountService=wojtekService.getAccountService();
        List<AccountEntity> list=accountService.getAll();

        for(AccountEntity l:list){
            System.out.println(l.getName());
        }

    }
}
