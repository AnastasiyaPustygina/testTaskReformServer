package com.reform.testTaskReform.service;

import com.reform.testTaskReform.domain.Route;
import com.reform.testTaskReform.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService{

    private final RouteRepository routeRepository;

    @Override
    public List<Route> getRoutesByUserId(long userId) {
        return routeRepository.findByUserId(userId);
    }

    @Override
    public Route insertRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void deleteRouteById(long routeId) {
        routeRepository.deleteById(routeId);
    }
}
