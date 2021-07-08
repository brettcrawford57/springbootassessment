package com.codeup.springbootassessment.controllers;

import com.codeup.springbootassessment.models.Order;
import com.codeup.springbootassessment.repos.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/orders/create")
    public String createOrder(Model model) {
        model.addAttribute("order", new Order());
        return "orders/create";
    }

    @GetMapping("/orders/{id}")
    public String showOrder(@PathVariable long orderNumber, Model model) {
        model.addAttribute("order", orderRepo.getById(orderNumber));
        return "orders/show";
    }

    //updateOrder is taking information from form to update a specific model
    @GetMapping("/orders/{id}/update")
    public String updateOrder(@PathVariable long orderNumber, Model model) {
        Order orderToEdit = orderRepo.getById(orderNumber);
        model.addAttribute("order", orderToEdit);
        return "orders/update";
    }

    //saveOrder is taking information from createOrder and putting it to the database. @ModelAttribute is saving all parameters from the Order object.
    //method is redirecting to orders concatenated with the new saved order number
    @PostMapping("/orders/create")
    public String saveOrder(@ModelAttribute Order order) {
        Order savedOrder = orderRepo.save(order);
        return "redirect:/orders/" + savedOrder.getOrderNumber();
    }

    //saveUpdatedOrder is taking information from updateOrder and changing database entry through the Order object.
    @PostMapping("/orders/{id}/update")
    public String saveUpdatedOrder(@ModelAttribute Order order) {
        Order savedUpdatedOrder = orderRepo.save(order);
        return "redirect:/orders/" + savedUpdatedOrder.getOrderNumber();
    }

}
