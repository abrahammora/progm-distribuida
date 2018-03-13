
import java.util.Scanner;
public class complejos {
	private double real;
	private double img;
	
	public void Complejos(double real,double img) {
		this.real=real;
		this.img=img;
	}
	public double getReal() {
		return this.real;
	}
	public double getImg() {
		return this.img;
	}
	
	public void setReal(double real) {
		this.real=real;
	}
	public void setImg(double img) {
		this.img=img;
	}
	

/*	public static void main(String []args) {
		complejos []ob = new complejos[10];
		for(int i=0;i<ob.length;i++)
		{
			ob[i]=new complejos();
		}
		ob[0].setReal(3); 
		ob[1].setReal(3);
		ob[2].setImg(5);
		ob[3].setImg(4);
		System.out.println("primer numero Imaginario: "+ob[0].getReal()+" + "+ob[2].getImg()+"i");
		System.out.println("Segundo numero Imaginario: "+ob[1].getReal()+" + "+ob[3].getImg()+"i");
		//double pr=ob[0].getReal();
		int img = ob[2].getImg()+ob[3].getImg();
		int real =ob[0].getReal()+ob[1].getReal();
		
		System.out.println("La suma de los numero imaginarios es: "+real+" + "+img+"i");
	}*/
}
