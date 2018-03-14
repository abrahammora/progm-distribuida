import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{
				private int cliente1,cliente2,nip1,nip2;
				private double saldo1,saldo2;
				public ObjetoRemoto() throws RemoteException{
								super();
								cliente1 = 1;
								nip1 = 1234;
								saldo1 = 1000.00;
								cliente2 = 2;
								nip2 = 4321;
								saldo2 = 50.00;
				}

				public boolean ExisteCliente(int no_cuenta) throws RemoteException{
								if(no_cuenta == cliente1 || no_cuenta == cliente2)
												return true;
								else
												return false;
				}
				public boolean ExisteNIP(int no_cuenta,int nip) throws RemoteException{
								if((no_cuenta == cliente1 && nip == nip1)||(no_cuenta == cliente2 && nip == nip2))
												return true;
								else 
												return false;
				}
				public double ConsultaSaldo(int no_cuenta) throws RemoteException{
								double saldo = 0.0;
								if(no_cuenta==cliente1)
											saldo=saldo1;
								else
											saldo=saldo2;
								return saldo;
								
				}
				public void RetiraSaldo(int no_cuenta,double cantidad) throws RemoteException{
								if(no_cuenta==cliente1)
											 saldo1-=cantidad;
								else
												saldo2-=cantidad;
				}
				public void DepositaSaldo(int no_cuenta,double cantidad) throws RemoteException{
								if(no_cuenta==cliente1)
												saldo1+=cantidad;
								else
												saldo2+=cantidad;
				}
}
