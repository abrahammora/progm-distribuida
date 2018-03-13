import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{
				

				public String suma(double r1,double i1,double r2,double i2) throws RemoteException;

				public String resta(double r1,double i1,double r2,double i2) throws RemoteException;
				
				public String multi(double r1,double i1,double r2,double i2) throws RemoteException;

				public double modu(double r1,double i1,double r2,double i2) throws RemoteException;
				public String  div(double r1,double i1,double r2,double i2) throws RemoteException;

}
