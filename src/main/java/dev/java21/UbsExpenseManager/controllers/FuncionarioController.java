package dev.java21.UbsExpenseManager.controllers;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.services.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios/")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping("/")
    public FuncionarioResponse create(@RequestBody FuncionarioRequest funcionarioRequest){
        return service.createFuncionario(funcionarioRequest);
    }

    @GetMapping("/")
    public List<FuncionarioResponse> getAllFuncionarios(){
        return service.getAll();
    }
}
