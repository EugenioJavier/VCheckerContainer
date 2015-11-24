import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class VCheckerApplication {
	
	//parámetros de la aplicación. El nombre del fichero a procesar
    public static void main(String[] args) {
        
    	boolean resultado=false;
    	
    	String fichero="./"+args[0];
    	resultado=ComprobarVersiones(fichero);
    	System.out.println(resultado);
    }

	private static boolean ComprobarVersiones(String fichero) {
		//construimos el FileReader
		File fich=null;
		FileReader fr=null;
		try {
			fich=new File(fichero);
			fr = new FileReader(fich);
			BufferedReader br=new BufferedReader(fr);
			
			//lectura del fichero
			String linea;
			boolean resultado=false;
			//mientras haya lineas en el fichero
			while ((linea=br.readLine())!=null) {
				String[]compLineas=linea.split("|");
				//nombreFichero|version|url		
				//comprobamos a que repositorio nos vamos a conectar
				if(compLineas[2].equals("search.maven.org")){
					resultado=ComprobarConMaven(compLineas);
				}else{
					resultado=ComprobarConArchiva(compLineas);
				}					
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
	         // Cerramos el fichero
	         try{                    
	            if( null != fr ){ 
	               fr.close();
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
		return false;
	}

	private static boolean ComprobarConArchiva(String[] compLineas) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean ComprobarConMaven(String[] compLineas) {
		// TODO Auto-generated method stub
		return false;
	}
}