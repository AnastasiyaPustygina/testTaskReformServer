package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.rest.dto.RouteDto;
import com.reform.testTaskReform.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RouteControllerImpl implements RouteController{

    private final RouteService routeService;

    @Override
    @PostMapping("/route")
    public RouteDto insertRoute(@RequestBody RouteDto routeDto) {
        return RouteDto.toDto(routeService.insertRoute(RouteDto.toDomainObject(routeDto)));
    }

    @Override
    @DeleteMapping("/route/{id}")
    public void deleteRouteById(@PathVariable long id) {
        routeService.deleteRouteById(id);
    }
}
