CREATE TABLE IF NOT EXISTS taxes (
    id UUID default random_uuid(),
    municipality VARCHAR(50) not null,
    tax DOUBLE PRECISION not null,
    start_date DATE not null,
    end_date DATE not null,

    PRIMARY KEY(id)
)