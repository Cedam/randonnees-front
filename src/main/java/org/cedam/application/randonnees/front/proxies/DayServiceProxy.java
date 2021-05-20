package org.cedam.application.randonnees.front.proxies;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "randonnees-back-day", url = "localhost:8085", path = "/days")
public interface DayServiceProxy {

    @GetMapping(value = "/{id}")
    DayBean getById(@PathVariable("id") long id);

}
