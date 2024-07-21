import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Envie o caminho para a pasta.\n Exemplo: D:\\\\Jogos\\\\osu!\\\\Skins\\\\-#(SK) Mathi 1.0 - DT");
    	String caminhoImg = scanner.nextLine();
        //String caminhoImg = "D:\\Jogos\\osu!\\Skins\\-            #(SK) Mathi 1.0 - DT";
        
        File directory = new File(caminhoImg);
        
        String keyword = "@2x";
        
        System.out.println("Deseja mesmo deletar todos os @2x? [S/N]");
        String escolha = scanner.nextLine();
        
        if(escolha.equals("S")) {
	        if (directory.exists() && directory.isDirectory()) {
	            File[] files = directory.listFiles();
	            
	            if (files != null && files.length > 0) {
	            	boolean encontrouArquivo = false;
	            	for(File file : files) {
	            		if (file.isFile() && file.getName().contains(keyword)) {
	            			boolean deleted = file.delete();
	            			if(deleted) {
	            				encontrouArquivo = true;
	            				System.out.println("Arquivo deletado: " + file.getName());
	            			}
	            		}
	            	}
	            	  if (!encontrouArquivo) {
	                      System.out.println("Nenhum arquivo contendo '" + keyword + "' foi encontrado.");
	                  }
	            }
	        }
	        else {
	        	System.out.println("O diretório especificado não existe.");
	        }
        } 
        else if(escolha.equals("N")) {
        	System.exit(0);
	    } 
        else {
        	System.out.println("Selecione uma resposta válida.");
	    }
        
        scanner.close();
    }
}
