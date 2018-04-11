public class Dato{

				Registro nodo1,nodo2;
				public Dato(){
								this.nodo1=null;
								this.nodo2=null;
				}

				public Registro BuscarCliente(int no_cuenta){
								Registro aux = nodo1;
								while(aux!=null){
												if(aux.getNocuenta() == no_cuenta)
																return aux;
												aux = aux.getNext();
								}
								return null;
				}
				public Registro BuscarNip(int nip){
								Registro aux = nodo1;
								while(aux !=null){
												if(aux.getNip() == nip)
																return aux;
												aux = aux.getNext();
								}
								return null;
				}

				public double  BuscarSaldo(int nip){
								Registro aux = nodo1;
								while(aux != null){
												if(aux.getNip() == nip)
																return aux.getSaldo();
												aux = aux.getNext();
								}
								return 0;
				}
				public void inserIni(int no_cuenta,int nip,double saldo){
								Registro temp = new Registro(no_cuenta,nip,saldo,null,null);
								if(nodo1==null){
												nodo1=temp;
												nodo2=nodo1;
								}else{
												temp.setNext(nodo1);
												nodo1.setPrevio(temp);
												nodo1=temp;
								}
				}

}
