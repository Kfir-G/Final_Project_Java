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
        JPanel subJP = new JPanel();
        this.mainPanel = new JPanel();
        this.okButton=new JButton("OK");
        this.cancelButton=new JButton("CANCEL");
        this.handler=new ButtonsHandler();

        mainPanel.setLayout(new BorderLayout()); 

        this.okButton.addActionListener(handler); 
        this.cancelButton.addActionListener(handler); 

        
        subJP.add(cancelButton); 
        subJP.add(okButton); 
        mainPanel.add(subJP,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   
        setContentPane(mainPanel); 
        getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false); 
        setLocationRelativeTo(null);
        setVisible(true); 
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
                mainPanel.setVisible(false); //TO DO 
            }
            if (e.getSource() == cancelButton){
                rollBack(); 
                mainPanel.setVisible(false); //TO DO 
            }
        } 
    }
    //absracts:
    public abstract boolean match(String key);
    protected abstract boolean validateData();
    protected abstract void commit();
    protected abstract void rollBack();
}