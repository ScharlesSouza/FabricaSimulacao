import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cronometro {
	
	
	final SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss.SSS");
	
	
	
	
	public Cronometro(Integer qnt_segundos, Integer velocidade) {
		
		
		List<Entidade> listaMaquinario = new ArrayList<Entidade>();
		listaMaquinario.add(new Entidade("Esteira1",100, 10, 100, 10, 1000, 1000, "va/H"));
		listaMaquinario.add(new Entidade("Forno1",100, 10, 600, 480, 600, 2, "L/H"));
		listaMaquinario.add(new Entidade("Maquina1",600, 540, 35, 25, 600, 500, "va/H", 250));
		listaMaquinario.add(new Entidade("Esteira2",35, 25, 35, 25, 420, 500, "va/H"));
		listaMaquinario.add(new Entidade("Resfriador1",35, 25, 35, 10,35, 2000, "va/H"));
		listaMaquinario.add(new Entidade("Caminhao1",35, 35, 1500, 450,1500, 20, "L"));
		
		
		
				
		for(long i =0; i<qnt_segundos;i++){
	           
             
			 try {
				Thread.sleep(velocidade);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 for(int j=0; j<listaMaquinario.size();j++) {
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 if(j==0) {
					 //verifico a frequencia de entrada na primeira maquina- pois o fluxo vai depender desta frequencia
				 	if(i%listaMaquinario.get(j).getFreqEntrada() == 0) {
				 		
				 		//carrego a primeira maquina se houver capacidade
				 		if(listaMaquinario.get(j).carrega()) {
				 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => "+listaMaquinario.get(j).getPesoEntrada()+"kg de Materia Prima em "+listaMaquinario.get(j).getNomeEntidade()+"!  - Total: "+listaMaquinario.get(j).getCargaAtual()+"kg");								
				 			if(listaMaquinario.get(j).getMomentoLigouProximaMaquina()==0) {
				 				listaMaquinario.get(j).setMomentoLigouProximaMaquina(10);
				 			}
				 			
				 			
				 		}
				 	}
				 }
				 if(j>0) {
				 	//verifico o tempo de produçao da maquina anterior - para saber qual a frequencia de entrada na maquina atual
				 	if( (i-listaMaquinario.get(j-1).getMomentoLigouProximaMaquina()) % listaMaquinario.get(j-1).getTempoProducao() == 0) {
				 		
				 		
				 		
				 		//se houver carga suficiente na maquina anterior para colocar materia prima na maquina atual eu transfiro de uma para a outra
			 			if(listaMaquinario.get(j-1).getCargaAtual()>=listaMaquinario.get(j).getPesoEntrada() && i>0) {
			 				
			 				
			 				
			 				if(listaMaquinario.get(j).carrega()) {
			 						
			 						//descarrega a maquina anterior		 						
			 						listaMaquinario.get(j-1).descarrega(listaMaquinario.get(j-1).getPesoSaida());
			 						//descarrega o desperdicio da maquina atual que acabou de ser carregada
			 						listaMaquinario.get(j).descarrega(listaMaquinario.get(j).getDesperdicio());
			 						System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => "+listaMaquinario.get(j).getNomeEntidade()+" com "+listaMaquinario.get(j).getCargaAtual()+"kg");			
			 						
			 						if((i-listaMaquinario.get(j-1).getMomentoLigouProximaMaquina())==0 && listaMaquinario.get(j).getCargaAtual()>=listaMaquinario.get(j).getPesoCapacidadeMaxima()) {
			 							listaMaquinario.get(j).setMomentoLigouProximaMaquina(i);
			 							listaMaquinario.get(j-1).setMomentoLigouProximaMaquina(i);
			 						}
			 							
			 					}
			 					 	
			 					//else {
			 					//	System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => "+listaMaquinario.get(j).getNomeEntidade()+" nao carregou");			
			 						
			 					//}
			 				
			 			}	
			 			
			 			
				 	}//fecha if tempo de producao
				 	
				 	
				 }//fecha if posicao entidade
				  
		 
				}//fecha for J
			 	
		}	 	
	}
	
	

	public void imprime() {
		
                
	}
	
	public String MascaraTempo(long seconds) {
		
		Duration duracao = Duration.ofSeconds(seconds);
		long horas = duracao.toHours();
		long minutos = duracao.minusHours(horas).toMinutes();
		long segundos = duracao.minusHours(horas).minusMinutes(minutos).getSeconds();
		
				
		
		return horas+":"+minutos+":"+segundos;
	}
	
	

}
