package com.edivanio.springboot.Ionic.enums;

public enum TipoCliente {

	PESSOA_FISICA( 1, "Pessoa Fisica"),
	PESSOA_JURIDICA( 2 , "Pessoa Juridica");

	private int codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoCliente tipo : TipoCliente.values()) {
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
