import java.rmi.Naming;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
public class Cliente{
				public static void main(String []args){
					double saldoInicial=0.0;
					int cont =0;
					String op;
					String cant;

					
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						Registro lista = new Registro();	
						/*for(int i=0;i<lista.length;i++)
										lista[i]=new Registro();*/
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/progm-distribuida");
						Scanner leer = new Scanner(System.in);
						
					String ruta = "/home/abraham/progm-distribuida/atm/clientes.txt";
					File archivo = new File(ruta);
					BufferedReader bw;
					FileWriter escribir;
					PrintWriter linea;
					FileReader leerLinea;
					FileOutputStream fileout;
					String cuenta,nip2,saldo,str;
					/*if(archivo.exists()){
									bw = new BufferedWriter(new FileWriter(archivo));
									bw.write("El fichero de texto ya existe");
					}else{
									bw = new BufferedWriter(new FileWriter(archivo));
									bw.write("Se ha creado el archivo de texto.");
					}
					bw.close();*/



				leerLinea = new FileReader(archivo);
				bw = new BufferedReader(leerLinea);
				str="";
				while(str!=null){									
							str = bw.readLine();
							cuenta = str;
							str = bw.readLine();
							nip2 = str;
							str = bw.readLine();
							saldo = str;
						if(str!=null)
									objrem.Registrar(Integer.parseInt(cuenta),Integer.parseInt(nip2),Double.parseDouble(saldo));

				}
				bw.close();
				leerLinea.close();
						while(true){
						System.out.print("1.-Registrarse\n2.-Iniciar Sesión\nElige una opción: ");
						String log = leer.nextLine();
						if(lista.isNumeric(log))
							if(Integer.parseInt(log)==1){
										System.out.print("Número de Cuenta: ");
										String new_cliente=leer.nextLine();
										System.out.print("Nip: ");
										String new_nip=leer.nextLine();
										if(archivo.exists()){
										if(lista.isNumeric(new_nip)&&lista.isNumeric(new_cliente))
											if(objrem.ExisteCliente(Integer.parseInt(new_cliente))){
															System.out.println("Número de cuenta ya existe");
											}else{
												escribir = new FileWriter(archivo,true);
												linea = new PrintWriter(escribir);
												linea.println(new_cliente);
												linea.println(new_nip);
												linea.println(saldoInicial);
												linea.close();
												escribir.close();
												if(objrem.Registrar(Integer.parseInt(new_cliente),Integer.parseInt(new_nip),saldoInicial)){																
																System.out.println("Usuario Registrado con Exito");
												}
												else System.out.println("No se pudo registrar el usuario");
											}
										}

						}else if(Integer.parseInt(log)==2){
						
						System.out.print("Ingresa el número del cliente: ");
						String cliente = leer.nextLine();
						if(lista.isNumeric(cliente))
						if(objrem.ExisteCliente(Integer.parseInt(cliente))){
							System.out.print("Ingresa el NIP: ");
							String nip = leer.nextLine();
							if(lista.isNumeric(nip))
							if(objrem.ExisteNIP(Integer.parseInt(cliente),Integer.parseInt(nip))){
								while(true){
									System.out.print("Bienvenido\n1.-Consultar Saldo\n2.-Retirar Saldo\n3.-Depositar\n4.-Salir\nElige una opcion: ");
									op = leer.nextLine();
									if(lista.isNumeric(op)){
								//		switch(Integer.parseInt(op)){
												if(Integer.parseInt(op)==1)
															System.out.println("Tu saldo es: "+ String.format("%.2f",objrem.ConsultaSaldo(Integer.parseInt(cliente))));


																

															//break;
												else if(Integer.parseInt(op)==2){	
												System.out.print("Ingresa la cantidad a retirar: ");
																  cant = leer.nextLine();
																 if(lista.isNumeric(cant))
																 if(Double.parseDouble(cant) > 0){
																 if(Double.parseDouble(cant) <= objrem.ConsultaSaldo(Integer.parseInt(cliente))){

																	String line = "",input="";
																				String sal=Double.toString(objrem.ConsultaSaldo(Integer.parseInt(cliente)));
																				objrem.RetiraSaldo(Integer.parseInt(cliente),Double.parseDouble(cant));
																				String sal2=Double.toString(objrem.ConsultaSaldo(Integer.parseInt(cliente)));

																	leerLinea = new FileReader(archivo);
																	bw = new BufferedReader(leerLinea);
																	int con=0,mul=3;													
																	while((line=bw.readLine())!=null){
																					cont++;
																					if(cont==mul && line.contains(sal)){
																						//if(line.contains(sal)){
																										input += line.replaceAll(sal,sal2+"\r\n");
																										mul-=3;
																					}else{
																							input +=line+"\r\n";
																							mul+=3;
																					}																						

																			
																				
																	}
																	
																	fileout = new FileOutputStream(ruta);
																	fileout.write(input.getBytes());
																	fileout.close();
																	bw.close();
																	leerLinea.close();

																				 System.out.println("Saldo nuevo: "+ String.format("%.2f",objrem.ConsultaSaldo(Integer.parseInt(cliente))));
																 }else
																				 System.out.println("Saldo insuficiente");
																}else System.out.println("Cantidad Invalida");
												//			break;
												}else if(Integer.parseInt(op)==3){
													System.out.print("Ingresa la cantidad a depositar: ");
																  cant = leer.nextLine();
																 if(lista.isNumeric(cant))
																 if(Double.parseDouble(cant)> 0){



																	String line = "",input="";
																	
																	String sal=Double.toString(objrem.ConsultaSaldo(Integer.parseInt(cliente)));
																 	objrem.DepositaSaldo(Integer.parseInt(cliente),Double.parseDouble(cant));
																	String sal2=Double.toString(objrem.ConsultaSaldo(Integer.parseInt(cliente)));
																	String[] busqueda = sal.split(";",3);
																	leerLinea = new FileReader(archivo);
																	bw = new BufferedReader(leerLinea);

																	while((line=bw.readLine())!=null){
																					//if(line.contains(cliente))
																						if(line.contains(sal)){
																									input += line.replaceAll(sal,sal2+"\r\n");
																						}else{
																									input +=line+"\r\n";
																						}
																					
																	}
																	
																	fileout = new FileOutputStream(ruta);
																	fileout.write(input.getBytes());
																	fileout.close();
																	

																 	System.out.println("Saldo nuevo: "+ String.format("%.2f",objrem.ConsultaSaldo(Integer.parseInt(cliente))));
																	/*while((line = bw.readLine())!=null){
																					if(line.contains("1"))
																									input += line.replaceAll("0.0","100 \r\n");


																	}

																	fileout = new FileOutputStream(ruta);
																	fileout.write(input.getBytes());
																	fileout.close();
																	for(int i = 0;i<len;i++)
																					busqueda[i] = busqueda[i].toLowerCase().trim();
																	while((line = bw.readLine())!=null){
																				//	String token0 = line.split(";",-1)[0];

																					//				if(token0.equalsIgnoreCase(sal))
																					for(int i=0;i<len;i++){
																									int pos = line.toLowerCase().indexOf(busqueda[i]);
																									if(pos > -1){
																													System.out.println("Se encontro "+line.substring(pos,pos+busqueda[i].length()));
																									}
																					}

																					
																	}*/

																	bw.close();
																	leerLinea.close();
																 }else System.out.println("Cantidad Invalida");
												}else if(Integer.parseInt(op)==4){
													System.out.println("Adios");
																 break;
												}else
													System.out.println("Opcion Incorrecta");
																//	break;
							//	}
								}
							}//while(Integer.parseInt(op)!=4);
							}else
									System.out.println("NIP Inválido");
					}else
									System.out.println("Cliente Inexistente");
				}
						}

					}catch(Exception e){e.printStackTrace();}
				}
}
