import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote{

				public double  suma(double  num1,double num2) throws RemoteException;
				public double  resta(double num1,double num2) throws RemoteException;
				public double  multiplicacion(double num1,double num2) throws RemoteException;
				public double  division(double num1,double num2) throws RemoteException;
}
