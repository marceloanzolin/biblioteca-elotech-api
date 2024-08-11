CREATE TABLE emprestimos (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	usuario_id INTEGER NOT NULL,
	livro_id INTEGER NOT NULL,
	data_emprestimo DATE NOT NULL,
	data_devolucao DATE,
	status VARCHAR(50) NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE RESTRICT,
    FOREIGN KEY (livro_id) REFERENCES livros(id) ON DELETE RESTRICT,
    CONSTRAINT check_status CHECK (status IN ('ATIVO', 'FINALIZADO'))
)