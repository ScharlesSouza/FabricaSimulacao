
public class Entidade {
	
	private Integer pesoEntrada;	
	private Integer freqEntrada;
	private Integer pesoSaida;
	private Integer tempoProducao;
	private Integer pesoCapacidadeMaxima;
	private Integer consumo;
	private String tipoConsumo;
	private Integer desperdicio;
	private Integer cargaAtual=0;
	
	//construtor 
	public Entidade() {
				
	}
	
	//construtor para  o resfriador - sem peso de capacidade e sem desperdicio
		public Entidade(Integer pesoEntrada, Integer freqEntrada, Integer tempoProducao,
				Integer pesoSaida, Integer consumo, String tipoConsumo) {
			this.setPesoEntrada(pesoEntrada);
			this.setFreqEntrada(freqEntrada);
			this.setPesoSaida(pesoSaida);
			this.setTempoProducao(tempoProducao);
			this.setConsumo(consumo);
			this.setTipoConsumo(tipoConsumo);
			
		}
		
		//construtor para a maquina que prepara a materia prima - com desperdicio
		public Entidade(Integer pesoEntrada, Integer freqEntrada, Integer pesoSaida, Integer tempoProducao,
				Integer pesoCapacidadeMaxima, Integer consumo, String tipoConsumo, Integer desperdicio) {
			
			this.setPesoEntrada(pesoEntrada);
			this.setFreqEntrada(freqEntrada);
			this.setPesoSaida(pesoSaida);
			this.setTempoProducao(tempoProducao);
			this.setPesoCapacidadeMaxima(pesoCapacidadeMaxima);
			this.setConsumo(consumo);
			this.setTipoConsumo(tipoConsumo);
			this.setDesperdicio(desperdicio);
		}
		
		//construtor para as demais entidades
		public Entidade(Integer pesoEntrada, Integer freqEntrada, Integer pesoSaida, Integer tempoProducao,
				Integer pesoCapacidadeMaxima, Integer consumo, String tipoConsumo) {
			
			this.setPesoEntrada(pesoEntrada);
			this.setFreqEntrada(freqEntrada);
			this.setPesoSaida(pesoSaida);
			this.setTempoProducao(tempoProducao);
			this.setPesoCapacidadeMaxima(pesoCapacidadeMaxima);
			this.setConsumo(consumo);
			this.setTipoConsumo(tipoConsumo);
			
		}
	
	
	public Integer getPesoEntrada() {
		return pesoEntrada;
	}
	public void setPesoEntrada(Integer pesoEntrada) {
		this.pesoEntrada = pesoEntrada;
	}
	
	public boolean carrega() {
		
		boolean livre;
		if(getCargaAtual()+getPesoEntrada() <= pesoCapacidadeMaxima) {
		this.cargaAtual = getPesoEntrada()+getCargaAtual();
			livre=true;
		}else {
			livre=false;
		}
		return livre;
	}
	
	public Integer getCargaAtual() {
		return cargaAtual;
	}
public boolean descarrega(Integer valor) {
		
		boolean contemItem;
		if(getCargaAtual()-valor >=0) {
		this.cargaAtual = getCargaAtual()-valor;
			contemItem=true;
		}else {
			contemItem=false;
		}
		return contemItem;
	}
	

	
	public Integer getFreqEntrada() {
		return freqEntrada;
	}
	public void setFreqEntrada(Integer freqEntrada) {
		this.freqEntrada = freqEntrada;
	}
	public Integer getPesoSaida() {
		return pesoSaida;
	}
	public void setPesoSaida(Integer pesoSaida) {
		this.pesoSaida = pesoSaida;
	}
	public Integer getTempoProducao() {
		return tempoProducao;
	}
	public void setTempoProducao(Integer tempoProducao) {
		this.tempoProducao = tempoProducao;
	}
	public Integer getPesoCapacidadeMaxima() {
		return pesoCapacidadeMaxima;
	}
	public void setPesoCapacidadeMaxima(Integer pesoCapacidadeMaxima) {
		this.pesoCapacidadeMaxima = pesoCapacidadeMaxima;
	}
	public Integer getConsumo() {
		return consumo;
	}
	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}
	public String getTipoConsumo() {
		return tipoConsumo;
	}
	public void setTipoConsumo(String tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}
	public Integer getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}

	
	
	
	
}
