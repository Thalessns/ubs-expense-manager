package dev.java21.UbsExpenseManager.controllers;

import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoRequest;
import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoResponse;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("departamentos/")
@Validated
public class DepartamentoController {

    private final IDepartamentoService service;

    public DepartamentoController(IDepartamentoService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DepartamentoResponse createDepartamento(
            @Valid
            @RequestBody 
            DepartamentoRequest departamentoRequest) {
        return service.createDepartamento(departamentoRequest);
    }

    @GetMapping("/")
    public List<DepartamentoResponse> getAllDepartamentos() {
        return service.getAllDepartamentos();
    }

    @GetMapping("/{id}")
    public DepartamentoResponse getDepartamentoById(@RequestParam UUID id) {
        return service.getDepartamentoById(id);
    }
}
