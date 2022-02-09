package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.KardexDto;
import com.prueba_back.prueba_java.Entity.Kardex;
import com.prueba_back.prueba_java.Response.ResponseKardex;
import com.prueba_back.prueba_java.Response.ResponseKardexSave;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KardexMapper {
    public ResponseKardex toResponseKardexDto(List<Kardex> kardexList, Integer codeResponse, String message, String status){
        return ResponseKardex.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .kardexDto(toKardex(kardexList))
                .build();
    }

    public List<KardexDto> toKardex(List<Kardex> kardex){
        if (kardex != null && !kardex.isEmpty()){
            return kardex.stream().map(this::toKardexMapp)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public KardexDto toKardexMapp(Kardex kardex){
        if (kardex != null){
            return KardexDto.builder()
                    .name(kardex.getName())
                    .unit(kardex.getUnit())
                    .supplier(kardex.getSupplier())
                    .date(kardex.getDate())
                    .description(kardex.getDescription())
                    .value(kardex.getValue())
                    .quantityTickets(kardex.getQuantityTickets())
                    .valueTickets(kardex.getValueTickets())
                    .quantityDepartures(kardex.getQuantityDepartures())
                    .valueDepartures(kardex.getValueDepartures())
                    .valueBalance(kardex.getValueBalance())
                    .build();
        }
        return null;
    }

    public ResponseKardexSave toResponseKardexSave(Kardex kardex, Integer codeResponse, String message, String status){
        return ResponseKardexSave.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .build();
    }
}
