import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashen
 */
public class server {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
 
        java.rmi.registry.Registry r;
        try {
            r = LocateRegistry.createRegistry(1099);
             r.rebind("bank", new OnlineBank());
            System.out.println("server is runing....");
        } catch (RemoteException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}