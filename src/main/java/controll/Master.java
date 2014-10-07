package controll;

import model.Accounts.AccountCheck;
import model.Accounts.CurrentAccount;
import model.service.MainServiceBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import view.MainFrame;
import controll.ActionListeners.LogButtAL;

import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class Master {

	private final MainServiceBean mainServiceBean;
	private final MainFrame gui;
	private final CurrentAccount currentAccount=CurrentAccount.getInstance();

	public Master(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
		ServicesControll servicesControll=new ServicesControll(context);
		mainServiceBean = (MainServiceBean)context.getBean( "mainServiceBean" );

		gui = new MainFrame();
		for( Observer observer:gui.getObserverComponent()){
			currentAccount.addObserver(observer);
		}

		gui.addALToLogButton( new LogButtAL( gui,new AccountCheck(mainServiceBean.getAccountService().getAll()) ) );


	}
}
