package controll;

import controll.ActionListeners.AddOfferAL;
import controll.ActionListeners.LogButtAL;
import controll.ActionListeners.ShowByCategoryAL;
import controll.tableListener.TableSelectionListener;
import model.Accounts.AccountCheck;
import model.Accounts.CurrentAccount;
import model.service.MainServiceBean;
import model.views_model.OfferViewModel;
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
	private AddOfferAL addOfferAL;
	private OfferViewModel offerViewModel;
	private TableSelectionListener selectionListener;

	public Master(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
		ServicesControll servicesControll=new ServicesControll(context);
		mainServiceBean = (MainServiceBean)context.getBean( "mainServiceBean" );

		gui = new MainFrame();
		for( Observer observer:gui.getObserverComponent()){
			currentAccount.addObserver(observer);
		}

		this.tableViewModel =new TableViewModel(gui);

		this.tableViewModel.addObserver( gui.getTableObserver() );

		this.offerViewModel =new OfferViewModel();
		selectionListener = new TableSelectionListener(offerViewModel);
		this.tableViewModel.addObserver( this.selectionListener );
		this.offerViewModel.addObserver( gui.getOfferModelObserver() );
		this.gui.setListSelectionListener( this.selectionListener );

		logButtAL=new LogButtAL( gui,new AccountCheck(mainServiceBean.getAccountService().getAll()) );
		gui.addALToLogButton( logButtAL );


		showByCategoryAL=new ShowByCategoryAL(gui,servicesControll,tableViewModel);
		gui.addALToViewByCategory(  showByCategoryAL);

		addOfferAL=new AddOfferAL( gui,servicesControll );
		gui.addALToAddOffer( addOfferAL );

	}
}
