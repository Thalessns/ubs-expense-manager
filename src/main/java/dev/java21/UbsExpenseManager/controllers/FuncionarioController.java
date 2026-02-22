package dev.java21.UbsExpenseManager.controllers;

import jakarta.validation.Valid;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios/")
public class FuncionarioController {

    private final IFuncionarioService service;

    public FuncionarioController(IFuncionarioService service) {
        this.service = service;
    }

    @PostMapping("/")
    public FuncionarioResponse create(@Valid @RequestBody FuncionarioRequest funcionarioRequest){
        return service.createFuncionario(funcionarioRequest);
    }

    @GetMapping("/")
    public List<FuncionarioResponse> getAllFuncionarios(){
        return service.getAll();
    }
}
