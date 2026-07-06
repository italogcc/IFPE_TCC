CREATE DATABASE IF NOT EXISTS sees
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE sees;

CREATE TABLE usuario (
    usuario_id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(150) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_cadastro DATETIME NOT NULL,
    usuario_tipo VARCHAR(2) NOT NULL,
    PRIMARY KEY (usuario_id),
    UNIQUE KEY uk_usuario_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE usuario_pf (
    usuario_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(30),
    data_nascimento DATE,
    logradouro VARCHAR(150),
    log_numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(10),
    telefone1 VARCHAR(20),
    telefone2 VARCHAR(20),
    PRIMARY KEY (usuario_id),
    UNIQUE KEY uk_usuario_pf_cpf (cpf),
    CONSTRAINT fk_usuario_pf_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE usuario_pj (
    id_usuario BIGINT NOT NULL,
    razao_social VARCHAR(150) NOT NULL,
    nome_fantasia VARCHAR(150),
    cnpj VARCHAR(18) NOT NULL,
    inscricao_estadual VARCHAR(50),
    logradouro VARCHAR(150),
    log_numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(10),
    telefone1 VARCHAR(20),
    telefone2 VARCHAR(20),
    PRIMARY KEY (id_usuario),
    UNIQUE KEY uk_usuario_pj_cnpj (cnpj),
    CONSTRAINT fk_usuario_pj_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE usuario_f (
    id_usuario BIGINT NOT NULL,
    razao_social VARCHAR(150) NOT NULL,
    nome_fantasia VARCHAR(150),
    cnpj VARCHAR(18) NOT NULL,
    inscricao_estadual VARCHAR(50),
    logradouro VARCHAR(150),
    log_numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(10),
    telefone1 VARCHAR(20),
    telefone2 VARCHAR(20),
    PRIMARY KEY (id_usuario),
    UNIQUE KEY uk_usuario_f_cnpj (cnpj),
    CONSTRAINT fk_usuario_f_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE usuario_a (
    usuario_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(30),
    data_nascimento DATE,
    logradouro VARCHAR(150),
    log_numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(10),
    telefone1 VARCHAR(20),
    telefone2 VARCHAR(20),
    PRIMARY KEY (usuario_id),
    UNIQUE KEY uk_usuario_a_cpf (cpf),
    CONSTRAINT fk_usuario_a_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE fatura_energia (
    fatura_id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    mes_ano VARCHAR(7) NOT NULL,
    kwh DECIMAL(10,2) NOT NULL,
    valor_pago DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (fatura_id),
    UNIQUE KEY uk_fatura_usuario_mes (usuario_id, mes_ano),
    CONSTRAINT fk_fatura_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
