package com.zoack.payments.controllers;

import com.zoack.payments.models.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
public class CheckController {
    @RequestMapping("/check")
    @ResponseBody
    public String response() {
        return "SERVICE IS RUNNING";
    }

}
