package elenaBackend.demo.actuatorservice;

//import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import elenaBackend.Algorithm;

@Controller
public class BackendController {
    private static final String AmherstToBos = "http://localhost:8080/getRoute?startLat=42.38887862&startLong=-72.53009035&endLat=42.36204482&endLong=-71.08557701&type=car&maximize=false";

    @GetMapping("/getRoute")
    @ResponseBody
    public String returnBestRoute(
        @RequestParam(name="startLat", required=true) String slat,
        @RequestParam(name="startLong", required=true) String slong,
        @RequestParam(name="endLat", required=true) String endLat,
        @RequestParam(name="endLong", required=true) String endlong,
        @RequestParam(name="type", required=true) String type,
        @RequestParam(name="max", required=true) boolean max) {
        JSONObject bestRoute = Algorithm.getBestRoute(slat, slong, endLat,endlong, type, max, false);
        return bestRoute.toString();
    }

}
