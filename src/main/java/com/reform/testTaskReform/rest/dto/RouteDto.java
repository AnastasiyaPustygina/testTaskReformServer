package com.reform.testTaskReform.rest.dto;
import com.reform.testTaskReform.domain.Route;
import com.reform.testTaskReform.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {

    private final long id;
    private final long user_id;
    private final AddressDto toAddress;
    private final AddressDto fromAddress;

    public static RouteDto toDto(Route route){
        return RouteDto.builder().id(route.getId()).user_id(route.getUser().getId())
                .toAddress(AddressDto.toDto(route.getAddressTo())).fromAddress(
                        AddressDto.toDto(route.getAddressFrom())).build();
    }

    public static Route toDomainObject(RouteDto routeDto){
        return Route.builder().id(routeDto.getId()).user(User.builder().id(routeDto.getUser_id()).build())
                .addressTo(AddressDto.toDomainObject(routeDto.getToAddress())).addressFrom(
                        AddressDto.toDomainObject(routeDto.getFromAddress())).build();
    }
}
