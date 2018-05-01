import java.rmi.Naming;
import java.util.Scanner;
public class Cliente2{
				public static void main(String []args){
								Scanner leer = new Scanner(System.in);
								String msj1=null,msj2,alias1,alias2,cipher,des,url;
								Caesar text = new Caesar();
							
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						
						url="rmi://"+args[0]+ ":2320/progm-distribuida";
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup(url);
						do{
							System.out.print("Escribe un Alias: ");
							alias2 = leer.nextLine();
							objrem.EnviaAlias(alias2,1);
							alias1 = objrem.RecibeAlias2();
						}while(alias2==null);
						do{
										System.out.println(alias2+"(escribe)");
										msj2=leer.nextLine();
										cipher = text.CifrarMensaje(msj2);
										if(msj2!=null){
										objrem.EnviaMensaje(cipher,1);

											cipher=objrem.RecibeMensaje2();
											if(cipher!=null)
												msj1 = text.DescifrarMensaje(cipher);
												System.out.println(alias1+": " + msj1);
										}
									

						}while(!msj2.isEmpty());

					}catch(Exception e){e.printStackTrace();}
				}
}

