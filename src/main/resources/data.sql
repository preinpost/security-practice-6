INSERT INTO users (`id`, `username`, `password`, `algorithm`) VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');

INSERT INTO authority (`id`, `name`, `users`) VALUES ('1', 'READ', '1');
INSERT INTO authority (`id`, `name`, `users`) VALUES ('2', 'WRITE', '1');

INSERT INTO product (`id`, `name`, `price`, `currency`) VALUES ('1', 'Chocolate', '10', 'USD');