package view;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class CategoryDialogChooser extends JDialog
{
	private final JComboBox<String> jComboBox;
	private final JButton btnOk,btnCancel;
	private JLabel categoryName;
	private String categoryString;
	private Boolean doProceed=false;

	public CategoryDialogChooser(JFrame parent,String[] listOfCategory){

		super(parent);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		categoryName = new JLabel("Category Name: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(categoryName, cs);

		jComboBox= new  JComboBox<String>(listOfCategory);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add( jComboBox, cs);
		jComboBox.setEditable( true );
		@SuppressWarnings( "rawtypes" )
		AutoCompleteSupport support = AutoCompleteSupport.install(jComboBox,
				GlazedLists.eventListOf( listOfCategory	));
		support.setStrict(true);


		jComboBox.addActionListener(  new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				categoryString= (String)jComboBox.getSelectedItem();

			}
		} );

		JPanel bp = new JPanel();
		btnOk=new JButton("Ok");
		btnOk.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{	if(categoryString==null){
				JOptionPane.showMessageDialog( CategoryDialogChooser.this,
						"You didnt choose Category",
						"Info",
						JOptionPane.INFORMATION_MESSAGE );
				}else
				{
					JOptionPane.showMessageDialog( CategoryDialogChooser.this,
							"You choose " + categoryString + " Category",
							"Info",
							JOptionPane.INFORMATION_MESSAGE );
					doProceed=true;
					dispose();
				}
			}
		} );


		btnCancel=new JButton("Cancel");
		btnCancel.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				dispose();
			}
		} );
		bp.add(btnOk);
		bp.add(btnCancel);


		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);


		pack();
		setResizable(false);
		setLocationRelativeTo(parent);

	}

	public String getCategoryString()
	{
		return categoryString;
	}
	public boolean doProceed(){return this.doProceed;}
}
