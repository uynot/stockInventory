package stock.inventory.springbootcrudapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.inventory.springbootcrudapi.model.CapsuleStock;
import stock.inventory.springbootcrudapi.service.CapsuleStockService;

@RestController
@RequestMapping("/api")
public class CapsuleStockController {
	
	private CapsuleStockService capsuleStockService;
	
	@GetMapping("/capsule_stock")
	public List<CapsuleStock> get() {
		return capsuleStockService.get();
	}
}
