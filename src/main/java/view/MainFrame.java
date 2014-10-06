package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class MainFrame extends JFrame
{
	private final JButton logButton,createAccoutnButton,showByCategoryButton,showByAccountButton,showAllOffers,
			showNextButton,showPrevButton,
			addOfferButton;
	public AccountJLabel accountJLabel;
	private final JTable tableOfOffers;

	public MainFrame(){



		this.logButton=new JButton( "Log in" );
		this.createAccoutnButton =new JButton("Create Account");
		this.showByCategoryButton=new JButton( "Show By Category" );
		this.showByAccountButton=new JButton( "Show By Account" );
		this.showAllOffers=new JButton("Show All Offers");
		this.showNextButton=new JButton(">>");
		this.showPrevButton=new JButton("<<");
		this.addOfferButton=new JButton( "Add Offer" );
		this.tableOfOffers=new JTable();
		this.accountJLabel=new AccountJLabel("Not logged", addOfferButton);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent( createLeftPanel() );
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane2.setLeftComponent( tableOfOffers );
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
		panel.add(logButton);
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
		this.addActionListenerToButton( al,logButton);
	}
	public void addALToCreateAccountBut(ActionListener al){
		this.addActionListenerToButton( al,logButton);
	}
	public void addALToViewByCategory(ActionListener al){this.addActionListenerToButton( al,showByCategoryButton);}
	public void addALToViewByAccount(ActionListener al){this.addActionListenerToButton( al,showByAccountButton);};
	public void addALToShowAll(ActionListener al){this.addActionListenerToButton( al,showAllOffers);};
	public void addALToAddOffer(ActionListener al){this.addActionListenerToButton( al,addOfferButton );}
	public void addALToShowNext(ActionListener al){this.addActionListenerToButton( al,showNextButton );}
	public void addALToShowPrev(ActionListener al){this.addActionListenerToButton( al,showPrevButton );}


	private void addActionListenerToButton(ActionListener al,JButton jbut){
		jbut.addActionListener( al );
	}

	public Observer getObserverComponent(){
		return this.accountJLabel;
	}
}
