package com.innova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.EconomatoDAO;
import com.innova.entity.Economato_Elementos;

@Service
public class EconomatoServiceImpl implements EconomatoService, EconomatoDAO {

	@Autowired
	EconomatoDAO economatoDAO;
	
	
	@Override
	public List<Economato_Elementos> listElementos() {

		List<Economato_Elementos> listElementos = economatoDAO.listElementos();
		return listElementos;
	}
	
}
