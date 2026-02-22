package dev.java21.UbsExpenseManager.controllers;

import dev.java21.UbsExpenseManager.dtos.despesa.DespesaRequest;
import dev.java21.UbsExpenseManager.dtos.despesa.DespesaResponse;
import dev.java21.UbsExpenseManager.interfaces.despesa.IDespesaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("despesas/")
public class DespesaController {

    private final IDespesaService service;

    public DespesaController(IDespesaService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DespesaResponse createDespesa(@Valid @RequestBody DespesaRequest despesaRequest) {
        return service.createDespesa(despesaRequest);
    }

    @GetMapping("/")
    public List<DespesaResponse> getAllDespesas() {
        return service.getAllDespesas();
    }

    @GetMapping("/{id}")
    public DespesaResponse getDespesaById(@RequestParam UUID id) {
        return service.getDespesaById(id);
    }
}
