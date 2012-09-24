import javax.swing.*;
import java.awt.*;

public class Card {
	int value;
	int suitRank;
	char suit;
	boolean faceUp;
	
	ImageIcon cardImage;
	ImageIcon cardBackImage;
	
	public Card(int v, int sr){
		
		value = v;
		suitRank = sr;
		faceUp = true;
		cardBackImage = new ImageIcon("images/b.gif");
		
		switch (suitRank) {
			case 0: suit = 's';
					break;
			case 1: suit = 'd';
					break;
			case 2: suit = 'h';
				break;
			case 3: suit = 'c';
				break;
		}
		
		setCardImage();
		
		value += 2;
		
		if (value > 10 && value != 14)
			value = 10;
		else if (value == 14)
			value = 11;
			
	}

	public String toString(){
		return "" + value + suit;
	}
	
	public void paintCard(JFrame j, Graphics2D g, int x, int y, boolean fu){
		if (fu)
			cardImage.paintIcon(j, g, x, y);
		else
			cardBackImage.paintIcon(j, g, x, y);
	}

	public void setCardImage(){
		if (suitRank == 0){
			switch (value) {
				case 0: cardImage = new ImageIcon("images/2s.gif");
						break;
				case 1: cardImage = new ImageIcon("images/3s.gif");
						break;
				case 2: cardImage = new ImageIcon("images/4s.gif");
						break;
				case 3: cardImage = new ImageIcon("images/5s.gif");
						break;
				case 4: cardImage = new ImageIcon("images/6s.gif");
						break;
				case 5: cardImage = new ImageIcon("images/7s.gif");
						break;
				case 6: cardImage = new ImageIcon("images/8s.gif");
						break;
				case 7: cardImage = new ImageIcon("images/9s.gif");
						break;
				case 8: cardImage = new ImageIcon("images/ts.gif");
						break;
				case 9: cardImage = new ImageIcon("images/js.gif");
						break;
				case 10:cardImage = new ImageIcon("images/qs.gif");
						break;
				case 11:cardImage = new ImageIcon("images/ks.gif");
						break;
				case 12:cardImage = new ImageIcon("images/as.gif");
						break;		
			}
		}
		else if (suitRank == 1){
			switch (value) {
				case 0: cardImage = new ImageIcon("images/2d.gif");
						break;
				case 1: cardImage = new ImageIcon("images/3d.gif");
						break;
				case 2: cardImage = new ImageIcon("images/4d.gif");
						break;
				case 3: cardImage = new ImageIcon("images/5d.gif");
						break;
				case 4: cardImage = new ImageIcon("images/6d.gif");
						break;
				case 5: cardImage = new ImageIcon("images/7d.gif");
						break;
				case 6: cardImage = new ImageIcon("images/8d.gif");
						break;
				case 7: cardImage = new ImageIcon("images/9d.gif");
						break;
				case 8: cardImage = new ImageIcon("images/td.gif");
						break;
				case 9: cardImage = new ImageIcon("images/jd.gif");
						break;
				case 10:cardImage = new ImageIcon("images/qd.gif");
						break;
				case 11:cardImage = new ImageIcon("images/kd.gif");
						break;
				case 12:cardImage = new ImageIcon("images/ad.gif");
						break;		
			}
		}
		else if (suitRank == 2){
			switch (value) {
				case 0: cardImage = new ImageIcon("images/2h.gif");
						break;
				case 1: cardImage = new ImageIcon("images/3h.gif");
						break;
				case 2: cardImage = new ImageIcon("images/4h.gif");
						break;
				case 3: cardImage = new ImageIcon("images/5h.gif");
						break;
				case 4: cardImage = new ImageIcon("images/6h.gif");
						break;
				case 5: cardImage = new ImageIcon("images/7h.gif");
						break;
				case 6: cardImage = new ImageIcon("images/8h.gif");
						break;
				case 7: cardImage = new ImageIcon("images/9h.gif");
						break;
				case 8: cardImage = new ImageIcon("images/th.gif");
						break;
				case 9: cardImage = new ImageIcon("images/jh.gif");
						break;
				case 10:cardImage = new ImageIcon("images/qh.gif");
						break;
				case 11:cardImage = new ImageIcon("images/kh.gif");
						break;
				case 12:cardImage = new ImageIcon("images/ah.gif");
						break;		
			}
		}
		else if (suitRank == 3){
			switch (value) {
				case 0: cardImage = new ImageIcon("images/2c.gif");
						break;
				case 1: cardImage = new ImageIcon("images/3c.gif");
						break;
				case 2: cardImage = new ImageIcon("images/4c.gif");
						break;
				case 3: cardImage = new ImageIcon("images/5c.gif");
						break;
				case 4: cardImage = new ImageIcon("images/6c.gif");
						break;
				case 5: cardImage = new ImageIcon("images/7c.gif");
						break;
				case 6: cardImage = new ImageIcon("images/8c.gif");
						break;
				case 7: cardImage = new ImageIcon("images/9c.gif");
						break;
				case 8: cardImage = new ImageIcon("images/tc.gif");
						break;
				case 9: cardImage = new ImageIcon("images/jc.gif");
						break;
				case 10:cardImage = new ImageIcon("images/qc.gif");
						break;
				case 11:cardImage = new ImageIcon("images/kc.gif");
						break;
				case 12:cardImage = new ImageIcon("images/ac.gif");
						break;		
			}
		}
	}
	
	public int getValue(){
		return value;
	}
}