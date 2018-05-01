public class Caesar{	
			private String ABC = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 áéíóúÁÉÍÓÚ";
			/*	private String[] Abcipher = {"d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","a","b","c"};*/
				private String mensaje1;
                private String mensaje2;
                private String alias1;
                private String alias2;

				public void setMensaje1(String mensaje){
								this.mensaje1 = mensaje;
				}
				public String getMensaje1(){
								return this.mensaje1;
				}
                public void setMensaje2(String mensaje){
                                this.mensaje2 = mensaje;
                }
                public String getMensaje2(){
                                return this.mensaje2;
                }
                public void setAlias1(String alias){
                                this.alias1 = alias;
                }
                public String getAlias1(){
                                return this.alias1;
                }
                public void setAlias2(String alias){
                                this.alias2 = alias;
                }
                public String getAlias2(){
                                return this.alias2;
                }
		public String CifrarMensaje(String text) {
			String ci="";
			int p;
			for(int j=0;j<text.length();j++)
				for(int i=0;i<ABC.length();i++) {
					if(text.charAt(j)==ABC.charAt(i)) {						
						ci+=ABC.charAt((i+3)%ABC.length());												
					}
						
				}
			return ci;	
		}
		public String DescifrarMensaje(String text) {
			String ci="";
			int p;
			for(int j=0;j<text.length();j++)
				for(int i=0;i<ABC.length();i++) {
					if(text.charAt(j)==ABC.charAt(i)) {						
						ci+=ABC.charAt((i+ABC.length()-3)%ABC.length());												
					}
						
				}
			return ci;	
		}
		
				
				/*public static String CifrarMensaje(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 27;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 27));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {

                    cifrado.append((char) (texto.charAt(i) + codigo - 27));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

		public static String DescifrarMensaje(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 27;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 27));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 27));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }*/

}
