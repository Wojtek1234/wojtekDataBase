package view;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import model.OfferCreateModel.FindImageFile;
import model.OfferCreateModel.OfferTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
@SuppressWarnings( "ALL" ) public class AddOfferDialog extends JDialog
{



	private final JButton btnOk,btnCancel,createNewCategory,addImage;
	private JLabel categoryName,offerName,offerFirstPrice,offerDate,imageName;
	protected JComboBox<String> jComboBox;
	private JTextField  offertTF,offertPriceTF,offerDateTF;
	private String[] listOfCategory;
	protected AutoCompleteSupport support;
	private BufferedImage bufferedImage=null;
	private OfferTemplate offerTemplate;
	private boolean succes=false;

	public AddOfferDialog(JFrame parent, final String[] listOfCategory){
		super(parent);
		this.listOfCategory=listOfCategory;
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		offerName = new JLabel("Offer Name: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(offerName, cs);

		offertTF= new JTextField(  );
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(offertTF, cs);

		categoryName = new JLabel("Category Name: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(categoryName, cs);


		jComboBox= new  JComboBox<String>(listOfCategory);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add( jComboBox, cs);

		jComboBox.setEditable( true );
		autoCompleteCombo( listOfCategory );

		offerDate = new JLabel("Expires Date: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(offerDate, cs);

		offerDateTF= new JTextField(  );
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(offerDateTF, cs);



		offerFirstPrice = new JLabel("Offer Start Price: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		panel.add(offerFirstPrice, cs);

		offertPriceTF= new JTextField(  );
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		panel.add(offertPriceTF, cs);

		addImage=new JButton("Add image");
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 1;
		panel.add(addImage, cs);
		addImage.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				FindImageFile findImageFile= new FindImageFile( AddOfferDialog.this );
				try
				{
					bufferedImage =findImageFile.findImageFile();

					JLabel picLabel = new JLabel(new ImageIcon(bufferedImage));
					JOptionPane.showMessageDialog(null, picLabel, "Picture", JOptionPane.PLAIN_MESSAGE, null);



				}
				catch( FileNotFoundException e )
				{
					bufferedImage =null;
					imageName.setText( "No Image" );
				}

			}
		} );
		imageName = new JLabel();
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 2;
		panel.add(imageName, cs);

		JPanel bp = new JPanel();
		btnOk=new JButton("Ok");





		btnCancel=new JButton("Cancel");
		btnCancel.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				dispose();
			}
		} );

		createNewCategory = new JButton( "Create New Category" );

		bp.add(btnOk);
		bp.add(btnCancel);
		bp.add(createNewCategory);



		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);
		pack();
		setResizable(false);
		setLocationRelativeTo(parent);

		this.createNewCategory.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				String[] newArray=new String[listOfCategory.length+1];

				String category= JOptionPane.showInputDialog("Please give new Category Name: ");

				for(int i=0;i<(newArray.length-1);i++){
					newArray[i]=listOfCategory[i];
				}
				newArray[newArray.length-1]=category;
				setListOfCategory(newArray);
				support.uninstall();
				autoCompleteCombo(newArray);
			}
		} );

		btnOk.addActionListener( new ActionListener()
		{
			@Override public void actionPerformed( ActionEvent actionEvent )
			{
				OfferTemplate offerTemplatet=new OfferTemplate();
				offerTemplatet.setOfferName(offertTF.getText());
				offerTemplatet.setCategoryName( (String)jComboBox.getSelectedItem() );
				java.sql.Timestamp data=java.sql.Timestamp.valueOf( offerDateTF.getText() );
				offerTemplatet.setDate(data);
				offerTemplatet.setPrice( Double.valueOf( offertPriceTF.getText() ));
				offerTemplatet.setImage( bufferedImage );
				succes=true;
				offerTemplate=offerTemplatet;
				dispose();


			}
		} );
	}

	private void autoCompleteCombo( String[] listOfCategory )
	{


		support = AutoCompleteSupport.install(jComboBox,
				GlazedLists.eventListOf( listOfCategory ));
		support.setStrict(true);

	}

	private BufferedImage getScaledImage(Image srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}

	public OfferTemplate getOfferTemplate(){
		return this.offerTemplate;
	}
	private void setListOfCategory(String[] array){
		listOfCategory=array;
	}
	public String[] getListOfCategory()
	{
		return listOfCategory;
	}

	public boolean isSucces()
	{
		return succes;
	}
}
