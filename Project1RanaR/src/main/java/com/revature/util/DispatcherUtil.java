package com.revature.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.RetrieveEmployeesUnderManagerService;

public class DispatcherUtil {
	private RetrieveEmployeesUnderManagerService reums = new RetrieveEmployeesUnderManagerService();
	private ObjectMapper om = new ObjectMapper();

	public String processGet(String entity, String get, String username) {
		try {
			if (entity.equals("employees")) {
				if (get.equals("manager")) {
					return om.writeValueAsString(reums.returnAllEmployeesUnderManager(username));
				}
			
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "error";
	}
}
