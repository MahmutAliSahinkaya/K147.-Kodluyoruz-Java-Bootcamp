package com.emlakcepte;

import java.util.List;
import com.emlakcepte.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



@Controller
@RequestMapping("/test")
public class RestClientController {
	
	private static final String webUrl="http://localhost:8080/banners";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<List<Banner>>getAll(){
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl, List.class);
        List<Banner> responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
	}
	
    @PostMapping
    public ResponseEntity<Banner> create(@RequestBody Banner banner){
        ResponseEntity<Banner> result = restTemplate.postForEntity(webUrl, banner, Banner.class);
        Banner responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }

	
}
