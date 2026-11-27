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

    public List<LostItem> findAll(String search, String location, String status) {
    return jdbcTemplate.query(
        """
        SELECT * FROM lost_items
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
        (rs, rowNum) -> new LostItem(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getString("location"),
            rs.getString("lost_date"),
            rs.getString("status")
        ),
        search, search, search,
        location, location,
        status, status
     );
    }
}