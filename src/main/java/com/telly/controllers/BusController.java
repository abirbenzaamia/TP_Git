package com.telly.controllers;
import com.telly.dao.Bus;
import com.telly.service.BusService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMethod;
import com.telly.dao.FormValidationGroup;
public class BusController {

    @Autowired
    BusService busService;
    @RequestMapping("/createtrip")
    public String reserveBus(Model model, Principal principal) {

        model.addAttribute("bus", new Bus ());

        return "createtrip";
    }
    @RequestMapping(value = "/createreserve", method = RequestMethod.POST)
    public String createReserve(@Validated(FormValidationGroup.class) Bus bus, BindingResult result,
                                Principal principal) {

        if (result.hasErrors()) {
            return "reservebus";
        }

        busService.create(bus);

        return "home";

    }
}
