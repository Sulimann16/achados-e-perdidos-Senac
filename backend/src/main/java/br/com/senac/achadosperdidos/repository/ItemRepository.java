package br.com.senac.achadosperdidos.repository;

import br.com.senac.achadosperdidos.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Item save(Item item) {
        Long id = jdbcTemplate.queryForObject(
            """
            INSERT INTO items (name, description, location, found_date, status)
            VALUES (?, ?, ?, ?, ?)
            RETURNING id
            """,
            Long.class,
            item.getName(),
            item.getDescription(),
            item.getLocation(),
            item.getFoundDate(),
            item.getStatus()
        );

        item.setId(id);
        return item;
    }

    public List<Item> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM items ORDER BY id DESC",
            (rs, rowNum) -> new Item(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("location"),
                rs.getString("found_date"),
                rs.getString("status")
            )
        );
    }
}