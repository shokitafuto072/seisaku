CREATE TABLE oharabank (
    `id` SERIAL NOT NULL COMMENT 'ID',
    `studentnumber` VARCHAR(64),
    `name` VARCHAR(128),
    `age` VARCHAR(32),
    `mail` VARCHAR(128),
    `phone` VARCHAR(64),
    PRIMARY KEY (id)
) ENGINE=InnoDB;