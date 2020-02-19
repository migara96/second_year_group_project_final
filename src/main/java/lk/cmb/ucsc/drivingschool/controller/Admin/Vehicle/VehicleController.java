package lk.cmb.ucsc.drivingschool.controller.Admin.Vehicle;

import lk.cmb.ucsc.drivingschool.model.Vehicle;
import lk.cmb.ucsc.drivingschool.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/api/admin/vehicle/")
public class VehicleController  {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("add")
    public String showVehicle(Model model){
        List<Vehicle> vehicleList=new ArrayList<>();
        vehicleList=vehicleService.findAll();
        model.addAttribute("vehicleList",vehicleList);
        model.addAttribute("vehicle", new Vehicle());
        return "admin/vehicle/vehicle";
    }
    @PostMapping("add")
    public String addVehicle(@ModelAttribute Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        return "admin/vehicle/vehicle";
    }
}
