package com.xsis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import com.xsis.service.BarangService;
import com.xsis.model.Barang;

@Controller
public class BarangController {
	
	@Autowired
	private BarangService brngsr;
	
	@RequestMapping(value="/barang",method=RequestMethod.GET)
	public String barang() {
		return ("barang/barang");
	}
	
	@RequestMapping("/listbarang")
	public String listbarang(Model mdl) {
		
		List<Barang> barangs = brngsr.listall();
		
		mdl.addAttribute("keybarang", barangs);
		
		
		
		return ("barang/listbarang");
	}
	
	@RequestMapping(value="/newbarang", method=RequestMethod.GET)
	public String newbarang(Model model) {
		Barang barang = new Barang();
		
		model.addAttribute("kbarang", barang);
		
		return ("barang/newbarang");
	}
	
	@ResponseBody
	@RequestMapping(value="/savebarang",method=RequestMethod.POST)
	public Map<String,String> savebarang(@ModelAttribute("barangs") Barang barangs,Model model) {
		
		System.out.println(barangs);
		//brngsr.save(barangs);
		
		Map<String,String>  map= new HashMap<>();
		
		map.put("status", "berhasil");
		
		return map;
	}
	
}
