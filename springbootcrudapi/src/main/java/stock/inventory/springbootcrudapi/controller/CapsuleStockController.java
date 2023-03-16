package stock.inventory.springbootcrudapi.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import stock.inventory.springbootcrudapi.request.CapsuleROIRequest;
import stock.inventory.springbootcrudapi.request.SaveCapsuleStockRequest;
import stock.inventory.springbootcrudapi.request.UpdateCapsuleStockRequest;
import stock.inventory.springbootcrudapi.response.CapsuleStockGetResponse;
import stock.inventory.springbootcrudapi.response.CapsuleStockROIResponse;
import stock.inventory.springbootcrudapi.response.CapsuleStockStandardResponse;
import stock.inventory.springbootcrudapi.service.CapsuleStockService;

@RestController
@RequestMapping("/api")
public class CapsuleStockController {
	
	@Autowired
	private CapsuleStockService capsuleStockService;
	
	//Full Single Hybrid
	
	@GetMapping("/capsule/getCapsuleStockFull")
	public CapsuleStockGetResponse getCapsuleStockFull() {
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
	public CapsuleStockStandardResponse getCapsuleStockSingle(@PathVariable Integer tradeId) throws Exception {
		//require	{
		//				"23"
		//			}
		CapsuleStockStandardResponse response = new CapsuleStockStandardResponse();
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
	public CapsuleStockStandardResponse createCapsuleStock(@RequestBody SaveCapsuleStockRequest saveCapsuleStockRequest) throws Exception {
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
		CapsuleStockStandardResponse response = new CapsuleStockStandardResponse();
		Float buyInPrice = saveCapsuleStockRequest.getBuyInPrice();
		Float cashoutPrice = saveCapsuleStockRequest.getCashoutPrice();
		
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
	public CapsuleStockStandardResponse updateCapsuleStock(@RequestBody UpdateCapsuleStockRequest updateCapsuleStockRequest) throws Exception {
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
		CapsuleStockStandardResponse response = new CapsuleStockStandardResponse();
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
	public CapsuleStockStandardResponse deleteCapsuleStock(@PathVariable Integer tradeId) throws Exception {
		//require	{
		//				"23"
		//			}
		CapsuleStockStandardResponse response = new CapsuleStockStandardResponse();
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
	
	@GetMapping("/capsule/capsuleROIHybrid")
	public CapsuleStockROIResponse getCapsuleROIHybrid(@RequestBody List<CapsuleROIRequest> capsuleROIRequests) throws Exception {
		//require	[
		//				{
		//        			"tradeId": 21
		//    			},
		//   			{
		//       			"tradeId": 22
		//    			}
		//			]
		CapsuleStockROIResponse response = new CapsuleStockROIResponse();
		List<String> items = new ArrayList<String>();
		int totalQuantity = 0;
		double totalBuyInPrice = 0;
		double totalCurrentPrice = 0;
		double totalProfit = 0;
		int recordFound = 0;
		
		response.setCode("ROI-CAPSULE-FAIL");
		response.setStatus("Failed");
		response.setMsg("Record not found");
		response.setAverageROI("0%");
		response.setRecordInput(capsuleROIRequests.size());
		
		if (capsuleROIRequests.isEmpty()) {
			response.setError("No trade record provided");
			response.setMsg("Please input trade records");
			return response;
		}
		  
		try {
			for (CapsuleROIRequest capsuleROIRequest : capsuleROIRequests) {
			    int tradeId = capsuleROIRequest.getTradeId();
			    Object[] roiDataArray = capsuleStockService.getCapsuleROIHybrid(tradeId);

			    if (roiDataArray != null) {
			        Double quantity = Double.parseDouble(String.valueOf(roiDataArray[1]).trim());
			        Double buyInPrice = Double.parseDouble(String.valueOf(roiDataArray[2]).trim());
			        Double soldPrice = 0d;
			        Double currentPrice = 0d;

			        if ((roiDataArray[3]) != null) {
			        	soldPrice = Double.parseDouble(String.valueOf(roiDataArray[3]).trim());
			        }
			        if ((roiDataArray[4]) != null) {
			        	currentPrice = Double.parseDouble(String.valueOf(roiDataArray[4]).trim());
			        }
			        if (soldPrice > 0 || currentPrice > 0) {
		                items.add(String.valueOf(roiDataArray[0]).trim());
		                totalQuantity += quantity;
		                totalBuyInPrice += buyInPrice;
		                recordFound++;

		                if (soldPrice > 0) {
		                    totalCurrentPrice += soldPrice;
		                    totalProfit += (soldPrice - buyInPrice);
		                } else {
		                    totalCurrentPrice += currentPrice;
		                    totalProfit += (currentPrice - buyInPrice);
		                }
		            }
			    }
			}
			if (recordFound > 0) {
				
				double averageProfit = totalProfit / totalQuantity;
				double averageROI = roundUpToDecimal2((totalCurrentPrice / totalBuyInPrice - 1) * 100);

				response.setCode("ROI-CAPSULE-SUCCESS");
				response.setStatus("Success");
				response.setMsg("Get capsule ROI successfully");
				response.setItems(new ArrayList<>(new HashSet<>(items)));
				response.setQuantity(totalQuantity);
				response.setTotalBuyInPrice(roundUpToDecimal2(totalBuyInPrice));
				response.setTotalCurrentPrice(roundUpToDecimal2(totalCurrentPrice));
				response.setProfit(roundUpToDecimal2(totalProfit));
				response.setAverageProfit(roundUpToDecimal2(averageProfit));
				response.setAverageROI(Double.toString(roundUpToDecimal2(averageROI)) + "%");
				response.setRecordFound(recordFound);
			}
		} catch(Exception e) {
			response.setCode("ROI-CAPSULE-ERROR");
			response.setError(e.getMessage());
			response.setMsg("Error occupied when getting capsule ROI record");
		}
	    return response;
	}

	private double roundUpToDecimal2(double value) {
	    return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	//List<Map<String,String>> top3ROI = new ArrayList<>();
}
