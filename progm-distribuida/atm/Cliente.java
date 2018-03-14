import java.rmi.Naming;
import java.util.Scanner;
public class Cliente{
				public static void main(String []args){
					double cant;
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/progm-distribuida");
						Scanner leer = new Scanner(System.in);
						System.out.print("Ingresa el número del cliente: ");
						int cliente = leer.nextInt();
						if(objrem.ExisteCliente(cliente)){
							System.out.print("Ingresa el NIP: ");
							int nip = leer.nextInt();
							if(objrem.ExisteNIP(cliente,nip)){
									System.out.print("Bienvenido\n1.-Consultar Saldo\n2.-Retirar Saldo\n3.-Depositar\nElige una opcion: ");
									int op = leer.nextInt();
									switch(op){
													case 1:System.out.println("Tu saldo es: "+objrem.ConsultaSaldo(cliente));
															break;
													case 2:System.out.print("Ingresa la cantidad a retirar: ");
																  cant = leer.nextDouble();
																 if(cant < objrem.ConsultaSaldo(cliente)){
																				 objrem.RetiraSaldo(cliente,cant);
																				 System.out.println("Saldo nuevo: "+ objrem.ConsultaSaldo(cliente));
																 }else
																				 System.out.println("Saldo insuficiente");
															break;
													case 3:System.out.print("Ingresa la cantidad a depositar: ");
																  cant = leer.nextDouble();
																 objrem.DepositaSaldo(cliente,cant);
																 System.out.println("Saldo nuevo: "+ objrem.ConsultaSaldo(cliente));
															break;
								}
							}else
									System.out.println("NIP Inválido");
					}else
									System.out.println("Cliente Inexistente");

					}catch(Exception e){e.printStackTrace();}
				}
}
