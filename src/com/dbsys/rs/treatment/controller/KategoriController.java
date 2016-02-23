package com.dbsys.rs.treatment.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbsys.rs.ApplicationException;
import com.dbsys.rs.EntityRestMessage;
import com.dbsys.rs.ListEntityRestMessage;
import com.dbsys.rs.RestMessage;
import com.dbsys.rs.treatment.entity.KategoriTindakan;
import com.dbsys.rs.treatment.service.KategoriService;

@Controller
@RequestMapping("/kategori")
public class KategoriController {

	@Autowired
	private KategoriService kategoriService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<KategoriTindakan> simpan(@RequestBody KategoriTindakan kategori) throws ApplicationException, PersistenceException {
		kategori = kategoriService.simpan(kategori);
		return new EntityRestMessage<KategoriTindakan>(kategori);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public EntityRestMessage<KategoriTindakan> getById(@PathVariable Long id) throws ApplicationException, PersistenceException {
		KategoriTindakan kategori = kategoriService.getById(id);
		return new EntityRestMessage<KategoriTindakan>(kategori);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<KategoriTindakan> getAll() throws ApplicationException, PersistenceException {
		List<KategoriTindakan> list = kategoriService.getAll();
		return new ListEntityRestMessage<KategoriTindakan>(list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test/test")
	@ResponseBody
	public RestMessage test() throws ApplicationException, PersistenceException {
		return RestMessage.success();
	}
}
