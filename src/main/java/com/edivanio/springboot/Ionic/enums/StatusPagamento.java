package com.edivanio.springboot.Ionic.enums;

public enum StatusPagamento {

	PENDENTE( 1, "Pendente"),
	PAGAMENTO_EFETUADO( 2 , "Pagamento Efetuado"),
	CANCELADO(3,"Cancelado");

	private int codigo;
	private String descricao;
	
	private StatusPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static StatusPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (StatusPagamento tipo : StatusPagamento.values()) {
			if(cod.equals(tipo.getCodigo())){
				return tipo;
			}
		}
		throw new IllegalArgumentException("Id ivalido" + cod);
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	

	
	
}
