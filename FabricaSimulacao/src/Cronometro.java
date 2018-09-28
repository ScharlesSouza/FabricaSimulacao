import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Cronometro {
	
	
	final SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss.SSS");
	
	
	
	
	public Cronometro(Integer qnt_segundos, Integer velocidade) {
		
		long momentoLigouForno=0;
		long momentoLigouMaquina = 0;
		Entidade esteira1 = new Entidade(100, 10, 100, 10, 1000, 1000, "va/H");
		Entidade forno1 = new Entidade(100, 10, 600, 480, 600, 2, "L/H");
		Entidade maquina1 = new Entidade(600, 540, 35, 25, 600, 500, "va/H", 250);
		Entidade esteira2 = new Entidade(35, 25, 35, 25, 420, 500, "va/H");
		Entidade resfriador1 = new Entidade(35, 25, 35, 10,35, 2000, "va/H");
		
		
		//Entidade maquina1 = new Entidade((float)600, 480, (float)35, 25, (float)600, (float)500, "va/H", (float)250);
		//Entidade esteira2 = new Entidade((float)35, 25, (float)35, 10, (float)420, (float)500, "va/H");
		//Entidade resfriador1 = new Entidade((float)35, 25, 10, (float)35, (float)2000, "va/H");
		
		
		esteira1.carrega();
		System.out.println("\n"+HHmmss.format(new Date()) +" - 00:00:00 => 100kg de Materia Prima na esteira1!  - Total: "+esteira1.getCargaAtual()+"kg");			
			
		for(long i =1; i<=qnt_segundos;i++){
	           
             
			 try {
				Thread.sleep(velocidade);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 	
			 	//verifico a frequencia de entrada na esteira
			 	if(i%esteira1.getFreqEntrada() == 0) {
			 		
			 		//carrego a esteira se houver capacidade
			 		if(esteira1.carrega() || forno1.getCargaAtual()==0) {
			 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => 100kg de Materia Prima na esteira1!  - Total: "+esteira1.getCargaAtual()+"kg");			
			 			
			 			//se houver carga suficiente para enche o forno eu tiro da esteira1 para o forno e ligo o forno
			 			if(esteira1.getCargaAtual()>=forno1.getPesoEntrada() && i>0) {
			 				
			 				if(forno1.getPesoCapacidadeMaxima()>forno1.getCargaAtual()) {
			 				
			 					if(forno1.carrega()) {
			 						//descarrega da esteira
			 						esteira1.descarrega(forno1.getPesoEntrada());
			 						System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => forno1 com "+forno1.getCargaAtual()+"kg");			
			 						momentoLigouForno = i;
			 					}
			 				}
			 			}		
 						
			 			
			 		}else if((momentoLigouForno + forno1.getTempoProducao()) == i) {
	 					//apos 8 horas libera o forno
	 					forno1.descarrega(600);	
	 					System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => forno1 liberado");
	 					
	 						//implementar a maquina1
	 						momentoLigouMaquina = i;
	 						maquina1.carrega();
	 						maquina1.descarrega(maquina1.getDesperdicio());
	 						System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => Maquina 1 Ligou!");
	 					
	 					
	 				}else {
			 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => esteira1 cheia!");
			 			
			 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => forno1 ligado com "+forno1.getCargaAtual()+"kg");
	 				}
			 		
			 		
			 		
			 	}
			 	//verifico a frequencia de entrada na na maquina
			 	if((i-momentoLigouMaquina)%maquina1.getTempoProducao() == 0 && maquina1.getCargaAtual()>0) {
			 		
			 		
			 		
			 		if(esteira2.getCargaAtual()<esteira2.getPesoCapacidadeMaxima()) {
			 			maquina1.descarrega(35);
				 		esteira2.carrega();
				 		resfriador1.carrega();
			 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => maquina 1 produziu uma peça! \n uma peça em Esteira2 - Total: "+ esteira2.getCargaAtual()+"kg");
				 		
			 		}else {
			 			System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => Esteira2 cheia!");
				 		
			 		}
			 		
			 		
			 	}
			 	//verifico a frequencia de entrada nresfriador
			 	if((i-momentoLigouMaquina)%(maquina1.getTempoProducao()+resfriador1.getTempoProducao()) == 0 && resfriador1.getCargaAtual()>0) {
			 		
			 		
			 		
			 		resfriador1.descarrega(35);
			 		System.out.println("\n"+HHmmss.format(new Date()) +" - "+ MascaraTempo(i*60) +" => resfriador esfriou uma peça em Esteira2");
				 		
			 		
			 		
			 		
			 	}
			 	
			 	
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
