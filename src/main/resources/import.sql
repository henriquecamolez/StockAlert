
INSERT INTO product (id, nome_produto, data_cadastro, data_fabricacao, data_vencimento, lote, qtde) VALUES (1, 'Arroz Tipo 1', '2025-08-01 10:15:30', '2025-05-01', '2026-05-01', 1001, 50);
INSERT INTO product (id, nome_produto, data_cadastro, data_fabricacao, data_vencimento, lote, qtde) VALUES (2, 'Feijão Carioca', '2025-08-02 09:00:00', '2025-06-01', '2026-06-01', 1002, 80);
INSERT INTO product (id, nome_produto, data_cadastro, data_fabricacao, data_vencimento, lote, qtde) VALUES (3, 'Macarrão Espaguete', '2025-08-03 11:45:00', '2025-07-01', '2026-07-01', 1003, 100);
INSERT INTO product (id, nome_produto, data_cadastro, data_fabricacao, data_vencimento, lote, qtde) VALUES (4, 'Açúcar Refinado', '2025-08-04 08:30:00', '2025-04-15', '2026-04-15', 1004, 60);
INSERT INTO product (id, nome_produto, data_cadastro, data_fabricacao, data_vencimento, lote, qtde) VALUES (5, 'Café Torrado', '2025-08-05 10:10:00', '2025-03-20', '2026-03-20', 1005, 70);
INSERT INTO market (id, nome_mercado, endereco, data_cadastro) VALUES (1, 'Supermercado Central', 'Rua das Flores, 123', '2025-08-01 08:00:00');
INSERT INTO market (id, nome_mercado, endereco, data_cadastro) VALUES (2, 'Mercado da Vila', 'Av. São João, 456', '2025-08-02 09:30:00');
INSERT INTO market (id, nome_mercado, endereco, data_cadastro) VALUES (3, 'Hortifruti Bom Preço', 'Rua das Laranjeiras, 789', '2025-08-03 10:00:00');
INSERT INTO market (id, nome_mercado, endereco, data_cadastro) VALUES (4, 'Mercadão Central', 'Praça da Matriz, 101', '2025-08-04 11:00:00');
INSERT INTO market (id, nome_mercado, endereco, data_cadastro) VALUES (5, 'Supermercado Parque', 'Av. das Américas, 202', '2025-08-05 12:00:00');
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (1, 1);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (1, 2);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (2, 3);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (3, 4);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (4, 5);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (5, 1);
INSERT INTO produto_mercado (id_mercado, id_produto) VALUES (5, 3);
