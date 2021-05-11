package org.cedam.application.randonnees.front.proxies;

import java.util.List;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "randonnees-back-day", url = "localhost:8085", path = "/days")
public interface DayServiceProxy {

    @GetMapping(value = "")
    List<DayBean> getAll();

    @GetMapping(value = "/id?id={id}")
    DayBean getById(@PathVariable("id") int id);

}
