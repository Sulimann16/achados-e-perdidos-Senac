package br.com.senac.achadosperdidos.repository;

import br.com.senac.achadosperdidos.model.LostItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LostItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public LostItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public LostItem save(LostItem item) {
        Long id = jdbcTemplate.queryForObject(
            """
            INSERT INTO lost_items (name, description, location, lost_date, status)
            VALUES (?, ?, ?, ?, ?)
            RETURNING id
            """,
            Long.class,
            item.getName(),
            item.getDescription(),
            item.getLocation(),
            item.getLostDate(),
            item.getStatus()
        );

        item.setId(id);
        return item;
    }

    public List<LostItem> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM lost_items ORDER BY id DESC",
            (rs, rowNum) -> new LostItem(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("location"),
                rs.getString("lost_date"),
                rs.getString("status")
            )
        );
    }
}