package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.interfaces.utils.IUtilsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class UtilsService implements IUtilsService {

    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}
