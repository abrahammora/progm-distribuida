import java.rmi.Naming;
import java.util.Scanner;
public class Cliente{

				public static void main(String []args){
					Scanner x=new Scanner(System.in);
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/progm-distribuida");



				/*	complejos []ob = new complejos[10];
					for(int i=0;i<ob.length;i++)
					{
						ob[i]=new complejos();
					}*/

					System.out.println("Ingresa el primer numero imaginario");
					System.out.print("Parte Real: ");
					double r1=x.nextDouble();
					System.out.print("Parte Imaginaria: ");
					double i1=x.nextDouble();
					System.out.println("Ingresa el segundo numero imaginario");
					System.out.print("Parte Real: ");
					double r2=x.nextDouble();
					System.out.print("Parte Imaginaria: ");
					double i2=x.nextDouble();
					System.out.println( objrem.suma(r1,i1,r2,i2));
					System.out.println(objrem.resta(r1,i1,r2,i2));

					System.out.println(objrem.multi(r1,i1,r2,i2));
					System.out.println(objrem.div(r1,i1,r2,i2));

					/*ob[0].setReal(r1);
					ob[1].setImg(r2);
					ob[2].setReal(r11);
					ob[3].setImg(r22);

						double real = objrem.suma(ob[0].getReal(),ob[2].getReal());
						double img = objrem.suma(ob[1].getImg(),ob[3].getImg());


					double realr= objrem.resta(ob[0].getReal(),ob[2].getReal());
					double imgr= objrem.resta(ob[1].getImg(),ob[3].getImg());

					double realm = objrem.mul(ob[0].getReal(),ob[2].getReal());
					double imgm = objrem.mul(ob[1].getImg(),ob[3].getImg());
					System.out.println("La suma es:" + real + " + " + img + "i");
					
					System.out.println("La resta es:"+ realr + " +  " + imgr + "i");
					System.out.println("La multiplicacion es:"+ realm +" +  " + imgm + "i");
					double div = ((ob[0].getReal()*ob[2].getReal())*(ob[0].getReal()*(-ob[2].getReal())));
					System.out.println("La division es: "+ div);
					/*double divisor= objrem.divi(ob[0].getReal(),ob[1].getImg(),ob[2].getReal(),ob[3].getImg());
          double conjR = objrem.conjugado(ob[0].getReal(),ob[2].getReal()); 
					double conjI = objrem.conjugado(ob[1].getImg(),ob[3].getImg());
					double div = objrem.div(conjR,conjI);				
						if(div!=Double.MAX_VALUE)
							System.out.println("La division es :" + conjR + "/ " +conjI+"i");
						else
							System.out.println("Error,Division por cero");*/

					}catch(Exception e){e.printStackTrace();}
				}
}
