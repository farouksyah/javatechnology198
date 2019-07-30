package com.xsis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.xsis.service.BarangService;
import com.xsis.model.Barang;

@Controller
public class BarangController {
	
	@Autowired
	private BarangService brngsr;
	
	@RequestMapping(value="/barang",method=RequestMethod.GET)
	public String barang(HttpSession httpSession ,HttpServletRequest request, Model model) {

		// Print session yang telah di register
		// menggunakan HttpSession
		// cetak dengan mengambil keynya "Username"
		System.out.println(httpSession.getAttribute("Username"));
		
		// menggunakan HttpServletRequest
		// cetak dengan mengambil key nya "Kota"		
		System.out.println(request.getSession().getAttribute("Kota"));
		
		// Untuk membawa value ke Html
		// menggunakan model dan addAttribute
		// Key = "Kota"
		// Value = diambil dari session yang telah di register dari HomeController
		model.addAttribute("Kota",request.getSession().getAttribute("Kota"));
		
		
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
	public Map<String,String> savebarang(@ModelAttribute("barangs") Barang barangs, Model model) {
		
		System.out.println(barangs);
		//brngsr.save(barangs);
		
		Map<String,String>  map= new HashMap<>();
		
		if (brngsr.simpan(barangs)) {
			map.put("status", "berhasil");
		} else {
			map.put("status", "gagal");
		}
		
		
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/deletebarang/{angka}",method=RequestMethod.DELETE)
	public Map<String,String> savebarang(@PathVariable("angka") Long angka, Model model) {
		
		System.out.println(angka);
		brngsr.hapus(angka);
		
		Map<String,String>  map= new HashMap<>();
		map.put("status", "berhasil");
		/*
		if (brngsr.simpan(barangs)) {
			map.put("status", "berhasil");
		} else {
			map.put("status", "gagal");
		}
		*/
		
		
		return map;
	}
	
}
