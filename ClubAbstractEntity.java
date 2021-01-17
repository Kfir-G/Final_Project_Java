import javax.swing.JFrame;
import java.awt.*;

public abstract class ClubAbstractEntity extends JFrame
{
    //-----------methods----------
    //absracts:
    public abstract boolean match(String key);
    protected abstract boolean validateData();
    protected abstract void commit();
    protected abstract void rollBack();
}