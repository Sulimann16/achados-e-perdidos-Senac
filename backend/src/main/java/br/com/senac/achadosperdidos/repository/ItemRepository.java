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

    public List<Item> findAll(String search, String location, String status) {
    return jdbcTemplate.query(
        """
        SELECT * FROM items
        WHERE (
            ? IS NULL OR
            LOWER(name) LIKE '%' || LOWER(?) || '%' OR
            LOWER(COALESCE(description, '')) LIKE '%' || LOWER(?) || '%'
        )
        AND (
            ? IS NULL OR
            LOWER(location) LIKE '%' || LOWER(?) || '%'
        )
        AND (
            ? IS NULL OR
            UPPER(status) = UPPER(?)
        )
        ORDER BY id DESC
        """,
        (rs, rowNum) -> new Item(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getString("location"),
            rs.getString("found_date"),
            rs.getString("status")
        ),
        search, search, search,
        location, location,
        status, status
    );
}
}