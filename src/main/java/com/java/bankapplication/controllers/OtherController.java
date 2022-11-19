package com.java.bankapplication.controllers;


import com.java.bankapplication.repository.UserRepository;
import com.java.bankapplication.service.CheckProfile;
import com.java.bankapplication.service.RegistrationService;
import com.java.bankapplication.service.ShowService;
import com.java.bankapplication.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OtherController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CheckProfile checkProfile;

    @Autowired
    TransferService transferService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ShowService showService;

    @GetMapping(path = "/showimage")
    public String showHome() {
        return "showimage";
    }

    @GetMapping(path = "/getDetails")
    public String showDetails(@RequestParam String username, ModelMap model) {
        System.out.println("------ ----------------------------" + username + "-------");
        model.put("user", checkProfile.getDetails(username));
        System.out.println(checkProfile.getDetails(username).toString());
        return "showdetails";
    }

    @GetMapping(path = "/transfermoney")
    public String transferMoney() {
        return "transfer";
    }

    @PostMapping(path = "/"
            + "transfermoney")
    public String transferMoney(@RequestParam String username, @RequestParam int amount, @RequestParam String user, ModelMap model, RedirectAttributes redirAttrs) {
        System.out.println("##########" + LoginController.uname + "######");
        int s = transferService.transfer(LoginController.uname, user, amount);
        if (s == 0) {
            redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
        } else if (s == 1) {
            redirAttrs.addFlashAttribute("message", "Transaction Successful");
        }
        return "redirect:/transfermoney";
    }

    @GetMapping(path = "/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping(path = "/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping(path = "/addadmin")
    public String addAdmin() {
        return "adminregister";
    }

    @GetMapping(path = "/addemp")
    public String addEmp() {
        return "empregister";
    }

    @PostMapping(path = "/addadmin")
    public String regAdmin(@RequestParam String name, @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String accno, @RequestParam int mobno,
                           @RequestParam String address, @RequestParam int ifsc, @RequestParam int balance) {

        int s = registrationService.addAdmin(name, username, accno, mobno, address, ifsc, balance);
        int ss = registrationService.addAdminLogin(username, password, "admin");
        return "adminregister";
    }

    @PostMapping(path = "/addemp")
    public String regEmp(@RequestParam String name, @RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String accno, @RequestParam int mobno,
                         @RequestParam String address, @RequestParam int ifsc, @RequestParam int balance) {

        int s = registrationService.addAdmin(name, username, accno, mobno, address, ifsc, balance);
        int ss = registrationService.addAdminLogin(username, password, "emp");
        return "empregister";
    }

    @GetMapping(path = "/addcust")
    public String addCust() {
        return "custregister";
    }

    @PostMapping(path = "/addcust")
    public String regCust(@RequestParam String name, @RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String accno, @RequestParam int mobno,
                          @RequestParam String address, @RequestParam int ifsc, @RequestParam int balance) {

        int s = registrationService.addAdmin(name, username, accno, mobno, address, ifsc, balance);
        int ss = registrationService.addAdminLogin(username, password, "cust");
        return "custregister";
    }

    @GetMapping(path = "/showtransaction")
    public String showTransaction(ModelMap model) {
        model.put("transaction", showService.showTransaction(LoginController.uname));
        return "showtransaction";
    }

    @GetMapping(path = "/logout")
    public String showLogout() {
        System.out.println(LoginController.uname);
        LoginController.uname = "";
        return "logout";
    }
}