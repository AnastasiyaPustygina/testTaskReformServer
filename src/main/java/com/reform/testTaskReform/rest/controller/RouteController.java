package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.domain.Route;
import com.reform.testTaskReform.rest.dto.RouteDto;

import java.util.List;

public interface RouteController {

    RouteDto insertRoute(RouteDto routeDto);
    void deleteRouteById(long routeId);
}
