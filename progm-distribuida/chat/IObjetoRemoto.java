import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{

				

				public void EnviaMensaje(String mensaje,int cliente) throws RemoteException;
				public String RecibeMensaje1() throws RemoteException;
				public String RecibeMensaje2() throws RemoteException;


				public void EnviaAlias(String alias,int cliente) throws RemoteException;
				public String RecibeAlias1() throws RemoteException;
				public String RecibeAlias2() throws RemoteException;
}
