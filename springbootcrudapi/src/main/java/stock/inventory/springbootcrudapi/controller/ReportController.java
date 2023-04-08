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

import stock.inventory.springbootcrudapi.model.ItemStock;
import stock.inventory.springbootcrudapi.request.CapsuleROIRequest;
import stock.inventory.springbootcrudapi.request.SaveCapsuleStockRequest;
import stock.inventory.springbootcrudapi.request.UpdateCapsuleStockRequest;
import stock.inventory.springbootcrudapi.response.CapsuleStockROIResponse;
import stock.inventory.springbootcrudapi.response.StockGetResponse;
import stock.inventory.springbootcrudapi.service.StockService;

@RestController
@RequestMapping("/api")
public class ReportController {
	
//	@Autowired
//	private ReportService reportService;
	
	//Full Delta
	
//	@GetMapping("/report/totalRoi")
//	public ReportRoiResponse getTotalRoi() {
//		ReportRoiResponse response = new ReportRoiResponse();	
//		return response;
//	}
	
	//get full list (group by quantity)
	
	//get by type method
	
	//
	
	//
//	
	// get capsule full set to order by roi (small task)
	
	//cal cost (medium task)
	
	//cal total worth without sold item (medium task)
}
