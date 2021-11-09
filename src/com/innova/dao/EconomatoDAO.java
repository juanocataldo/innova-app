package com.innova.dao;

import java.util.List;

import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;

public interface EconomatoDAO {

	public List<Economato_Elementos> listElementos();

	public List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo );

	public void addElemento(Economato_Elementos nuevoElemento);

	public List<EcoBienesUso> listBienesUso();

	public int countBienesUso();

	public List<EcoBienesUso> listBienesUsoByName(String nombre);
}
