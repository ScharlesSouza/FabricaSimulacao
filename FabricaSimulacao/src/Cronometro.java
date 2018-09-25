import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Cronometro {
	
	
	final SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss.SSS");
	
	
	
	
	public Cronometro(Integer qnt_segundos, Integer velocidade) {
		
		Integer momentoLigouForno=0;
		Entidade esteira1 = new Entidade(100, 10, 100, 10, 1000, 1000, "va/H");
		Entidade forno1 = new Entidade(100, 10, 600, 480, 600, 2, "L/H");
		
		//Entidade maquina1 = new Entidade((float)600, 480, (float)35, 25, (float)600, (float)500, "va/H", (float)250);
		//Entidade esteira2 = new Entidade((float)35, 25, (float)35, 10, (float)420, (float)500, "va/H");
		//Entidade resfriador1 = new Entidade((float)35, 25, 10, (float)35, (float)2000, "va/H");
		
		
		esteira1.carrega();
		System.out.println("\n"+HHmmss.format(new Date()) +" => 0  100kg de Materia Prima na esteira1!  - Total: "+esteira1.getCargaAtual());			
			
		for(int i =1; i<=qnt_segundos;i++){
	           
             
			 try {
				Thread.sleep(velocidade);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 	
			 	//verifico a frequencia de entrada na esteira
			 	if(i%esteira1.getFreqEntrada() == 0) {
			 		
			 		//carrego a esteira se houver capacidade
			 		if(esteira1.carrega() || forno1.carrega()) {
			 			System.out.println("\n"+HHmmss.format(new Date()) +" => "+ i+" 100kg de Materia Prima na esteira1!  - Total: "+esteira1.getCargaAtual());			
			 			
			 			//se houver carga suficiente para enche o forno eu tiro da esteira1 para o forno e ligo o forno
			 			if(esteira1.getCargaAtual()>=forno1.getPesoEntrada() && i>0) {
			 				
			 				if(forno1.getPesoCapacidadeMaxima()>forno1.getCargaAtual()) {
			 				
			 					if(forno1.carrega()) {
			 						//descarrega da esteira
			 						esteira1.descarrega(forno1.getPesoEntrada());
			 						System.out.println("\n forno1 com "+forno1.getCargaAtual()+"kg");			
			 						momentoLigouForno = i;
			 					}
			 				}
			 			}		
 						
			 			
			 		}else if((momentoLigouForno + forno1.getTempoProducao()) == i) {
	 					//apos 8 horas libera o forno
	 					forno1.descarrega(600);	
	 					System.out.println("\n forno1 com liberado");
	 					
	 						//implementar a maquina1
	 					
	 				}else {
			 			System.out.println("\n"+HHmmss.format(new Date()) +" => "+ i+" esteira1 cheia!");
			 			
			 			System.out.println("\n forno1 ligado com "+forno1.getCargaAtual()+"kg");
	 				}
			 		
			 		
			 		
			 	}
			 	
			 	
		}
	}
	
	

	public void imprime() {
		
                
	}
	
	

}
