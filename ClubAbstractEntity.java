import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class ClubAbstractEntity extends JFrame
{
    //-----------data fields---------
    protected JPanel mainPanel;
    protected JButton okButton;
    protected JButton cancelButton;
    private ButtonsHandler handler;

    //-----------constructors--------
    public ClubAbstractEntity()
    {
        JFrame frame= new JFrame();
        frame.setTitle("Club's Data");
        frame.setLocationRelativeTo(null);

        this.handler=new ButtonsHandler();
        this.mainPanel=new JPanel();
        mainPanel.setPreferredSize(new Dimension(450,220));
        mainPanel.setLayout(new BorderLayout()); 
        this.okButton=new JButton("OK");
        this.okButton.addActionListener(handler); 
        this.cancelButton=new JButton("CANCEL");
        this.cancelButton.addActionListener(handler); 
    }  
    //-----------methods----------
    protected void addToCenter(Component guiComponent)
    {
        this.mainPanel.add(guiComponent,BorderLayout.CENTER);
    }
    private class ButtonsHandler implements ActionListener
    {
        //test
        /////
        
    }
    //absracts:
    public abstract boolean match(String key);
    protected abstract boolean validateData();
    protected abstract void commit();
    protected abstract void rollBack();
}