package stock.inventory.springbootcrudapi.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.inventory.springbootcrudapi.model.CapsuleStock;
import stock.inventory.springbootcrudapi.request.SaveCapsuleStockRequest;
import stock.inventory.springbootcrudapi.request.UpdateCapsuleStockRequest;
import stock.inventory.springbootcrudapi.response.SaveOrUpdateCapsuleStockResponse;
import stock.inventory.springbootcrudapi.service.CapsuleStockService;

@RestController
@RequestMapping("/api")
public class CapsuleStockController {
	
	@Autowired
	private CapsuleStockService capsuleStockService;
	
	@GetMapping("/capsule/get_all_capsule_stock")
	public List<CapsuleStock> getCapsuleStockFull() {
		return capsuleStockService.getCapsuleStockFull();
	}
	
	@PostMapping("/capsule/create_capsule_stock")
	public SaveOrUpdateCapsuleStockResponse createCapsuleStock(@RequestBody SaveCapsuleStockRequest saveCapsuleStockRequest) throws Exception {
		//response {
		//			"itemOwner": "stella",
		//			"itemId": 123,
		//			"tradeAction": "Buy",
		//			"quantity": 123,
		//			"buyinPrice": 1.0,
		//			"cashoutPrice": 1.0,
		//			"tradeTime": "2022-02-20T00:00:00",
		//			"buffUrl": "1"
		//			}
		
		CapsuleStock capsuleStock = new CapsuleStock(); //empty entity
		SaveOrUpdateCapsuleStockResponse response = new SaveOrUpdateCapsuleStockResponse(); //response api format
		//List<CapsuleStock> data = new ArrayList<>();//saved data array list if data contain multiple array
		Float buyInPrice = saveCapsuleStockRequest.getBuyInPrice();
		Float cashoutPrice = saveCapsuleStockRequest.getCashoutPrice();
		
		//LocalDateTime tradeTime = saveCapsuleStockRequest.getTradeTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String saveSuccessOrFail = "Failed";
		
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
		if(!saveCapsuleStockRequest.getTradeTime().toString().isEmpty()) {
			capsuleStock.setTradeTime(format.parse(saveCapsuleStockRequest.getTradeTime()));
		} else {
			capsuleStock.setTradeTime(currentDate);
		}
		if(saveCapsuleStockRequest.getBuffUrl() != null) {
			capsuleStock.setBuffUrl(saveCapsuleStockRequest.getBuffUrl());
		}
		
		response.setCode("SAVE-CAPSULE-FAIL");
		response.setStatus(saveSuccessOrFail);
		response.setError(null);
		response.setData(null);
		
		try {
			if(capsuleStock.getItemOwner().isEmpty()) {
				response.setMsg("Item Owner is missing");
			} else if(capsuleStock.getItemId() == null) {
				response.setMsg("Item Name is missing");
			} else if(capsuleStock.getTradeAction().isEmpty()) {
				response.setMsg("Trade Action is missing");
			} else if(!capsuleStock.getTradeAction().toLowerCase().equals("buy") && !capsuleStock.getTradeAction().toLowerCase().equals("sell")) {
				response.setMsg("Incorrect Trade Action");
			} else if(capsuleStock.getQuantity() == null) {
				response.setMsg("Quantity is missing");
			} else {
				saveSuccessOrFail = capsuleStockService.saveOrUpdateCapsuleStock(capsuleStock);
				response.setCode("SAVE-CAPSULE-SUCCESS");
				response.setStatus(saveSuccessOrFail);
				response.setError(null);
				response.setMsg("Saved capsule trade record successfully");
				response.setData(capsuleStock);
			}
		} catch (Exception e) {
			response.setError(e.getMessage());
			response.setStatus(saveSuccessOrFail);
			response.setCode("SAVE-CAPSULE-ERROR");
			response.setMsg("Error occupied when saving capsule trade record.");
			response.setData(null);
		}
		return response;
	}
	
