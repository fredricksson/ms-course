package com.devsuperiorhrpayrool.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperiorhrpayrool.entities.Payment;
import com.devsuperiorhrpayrool.entities.Worker;
import com.devsuperiorhrpayrool.feingclients.WorkerFeingClient;

@Service
public class PaymentService  {
	
	@Autowired
	private WorkerFeingClient workerFeingClient;
	
	
	
	public  Payment getPayment(long workerId, int days) {
	
		// Worker.class is type of object we hopw
		Worker worker = workerFeingClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
	

}
