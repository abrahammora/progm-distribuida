import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote
{
    public void EnviaMensaje(String mensaje, int idpc) throws RemoteException; 
    public String RecibeMensajePc1() throws RemoteException;
    public String RecibeMensajePc2() throws RemoteException;
    public void EnviaAlias(String alias, int idpc) throws RemoteException;
    public String RecibeAlias1() throws RemoteException;
    public String RecibeAlias2() throws RemoteException;

}  // Fin interfaz IObjetoRemoto
