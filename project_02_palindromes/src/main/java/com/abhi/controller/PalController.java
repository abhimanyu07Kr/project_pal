package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.Entity.PalData;
import com.abhi.Service.PalService;

@Controller
public class PalController {

	
	@Autowired
	private PalService palSer;
	
	@GetMapping("/")
	public String getIndex(Model model)
	{
		model.addAttribute("greet", "Check String is palindrome are not");
		return "index";
	}
	
	@PostMapping("/pal")
	public String ispalindromes(@RequestParam("str") String str,Model model)
	{
		PalData pp = new PalData();
		int i=0,j=str.length()-1;
		boolean b=true;
		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j)) {
				b=false;
				break;
			}
			i++;
			j--;
		}
		if(b) {
			pp.setPalStr(str);
			pp.setYes("yes");
			pp.setNo("-");
			boolean flag = palSer.palSave(pp);
			System.out.println(flag);
			if(flag)
			{
				model.addAttribute("save", "Given data is saved in Database");
			}else
			{
				model.addAttribute("save", "Given data is not saved in Database  because this string is already present in DB");
			}
			model.addAttribute("msg", str+" is palindrome String");
		}else
		{
			pp.setPalStr(str);
			pp.setNo("No");
			pp.setYes("-");
			boolean flag = palSer.palSave(pp);
			
			if(flag)
			{
				model.addAttribute("save", "Given data is saved in Database");
			}else
			{
				model.addAttribute("save", "Given data is not saved in Database because this string is already present in DB");
			}
//			model.addAttribute("save", "Given data is not saved");
			model.addAttribute("msg", str+" is not palindrome String");
		}
		
		return "result";
	}
	
	@GetMapping("/all")
	public String getAll(Model model)
	{
		List<PalData> all = palSer.getAll();
		
		model.addAttribute("allData", all);
		return "data";
	}
}
