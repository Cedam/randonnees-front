package org.cedam.application.randonnees.front.proxies;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "randonnees-back-day", url = "${randonnees.back.url}", path = "/days")
public interface DayServiceProxy {

    @GetMapping(value = "/{id}")
    DayBean getById(@PathVariable("id") long id);

    @PostMapping(value = "/save")
    DayBean save(@RequestBody DayBean day);
    
}
