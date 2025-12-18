INSERT INTO countries (name, code) VALUES ('Ukraine', 'UKR');
INSERT INTO countries (name, code) VALUES ('Russia', 'RUS');

INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Ukraine War', '2022-02-24', 'ACTIVE', 'Conflicto armado entre Rusia y Ucrania');

INSERT INTO country_conflicts (conflict_id, country_id) VALUES (1, 1);
INSERT INTO country_conflicts (conflict_id, country_id) VALUES (1, 2);