CREATE TABLE IF NOT EXISTS items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    location TEXT NOT NULL,
    found_date TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'FOUND'
);

CREATE TABLE IF NOT EXISTS lost_items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    location TEXT NOT NULL,
    lost_date TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'LOST'
);