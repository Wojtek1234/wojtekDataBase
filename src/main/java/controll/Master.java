package controll;

import controll.ActionListeners.LogButtAL;
import controll.ActionListeners.ShowByCategoryAL;
import model.Accounts.AccountCheck;
import model.Accounts.CurrentAccount;
import model.service.MainServiceBean;
import model.views_model.TableViewModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.MainFrame;

import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class Master {

	private final MainServiceBean mainServiceBean;
	private final MainFrame gui;
	private final CurrentAccount currentAccount=CurrentAccount.getInstance();
	private TableViewModel tableViewModel;
	private LogButtAL logButtAL;
	private ShowByCategoryAL showByCategoryAL;

	public Master(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
		ServicesControll servicesControll=new ServicesControll(context);
		mainServiceBean = (MainServiceBean)context.getBean( "mainServiceBean" );

		gui = new MainFrame();
		for( Observer observer:gui.getObserverComponent()){
			currentAccount.addObserver(observer);
		}

		tableViewModel=new TableViewModel();
		tableViewModel.addObserver( gui.getTableObserver() );


		logButtAL=new LogButtAL( gui,new AccountCheck(mainServiceBean.getAccountService().getAll()) );
		gui.addALToLogButton( logButtAL );


		showByCategoryAL=new ShowByCategoryAL(gui,servicesControll,tableViewModel);
		gui.addALToViewByCategory(  showByCategoryAL);

	}
}
