import java.rmi.registry.*;
public class Servidor{
	public static void main(String []args){
		try{
						Registry registro = LocateRegistry.createRegistry(2320);


						System.setProperty("java.rmi.server.hostname","192.168.202.120");
						//registro.rebind("SistemasDstribuidos",new ObjetoRemoto());
						registro.rebind("progm-distribuida",new ObjetoRemoto());
		}catch(Exception e){e.printStackTrace();}
	}
}
