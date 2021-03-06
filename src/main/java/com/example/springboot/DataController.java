package com.example.springboot;

import com.example.springboot.model.Data;
import com.example.springboot.repository.IDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {
    private final IDataRepository iDataRepository;
    @Autowired
    public DataController(IDataRepository iDataRepository) {this.iDataRepository = iDataRepository;}

    @GetMapping(value =  "/all")
    @Operation(summary = "Получить список пользователей")
    public List<Data> GetAll()
            throws Exception {
        return iDataRepository.getall();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получить одного пользователя")
    public Data Get(
            @Parameter(description = "Ид пользователя") @PathVariable int id
    ) throws Exception {
        return iDataRepository.get(id);
    }

    @PostMapping
    @Operation(summary = "Создание пользователя")
    public String Create(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ){
        return iDataRepository.insert(data);
    }

    @PutMapping
    @Operation(summary = "Обновление информации пользователя")
    public Data Update(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ) throws Exception {
        return iDataRepository.update(data);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ользователя")
    public int Delete(
            @Parameter(description = "Ид пользователя") @PathVariable int id
    ) throws Exception {
        return iDataRepository.delete(id);
    }
    @GetMapping("/messages")
    public String getMessage() {
        return "Hello from Docker!";
    }
}
