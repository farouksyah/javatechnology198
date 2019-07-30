package com.xsis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.xsis.viewmodel.TransactionViewModel;

@Controller
public class TransactionController {

	@RequestMapping("/transaction")
	public String transaction() {
		return ("transaction/transaction");
	}
	
	@ResponseBody
	@RequestMapping(value="/transaction/savetransaction",method=RequestMethod.POST)
	public Map<String,String> savetransaction(@ModelAttribute("transactions") TransactionViewModel transactionviewmodel, Model model){
		
		System.out.println(transactionviewmodel);
		System.out.println(transactionviewmodel.getNofaktur());
		System.out.println(transactionviewmodel.getTglpenjualan());
		System.out.println(transactionviewmodel.getDetailTransaction());
		System.out.println(transactionviewmodel.getTotal());
		System.out.println(transactionviewmodel.getReturncash());
		
		
		Map<String,String> map = new HashMap<>();
		map.put("status", "berhasil");
		return map;
	}
}
