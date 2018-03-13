import java.rmi.*;
import java.rmi.server.*;
import java.lang.Math;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto{

				public ObjetoRemoto() throws RemoteException{
								super();
				}

				public String suma(double r1,double i1,double r2,double i2) throws RemoteException{
							

						complejos []com = new complejos[10];
						for(int i=0;i<com.length;i++){
									com[i]=new complejos();
						}

							com[0].setReal(r1);
							com[1].setImg(i1);
							com[2].setReal(r2);
							com[3].setImg(i2);
							double x = com[0].getReal() + com[2].getReal();
							double y = com[1].getImg() + com[3].getImg();
//							System.out.println("La suma es: "+x+" + "+y+"i");
							return "La suma es: "+x+" + "+y+"i";
							
				}
				
				public String resta(double r1,double i1,double r2,double i2) throws RemoteException{


						complejos []com = new complejos[10];
						for(int i=0;i<com.length;i++){
									com[i]=new complejos();
						}

							com[0].setReal(r1);
							com[1].setImg(i1);
							com[2].setReal(r2);
							com[3].setImg(i2);
						double x1 = -1*(com[2].getReal());
						double y2 = -1*(com[3].getImg());
						double x = com[0].getReal()+x1;
						double y = com[1].getImg()+y2;
					//	System.out.println("La resta es: "+x+" + "+y+"i");
					return "La resta es: "+x+" + "+y+"i";
				}
				public String  multi(double r1,double i1,double r2,double i2) throws RemoteException{
								
						complejos []com = new complejos[10];
						for(int i=0;i<com.length;i++){
									com[i]=new complejos();
						}

							com[0].setReal(r1);
							com[1].setImg(i1);
							com[2].setReal(r2);
							com[3].setImg(i2);
						double x = com[0].getReal()*com[2].getReal() - com[1].getImg()*com[3].getImg();
						double y = com[0].getReal()*com[3].getImg() + com[1].getImg()*com[2].getReal();
//						System.out.println("La multipicacion es: "+x+" + "+y+"i");
						return "La multiplicacion es: "+x+" + "+y+"i";

				}
				public double  modu(double r1,double i1,double r2,double i2) throws RemoteException{

						complejos []com = new complejos[10];
						for(int i=0;i<com.length;i++){
									com[i]=new complejos();
						}

							com[0].setReal(r1);
							com[1].setImg(i1);
							com[2].setReal(r2);
							com[3].setImg(i2);
						return Math.sqrt(com[0].getReal()*com[2].getReal()+com[1].getImg()*com[3].getImg());
				}
				public String div(double r1,double i1,double r2,double i2) throws RemoteException{
					double aux=0.0,x=0.0,y=0.0;				
						complejos []com = new complejos[10];
						for(int i=0;i<com.length;i++){
									com[i]=new complejos();
						}

							com[0].setReal(r1);
							com[1].setImg(i1);
							com[2].setReal(r2);
							com[3].setImg(i2);
							if(modu(r1,i1,r2,i2)==0.0){
//								System.out.println("Err:Division entre Cero");
									return "Err:División entre Cero";
							}else{
								aux = com[2].getReal()*com[2].getReal()+com[3].getImg()*com[3].getImg();
								x=(com[0].getReal()*com[2].getReal()+com[1].getImg()*com[3].getImg());///aux;
								y=(com[1].getImg()*com[2].getReal()-com[0].getReal()*com[3].getImg());///aux;

								//System.out.println("La division es: "+x+"/"+aux+" + "+y+"/"+aux+"i");								
								return "La división es: "+x+"/"+aux+" + "+y+"/"+aux+"i";
							}

				//return null;


				}



}
