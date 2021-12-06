package com.innova.service;

import java.util.List;

import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.EcoTemporal;
import com.innova.entity.Economato_Elementos;

public interface EconomatoService {
	
	List<Economato_Elementos> listElementos();

	List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo);

	void addElemento(Economato_Elementos nuevoElemento);

	List<EcoBienesUso> listBienesUso();

	int countBienesUso();

	List<EcoBienesUso> listBienesUsoByName(String nombre);
	
	List<EcoBienesUso> listBienesUsoByNameExc(String nombre, List<Integer> excepciones);

	EcoBienesUso getBienById(Integer id);

	List<EcoBienesUso> listBienesUsoByNameInc(List<Integer> excepciones);
	
	void saveMovBu(int bu, int tipoMov, int perId);

	int editBC(int id, int stock, String nombre);

	Economato_Elementos getBCbyId(int id);

	void updateBCestado(int estado, int id);

	int editBU(int id, Integer stock, String nombre);

	void addElementoBU(EcoBienesUso nuevoElemento);

	void updateBUestado(int estado, int id);

	EcoBienesUso getBienByNameId(int id, String nombre);

	void saveMovBien(int mov, int tipoBien, int idBien, int perid, int cant, Integer i);

	List<EcoBienesMov> listMovimientos();

	int getStockBU(int id);

	void updateStockBU(EcoBienesUso bu);

	Economato_Elementos getBienByNameIdBC(int id, String nombre);

	void updateStockBC(Economato_Elementos bc);

	int getStockBC(int id);

	List<EcoTemporal> listBienesCargo(Integer id);

	int getBienCantCargo(Integer id, int id2);

	void updateBienCantCargo(int id, int id2, int id3);

	void saveTemporal(int id, int id2, int cant, int tipoMov);
	 
}
