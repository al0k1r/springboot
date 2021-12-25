package com.example.springboot;

import com.example.springboot.model.Data;
import com.example.springboot.repository.IDataRepository;
<<<<<<< Updated upstream
import io.swagger.v3.oas.annotations.Operation;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    @Operation(summary = "Получить список пользователей")
=======
>>>>>>> Stashed changes
    public List<Data> GetAll()
            throws Exception {
        return iDataRepository.getall();
    }

    @GetMapping(value = "/{id}")
<<<<<<< Updated upstream
    @Operation(summary = "Получить одного пользователя")
=======
>>>>>>> Stashed changes
    public Data Get(
            @Parameter(description = "Ид пользователя") @PathVariable int id
    ) throws Exception {
        return iDataRepository.get(id);
    }

    @PostMapping
<<<<<<< Updated upstream
    @Operation(summary = "Создание пользователя")
=======
>>>>>>> Stashed changes
    public String Create(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ){
        return iDataRepository.insert(data);
    }

    @PutMapping
<<<<<<< Updated upstream
    @Operation(summary = "Обновление информации пользователя")
=======
>>>>>>> Stashed changes
    public Data Update(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ) throws Exception {
        return iDataRepository.update(data);
    }

    @DeleteMapping("/{id}")
<<<<<<< Updated upstream
    @Operation(summary = "Удаление ользователя")
=======
>>>>>>> Stashed changes
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
