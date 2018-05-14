import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{
				public void Saludo(String mensaje) throws RemoteException;
}
