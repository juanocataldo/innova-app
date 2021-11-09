package com.innova.service;

import java.util.List;

import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;

public interface EconomatoService {
	
	List<Economato_Elementos> listElementos();

	List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo);

	void addElemento(Economato_Elementos nuevoElemento);

	List<EcoBienesUso> listBienesUso();

	int countBienesUso();

	List<EcoBienesUso> listBienesUsoByName(String nombre);	
}
