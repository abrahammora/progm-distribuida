import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{
				public ObjetoRemoto() throws RemoteException{
								super();
				}


				public double Sin(double x0,double x1,double x2) throws RemoteException{
								return (init_h(x0,x2)/3)*(Math.sin(Math.exp(Math.pow(x0,2))) + 4*Math.sin(Math.exp(Math.pow(x1,2))) + Math.sin(Math.exp(Math.pow(x2,2))));
				}
				public double xcuadrada(double x0,double x1,double x2) throws RemoteException{
								return (init_h(x0,x1)/3)*(Math.pow(x0,2) + 4*Math.pow(x1,2) + Math.pow(x2,2));
				}
				

				public double init_h(double x0,double x2) throws RemoteException{
								double h = (x2-x0)/2;
								return h;
				}


				public double init_x1(double x0,double x2) throws RemoteException{
								double x1 = x0 + init_h(x0,x2);
								return x1;
				}
	

				public double Resultado(double x0,double x2) throws RemoteException{
								return  Sin(x0,init_x1(x0,x2),x2);

				}	

			
}
