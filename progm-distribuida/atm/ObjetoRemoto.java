import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{
				private int cliente1,cliente2,nip1,nip2;
				private double saldo1,saldo2;
				private int cont;
				Registro nodo1;
				Dato lista;
				//Registro []lista = new Registro[1000];
				public ObjetoRemoto() throws RemoteException{
								super();
								lista = new Dato();
								/*for(int i=0;i<lista.length;i++){
												lista[i]=new Registro();
								}*/
				}

				public boolean Registrar(int no_cuenta,int nip,double saldo) throws RemoteException{
								/*lista[cont].setNocuenta(no_cuenta);
								lista[cont].setNip(nip);
								lista[cont].setSaldo(saldo);
								cont++;*/	
								lista.inserIni(no_cuenta,nip,saldo);
								return true;
				}
				public boolean ExisteCliente(int no_cuenta) throws RemoteException{
								if(lista.BuscarCliente(no_cuenta) != null)
												return true;
						return false;
				}
				public boolean ExisteNIP(int no_cuenta,int nip) throws RemoteException{
								if(lista.BuscarCliente(no_cuenta)!= null && lista.BuscarNip(nip)!=null) 
															return true;
										
						return false;
				}
				public double ConsultaSaldo(int no_cuenta) throws RemoteException{																											Registro aux = lista.BuscarCliente(no_cuenta);
								double saldo =0.0;
								if(aux!=null) saldo = aux.getSaldo();											
												
							return saldo;
								
				}
				public void RetiraSaldo(int no_cuenta,double cantidad) throws RemoteException{
								double saldo = 0.0;
								Registro aux = lista.BuscarCliente(no_cuenta);
								if(aux !=null){
												saldo = aux.getSaldo();
												saldo -=cantidad;
												aux.setSaldo(saldo);
								}
				}
				public void DepositaSaldo(int no_cuenta,double cantidad) throws RemoteException{
								double saldo = 0.0;
								Registro aux = lista.BuscarCliente(no_cuenta);
								if(aux !=null){
												saldo = aux.getSaldo();
												saldo +=cantidad;
												aux.setSaldo(saldo);
								}
				}
}
