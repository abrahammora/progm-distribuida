import java.rmi.Naming;
public class Cliente{
				public static void main(String []args){
					try{
						System.setProperty("java.security.policy","rmi.policy");
						System.setSecurityManager(new SecurityManager());
						
						//IObjetoRemoto objrem = [IObjetoRemoto] Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
						IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/progm-distribuida");
						System.out.println(objrem.Resultado(0.0,1.0));
					}catch(Exception e){e.printStackTrace();}
				}
}
