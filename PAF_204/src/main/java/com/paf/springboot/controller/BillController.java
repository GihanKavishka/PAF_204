package com.paf.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.springboot.exception.ResourceNotFoundException;
import com.paf.springboot.model.Bill;
import com.paf.springboot.repository.BillRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class BillController {

	@Autowired
	private BillRepository billRepository;
	
	// get all bills
	@GetMapping("/bills")
	public List<Bill> getAllBills(){
		return billRepository.findAll();
	}		
	
	// create bill rest api
	@PostMapping("/bills")
	public Bill createBill(@RequestBody Bill bill) {
		return billRepository.save(bill);
	}
	
	// get bill by id rest api
	@GetMapping("/bills/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
		Bill bill = billRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill not exist with id :" + id));
		return ResponseEntity.ok(bill);
	}
	
	// update bill rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill billDetails){
		Bill bill = billRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill not exist with id :" + id));
		
		bill.setLastReading(billDetails.getLastReading());
		bill.setPresentReading(billDetails.getPresentReading());
		bill.setUnits(billDetails.getUnits());
		bill.setAmount(billDetails.getAmount());
		
		Bill updatedBill = billRepository.save(bill);
		return ResponseEntity.ok(updatedBill);
	}
	
	// delete bill rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBill(@PathVariable Long id){
		Bill bill = billRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill not exist with id :" + id));
		
		billRepository.delete(bill);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
