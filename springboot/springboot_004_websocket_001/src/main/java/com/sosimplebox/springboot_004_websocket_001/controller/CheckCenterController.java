package com.sosimplebox.springboot_004_websocket_001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sosimplebox.springboot_004_websocket_001.websocketServer.WebSocketServer;

@Controller
@RequestMapping("/checkCenter")
public class CheckCenterController {
	@GetMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("cid", cid);
		return mav;
	}
	
	@RequestMapping("/socket/push/{cid}")
	@ResponseBody
	public String pushToWeb(@PathVariable String cid, String message) {
		try {
			WebSocketServer.sendInfo(message, cid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}
