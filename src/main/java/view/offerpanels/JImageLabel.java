package view.offerpanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class JImageLabel extends JLabel
{
	private Image img;
	public int xx;
	public int yy;

	public JImageLabel(Image img){
		this.img=img;
	}
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		if(img!=null){

			int wys=img.getHeight(this);
			int szer=img.getWidth(this);

			xx=this.getSize().width;
			yy=this.getSize().height;

			double stx=(double)xx/(double)szer;
			double sty=(double)yy/(double)wys;

			int szerw,wysw;

			if(sty<stx){
				szerw=(int)(szer*sty);
				wysw=(int)(wys*sty);
			}else{
				szerw=(int)(szer*stx);
				wysw=(int)(wys*stx);
			}
			try{
				Image img1=img.getScaledInstance(szerw, wysw,java.awt.Image.SCALE_SMOOTH);
				g.drawImage(img1, (int)((xx-szerw)/2),(int)((yy-wysw)/2), szerw, wysw, this);
			}catch(Exception eee){

			}
		}
	}

	public void setImg( Image img )
	{
		this.img = img;
		this.repaint(  );
	}
}
