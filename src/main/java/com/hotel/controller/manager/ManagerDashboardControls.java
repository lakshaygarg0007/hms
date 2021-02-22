package com.hotel.controller.manager;

import com.hotel.Service.manager.ManageTranscation;
import com.hotel.Service.LoginVerification;
import com.hotel.Service.manager.ManagerExpenseService;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ManagerDashboardControls {
    @Autowired
    ManageTranscation manageTranscation;
    @Autowired
    ManagerExpenseService managerExpenseService;
    Double totalAmount=0.0;

    @RequestMapping(value = "/addTransaction",method = RequestMethod.POST)
    public String addTranscation(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "transaction") Double transaction,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){
       // manageTranscation.addTranscation(hotelId, transaction, date);
        //return "demo";
        System.out.println(hotelId);
        model.addAttribute("hotelId",hotelId);
        manageTranscation.addTranscation(hotelId, transaction, date);
        //System.out.println("heeeeeee");
        //JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
        totalAmount=manageTranscation.fetchTotalAmount(hotelId);
        totalAmount += transaction;
        model.addAttribute("totalAmount", totalAmount);
        String succ = "Successfully Done!";
        model.addAttribute("succ",succ);
        return "managerDashboard";
    }

    @RequestMapping(value = "/addExpense",method = RequestMethod.POST)
    public String addExpense(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "expense") Double expense,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){
        model.addAttribute("hotelId",hotelId);
        managerExpenseService.addExpense(hotelId, expense, date);
        totalAmount=manageTranscation.fetchTotalAmount(hotelId);
        totalAmount -= expense;
        model.addAttribute("totalAmount", totalAmount);
        String su = "Expense Successfully Added!";
        model.addAttribute("su", su);
        return "managerDashboard";
    }

   /* @RequestMapping(value = "/viewExpense",method = RequestMethod.POST)
    public String viewExpense(@RequestParam(value="hotelId") String hotelId,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){

    }*/




    @RequestMapping(value = "/viewTransaction",method=RequestMethod.POST)
    public String fetchTranscation(@RequestParam(value="hotelId") String hotelId,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){
        Double amount=manageTranscation.fetchTranscation(hotelId,date);
        model.addAttribute("amount",amount);
        return "demo";
    }

    @RequestMapping(value="/transactionHistory",method = RequestMethod.POST)
    public String transcationHistory(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "startingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date startingDate, @RequestParam(value = "endingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date endingDate, Model model)
    {
        List<ManagerTransaction> list=manageTranscation.transactionHistory(hotelId,startingDate,endingDate);
        model.addAttribute("list",list);
        //System.out.println(list.size());
        String c1 = "Amount";
        model.addAttribute("c1", c1);
        String c2 = "Date";
        model.addAttribute("c2", c2);
       return "managerDashboard";
    }



}
