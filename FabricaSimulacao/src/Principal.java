import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner leitor;
		leitor = new Scanner(System.in);
		int qnt_segundos, velocidade;
		
		System.out.println("Quantos segundos deseja simular?");
		qnt_segundos = leitor.nextInt();
		
		System.out.println("Duração de cada segundo(MS)?");
		velocidade = leitor.nextInt();
		
		
		Cronometro cronometro = new Cronometro(qnt_segundos,velocidade);
		
		
				
		
		
		

	}

}
