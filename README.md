# Senac-2024-2F-POO-Java-Projeto-Eventos

CREATE SCHEMA eventos;
USE eventos;

-- Criação da tabela Pessoa
CREATE TABLE Pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(20)
);

-- Criação da tabela Local
CREATE TABLE Local (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    vagas INT NOT NULL
);

-- Criação da tabela Evento
CREATE TABLE Evento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idOrganizacao INT,
    idLocal INT,
    data DATETIME NOT NULL,
    descricao TEXT NOT NULL,
    vagas INT NOT NULL,
    FOREIGN KEY (idOrganizacao) REFERENCES Pessoa(id),
    FOREIGN KEY (idLocal) REFERENCES Local(id)
);

-- Criação da tabela Participacao (relação entre Evento e Pessoa)
CREATE TABLE Participacao (
    idEvento INT,
    idPessoa INT,
    PRIMARY KEY (idEvento, idPessoa),
    FOREIGN KEY (idEvento) REFERENCES Evento(id),
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(id)
);

-- Criação da tabela Notificacao
CREATE TABLE Notificacao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idPessoa INT,
    mensagem TEXT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(id)
);