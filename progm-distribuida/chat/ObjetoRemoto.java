import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{
				private String mensaje1,mensaje2,alias1,alias2;
				private int cliente;
				public ObjetoRemoto() throws RemoteException{
								super();
				}

				public void EnviaMensaje(String mensaje,int cliente) throws RemoteException{
								if(cliente == 1){
									mensaje1=mensaje;									
									System.out.println(mensaje1);
								}
								if(cliente == 2){
									System.out.println(mensaje1);
												mensaje2=mensaje;
								}
						
				}
				public void EnviaAlias(String alias,int cliente) throws RemoteException{
								if(cliente == 1){
									alias1 = alias;
									System.out.println(alias1);
								}															
								if(cliente == 2){
												alias2 = alias;
												System.out.println(alias2);
								}
				}
				public String RecibeMensaje1() throws RemoteException{
								return mensaje1;
				}
				public String RecibeMensaje2() throws RemoteException{
								return mensaje2;
				}
				public String RecibeAlias1() throws RemoteException{
								return alias1;
				}
				public String RecibeAlias2() throws RemoteException{
								return alias2;
				}

}
