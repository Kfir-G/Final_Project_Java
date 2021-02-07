import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
/**
 * ClubAbstractEntity class which inherite to Person class
 * {@link Person} 
 */
public abstract class ClubAbstractEntity extends JFrame implements Serializable
{
    //-----------data fields---------
    protected JPanel mainPanel;
    protected JButton okButton;
    protected JButton cancelButton;
    private ButtonsHandler handler; 

    //-----------constructors--------
    /**
     * ClubAbstractEntity constructor
     */
    public ClubAbstractEntity()
    {
        JPanel subJP = new JPanel();
        this.mainPanel = new JPanel();
        this.okButton=new JButton("OK");
        this.cancelButton=new JButton("CANCEL");
        handler=new ButtonsHandler();
        mainPanel.setLayout(new BorderLayout()); 

        this.okButton.addActionListener(handler); 
        this.cancelButton.addActionListener(handler); 

        subJP.add(okButton);
        subJP.add(cancelButton); 
        mainPanel.add(subJP,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   
        setContentPane(mainPanel); 
        getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false); 
        setLocationRelativeTo(null);
        setVisible(false);    
    }  
    /** 
     * setEnabledCancel method set the cencel button to enabled to true or false
     * @param bool boolean which set the cencel button to enabled to true or false
     */
    //-----------methods----------
    protected void setEnabledCancel(boolean bool){
        cancelButton.setEnabled(bool);
    }
    /** 
     * addToCenter method center the gui compinent
     * @param guiComponent Component which is centering the gui compinent
     */
    protected void addToCenter(Component guiComponent)
    {       
        mainPanel.add(guiComponent,BorderLayout.CENTER);     
    }
    /**
     * ButtonsHandler which listen to buttons 
     */
    private class ButtonsHandler implements ActionListener ,Serializable
    {
        /**
         * actionPerformed listen to OK and Cancel buttons
         * @param e ActionEvent of the button
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == okButton && validateData()){
                commit(); 
                setEnabledCancel(true);
                setVisible(false); //TO DO 
            }
            if (e.getSource() == cancelButton){
                rollBack(); 
                setVisible(false); //TO DO                
            }
        } 
    }
    //absracts:
    public abstract boolean match(String key);
    protected abstract boolean validateData();
    protected abstract void commit();
    protected abstract void rollBack();
    protected abstract void showDetails();
}