public class Registro{
		private int no_cuenta;
		private int nip;
		private double saldo;
		Registro nextnodo;
		Registro previo;
		public Registro(){
				this.nextnodo = null;
				this.previo = null;
		}

		public Registro(int no_cuenta,int nip,double saldo,Registro next,Registro previo){
						this.no_cuenta=no_cuenta;
						this.nip=nip;
						this.saldo=saldo;
						this.nextnodo=next;
						this.previo=previo;
		}
		public Registro getNext(){
						return this.nextnodo;
		}
		public void setNext(Registro next){
						this.nextnodo = next;
		}
		public Registro getPrevio(){
						return this.previo;
		}
		public void setPrevio(Registro previo){
						this.previo=previo;
		}

		public void setNocuenta(int no_cuenta){
						this.no_cuenta=no_cuenta;
		}
		public int getNocuenta(){
						return this.no_cuenta;
		}
	
		public void setNip(int nip){
						this.nip=nip;
		}
		public int getNip(){
						return this.nip;
		}
		public void setSaldo(double saldo){
						this.saldo=saldo;
		}
		public double getSaldo(){
						return this.saldo;
		}


	public boolean isNumeric(String cadena){
		try {
			double na=Double.parseDouble(cadena);

		} catch (NumberFormatException na){
			return false;
		}
		return true;
	}

}
