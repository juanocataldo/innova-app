package com.innova.dao;

import java.util.List;

import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;

public interface EconomatoDAO {

	public List<Economato_Elementos> listElementos();

	public List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo );

	public void addElemento(Economato_Elementos nuevoElemento);

	public List<EcoBienesUso> listBienesUso();

	public int countBienesUso();

	public List<EcoBienesUso> listBienesUsoByName(String nombre);
	public List<EcoBienesUso> listBienesUsoByNameExc(String nombre, List<Integer> excepciones);

	public EcoBienesUso getBienById(Integer id);

	List<EcoBienesUso> listBienesUsoByNameInc(List<Integer> excepciones);

	public void saveMovBu(int bu, int tipoMov, int perId);
	
}
