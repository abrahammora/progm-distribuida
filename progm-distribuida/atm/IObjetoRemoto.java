import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{



				
				public boolean ExisteCliente(int no_cuenta) throws RemoteException;
				public boolean ExisteNIP(int no_cuenta,int nip) throws RemoteException;
				public double ConsultaSaldo(int no_cuenta) throws RemoteException;	
				public void RetiraSaldo(int no_cuenta,double cantidad) throws RemoteException;
				public void DepositaSaldo(int no_cuenta,double cantidad) throws RemoteException;
}
