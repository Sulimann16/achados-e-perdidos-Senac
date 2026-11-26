package br.com.senac.achadosperdidos.controller;

import br.com.senac.achadosperdidos.model.LostItem;
import br.com.senac.achadosperdidos.repository.LostItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-items")
public class LostItemController {

    private final LostItemRepository lostItemRepository;

    public LostItemController(LostItemRepository lostItemRepository) {
        this.lostItemRepository = lostItemRepository;
    }

    @PostMapping
    public LostItem create(@RequestBody LostItem item) {
        if (item.getStatus() == null || item.getStatus().isBlank()) {
            item.setStatus("LOST");
        }

        return lostItemRepository.save(item);
    }

    @GetMapping
    public List<LostItem> findAll() {
        return lostItemRepository.findAll();
    }
}