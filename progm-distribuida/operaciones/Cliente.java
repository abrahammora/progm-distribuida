import java.rmi.Naming;
import java.util.Scanner;
public class Cliente{
				public static void main(String []args){
					Scanner sc=new Scanner(System.in);
						try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/progm-distribuida");
            System.out.println("Dame el primer numero");
						double num1=sc.nextDouble();
						System.out.println("Dame segundo numero");
						double num2=sc.nextDouble();
						System.out.println("Suma: "+objrem.suma(num1,num2));
						System.out.println("Resta: "+objrem.resta(num1,num2));
						double div = objrem.division(num1,num2);

						if(div!=Double.MAX_VALUE)
							System.out.println("Divison: "+objrem.division(num1,num2));
						else
							System.out.println("Error,Division por cero");
						
						System.out.println("Multiplicacion: "+objrem.multiplicacion(num1,num2));
					}catch(Exception e){e.printStackTrace();}
				}
}
