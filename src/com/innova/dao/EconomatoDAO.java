package com.innova.dao;

import java.util.List;

import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.EcoTemporal;
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

	public int editBC(int id, int stock, String nombre);

	public Economato_Elementos getBCbyId(int id);

	public void updateBCestado(int estado, int id);

	public int editBU(int id, Integer stock, String nombre);

	public void addElementoBU(EcoBienesUso nuevoElemento);

	public void updateBUestado(int estado, int id);

	public EcoBienesUso getBienByNameId(int id, String nombre);

	public void saveMovBien(int mov, int tipoBien, int idBien, int perid, int cant, Integer temp);

	public List<EcoBienesMov> listMovimientos();

	public int getStockBU(int id);

	public void updateStock(EcoBienesUso bu);

	public Economato_Elementos getBienByNameIdBC(int id, String nombre);

	public void updateStock(Economato_Elementos bc);

	public int getStockBC(int id);

	public List<EcoTemporal> listBienesCargo(Integer id);

	public int getBienCantCargo(Integer id, int id2);

	public void updateBienCantCargo(int id, int id2, int id3);

	public void saveTemporal(int id, int id2, int cant, int tipoMov);
	
}
