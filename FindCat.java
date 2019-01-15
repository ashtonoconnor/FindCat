
package findcat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FindCat extends JFrame
{

  JLabel label0 = new JLabel();
  JLabel label1 = new JLabel();
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label4 = new JLabel();
  JLabel label5 = new JLabel();
  JLabel label6 = new JLabel();
  JLabel label7 = new JLabel();
  JLabel label8 = new JLabel();
  JLabel label9 = new JLabel();
  JLabel label10 = new JLabel();
  JLabel label11 = new JLabel();
  JLabel label12 = new JLabel();
  JLabel label13 = new JLabel();
  JLabel label14 = new JLabel();
  JLabel label15 = new JLabel();
  JLabel label16= new JLabel();
  JLabel label17= new JLabel();
  JLabel label18= new JLabel();
  JLabel label19 = new JLabel();
  JLabel label20 = new JLabel();
  JLabel label21 = new JLabel();
  JLabel label22 = new JLabel();
  JLabel label23 = new JLabel();
  JLabel label24 = new JLabel();

  
  
  int x = 5;
  int y = 5;
  JLabel[][] choiceLabel = new JLabel[x][y];
  ImageIcon cat = new ImageIcon("treasurechest.gif");
  ImageIcon cat1 = new ImageIcon("cat100100.gif");
  JButton newButton = new JButton();
  JLabel newLabel = new JLabel();
  int catLocation;
  int cat1Location;
  int count;
  Random myRandom = new Random();
  Random my1Random = new Random();


  public static void main(String args[])
  {
    // create frame
    new FindCat().setVisible(true);
  }

  public FindCat()
  {
    // frame constructor
    setTitle("Find the Treasure - By Ashton O'Connor, November 2018");
    setResizable(false);
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent evt)
      {
        exitForm(evt);
      }
    });
    getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints gridConstraints;

	  
	choiceLabel[0][0] = label0;
    choiceLabel[0][1] = label1;
    choiceLabel[0][2] = label2;
    choiceLabel[0][3] = label3;
    choiceLabel[0][4] = label4;
    choiceLabel[1][0] = label5;
    choiceLabel[1][1] = label6;
    choiceLabel[1][2] = label7;
    choiceLabel[1][3] = label8;
    choiceLabel[1][4] = label9;
    choiceLabel[2][0] = label10;
    choiceLabel[2][1] = label11;
    choiceLabel[2][2] = label12;
    choiceLabel[2][3] = label13;
    choiceLabel[2][4] = label14;
    choiceLabel[3][0] = label15;
    choiceLabel[3][1] = label16;
    choiceLabel[3][2] = label17;
    choiceLabel[3][3] = label18;
    choiceLabel[3][4] = label19;
    choiceLabel[4][0] = label20;
    choiceLabel[4][1] = label21;
    choiceLabel[4][2] = label22;
    choiceLabel[4][3] = label23;
    choiceLabel[4][4] = label24;
    
    
   
    for (int i  = 0; i < x; i++)
    {
    	for (int j = 0; j<y;j++) {
      gridConstraints = new GridBagConstraints();
      choiceLabel[i][j].setPreferredSize(new Dimension(cat.getIconWidth(), 
              cat.getIconHeight()));
      choiceLabel[i][j].setOpaque(true);
      choiceLabel[i][j].setBackground(Color.BLUE);
      gridConstraints.gridx = i;
      gridConstraints.gridy = j;
      gridConstraints.insets = new Insets(10, 10, 10, 10);
      getContentPane().add(choiceLabel[i][j], gridConstraints);
 
      
      newLabel.setText("Count: " + count);
      gridConstraints = new GridBagConstraints();
      gridConstraints.gridx = 0;
      gridConstraints.gridy = x*y;
      gridConstraints.insets = new Insets(20, 20, 20, 20);
      getContentPane().add(newLabel, gridConstraints);
     
    
      
      choiceLabel[i][j].addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          labelMouseClicked(e);
          count +=1;
          newLabel.setText("Count: " + count);
        }
      });
    }

    
    
    
    
    
    newButton.setText("Play Again");
    gridConstraints = new GridBagConstraints();
    gridConstraints.gridx = 2;
    gridConstraints.gridy = x*y;
    gridConstraints.insets = new Insets(10, 10, 10, 10);
    getContentPane().add(newButton, gridConstraints);
    newButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        newButtonActionPerformed(e);
      }
    });
    getContentPane().setBackground(Color.RED);
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    // start first game
    newButton.doClick();
    }
  }

  
  
  
  
  
  
  private void labelMouseClicked(MouseEvent e)
  {
    Component clickedComponent = e.getComponent();
   
    for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
      if (clickedComponent == choiceLabel[i][j])
      {
    	  choiceLabel[i][j].setBackground(Color.WHITE);
    	    
    	  if (j == catLocation)
    	     {
    	    	if (i == catLocation) {
    	      choiceLabel[i][j].setIcon(cat);
    	      newButton.setEnabled(true); }
    	      
    	      
    	      
    	      
    	     
    	    		 
    	    	  
    	    	}
    	  if (j == cat1Location) {
  	    	if (i == cat1Location) {
  	    		choiceLabel[i][j].setIcon(cat1);
  	   
  	    		JOptionPane.showMessageDialog(null, "Oh no! You found the destructo image!");
  	    		for (int m = 0; m < x; m++)
  	    	    {
  	    	    	for (int n = 0; n <y; n++) {
  	    	  
  	    	      choiceLabel[m][n].setIcon(null);
  	    	      choiceLabel[m][n].setBackground(Color.BLUE);
  	    	    }
  	    	    }
  	    	    catLocation = myRandom.nextInt(x);
  	    	    cat1Location = my1Random.nextInt(x);
  	    	    newButton.setEnabled(false);
  	    		
  	    		
    	    }
      
     
	    	}
    	      
      }
    
    
    }
    }
		}
    

	
  
  
  
  
  private void newButtonActionPerformed(ActionEvent e)
  {
    // clear boxes and hide cat
    for (int i = 0; i < x; i++)
    {
    	for (int j = 0; j <y; j++) {
  
      choiceLabel[i][j].setIcon(null);
      choiceLabel[i][j].setBackground(Color.BLUE);
    }
    }
    catLocation = myRandom.nextInt(x);
    cat1Location = my1Random.nextInt(x);
    newButton.setEnabled(false);
    }
  

  

  
  
  
  
  private void exitForm(WindowEvent evt)
  {
    System.exit(0);
  }
}