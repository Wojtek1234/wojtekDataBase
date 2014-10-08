package view;

import view.offerpanels.OfferPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class MainFrame extends JFrame
{
	private final JButton createAccoutnButton,showByCategoryButton,showByAccountButton,showAllOffers,
			showNextButton,showPrevButton,
			addOfferButton;
	private final ListSelectionModel cellSelectionModel;
	private LogingButton logingButton;
	public AccountJLabel accountJLabel;
	private  TableOfOffers tableOfOffers;
	private ArrayList<Observer> accountObserverArrayList;
	private OfferPanel offerPanel;

	public MainFrame(){



		this.logingButton=new LogingButton( "Log in" );
		this.createAccoutnButton =new JButton("Create Account");
		this.showByCategoryButton=new JButton( "Show By Category" );
		this.showByAccountButton=new JButton( "Show By Account" );
		this.showAllOffers=new JButton("Show All Offers");
		this.showNextButton=new JButton(">>");
		this.showPrevButton=new JButton("<<");
		this.addOfferButton=new JButton( "Add Offer" );
		this.tableOfOffers=new TableOfOffers();
		this.accountJLabel=new AccountJLabel("Not logged", addOfferButton);
		accountObserverArrayList=new ArrayList<>(  );
		accountObserverArrayList.add( logingButton );
		accountObserverArrayList.add( accountJLabel );
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent( createLeftPanel() );
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane2.setLeftComponent(new JScrollPane(tableOfOffers  ) );
		cellSelectionModel = tableOfOffers.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.offerPanel=new OfferPanel(  );
		splitPane2.setRightComponent( offerPanel );
		splitPane.setRightComponent( splitPane2 );

		this.add( splitPane );
		this.setSize( 1000,500 );
		this.setVisible( true );

	}

	private JPanel createLeftPanel()
	{
		GridLayout gl=new GridLayout( 5,0 );
		gl.setVgap( 15 );
		gl.setHgap( 15 );
		JPanel lewyPanel=new JPanel( gl );
		addButtons( lewyPanel );
		return lewyPanel;
	}

	private void addButtons( JPanel lewyPanel )
	{
		JPanel panel=new JPanel(new GridLayout(0,3  ));
		panel.add(logingButton);
		panel.add(accountJLabel);
		panel.add(createAccoutnButton);
		lewyPanel.add( panel );
		lewyPanel.add( showByCategoryButton );
		lewyPanel.add( showByAccountButton );
		lewyPanel.add( showAllOffers );
		addOfferButton.setEnabled( false );
		lewyPanel.add( addOfferButton ) ;
	}

	public void addALToLogButton(ActionListener al){
		this.addActionListenerToButton( al,logingButton);
	}
	public void addALToCreateAccountBut(ActionListener al){
		this.addActionListenerToButton( al,logingButton);
	}
	public void addALToViewByCategory(ActionListener al){this.addActionListenerToButton( al,showByCategoryButton);}
	public void addALToViewByAccount(ActionListener al){this.addActionListenerToButton( al,showByAccountButton);};
	public void addALToShowAll(ActionListener al){this.addActionListenerToButton( al,showAllOffers);};
	public void addALToAddOffer(ActionListener al){this.addActionListenerToButton( al,addOfferButton );}
	public void addALToShowNext(ActionListener al){this.addActionListenerToButton( al,showNextButton );}
	public void addALToShowPrev(ActionListener al){this.addActionListenerToButton( al,showPrevButton );}
	public void setListSelectionListener(ListSelectionListener lsl){
		cellSelectionModel.addListSelectionListener( lsl );
	}

	private void addActionListenerToButton(ActionListener al,JButton jbut){
		jbut.addActionListener( al );
	}

	public ArrayList<Observer> getObserverComponent(){
		return accountObserverArrayList;
	}

	public Observer getTableObserver(){
		return this.tableOfOffers;
	}
	public Observer getOfferModelObserver(){
		return this.offerPanel;
	}
	public void setOfferPanel( OfferPanel offerPanel )
	{
		this.offerPanel = offerPanel;
		this.revalidate();
	}
}