	@PutMapping("/capsule/update_capsule_stock")
	public SaveOrUpdateCapsuleStockResponse updateCapsuleStock(@RequestBody UpdateCapsuleStockRequest updateCapsuleStockRequest) throws Exception {
		//response {
		//			"tradeId": "1",
		//			"itemOwner": "stella",
		//			"itemId": 123,
		//			"tradeAction": "Buy",
		//			"quantity": 123,
		//			"buyinPrice": 1.0,
		//			"cashoutPrice": 1.0,
		//			"tradeTime": "2022-02-20T00:00:00",
		//			"buffUrl": "1"
		//			}
		CapsuleStock capsuleStock = new CapsuleStock();
		SaveOrUpdateCapsuleStockResponse response = new SaveOrUpdateCapsuleStockResponse();
		Float buyInPrice = updateCapsuleStockRequest.getBuyInPrice();
		Float cashoutPrice = updateCapsuleStockRequest.getCashoutPrice();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String updateSuccessOrFail = "Failed";

		capsuleStock.setTradeId(updateCapsuleStockRequest.getTradeId());
		capsuleStock.setItemOwner(updateCapsuleStockRequest.getItemOwner());
		capsuleStock.setItemId(updateCapsuleStockRequest.getItemId());
		capsuleStock.setTradeAction(updateCapsuleStockRequest.getTradeAction());
		capsuleStock.setQuantity(updateCapsuleStockRequest.getQuantity());
		if(buyInPrice != null && buyInPrice != 0.0f) {
			capsuleStock.setBuyInPrice(updateCapsuleStockRequest.getBuyInPrice());
		}
		if(cashoutPrice != null && cashoutPrice != 0.0f) {
			capsuleStock.setCashoutPrice(updateCapsuleStockRequest.getCashoutPrice());
		}
		if(!updateCapsuleStockRequest.getTradeTime().toString().isEmpty()) {
			capsuleStock.setTradeTime(format.parse(updateCapsuleStockRequest.getTradeTime()));
		} else {
			capsuleStock.setTradeTime(currentDate);
		}
		if(updateCapsuleStockRequest.getBuffUrl() != null) {
			capsuleStock.setBuffUrl(updateCapsuleStockRequest.getBuffUrl());
		}
		
		response.setCode("UPDATE-CAPSULE-FAIL");
		response.setStatus(updateSuccessOrFail);
		response.setError(null);
		response.setData(null);
		
		try {
			if(capsuleStock.getTradeId() == null) {
				response.setMsg("Trade ID is missing");
			} else if(capsuleStock.getItemOwner().isEmpty()) {
				response.setMsg("Item Owner is missing");
			} else if(capsuleStock.getItemId() == null) {
				response.setMsg("Item Name is missing");
			} else if(capsuleStock.getTradeAction().isEmpty()) {
				response.setMsg("Trade Action is missing");
			} else if(!capsuleStock.getTradeAction().toLowerCase().equals("buy") && !capsuleStock.getTradeAction().toLowerCase().equals("sell")) {
				response.setMsg("Incorrect Trade Action");
			} else if(capsuleStock.getQuantity() == null) {
				response.setMsg("Quantity is missing");
			} else {
				updateSuccessOrFail = capsuleStockService.saveOrUpdateCapsuleStock(capsuleStock);
				response.setCode("UPDATE-CAPSULE-SUCCESS");
				response.setStatus(updateSuccessOrFail);
				response.setError(null);
				response.setMsg("Updated capsule trade record successfully");
				response.setData(capsuleStock);
			}
		} catch (Exception e) {
			response.setError(e.getMessage());
			response.setStatus(updateSuccessOrFail);
			response.setCode("UPDATE-CAPSULE-ERROR");
			response.setMsg("Error occupied when updating capsule trade record.");
			response.setData(null);
		}
		return response;
	}

	//delete
}
