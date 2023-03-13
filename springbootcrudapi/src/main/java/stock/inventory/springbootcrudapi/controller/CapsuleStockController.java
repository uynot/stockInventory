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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.inventory.springbootcrudapi.model.CapsuleStock;
import stock.inventory.springbootcrudapi.request.SaveCapsuleStockRequest;
import stock.inventory.springbootcrudapi.request.UpdateCapsuleStockRequest;
import stock.inventory.springbootcrudapi.response.CapsuleStockGetResponse;
import stock.inventory.springbootcrudapi.response.CapsuleStockResponse;
import stock.inventory.springbootcrudapi.service.CapsuleStockService;

@RestController
@RequestMapping("/api")
public class CapsuleStockController {
	
	@Autowired
	private CapsuleStockService capsuleStockService;
	
	@GetMapping("/capsule/getCapsuleStockFull")
	public CapsuleStockGetResponse getCapsuleStockFull() { // CHANGE TO return response
		CapsuleStockGetResponse response = new CapsuleStockGetResponse();
		List<CapsuleStock> dataList = new ArrayList<CapsuleStock>();
		
		response.setCode("GET-CAPSULE-FAIL");
		response.setStatus("Failed");
		response.setError(null);
		response.setData(null);
		
		try {
			dataList = capsuleStockService.getCapsuleStockFull();
			
			if(dataList == null) {
				response.setCode("GET-CAPSULE-SUCCESS");
				response.setStatus("Success");
				response.setMsg("Record not found");
			} else {
				response.setData(dataList);
				response.setCode("GET-CAPSULE-SUCCESS");
				response.setStatus("Success");
				response.setMsg("Get capsule trade record successfully");
			}
		} catch(Exception e) {
			response.setError(e.getMessage());
			response.setCode("GET-CAPSULE-ERROR");
			response.setMsg("Error occupied when getting capsule trade record.");
		}
		
		return response;
	}
	
	@GetMapping("/capsule/getCapsuleStock/{tradeId}")
	public CapsuleStockResponse getCapsuleStockSingle(@PathVariable Integer tradeId) throws Exception {
		//require	{
		//				"23"
		//			}
		CapsuleStockResponse response = new CapsuleStockResponse();
		CapsuleStock capsuleStock = new CapsuleStock();
		String getSuccessOrFail = "Failed";
		
		response.setCode("GET-CAPSULE-FAIL");
		response.setStatus(getSuccessOrFail);
		response.setError(null);
		response.setData(null);
		
		try {
			capsuleStock = capsuleStockService.getCapsuleStockSingle(tradeId);
			
			if(capsuleStock == null) {
				response.setCode("GET-CAPSULE-SUCCESS");
				response.setMsg("Record not found");
				response.setStatus("Success");
				//throw new RuntimeException("Record not found");
			} else {
				response.setMsg("Get capsule trade record " + tradeId + " successfully");
				response.setCode("GET-CAPSULE-SUCCESS");
				response.setStatus("Success");
				response.setData(capsuleStock);
			}
		} catch(Exception e) {
			response.setError(e.getMessage());
			response.setCode("GET-CAPSULE-ERROR");
			response.setMsg("Error occupied when getting capsule trade record " + tradeId + ".");
		}
		
		return response;
	}
	
