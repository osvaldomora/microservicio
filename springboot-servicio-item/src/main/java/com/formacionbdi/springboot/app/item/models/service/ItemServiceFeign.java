package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

import feign.codec.DecodeException;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		System.out.println("in method");
		try {
		clienteFeign.listar();
		}
		catch (DecodeException e) {
			System.out.println("causa:"+e.getCause());
			e.printStackTrace();
//			System.out.println("2mess:"+e.contentUTF8());
//			System.out.println(e.);
			
		}
		
		return null;// clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
