package com.reform.testTaskReform.service;

import com.reform.testTaskReform.domain.Route;

import java.util.List;

public interface RouteService {

    List<Route> getRoutesByUserId(long userId);

    Route insertRoute(Route route);

    void deleteRouteById(long routeId);
}
