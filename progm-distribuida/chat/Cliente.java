import java.rmi.Naming;
import java.util.Scanner;
public class Cliente {
				public static void main(String []args){
								Scanner leer = new Scanner(System.in);
								String msj1="";
								/* String msj2="";*/
								 String cipher,desc;
								 String url,carpeta;
								 String alias1;
								//cliente1 cus = new cliente1();
								boolean flag=false;
								int contador=0;
								Caesar text = new Caesar();
								
							
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());

						url="rmi://"+args[0]+ ":2320/progm-distribuida";
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup(url);
						/*cliente1 cus = new cliente1(2,url);
						cliente1 cus2 = new cliente1(1,url);
						(new Thread(cus)).start();
						
						(new Thread(cus2)).start();*/
						//cliente1 cus2 = new cliente1(1,url);
						/*Thread cl1 = new Thread(cus,"cliente1");
						Thread cl2 = new Thread(cus,"cliente2");
						cl1.start();
						cl2.start();*/
						//cus.start();
						//cus.setVisible(true);

						
						/*do{
							System.out.print("Escibre un Alias: ");
							alias1 = leer.nextLine();
							objrem.EnviaAlias(alias1,2);
							alias2 = objrem.RecibeAlias1();
						}while(alias1==null);*/
							/*	do{
									System.out.print("Escribe un Alias: ");
									alias1 = leer.nextLine();
									flag=true;
									contador++;

									//objrem.EnviaAlias(alias1,2);
									//alias2 = objrem.RecibeAlias2();
								}while(alias1.isEmpty());

						Thread cl1 = new Thread(new Runnable(){							 								 
							int cont = objrem.leerMensaje().size();
							@Override
							public void run(){
								try{
									while(true){
										
											if(objrem.leerMensaje().size()>cont){
												//if(cont==1){
													System.out.println(text.DescifrarMensaje(objrem.leerMensaje().get(objrem.leerMensaje().size()-1)));
													cont++;
												//}else
												//	System.out.println("Deben de haber dos para chatear");
												//System.out.println(cont);
											}
										

											

									}
									

								}
								catch(Exception e){
									
								}
								
							}
						});
						


						
						cl1.start();
								
									do{
										System.out.println(alias1 + " (Escriba): ");
										msj1 = leer.nextLine();
										
										//cipher = text.CifrarMensaje(msj1);
										//desc = text.CifrarMensaje(alias1);
										//if(msj1!=null){
											//objrem.EnviaMensaje(cipher,2);
											//objrem.enviarMensajes(alias1+":"+msj1);
											//cipher = objrem.RecibeMensaje2();
										//if(!cipher.isEmpty()){
									
												objrem.enviarMensajes(text.CifrarMensaje(alias1+":"+msj1));
												//msj2 = text.DescifrarMensaje(cipher);
												//System.out.println(alias1+ ": " + msj1);			
										//	}
										//}
										StringBuffer texto = new StringBuffer();
									
										
									}while(!msj1.isEmpty());*/
								
									
					/*	do{
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
									
										
						}while(!msj1.isEmpty());*/

					}catch(Exception e){e.printStackTrace();}
				}


}

