package stock.inventory.springbootcrudapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.inventory.springbootcrudapi.model.CapsuleStock;
import stock.inventory.springbootcrudapi.request.SaveCapsuleStockRequest;
import stock.inventory.springbootcrudapi.response.SaveCapsuleStockResponse;
import stock.inventory.springbootcrudapi.service.CapsuleStockService;

@RestController
@RequestMapping("/api")
public class CapsuleStockController {
	
	@Autowired
	private CapsuleStockService capsuleStockService;
	
	@GetMapping("/capsule_stock")
	public List<CapsuleStock> getCapsuleStockFull() {
		return capsuleStockService.getCapsuleStockFull();
	}
	
	@PostMapping("/capsule_stock")
	public SaveCapsuleStockResponse saveCapsuleStock(@RequestBody SaveCapsuleStockRequest saveCapsuleStockRequest) {
		CapsuleStock capsuleStock = new CapsuleStock(); //Entity
		SaveCapsuleStockResponse response = new SaveCapsuleStockResponse(); //response api format
		//List<SaveCapsuleStockResponse> data = new ArrayList();//saved data array list
		Float buyInPrice = saveCapsuleStockRequest.getBuyInPrice();
		Float cashoutPrice = saveCapsuleStockRequest.getCashoutPrice();
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		capsuleStock.setItemOwner(saveCapsuleStockRequest.getItemOwner());
		capsuleStock.setItemId(saveCapsuleStockRequest.getItemId());
		capsuleStock.setTradeAction(saveCapsuleStockRequest.getTradeAction());
		capsuleStock.setQuantity(saveCapsuleStockRequest.getQuantity());
		if(buyInPrice != null && buyInPrice != 0.0f) {
			capsuleStock.setBuyInPrice(saveCapsuleStockRequest.getBuyInPrice());
		}
		if(cashoutPrice != null && cashoutPrice != 0.0f) {
			capsuleStock.setCashoutPrice(saveCapsuleStockRequest.getCashoutPrice());
		}
		if(saveCapsuleStockRequest.getTradeTime() != null) {
			capsuleStock.setTradeTime(saveCapsuleStockRequest.getTradeTime());
		} else {
			capsuleStock.setTradeTime(currentDateTime);
		}
		if(saveCapsuleStockRequest.getBuffUrl() != null) {
			capsuleStock.setBuffUrl(saveCapsuleStockRequest.getBuffUrl());
		}
		
		try {
			capsuleStockService.saveCapsuleStock(capsuleStock);
			response.setCode("SAVE-SUS-0001");
			//response.setStatus
			response.setError(null);
			response.setMsg("Saved capsule trade record successfully");
			//response.setData(data);
		} catch (Exception e) {
			response.setCode("SAVE-ERR-0001");
			//response.setStatus
			response.setError(e.getMessage());
			response.setMsg("Error occupied when saving capsule trade record.");
			response.setData(null);
		}
		
		return response;
	}
}
