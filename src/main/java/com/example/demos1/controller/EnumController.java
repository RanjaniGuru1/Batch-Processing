package com.example.demos1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demos1.enums.MonthEnum;
import com.example.demos1.model.Enum;

@RestController
public class EnumController {
	
	@GetMapping("/enum")
	public Map<String, List<Enum>> getEnumLists() {
		Map<String, List<Enum>> map = new HashMap<String, List<Enum>>();
		List<MonthEnum> enumValues = Arrays.asList(MonthEnum.values());
		List<Enum> enumList = new ArrayList<>();
		
		enumValues.forEach(item -> {
			Enum entity = new Enum();
			entity.setName(item.toString());
			entity.setValue(item.toString());
			enumList.add(entity);
		});
		map.put("month", enumList);
		return map;
	}
}
