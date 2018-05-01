import java.rmi.Naming;
import java.util.Scanner;
public class Cliente{
				public static void main(String []args){
								Scanner leer = new Scanner(System.in);
								String msj1,msj2,alias1,alias2,cipher,desc,url,carpeta;
								//cliente1 cus = new cliente1();
								Caesar text = new Caesar();
							
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());

						url="rmi://"+args[0]+ ":2320/progm-distribuida";
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup(url);
						/*cliente1 cus = new cliente1();
						cus.setVisible(true);*/
						
						do{
							System.out.print("Escibre un Alias: ");
							alias1 = leer.nextLine();
							objrem.EnviaAlias(alias1,2);
							alias2 = objrem.RecibeAlias1();
						}while(alias1==null);
						do{
										System.out.println(alias1 + " (Escriba): ");
										msj1 = leer.nextLine();
										cipher = text.CifrarMensaje(msj1);
										if(msj1!=null){
											objrem.EnviaMensaje(cipher,2);
											cipher = objrem.RecibeMensaje1();
											if(cipher!=null){
												msj2 = text.DescifrarMensaje(cipher);
												System.out.println(alias2+ ": " + msj2);			
											}
										}
										StringBuffer texto = new StringBuffer();
									
										
						}while(!msj1.isEmpty());

					}catch(Exception e){e.printStackTrace();}
				}
}