	@PostMapping("/capsule/createCapsuleStock")
	public CapsuleStockResponse createCapsuleStock(@RequestBody SaveCapsuleStockRequest saveCapsuleStockRequest) throws Exception {
		//require	{
		//				"itemOwner": "stella",
		//				"itemId": 123,
		//				"tradeAction": "Buy",
		//				"quantity": 123,
		//				"buyinPrice": 1.0,
		//				"cashoutPrice": 1.0,
		//				"tradeTime": "2022-02-20T00:00:00",
		//				"buffUrl": "1"
		//			}
		
		CapsuleStock capsuleStock = new CapsuleStock();
		CapsuleStockResponse response = new CapsuleStockResponse();
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
				response.setMsg("Invalid Item Owner");
			} else if(capsuleStock.getItemId() == null) {
				response.setMsg("Invalid Item Name");
			} else if(capsuleStock.getTradeAction().isEmpty()) {
				response.setMsg("Invalid Trade Action");
			} else if(capsuleStock.getTradeAction().isEmpty() || 
					(!capsuleStock.getTradeAction().toLowerCase().equals("buy") && !capsuleStock.getTradeAction().toLowerCase().equals("sell"))) {
				response.setMsg("Invalid Incorrect");
			} else if(capsuleStock.getQuantity() == null) {
				response.setMsg("Invalid Quantity");
			} else {
				saveSuccessOrFail = capsuleStockService.saveOrUpdateCapsuleStock(capsuleStock);
				response.setCode("SAVE-CAPSULE-SUCCESS");
				response.setStatus(saveSuccessOrFail);
				response.setMsg("Saved capsule trade record successfully");
				response.setData(capsuleStock);
			}
		} catch (Exception e) {
			response.setError(e.getMessage());
			response.setCode("SAVE-CAPSULE-ERROR");
			response.setMsg("Error occupied when saving capsule trade record.");
		}
		return response;
	}
	
	@PutMapping("/capsule/updateCapsuleStock")
	public CapsuleStockResponse updateCapsuleStock(@RequestBody UpdateCapsuleStockRequest updateCapsuleStockRequest) throws Exception {
		//require	{
		//				"tradeId": "1",
		//				"itemOwner": "stella",
		//				"itemId": 123,
		//				"tradeAction": "Buy",
		//				"quantity": 123,
		//				"buyinPrice": 1.0,
		//				"cashoutPrice": 1.0,
		//				"tradeTime": "2022-02-20T00:00:00",
		//				"buffUrl": "1"
		//			}
		CapsuleStock capsuleStock = new CapsuleStock();
		CapsuleStockResponse response = new CapsuleStockResponse();
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
				response.setMsg("Invalid Trade ID");
			} else if(capsuleStock.getItemOwner().isEmpty()) {
				response.setMsg("Invalid Item Owner");
			} else if(capsuleStock.getItemId() == null) {
				response.setMsg("Invalid Item Name");
			} else if(capsuleStock.getTradeAction().isEmpty() || 
					(!capsuleStock.getTradeAction().toLowerCase().equals("buy") && !capsuleStock.getTradeAction().toLowerCase().equals("sell"))) {
				response.setMsg("Invalid Trade Action");
			} else if(capsuleStock.getQuantity() == null) {
				response.setMsg("Invalid Quantity");
			} else {
				updateSuccessOrFail = capsuleStockService.saveOrUpdateCapsuleStock(capsuleStock);
				response.setCode("UPDATE-CAPSULE-SUCCESS");
				response.setStatus(updateSuccessOrFail);
				response.setMsg("Updated capsule trade record successfully");
				response.setData(capsuleStock);
			}
		} catch(Exception e) {
			response.setError(e.getMessage());
			response.setCode("UPDATE-CAPSULE-ERROR");
			response.setMsg("Error occupied when updating capsule trade record.");
		}
		return response;
	}
	
	@DeleteMapping("/capsule/deleteCapsuleStock/{tradeId}")
	public CapsuleStockResponse deleteCapsuleStock(@PathVariable Integer tradeId) throws Exception {
		//require	{
		//				"23"
		//			}
		CapsuleStockResponse response = new CapsuleStockResponse();
		CapsuleStock capsuleStock = new CapsuleStock();
		String deleteSuccessOrFail = "Failed";
		
		response.setCode("DELETE-CAPSULE-FAIL");
		response.setStatus(deleteSuccessOrFail);
		response.setError(null);
		response.setData(null);
		
		try {
			if(tradeId == null || tradeId == 0) {
				response.setMsg("Invalid Trade ID");
			} else {
				capsuleStock = capsuleStockService.getCapsuleStockSingle(tradeId);
				if(capsuleStock == null) {
					response.setMsg("Record not found");
					throw new RuntimeException("Record not found");
				} else {
					deleteSuccessOrFail = capsuleStockService.deleteCapsuleStock(tradeId);
					response.setMsg("Delete capsule trade record successfully");
					response.setCode("DELETE-CAPSULE-SUCCESS");
					response.setStatus(deleteSuccessOrFail);
					response.setData(capsuleStock);
				}
			}
		} catch(Exception e) {
			response.setError(e.getMessage());
			response.setCode("DELETE-CAPSULE-ERROR");
			response.setMsg("Error occupied when deleting capsule trade record");
		}
		return response;
	}
}
