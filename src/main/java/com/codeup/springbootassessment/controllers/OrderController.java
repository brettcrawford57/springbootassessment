package com.codeup.springbootassessment.controllers;

import com.codeup.springbootassessment.models.Order;
import com.codeup.springbootassessment.repos.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/orders/create")
    public String createOrder(Model model){
        model.addAttribute("order", new Order());
        return "orders/create";
    }

    @GetMapping("/orders/{id}")
    public String showOrder(@PathVariable long orderNumber, Model model){
        model.addAttribute("order", orderRepo.getById(orderNumber));
        return "orders/show";
    }

    @GetMapping("/orders/{id}/update")
    public String updateOrder(@PathVariable long orderNumber, Model model){
        Order orderToEdit = orderRepo.getById(orderNumber);
        model.addAttribute("order", orderToEdit);
        return "orders/update";
    }


}
