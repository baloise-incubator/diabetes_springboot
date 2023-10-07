package com.baloise.cc2023diabetes.htmx.food;

import com.baloise.cc2023diabetes.service.food.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxFoodController {

	private final FoodService foodService;

	@GetMapping("/food")
	public String food(Model model) {
		List<FoodModel> rows = foodService.all();

		// View model population:
		model.addAttribute("model", new FoodVM(rows));

		return "food/main";
	}
}
