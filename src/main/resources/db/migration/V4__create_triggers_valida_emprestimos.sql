DELIMITER $$

	CREATE TRIGGER valida_emprestimo_before_insert
	BEFORE INSERT ON emprestimos
	FOR EACH ROW
	BEGIN
		DECLARE total_emprestimo INT;
		IF NEW.status = 'ATIVO' THEN
			SELECT COUNT(*) INTO total_emprestimo
			FROM emprestimos
			WHERE livro_id = NEW.livro_id AND status = 'ATIVO';
			IF total_emprestimo > 0 THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Já existe um empréstimo ativo para este livro.';
			END IF;
		END IF;
	END$$
    
CREATE TRIGGER valida_emprestimo_before_update
	BEFORE UPDATE ON emprestimos
	FOR EACH ROW
	BEGIN
		DECLARE total_emprestimo INT;
		IF NEW.status = 'ATIVO' AND OLD.status <> 'ATIVO' THEN
			SELECT COUNT(*) INTO total_emprestimo
			FROM emprestimos
			WHERE livro_id = NEW.livro_id AND status = 'ATIVO';
			IF total_emprestimo > 0 THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Já existe um empréstimo Ativo para este livro.';
			END IF;
		END IF;
	END$$
    
DELIMITER ;