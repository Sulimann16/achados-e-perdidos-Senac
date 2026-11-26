package br.com.senac.achadosperdidos.controller;

import br.com.senac.achadosperdidos.model.Item;
import br.com.senac.achadosperdidos.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        if (item.getStatus() == null || item.getStatus().isBlank()) {
            item.setStatus("FOUND");
        }

        return itemRepository.save(item);
    }

    @GetMapping
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}