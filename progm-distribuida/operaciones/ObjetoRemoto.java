import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{
				public ObjetoRemoto() throws RemoteException{
								super();
				}


				public double  suma(double num1,double num2) throws RemoteException{
								return num1+num2;
				}

				public double  resta(double num1,double num2) throws RemoteException{
								return num1-num2;
				}
				public double  multiplicacion(double num1,double num2) throws RemoteException{
								return num1*num2;
				}
				public double  division(double num1,double num2) throws RemoteException{
								if(num2!=0)return num1/num2;
								else return Double.MAX_VALUE;
				}
}
