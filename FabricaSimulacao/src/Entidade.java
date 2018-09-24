
public class Entidade {
	
	public Float pesoEntrada;	
	private Integer freqEntrada;
	private Float pesoSaida;
	private Integer tempoProducao;
	private Float pesoCapacidadeMaxima;
	private Float consumo;
	private String tipoConsumo;
	private Float desperdicio;
	
	//construtor para  o resfriador - sem peso de capacidade
		public Entidade(Float pesoEntrada, Integer freqEntrada, Integer tempoProducao,
				Float pesoSaida, Float consumo, String tipoConsumo) {
			this.setPesoEntrada(pesoEntrada);
			this.setFreqEntrada(freqEntrada);
			this.setPesoSaida(pesoSaida);
			this.setTempoProducao(tempoProducao);
			this.setConsumo(consumo);
			this.setTipoConsumo(tipoConsumo);
			
		}
		
		//construtor para a maquina que prepara a materia prima - com desperdicio
		public Entidade(Float pesoEntrada, Integer freqEntrada, Float pesoSaida, Integer tempoProducao,
				Float pesoCapacidadeMaxima, Float consumo, String tipoConsumo, Float desperdicio) {
			
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
		public Entidade(Float pesoEntrada, Integer freqEntrada, Float pesoSaida, Integer tempoProducao,
				Float pesoCapacidadeMaxima, Float consumo, String tipoConsumo) {
			
			this.setPesoEntrada(pesoEntrada);
			this.setFreqEntrada(freqEntrada);
			this.setPesoSaida(pesoSaida);
			this.setTempoProducao(tempoProducao);
			this.setPesoCapacidadeMaxima(pesoCapacidadeMaxima);
			this.setConsumo(consumo);
			this.setTipoConsumo(tipoConsumo);
			
		}
	
	
	public Float getPesoEntrada() {
		return pesoEntrada;
	}
	public void setPesoEntrada(Float pesoEntrada) {
		this.pesoEntrada = pesoEntrada;
	}
	public Integer getFreqEntrada() {
		return freqEntrada;
	}
	public void setFreqEntrada(Integer freqEntrada) {
		this.freqEntrada = freqEntrada;
	}
	public Float getPesoSaida() {
		return pesoSaida;
	}
	public void setPesoSaida(Float pesoSaida) {
		this.pesoSaida = pesoSaida;
	}
	public Integer getTempoProducao() {
		return tempoProducao;
	}
	public void setTempoProducao(Integer tempoProducao) {
		this.tempoProducao = tempoProducao;
	}
	public Float getPesoCapacidadeMaxima() {
		return pesoCapacidadeMaxima;
	}
	public void setPesoCapacidadeMaxima(Float pesoCapacidadeMaxima) {
		this.pesoCapacidadeMaxima = pesoCapacidadeMaxima;
	}
	public Float getConsumo() {
		return consumo;
	}
	public void setConsumo(Float consumo) {
		this.consumo = consumo;
	}
	public String getTipoConsumo() {
		return tipoConsumo;
	}
	public void setTipoConsumo(String tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}
	public Float getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(Float desperdicio) {
		this.desperdicio = desperdicio;
	}
	
	
	
	
}
