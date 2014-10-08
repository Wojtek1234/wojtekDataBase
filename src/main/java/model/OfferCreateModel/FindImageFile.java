package model.OfferCreateModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class FindImageFile
{
	private JDialog parent;
	public FindImageFile(JDialog dialog){
		parent=dialog;
	}
	public BufferedImage findImageFile() throws FileNotFoundException
	{
		FileFilter filter = new FileNameExtensionFilter("Image Files","jpg","png","gif");
		JFileChooser fc=new JFileChooser(  );
		fc.setFileFilter( filter );
		int returnVal = fc.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			return  getBuffImage( file );
		}else
		{
			throw new FileNotFoundException();
		}
	}

	private BufferedImage getBuffImage( File file ) throws FileNotFoundException
	{
		try
		{
			return ImageIO.read( file );
		}
		catch( IOException e )
		{
			throw new FileNotFoundException();
		}
	}
}
