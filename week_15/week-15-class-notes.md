# Week 15 - Class notes

Schema design, table to entity, many-to-many, create location example testing

### Schema setup

-   ER diagram - draw.io
-   Two options:
    -   allow JPA to scan your Entities
    -   Allow Spring to read your data and schemal SQL files

### Other notes

-   Reset record IDs using `ALTER TABLE tablename AUTO_INCREMENT = 1`

-   Use a `Set` because `Set`s don't allow duplicates

-   Cascade types: `PERSIST`, `REMOVE`, `REFRESH`, `MERGE`, `DETACH`
