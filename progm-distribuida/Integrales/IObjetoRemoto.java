import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{

				public double Sin(double x0,double x1,double x2) throws RemoteException;
				public double xcuadrada(double x0,double x1,double x2) throws RemoteException;
				public double init_h(double x0,double x2) throws RemoteException;
				public double init_x1(double x0,double x2) throws RemoteException;
				public double Resultado(double x0,double x2) throws RemoteException;
}
