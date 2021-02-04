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

        JPanel subJP = new JPanel();
        subJP.add(cancelButton);
        subJP.add(okButton);
        mainPanel.add(subJP,BorderLayout.SOUTH); 

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   
        frame.setContentPane(mainPanel); 
        frame.setVisible(true); 
        frame.setResizable(false); 
    }  
    //-----------methods----------
    protected void addToCenter(Component guiComponent)
    {
        this.mainPanel.add(guiComponent,BorderLayout.CENTER);
    }
    private class ButtonsHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == okButton && validateData()){
                commit(); 
                mainPanel.setVisible(false); 
            }
            if (e.getSource() == cancelButton){
                rollBack(); 
                mainPanel.setVisible(false); 
            }
        } 
    }
    //absracts:
    public abstract boolean match(String key);
    protected abstract boolean validateData();
    protected abstract void commit();
    protected abstract void rollBack();
}